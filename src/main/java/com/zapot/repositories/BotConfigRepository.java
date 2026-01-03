package com.zapot.repositories;

import com.zapot.entities.BotConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BotConfigRepository extends JpaRepository<BotConfigEntity, UUID> {
}
