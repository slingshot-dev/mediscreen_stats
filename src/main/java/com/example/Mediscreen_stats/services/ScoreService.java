package com.example.Mediscreen_stats.services;

import com.example.Mediscreen_stats.WebClient.WebClientPatients;
import com.example.Mediscreen_stats.WebClient.WebClientNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ScoreService {

    final WebClientNotes webClientNotes;
    final WebClientPatients webClientPatients;

    public ScoreService(WebClientNotes webClientNotes, WebClientPatients webClientPatients) {
        this.webClientNotes = webClientNotes;
        this.webClientPatients = webClientPatients;
    }


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



    public Integer getAgePatient(Integer id){

        return webClientPatients.getAge(id);
    }

    public String getGenrePatient(Integer id){

        return webClientPatients.getGenrePatient(id);
    }


    public String getScoreDanger(String symptom, String patientId) throws IOException {

        int intPatientId = Integer.parseInt(patientId);
        Integer score = getScoreTotal(symptom, patientId);
        Integer age = getAgePatient(intPatientId);
        String sexe = getGenrePatient(intPatientId);
        String response = "None";


        if (score == 2 & age > 30) {
             return response = "Borderline";
        }

        if (score == 3 & age < 30 & sexe.equals("M")) {
            return response = "Danger";
        }

        if (score == 4 & age < 30 & sexe.equals("F")) {
            return response ="Danger";
        }

        if (score == 6 & age > 30 ) {
            response ="Danger";
            System.out.println(response);
            return response;
        }

        if (score == 5 & age < 30 & sexe.equals("M")) {
            return response = "Early onset";
        }

        if (score == 7 & age < 30 & sexe.equals("F")) {
            return response ="Early onset";
        }

        if (score == 8 & age > 30) {
            return response ="Early onset";
        }

        return response;
    }




    }


