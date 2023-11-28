package com.example.ext;

import java.time.LocalDate;

public class Speler {
    private String geslacht;
    private LocalDate lid_sinds;
    private Ervaring ervaring;
    private Persoon persoon;

    public Speler() {
        this.persoon = new Persoon();
        this.geslacht = new String();
        this.lid_sinds = null;
        this.ervaring = Ervaring.GEEN;
    };

    public Speler(Persoon persoon, String geslacht, LocalDate lid_sinds, Ervaring ervaring) {
        this.persoon = persoon;
        this.geslacht = geslacht;
        this.lid_sinds = lid_sinds;
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

    public void setLid_sinds(LocalDate lid_sinds) {
        this.lid_sinds = lid_sinds;
    };

    public LocalDate getLid_sinds() {
        return lid_sinds;
    };

    public void setErvaring(Ervaring ervaring) {
        this.ervaring = ervaring;
    };

    public Ervaring getErvaring() {
        return ervaring;
    };

    @Override
    public String toString() {
        String tekst = new String();

        tekst += "*************** Speler info ***************\n";
        tekst += "Geslacht: " + getGeslacht() + ", ervaring: " + getErvaring() + ", en is lid sinds " + getLid_sinds() + "\n";
        tekst += "Over de persoon: " + getPersoon() + "\n";

        return tekst;
    };
}
