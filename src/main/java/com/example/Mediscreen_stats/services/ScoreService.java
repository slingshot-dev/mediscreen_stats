package com.example.Mediscreen_stats.services;

import com.example.Mediscreen_stats.WebClient.WebClientNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ScoreService {

    @Autowired
    WebClientNotes webClientNotes;

    public Integer getScoreTotal(String symptom, String patientId) throws IOException {

        List<String> triggersConst = Arrays.asList("Hémoglobine A1C","Microalbumine","Taille","Poids","Fumeur","Anormal", "Cholesterol","Vertige","Rechute","Réaction","Anticorps");
        int count = 0;

        for(String s : triggersConst) {
            Integer result = webClientNotes.getScore(s, patientId);
            if (result > 0) {
                count++;
              }
            }
        return count;
        }

    }


