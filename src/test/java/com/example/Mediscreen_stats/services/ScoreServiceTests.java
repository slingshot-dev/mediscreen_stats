package com.example.Mediscreen_stats.services;

import com.example.Mediscreen_stats.WebClient.WebClientNotes;
import com.example.Mediscreen_stats.controllers.StatsController;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ScoreServiceTests {

    StatsController statsController;

    @Mock
    ScoreService scoreService;

    @BeforeEach
    public void init(){
        statsController=new StatsController(scoreService);
    }


    @Test
    public void getnote() throws Exception {
        // Arange
        when(scoreService.getAgePatient(1)).thenReturn(50);
        when(scoreService.getGenrePatient(1)).thenReturn("M");
        when(scoreService.getScoreTotal(anyString(), anyString())).thenReturn(2);
        when(scoreService.getScoreDanger(anyString(), anyString())).thenCallRealMethod();

        //act
        Assert.assertEquals(statsController.ScoreNote("Taille", "1"), "Borderline");

    }

    @Test
    public void getnote2() throws Exception {
        // Arange
        when(scoreService.getAgePatient(1)).thenReturn(28);
        when(scoreService.getGenrePatient(1)).thenReturn("M");
        when(scoreService.getScoreTotal(anyString(), anyString())).thenReturn(3);
        when(scoreService.getScoreDanger(anyString(), anyString())).thenCallRealMethod();

        //act
        Assert.assertEquals(statsController.ScoreNote("Taille", "1"), "Danger");

    }


    @Test
    public void getnote3() throws Exception {
        // Arange
        when(scoreService.getAgePatient(1)).thenReturn(28);
        when(scoreService.getGenrePatient(1)).thenReturn("F");
        when(scoreService.getScoreTotal(anyString(), anyString())).thenReturn(4);
        when(scoreService.getScoreDanger(anyString(), anyString())).thenCallRealMethod();

        //act
        Assert.assertEquals(statsController.ScoreNote("Taille", "1"), "Danger");

    }

    @Test
    public void getnote4() throws Exception {
        // Arange
        when(scoreService.getAgePatient(1)).thenReturn(31);
        when(scoreService.getGenrePatient(1)).thenReturn("F");
        when(scoreService.getScoreTotal(anyString(), anyString())).thenReturn(6);
        when(scoreService.getScoreDanger(anyString(), anyString())).thenCallRealMethod();

        //act
        Assert.assertEquals(statsController.ScoreNote("Taille", "1"), "Danger");

    }

    @Test
    public void getnote5() throws Exception {
        // Arange
        when(scoreService.getAgePatient(1)).thenReturn(29);
        when(scoreService.getGenrePatient(1)).thenReturn("M");
        when(scoreService.getScoreTotal(anyString(), anyString())).thenReturn(5);
        when(scoreService.getScoreDanger(anyString(), anyString())).thenCallRealMethod();

        //act
        Assert.assertEquals(statsController.ScoreNote("Taille", "1"), "Early onset");

    }

    @Test
    public void getnote6() throws Exception {
        // Arange
        when(scoreService.getAgePatient(1)).thenReturn(29);
        when(scoreService.getGenrePatient(1)).thenReturn("F");
        when(scoreService.getScoreTotal(anyString(), anyString())).thenReturn(7);
        when(scoreService.getScoreDanger(anyString(), anyString())).thenCallRealMethod();

        //act
        Assert.assertEquals(statsController.ScoreNote("Taille", "1"), "Early onset");

    }

    @Test
    public void getnote7() throws Exception {
        // Arange
        when(scoreService.getAgePatient(1)).thenReturn(31);
        when(scoreService.getGenrePatient(1)).thenReturn("F");
        when(scoreService.getScoreTotal(anyString(), anyString())).thenReturn(8);
        when(scoreService.getScoreDanger(anyString(), anyString())).thenCallRealMethod();

        //act
        Assert.assertEquals(statsController.ScoreNote("Taille", "1"), "Early onset");

    }

}
