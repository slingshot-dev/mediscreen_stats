package com.example.Mediscreen_stats.WebClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WebClientPatients {

    private final RestTemplate restTemplate;
    @Autowired
    public WebClientPatients(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Integer getAge(Integer patientId){

//        RestTemplate restTemplate = new RestTemplate();
        String ResourceUrl = "http://localhost:8080/api/patients/age";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ResourceUrl)
                .queryParam("id", patientId);

        ResponseEntity<Integer> response = restTemplate.getForEntity(builder.toUriString(), Integer.class);

        return response.getBody();
    }


    public String getGenrePatient(Integer patientId){

//        RestTemplate restTemplate = new RestTemplate();
        String ResourceUrl = "http://localhost:8080/api/patients/genre/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ResourceUrl)
                .queryParam("id", patientId);

        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);
        System.out.println(builder.toUriString());
        System.out.println(response);


        return response.getBody();
    }


}
