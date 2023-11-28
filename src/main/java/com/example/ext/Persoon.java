package com.example.ext;

import java.time.LocalDate;

public class Persoon {
    private String naam, achternaam, adres;
    private int leeftijd;
    private LocalDate geboortedatum;

    public Persoon() {
        this.naam = new String();
        this.achternaam = new String();
        this.leeftijd = 0;
        this.adres = new String();
        this.geboortedatum = null;
    }

    public Persoon(String naam, String achternaam, int leeftijd, String adres, LocalDate geboortedatum) {
        this.naam = naam;
        this.achternaam = achternaam;
        this.leeftijd = leeftijd;
        this.adres = adres;
        this.geboortedatum = geboortedatum;
    };

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getAdres() {
        return adres;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    @Override
    public String toString() {
        String tekst = new String();

        tekst += "*************** Persoon info ***************\n";
        tekst += "Naam: " + getNaam() + ", achternaam: " + getAchternaam() + ", leeftijd: " + getLeeftijd() + "\n";
        tekst += "Woont op " + getAdres() + ", en is geboren op " + getGeboortedatum() + "\n";

        return tekst;
    }
}
