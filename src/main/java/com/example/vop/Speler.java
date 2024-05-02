package com.example.vop;

import java.time.LocalDate;
import javafx.beans.property.*;

public class Speler {
    private SimpleStringProperty geslacht, foto;
    private SimpleObjectProperty<LocalDate> lid_sinds;
    private SimpleObjectProperty<Ervaring> ervaring;
    private SimpleObjectProperty<Persoon> persoon;

    public Speler() {
        this.geslacht = new SimpleStringProperty();
        this.foto = new SimpleStringProperty();
        this.lid_sinds = new SimpleObjectProperty<>();
        this.ervaring = new SimpleObjectProperty<>();
        this.persoon = new SimpleObjectProperty<>();
    };

    public Speler(Persoon persoon, String geslacht, LocalDate lid_sinds, Ervaring ervaring, String foto) {
        this.persoon = new SimpleObjectProperty<>(persoon);
        this.foto = new SimpleStringProperty(foto);
        this.geslacht = new SimpleStringProperty(geslacht);
        this.lid_sinds = new SimpleObjectProperty<LocalDate>(lid_sinds);
        this.ervaring = new SimpleObjectProperty<Ervaring>(ervaring);
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

    public void setLid_sinds(LocalDate lid_sinds) {
        this.lid_sinds.set(lid_sinds);
    };

    public LocalDate getLid_sinds() {
        return lid_sinds.get();
    };

    public void setErvaring(Ervaring ervaring) {
        this.ervaring.set(ervaring);
    };

    public Ervaring getErvaring() {
        return ervaring.get();
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
