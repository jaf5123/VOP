package com.example.ext;

import java.time.LocalDate;

public class Trainer {
    private String geslacht, specialiteit;
    private LocalDate werkt_sinds;
    private Ervaring ervaring;
    private Persoon persoon;

    public Trainer() {
        this.persoon = new Persoon();
        this.geslacht = new String();
        this.werkt_sinds = null;
        this.specialiteit = new String();
        this.ervaring = Ervaring.GEEN;
    };

    public Trainer(Persoon persoon, String geslacht, LocalDate werkt_sinds, String specialiteit, Ervaring ervaring) {
        this.persoon = persoon;
        this.geslacht = geslacht;
        this.werkt_sinds = werkt_sinds;
        this.specialiteit = specialiteit;
        this.ervaring = ervaring;
    };

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    };

    public Persoon getPersoon() {
        return persoon;
    };

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    };

    public String getGeslacht() {
        return geslacht;
    };

    public void setWerkt_sinds(LocalDate werkt_sinds) {
        this.werkt_sinds = werkt_sinds;
    }

    public LocalDate getWerkt_sinds() {
        return werkt_sinds;
    }

    public void setSpecialiteit(String specialiteit) {
        this.specialiteit = specialiteit;
    }

    public String getSpecialiteit() {
        return specialiteit;
    }

    public void setErvaring(Ervaring ervaring) {
        this.ervaring = ervaring;
    };

    public Ervaring getErvaring() {
        return ervaring;
    };

    @Override
    public String toString() {
        String tekst = new String();

        tekst += "*************** Trainer info ***************\n";
        tekst += "Geslacht: " + getGeslacht() + ", specialiteit: " + getSpecialiteit() + ", ervaring: " + getErvaring() + ", en is werkt sinds " + getWerkt_sinds() + "\n";
        tekst += "Over de persoon: " + getPersoon() + "\n";

        return tekst;
    };
}
