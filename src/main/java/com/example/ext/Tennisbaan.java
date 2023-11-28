package com.example.ext;

public class Tennisbaan {
    private int baannummer;
    private boolean beschikbaar;

    public Tennisbaan() {
        this.baannummer = 0;
        this.beschikbaar = false;
    };

    public Tennisbaan(int baannummer, boolean beschikbaar) {
        this.baannummer = baannummer;
        this.beschikbaar = beschikbaar;
    };

    public void setBaannummer(int baannummer) {
        this.baannummer = baannummer;
    };

    public int getBaannummer() {
        return baannummer;
    };

    public void setBeschikbaar(boolean beschikbaar) {
        this.beschikbaar = beschikbaar;
    };

    public boolean isBeschikbaar() {
        return beschikbaar;
    };
}
