package com.example.Mediscreen_stats.controllers;

import com.example.Mediscreen_stats.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/stats")
@CrossOrigin
public class StatsController {

    private final ScoreService scoreService;

    public StatsController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/note")
    public String ScoreNote(String symptom, String patientId) throws IOException, InterruptedException {
        return scoreService.getScoreDanger(symptom, patientId);
    }
}
