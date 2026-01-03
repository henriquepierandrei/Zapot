package com.zapot.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "bot_config_tb")
public class BotConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;        // ID do user (FK)

    private String systemPrompt;        // Prompt da IA do BOT

    private Integer minDelayMs;         // Mínimo de delay para enviar a mensagem (Um número menor pode ocasionar na suspensão do número no whatsapp)

    private Integer maxDelayMs;

    private Boolean followUpEnabled;        // Permissão para cronometrar mensagens!

    private String keyIa;                   // Key da Inteligência Artificial

    public BotConfigEntity() {
    }

    // Getters and Setters


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getSystemPrompt() {
        return systemPrompt;
    }

    public void setSystemPrompt(String systemPrompt) {
        this.systemPrompt = systemPrompt;
    }

    public Integer getMinDelayMs() {
        return minDelayMs;
    }

    public void setMinDelayMs(Integer minDelayMs) {
        this.minDelayMs = minDelayMs;
    }

    public Integer getMaxDelayMs() {
        return maxDelayMs;
    }

    public void setMaxDelayMs(Integer maxDelayMs) {
        this.maxDelayMs = maxDelayMs;
    }

    public Boolean getFollowUpEnabled() {
        return followUpEnabled;
    }

    public void setFollowUpEnabled(Boolean followUpEnabled) {
        this.followUpEnabled = followUpEnabled;
    }

    public String getKeyIa() {
        return keyIa;
    }

    public void setKeyIa(String keyIa) {
        this.keyIa = keyIa;
    }
}
