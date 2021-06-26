package com.example.Mediscreen_stats.WebClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class WebClientNotes {

    private final RestTemplate restTemplate;

    @Autowired
    public WebClientNotes(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Integer getScore(String symptom, String patientId) {

        String ResourceUrl = "http://localhost:8088/api/notes/symptom";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ResourceUrl)
                .queryParam("symptom", symptom)
                .queryParam("patientId", patientId);

        ResponseEntity<Integer> response = restTemplate.getForEntity(builder.toUriString(), Integer.class);
        System.out.println(builder.toUriString());

        return response.getBody();
    }

}
