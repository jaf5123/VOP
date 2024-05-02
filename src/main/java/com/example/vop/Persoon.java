package com.example.vop;

import java.time.LocalDate;
import javafx.beans.property.*;

public class Persoon {
    private SimpleStringProperty naam, achternaam, adres;
    private SimpleIntegerProperty leeftijd;
    private SimpleObjectProperty<LocalDate> geboortedatum;

    public Persoon() {
        this.naam = new SimpleStringProperty();
        this.achternaam = new SimpleStringProperty();
        this.leeftijd = new SimpleIntegerProperty();
        this.adres = new SimpleStringProperty();
        this.geboortedatum = new SimpleObjectProperty<>();
    }

    public Persoon(String naam, String achternaam, Integer leeftijd, String adres, LocalDate geboortedatum) {
        this.naam = new SimpleStringProperty(naam);
        this.achternaam = new SimpleStringProperty(achternaam);
        this.leeftijd = new SimpleIntegerProperty(leeftijd);
        this.adres = new SimpleStringProperty(adres);
        this.geboortedatum = new SimpleObjectProperty<>(geboortedatum);
    };

    public void setNaam(String naam) {
        this.naam.set(naam);
    }

    public String getNaam() {
        return naam.get();
    }

    public void setAchternaam(String achternaam) {
        this.achternaam.set(achternaam);
    }

    public String getAchternaam() {
        return achternaam.get();
    }

    public void setAdres(String adres) {
        this.adres.set(adres);
    }

    public String getAdres() {
        return adres.get();
    }

    public void setLeeftijd(Integer leeftijd) {
        this.leeftijd.set(leeftijd);
    }

    public Integer getLeeftijd() {
        return leeftijd.get();
    }

    public void setGeboortedatum(LocalDate geboortedatum) {
        this.geboortedatum.set(geboortedatum);
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum.get();
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
