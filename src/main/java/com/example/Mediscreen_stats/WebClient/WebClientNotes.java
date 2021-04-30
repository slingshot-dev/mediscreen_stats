package com.example.Mediscreen_stats.WebClient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Service
public class WebClientNotes {

    public Integer getScore(String symptom, String patientId) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String ResourceUrl = "http://localhost:8088/api/notes/symptom";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ResourceUrl)
                .queryParam("symptom", symptom)
                .queryParam("patientId", patientId);

        ResponseEntity<Integer> response = restTemplate.getForEntity(builder.toUriString(), Integer.class);

        return response.getBody();
    }




}
