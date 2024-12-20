package com.example.smartmed.repositories;


import com.example.smartmed.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    // Récupère les rendez-vous pour lesquels les rappels doivent être envoyés
    @Query("SELECT a FROM Appointment a WHERE a.rappelEnvoye = false AND a.rappelDate <= :currentDate")
    List<Appointment> findAppointmentsForRappel(LocalDateTime currentDate);
}
