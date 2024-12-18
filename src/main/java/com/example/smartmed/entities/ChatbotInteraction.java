package com.example.smartmed.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chatbot_interactions")
public class ChatbotInteraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interaction_id;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    private String message;
    private String response;
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp interaction_date;
}