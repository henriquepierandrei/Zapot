package com.zapot.config.auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.zapot.config.auth.dtos.AuthResponseDTO;
import com.zapot.config.security.CustomUserDetailsService;
import com.zapot.entities.UserEntity;
import com.zapot.enums.AuthProviderEnum;
import com.zapot.enums.RolesEnum;
import com.zapot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

@Service
public class GoogleAuthService {

    @Value("${google.client.id}")
    private String googleClientId;

    private final AuthService authService;
    private final CustomUserDetailsService userDetailsService;
    private final UserRepository userRepository;


    public GoogleAuthService(AuthService authService, CustomUserDetailsService userDetailsService, UserRepository userRepository) {
        this.authService = authService;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    public AuthResponseDTO authenticateWithGoogle(String idTokenString) throws Exception {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                new NetHttpTransport(),
                GsonFactory.getDefaultInstance()
        )
                .setAudience(Collections.singletonList(googleClientId))
                .build();

        GoogleIdToken idToken = verifier.verify(idTokenString);

        if (idToken == null) {
            throw new Exception("Token do Google inválido");
        }

        GoogleIdToken.Payload payload = idToken.getPayload();
        String email = payload.getEmail();
        String name = (String) payload.get("name");
        String pictureUrl = (String) payload.get("picture");
        String googleId = payload.getSubject(); // ID único do Google

        // Busca ou cria o usuário
        UserEntity user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    UserEntity newUser = new UserEntity();
                    newUser.setEmail(email);
                    newUser.setUsername(name);
                    newUser.setGoogleId(googleId);
                    newUser.setUserPicture(pictureUrl);
                    newUser.setAuthProvider(AuthProviderEnum.GOOGLE);
                    newUser.setRoles(Set.of(RolesEnum.USER));
                    newUser.setCreatedAt(LocalDateTime.now());
                    newUser.setActive(true);
                    return userRepository.save(newUser);
                });

        // Carrega o UserDetails REAL
        UserDetails userDetails =
                userDetailsService.loadUserByUsername(user.getEmail());

        // Gera tokens
        String accessToken = authService.generateToken(userDetails);
        String refreshToken = authService.generateRefreshToken(userDetails);

        return new AuthResponseDTO(
                accessToken,
                refreshToken,
                "Autenticação com Google realizada com sucesso"
        );
    }

}