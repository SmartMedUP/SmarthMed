package com.example.smartmed;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Rendezvous {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rendezvousId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime scheduledDate;

    @Column
    private String notes;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RendezvousStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Enum for Rendezvous Status
    public enum RendezvousStatus {
        Pending, Confirmed, Completed
    }

    public void setRendezvousId(Integer rendezvousId) {
        this.rendezvousId = rendezvousId;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setScheduledDate(LocalDateTime scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setStatus(RendezvousStatus status) {
        this.status = status;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

