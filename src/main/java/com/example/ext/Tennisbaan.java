package com.example.ext;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Tennisbaan {
    private IntegerProperty baannummer;
    private BooleanProperty beschikbaar;

    public Tennisbaan() {
        this.baannummer = new SimpleIntegerProperty();
        this.beschikbaar = new SimpleBooleanProperty();
    };

    public Tennisbaan(IntegerProperty baannummer, BooleanProperty beschikbaar) {
        this.baannummer = baannummer;
        this.beschikbaar = beschikbaar;
    };

    public void setBaannummer(IntegerProperty baannummer) {
        this.baannummer = baannummer;
    };

    public IntegerProperty getBaannummer() {
        return baannummer;
    };

    public void setBeschikbaar(BooleanProperty beschikbaar) {
        this.beschikbaar = beschikbaar;
    };

    public BooleanProperty isBeschikbaar() {
        return beschikbaar;
    };
}
