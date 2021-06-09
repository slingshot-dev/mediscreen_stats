package com.example.Mediscreen_stats.controllers;

import com.example.Mediscreen_stats.MediscreenStatsApplication;
import com.example.Mediscreen_stats.services.ScoreService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;


@SpringBootTest(classes=MediscreenStatsApplication.class)
public class StatsControllerTests {

    StatsController statsController;

    @Mock
    ScoreService scoreService;

    @BeforeEach
    public void init(){
        statsController=new StatsController(scoreService);
    }


    @Test
    public void getnote() throws Exception {
        // Arange & Act
        when(scoreService.getScoreDanger(anyString(), anyString())).thenReturn("1");

        statsController.ScoreNote("diabete", "1");

    }


}
