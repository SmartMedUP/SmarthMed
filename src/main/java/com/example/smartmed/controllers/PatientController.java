package com.example.smartmed.controllers;

import com.example.smartmed.entities.Appointment;
import com.example.smartmed.entities.ChatbotInteraction;
import com.example.smartmed.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;


@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @PostMapping("/{patientUserId}/schedule")
    public ResponseEntity<Appointment> scheduleAppointment(
            @PathVariable Integer patientUserId,
            @RequestParam Integer doctorUserId,
            @RequestParam String appointment_date,
            @RequestParam String reason) {

        Timestamp appointmentTimestamp = Timestamp.valueOf(appointment_date);
        Appointment appointment = patientService.scheduleAppointment(patientUserId,doctorUserId, appointmentTimestamp, reason);
        return ResponseEntity.ok(appointment);

    }
    @PutMapping("/appointments/{appointment_id}/update")
        public ResponseEntity<Appointment> updateAppointment(
                @PathVariable Integer appointment_id,
                @RequestParam String status) {

            Appointment appointment = patientService.updateAppointment(appointment_id, status);
            return ResponseEntity.ok(appointment);
        }

    @PutMapping("/appointments/{appointment_id}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(@PathVariable Integer appointment_id) {
        Appointment appointment = patientService.cancelAppointment(appointment_id);
        return ResponseEntity.ok(appointment);
    }
    
}

