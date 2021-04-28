package com.example.Mediscreen_stats.services;

import com.example.Mediscreen_stats.modeles.Notes;
import com.example.Mediscreen_stats.modeles.Patients;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.DataInput;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class StatsNoteService {

    WebClient webClient = WebClient.create("http://localhost:8088");

    public Flux<Notes> getStatsNotes(String symptom) throws IOException {

        Flux<Notes> statsStream = webClient
                .get()
                .uri("/api/notes/symptom/?symptom="+symptom)
                .retrieve().bodyToFlux(Notes.class);

/*        Map<String, String> map1 = statsStream.collectMap(item -> {return item.getRegId();},
                item -> {return item.getPatientId();});*/

        return statsStream;
    }

}
