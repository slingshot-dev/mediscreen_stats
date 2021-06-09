package com.example.Mediscreen_stats.webClient;

import com.example.Mediscreen_stats.WebClient.WebClientNotes;
import com.example.Mediscreen_stats.WebClient.WebClientPatients;
import com.example.Mediscreen_stats.controllers.StatsController;
import com.example.Mediscreen_stats.modeles.Notes;
import com.example.Mediscreen_stats.services.ScoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WebClientsTests {

    @Autowired
    WebClientNotes webClientNotes;

    @Autowired
    WebClientPatients webClientPatients;

    @Autowired
    ScoreService scoreService;

    private final RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

    @BeforeEach
    public void setup() {
        webClientNotes = new WebClientNotes(restTemplate);
        webClientPatients = new WebClientPatients(restTemplate);
    }

    @Test
    public void getScore() {


      when(restTemplate.getForEntity("http://localhost:8088/api/notes/symptom?symptom=Taille&patientId=1", Integer.class)).thenReturn(new ResponseEntity(2, HttpStatus.OK));
      Assert.assertTrue(webClientNotes.getScore("Taille", "1") == 2);
    }


    @Test
    public void getAge() {

        when(restTemplate.getForEntity("http://localhost:8080/api/patients/age?id=1", Integer.class)).thenReturn(new ResponseEntity(31, HttpStatus.OK));
        Assert.assertTrue(webClientPatients.getAge(1) == 31);
    }

    @Test
    public void getGenre() {

        when(restTemplate.getForEntity("http://localhost:8080/api/patients/genre/?id=1", String.class)).thenReturn(new ResponseEntity("F", HttpStatus.OK));
        Assert.assertTrue(webClientPatients.getGenrePatient(1) == "F");
    }

}
