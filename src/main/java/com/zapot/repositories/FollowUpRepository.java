package com.zapot.repositories;

import com.zapot.entities.FollowUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface FollowUpRepository extends JpaRepository<FollowUpEntity, UUID> {
}

