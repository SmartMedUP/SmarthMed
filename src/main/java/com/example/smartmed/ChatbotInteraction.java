package com.example.smartmed;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Entity
public class ChatbotInteraction {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interactionId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private String message;

    @Column
    private String response;

    @Column(nullable = false)
    private LocalDateTime interactionDate;

    public void setInteractionId(Integer interactionId) {
        this.interactionId = interactionId;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setInteractionDate(LocalDateTime interactionDate) {
        this.interactionDate = interactionDate;
    }
}

