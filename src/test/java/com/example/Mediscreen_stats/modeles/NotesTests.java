package com.example.Mediscreen_stats.modeles;

import com.example.Mediscreen_stats.WebClient.WebClientNotes;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

@SpringBootTest
public class NotesTests {

    Notes notes = new Notes("123456", "test", "test2");

    @Test
    public void getModeleNote(){
        notes.setNote("test2");
        Assert.assertEquals(notes.getNote(),"test2");
        Assert.assertEquals(notes.getPatientId(),"test");
        Assert.assertEquals(notes.getRegId(),"123456");

    }

    @Test
    public void setNoteModeleNote(){

        notes.setNote("test3");
        notes.setPatientId("test3");
        notes.setRegId("123456");

        Assert.assertEquals(notes.getNote(),"test3");

    }

    @Test
    public void setPatientIdModeleNote(){

        notes.setPatientId("test4");

        Assert.assertEquals(notes.getPatientId(),"test4");

    }






}
