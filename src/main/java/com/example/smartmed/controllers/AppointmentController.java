package com.example.smartmed.controllers;

import com.example.smartmed.services.RappelAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    @Autowired
    private RappelAppointmentService rappelService;

    //test
    @GetMapping("/test-rappel")
    public String testRappel() {
        try {
            rappelService.envoyerRappels();
            return "Rappels envoyés avec succès !";
        } catch (Exception e) {
            return "Erreur lors du test de rappel : " + e.getMessage();
        }
    }
}
