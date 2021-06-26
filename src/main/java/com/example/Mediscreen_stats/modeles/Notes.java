package com.example.Mediscreen_stats.modeles;

public class Notes {

    private String regId;
    private String patientId;
    private String note;


    public Notes(String regId, String patientId, String note) {
        this.regId = regId;
        this.patientId = patientId;
        this.note = note;
    }

    public Notes() {
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
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
