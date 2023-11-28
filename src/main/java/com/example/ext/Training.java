package com.example.ext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Training {
    private LocalDate datum;
    private LocalTime start_om, eindigt_om;
    private Trainer trainer;
    private ArrayList<Speler> spelers;
    private Tennisbaan baan;

    public Training() {
        this.datum = null;
        this.baan = new Tennisbaan();
        this.start_om = null;
        this.eindigt_om = null;
        this.trainer = new Trainer();
        this.spelers = new ArrayList<Speler>();
    };

    public Training(LocalDate datum, LocalTime start_om, LocalTime eindigt_om, Trainer trainer, Tennisbaan baan) {
        this.datum = datum;
        this.baan = baan;
        this.start_om = start_om;
        this.eindigt_om = eindigt_om;
        this.trainer = trainer;
        this.spelers = new ArrayList<Speler>();
    };

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    };

    public LocalDate getDatum() {
        return datum;
    };

    public void setStart_om(LocalTime start_om) {
        this.start_om = start_om;
    };

    public LocalTime getStart_om() {
        return start_om;
    };

    public void setEindigt_om(LocalTime eindigt_om) {
        this.eindigt_om = eindigt_om;
    };

    public LocalTime getEindigt_om() {
        return eindigt_om;
    };

    public void setAfgesprokenTrainer(Trainer trainer) {
        this.trainer = trainer;
    };

    public Trainer getAfgesprokenTrainer() {
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

    public void setTennisbaan(Tennisbaan baan) {
        this.baan = baan;
    };

    public Tennisbaan getTennisbaan() {
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
