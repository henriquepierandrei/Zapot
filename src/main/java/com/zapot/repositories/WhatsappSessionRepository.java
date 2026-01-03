package com.zapot.repositories;

import com.zapot.entities.WhatsappSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface WhatsappSessionRepository extends JpaRepository<WhatsappSessionEntity, UUID> {
}
