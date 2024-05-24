package com.example.vop;

import java.time.LocalDate;
import javafx.beans.property.*;

public class Trainer {
    private SimpleStringProperty geslacht, specialiteit, foto;
    private SimpleObjectProperty<LocalDate> werkt_sinds;
    private SimpleObjectProperty<Ervaring> ervaring;
    private SimpleObjectProperty<Persoon> persoon;

    public Trainer() {
        this.geslacht = new SimpleStringProperty();
        this.werkt_sinds = new SimpleObjectProperty<>();
        this.specialiteit = new SimpleStringProperty();
        this.foto = new SimpleStringProperty();
        this.ervaring = new SimpleObjectProperty<>();
        this.persoon = new SimpleObjectProperty<>();
    };

    public Trainer(Persoon persoon, String specialiteit, String geslacht, LocalDate werkt_sinds, Ervaring ervaring, String foto) {
        this.persoon = new SimpleObjectProperty<>(persoon);
        this.foto = new SimpleStringProperty(foto);
        this.geslacht = new SimpleStringProperty(geslacht);
        this.specialiteit = new SimpleStringProperty(specialiteit);
        this.ervaring = new SimpleObjectProperty<Ervaring>(ervaring);
        this.werkt_sinds = new SimpleObjectProperty<LocalDate>(werkt_sinds);
    };

    public void setPersoon(Persoon persoon) {
        this.persoon.set(persoon);
    };

    public Persoon getPersoon() {
        return persoon.get();
    };

    public void setGeslacht(String geslacht) {
        this.geslacht.set(geslacht);
    };

    public String getGeslacht() {
        return geslacht.get();
    };

    public void setFoto(String foto) {
        this.foto.set(foto);
    }

    public String getFoto() {
        return foto.get();
    }

    public void setWerkt_sinds(LocalDate werkt_sinds) {
        this.werkt_sinds.set(werkt_sinds);
    }

    public LocalDate getWerkt_sinds() {
        return werkt_sinds.get();
    }

    public void setSpecialiteit(String specialiteit) {
        this.specialiteit.set(specialiteit);
    }

    public String getSpecialiteit() {
        return specialiteit.get();
    }

    public void setErvaring(Ervaring ervaring) {
        this.ervaring.set(ervaring);
    };

    public Ervaring getErvaring() {
        return ervaring.get();
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
