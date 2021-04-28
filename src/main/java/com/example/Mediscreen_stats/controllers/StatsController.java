package com.example.Mediscreen_stats.controllers;

import com.example.Mediscreen_stats.modeles.Notes;
import com.example.Mediscreen_stats.modeles.Patients;
import com.example.Mediscreen_stats.services.StatsNoteService;
import com.example.Mediscreen_stats.services.StatsPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("api/stats")
@CrossOrigin
public class StatsController {

    @Autowired
    private StatsPatientsService statsPatientsService;

    @Autowired
    private StatsNoteService statsNoteService;


    @GetMapping("/list")
    public Flux<Patients> listPatients() throws IOException {
        return statsPatientsService.getStatsPatients();
    }

    @GetMapping("/note")
    public Flux<Notes> listNote(String symptom) throws IOException {
        return statsNoteService.getStatsNotes(symptom);
    }


}
