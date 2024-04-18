package com.example.ext;

import javafx.beans.property.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Training {
    private ObjectProperty<LocalDate> datum;
    private ObjectProperty<LocalTime> start_om, eindigt_om;
    private ObjectProperty<Trainer> trainer;
    private ObservableList<Speler> spelers;
    private ObjectProperty<Tennisbaan> baan;

    public Training() {
        this.datum = new SimpleObjectProperty<>();
        this.start_om = new SimpleObjectProperty<>();
        this.eindigt_om = new SimpleObjectProperty<>();
        this.trainer = new SimpleObjectProperty<>();
        this.spelers = FXCollections.observableArrayList();
        this.baan = new SimpleObjectProperty<>();
    };

    public Training(ObjectProperty<LocalDate> datum, ObjectProperty<LocalTime> start_om, ObjectProperty<LocalTime> eindigt_om, ObjectProperty<Trainer> trainer, ObjectProperty<Tennisbaan> baan) {
        this.datum = datum;
        this.baan = baan;
        this.start_om = start_om;
        this.eindigt_om = eindigt_om;
        this.trainer = trainer;
        this.spelers = FXCollections.observableArrayList();
    };

    public void setDatum(ObjectProperty<LocalDate> datum) {
        this.datum = datum;
    };

    public ObjectProperty<LocalDate> getDatum() {
        return datum;
    };

    public void setStart_om(ObjectProperty<LocalTime> start_om) {
        this.start_om = start_om;
    };

    public ObjectProperty<LocalTime> getStart_om() {
        return start_om;
    };

    public void setEindigt_om(ObjectProperty<LocalTime> eindigt_om) {
        this.eindigt_om = eindigt_om;
    };

    public ObjectProperty<LocalTime> getEindigt_om() {
        return eindigt_om;
    };

    public void setAfgesprokenTrainer(ObjectProperty<Trainer> trainer) {
        this.trainer = trainer;
    };

    public ObjectProperty<Trainer> getAfgesprokenTrainer() {
        return trainer;
    };

    public void voegSpelerToeAanTraining(Speler speler) {
        spelers.add(speler);
    };

    public void schrapSpelerVanTraining(String naam) {
        for(int i = 0; i < spelers.size(); i++) {
            if (spelers.get(i).getPersoon().getNaam().equals(naam)) {
                spelers.remove(spelers.get(i));
            };
        };
    };

    public Speler geefSpelerVanTraining(String naam) {
        Speler local = new Speler();
        for(int i = 0; i < spelers.size(); i++) {
            if (spelers.get(i).getPersoon().getNaam().equals(naam)) {
                local = spelers.get(i);
            };
        };
        return local;
    };

    public void setTennisbaan(ObjectProperty<Tennisbaan> baan) {
        this.baan = baan;
    };

    public ObjectProperty<Tennisbaan> getTennisbaan() {
        return baan;
    };

    @Override
    public String toString() {
        String tekst = new String();

        tekst += "*************** Training info ***************\n";
        tekst += "Begint op " + getDatum() + " om " + getStart_om() + " tot en met " + getEindigt_om() + "\n";
        tekst += "Trainer is " + getAfgesprokenTrainer().getPersoon().getNaam() + " en het aantal leden die meedoen zijn " + spelers.size() + "\n";
        tekst += "De training vindt zich plaats op baan " + getTennisbaan() + "\n";

        return tekst;
    };
}
