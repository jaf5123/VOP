package com.example.vop;

import javafx.beans.property.*;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Training {
    private SimpleObjectProperty<LocalDate> datum;
    private SimpleObjectProperty<LocalTime> start_om, eindigt_om;
    private SimpleObjectProperty<Trainer> trainer;
    private ObservableList<Speler> spelers;
    private SimpleObjectProperty<Tennisbaan> baan;

    public Training() {
        this.datum = new SimpleObjectProperty<>();
        this.start_om = new SimpleObjectProperty<>();
        this.eindigt_om = new SimpleObjectProperty<>();
        this.trainer = new SimpleObjectProperty<>();
        this.spelers = FXCollections.observableArrayList();
        this.baan = new SimpleObjectProperty<>();
    };

    public Training(LocalDate datum, LocalTime start_om, LocalTime eindigt_om, Trainer trainer, Tennisbaan baan) {
        this.datum = new SimpleObjectProperty<>(datum);
        this.baan = new SimpleObjectProperty<>(baan);
        this.start_om = new SimpleObjectProperty<>(start_om);
        this.eindigt_om = new SimpleObjectProperty<>(eindigt_om);
        this.trainer = new SimpleObjectProperty<>(trainer);
        this.spelers = FXCollections.observableArrayList();
    };

    public void setDatum(LocalDate datum) {
        this.datum.set(datum);
    };

    public LocalDate getDatum() {
        return datum.get();
    };

    public void setStart_om(LocalTime start_om) {
        this.start_om.set(start_om);
    };

    public LocalTime getStart_om() {
        return getEindigt_om();
    };

    public void setEindigt_om(LocalTime eindigt_om) {
        this.eindigt_om.set(eindigt_om);
    };

    public LocalTime getEindigt_om() {
        return eindigt_om.get();
    };

    public void setAfgesprokenTrainer(Trainer trainer) {
        this.trainer.set(trainer);
    };

    public Trainer getAfgesprokenTrainer() {
        return trainer.get();
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

    public void setTennisbaan(Tennisbaan baan) {
        this.baan.set(baan);
    };

    public Tennisbaan getTennisbaan() {
        return baan.get();
    };

    @Override
    public String toString() {
        String tekst = new String();

        tekst += "*************** Training info ***************\n";
        tekst += "Begint op " + getDatum() + " om " + getStart_om() + " tot en met " + getEindigt_om() + "\n";
        tekst += "Trainer is " + getAfgesprokenTrainer() + " en het aantal leden die meedoen zijn " + spelers.size() + "\n";
        tekst += "De training vindt zich plaats op baan " + getTennisbaan() + "\n";

        return tekst;
    };
}
