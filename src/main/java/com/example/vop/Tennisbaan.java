package com.example.vop;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Tennisbaan {
    private SimpleIntegerProperty baannummer;
    private SimpleBooleanProperty beschikbaar;

    public Tennisbaan() {
        this.baannummer = new SimpleIntegerProperty();
        this.beschikbaar = new SimpleBooleanProperty();
    };

    public Tennisbaan(Integer baannummer, Boolean beschikbaar) {
        this.baannummer = new SimpleIntegerProperty(baannummer);
        this.beschikbaar = new SimpleBooleanProperty(beschikbaar);
    };

    public void setBaannummer(Integer baannummer) {
        this.baannummer.set(baannummer);
    };

    public Integer getBaannummer() {
        return baannummer.get();
    };

    public void setBeschikbaar(Boolean beschikbaar) {
        this.beschikbaar.set(beschikbaar);
    };

    public Boolean isBeschikbaar() {
        return beschikbaar.get();
    };
}
