package com.example.smartmed.services;
import com.example.smartmed.dtos.PatientDto;
import com.example.smartmed.models.Appointment;
import com.example.smartmed.models.Patient;
import com.example.smartmed.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class RappelAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private JavaMailSender mailSender;

    //Planifie l'envoi  à 08h.

    @Scheduled(cron = "0 0 8 * * *")
    public void envoyerRappels() {
        LocalDateTime maintenant = LocalDateTime.now();

        // Récupérer les rendez-vous devant recevoir un rappel
        List<Appointment> appointments = appointmentRepository.findAppointmentsForRappel(maintenant);

        // Parcourir chaque rendez-vous
        for (Appointment appointment : appointments) {
            Patient patient = appointment.getPatient(); // Charger l'entité Patient

            // Convertir le Patient en PatientDTO directement dans le service
            PatientDto patientDTO = convertToPatientDTO(patient);

            // Envoyer le rappel e-mail
            envoyerEmailRappel(patientDTO, appointment);

            // Mettre à jour l'état du rendez-vous
            appointment.setRappelEnvoye(true);
            appointmentRepository.save(appointment);
        }
    }


    private PatientDto convertToPatientDTO(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Le patient est null et ne peut pas être converti.");
        }

        PatientDto patientDTO = new PatientDto();
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());

        // Ajoutez d'autres champs si nécessaires
        return patientDTO;
    }

    private void envoyerEmailRappel(PatientDto patient, Appointment appointment) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(patient.getEmail()); 
        mail.setSubject("Rappel de votre rendez-vous");
        mail.setText("Bonjour " + patient.getFirstName() + " " + patient.getLastName() + ",\n\n" +
                "Ceci est un rappel pour votre rendez-vous de type '" + appointment.getReason() + "' " +
                "prévu le " + appointment.getAppointmentDate() + ".\n\n" +
                "Cordialement,\nVotre Cabinet Médical.");

        mailSender.send(mail);
        System.out.println("Rappel envoyé avec succès à : " + patient.getEmail());
    }
}