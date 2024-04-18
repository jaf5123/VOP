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

    public Tennisbaan(int baannummer, boolean beschikbaar) {
        this.baannummer = new SimpleIntegerProperty(baannummer);
        this.beschikbaar = new SimpleBooleanProperty(beschikbaar);
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
