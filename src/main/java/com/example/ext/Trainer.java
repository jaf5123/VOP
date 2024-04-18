package com.example.ext;

import java.time.LocalDate;
import javafx.beans.property.*;

public class Trainer {
    private StringProperty geslacht, specialiteit;
    private ObjectProperty<LocalDate> werkt_sinds;
    private ObjectProperty<Ervaring> ervaring;
    private ObjectProperty<Persoon> persoon;

    public Trainer() {
        this.geslacht = new SimpleStringProperty();
        this.werkt_sinds = new SimpleObjectProperty<>();
        this.specialiteit = new SimpleStringProperty();
        this.ervaring = new SimpleObjectProperty<>();
        this.persoon = new SimpleObjectProperty<>();
    };

    public void setPersoon(ObjectProperty<Persoon> persoon) {
        this.persoon = persoon;
    };

    public ObjectProperty<Persoon> getPersoon() {
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
