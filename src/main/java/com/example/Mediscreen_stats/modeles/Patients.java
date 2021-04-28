package com.example.Mediscreen_stats.modeles;


import java.time.LocalDate;

public class Patients {

    private Integer idpatients;
    private String prenom;
    private String nom;
    private LocalDate datenaissance;
    private String genre;
    private String adresse;
    private String telephone;


    public Patients() {
    }

    public Patients(Integer idpatients, String prenom, String nom, LocalDate datenaissance, String genre, String adresse, String telephone) {
        this.idpatients = idpatients;
        this.prenom = prenom;
        this.nom = nom;
        this.datenaissance = datenaissance;
        this.genre = genre;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public Patients(Integer idpatients, String prenom, String nom, String genre, String adresse, String telephone) {
        this.idpatients = idpatients;
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.adresse = adresse;
        this.telephone = telephone;
    }


    public Integer getIdpatients() {
        return idpatients;
    }

    public void setIdpatients(Integer idpatients) {
        this.idpatients = idpatients;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(LocalDate datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
