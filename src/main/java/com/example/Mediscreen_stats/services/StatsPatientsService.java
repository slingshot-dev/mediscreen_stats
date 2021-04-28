package com.example.Mediscreen_stats.services;

import com.example.Mediscreen_stats.modeles.Patients;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.DataInput;
import java.io.IOException;
import java.util.List;

@Service
public class StatsPatientsService {


    WebClient webClient = WebClient.create("http://localhost:8080");

    public Flux<Patients> getStatsPatients() throws IOException {

        Flux<Patients> statsStream = webClient
                .get()
                .uri("/api/patients/list")
                .retrieve().bodyToFlux(Patients.class);

        return statsStream;
    }


}
