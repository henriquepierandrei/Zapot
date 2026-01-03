package com.zapot.repositories;

import com.zapot.entities.RateLimitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RateLimitRepository extends JpaRepository<RateLimitEntity, UUID> {
}
