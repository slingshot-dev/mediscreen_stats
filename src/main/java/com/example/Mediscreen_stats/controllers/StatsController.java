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

    @Autowired
    private ScoreService scoreService;



    @GetMapping("/note")
    public Integer ScoreNote(String symptom, String patientId) throws IOException, InterruptedException {
//        return statsNoteService.getStatsNotes(symptom, patientId);
        return scoreService.getScoreTotal(symptom, patientId);

    }


}
