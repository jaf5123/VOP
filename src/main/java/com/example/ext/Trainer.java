package com.example.ext;

import java.time.LocalDate;
import javafx.beans.property.*;

public class Trainer {
    private StringProperty geslacht, specialiteit, foto;
    private ObjectProperty<LocalDate> werkt_sinds;
    private ObjectProperty<Ervaring> ervaring;
    private ObjectProperty<Persoon> persoon;

    public Trainer() {
        this.geslacht = new SimpleStringProperty();
        this.werkt_sinds = new SimpleObjectProperty<>();
        this.specialiteit = new SimpleStringProperty();
        this.foto = new SimpleStringProperty();
        this.ervaring = new SimpleObjectProperty<>();
        this.persoon = new SimpleObjectProperty<>();
    };

    public Trainer(ObjectProperty<Persoon> persoon, StringProperty geslacht, ObjectProperty<LocalDate> werkt_sinds, ObjectProperty<Ervaring> ervaring, StringProperty foto) {
        this.persoon = persoon;
        this.foto = foto;
        this.geslacht = geslacht;
        this.ervaring = ervaring;
        this.werkt_sinds = werkt_sinds;
    };

    public void setPersoon(ObjectProperty<Persoon> persoon) {
        this.persoon = persoon;
    };

    public ObjectProperty<Persoon> getPersoon() {
        return persoon;
    };

    public void setGeslacht(StringProperty geslacht) {
        this.geslacht = geslacht;
    };

    public StringProperty getGeslacht() {
        return geslacht;
    };

    public void setFoto(StringProperty foto) {
        this.foto = foto;
    }

    public StringProperty getFoto() {
        return foto;
    }

    public void setWerkt_sinds(ObjectProperty<LocalDate> werkt_sinds) {
        this.werkt_sinds = werkt_sinds;
    }

    public ObjectProperty<LocalDate> getWerkt_sinds() {
        return werkt_sinds;
    }

    public void setSpecialiteit(StringProperty specialiteit) {
        this.specialiteit = specialiteit;
    }

    public StringProperty getSpecialiteit() {
        return specialiteit;
    }

    public void setErvaring(ObjectProperty<Ervaring> ervaring) {
        this.ervaring = ervaring;
    };

    public ObjectProperty<Ervaring> getErvaring() {
        return ervaring;
    };

    @Override
    public String toString() {
        String tekst = new String();

        tekst += "*************** Trainer info ***************\n";
        tekst += "Geslacht: " + getGeslacht().get() + ", specialiteit: " + getSpecialiteit().get() + ", ervaring: " + getErvaring().get() + ", en is werkt sinds " + getWerkt_sinds().get() + "\n";
        tekst += "Over de persoon: " + getPersoon().get() + "\n";

        return tekst;
    };
}
