package com.example.Mediscreen_stats.modeles;


public class Stats {

    private String patientId;
    private String note;


    public Stats(String patientId, String note) {
        this.patientId = patientId;
        this.note = note;
    }

    public Stats() {
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
