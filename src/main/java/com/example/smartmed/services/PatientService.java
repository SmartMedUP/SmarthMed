package com.example.smartmed.services;
import com.example.smartmed.entities.Appointment;
import com.example.smartmed.entities.Doctor;
import com.example.smartmed.entities.Patient;
import com.example.smartmed.entities.User;
import com.example.smartmed.repositories.AppointmentRepository;
import com.example.smartmed.repositories.DoctorRepository;
import com.example.smartmed.repositories.PatientRepository;
import com.example.smartmed.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    private Patient validatePatient(Integer PatientUserId) {
        return patientRepository.findByUserIdAndUserType(PatientUserId, User.UserType.PATIENT)
                .orElseThrow(() -> new RuntimeException("utilisateur inexistant ou n'est pas un Patient"));
    }

    private Doctor validateDoctor(Integer userId) {
        return userRepository.findById(userId)
                .filter(user -> user.getUserType() == User.UserType.DOCTOR)
                .map(user -> (Doctor) user)
                .orElseThrow(() -> new RuntimeException("Utilisateur inexistant ou n'est pas un Docteur"));
    }


    public Appointment scheduleAppointment(Integer PatientUserId, Integer DoctorUserId , Timestamp appointment_date, String reason) {
        Patient patient = validatePatient(PatientUserId);
        Doctor doctor = validateDoctor(DoctorUserId);
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointment_date(appointment_date);
        appointment.setReason(reason);
        appointment.setStatus("SCHEDULED");
        appointment.setCreated_at(new Timestamp(System.currentTimeMillis()));
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Integer appointment_id, String status) {
        Appointment appointment = appointmentRepository.findById(appointment_id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }

    public Appointment cancelAppointment(Integer appointment_id) {
        Appointment appointment = appointmentRepository.findById(appointment_id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus("CANCELED");
        return appointmentRepository.save(appointment);
    }

}
