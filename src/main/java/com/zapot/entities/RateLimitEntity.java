package com.zapot.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rate_limit_tb")
public class RateLimitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID whatsappSessionId;     // ID da sessão vinculada (FK)

    private LocalDate date;

    private Integer messagesSent;

    public RateLimitEntity() {
    }

    // Getters and Setters


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getWhatsappSessionId() {
        return whatsappSessionId;
    }

    public void setWhatsappSessionId(UUID whatsappSessionId) {
        this.whatsappSessionId = whatsappSessionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(Integer messagesSent) {
        this.messagesSent = messagesSent;
    }
}
