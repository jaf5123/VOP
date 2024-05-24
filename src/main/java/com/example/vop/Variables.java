package com.example.vop;

import javafx.collections.ObservableList;

public class Variables {
    private static Variables variables;
    private ObservableList<Speler> lijstMetSpelers;
    private ObservableList<Trainer> lijstMetTrainers;
    private ObservableList<Training> lijstMetTrainingen;
    private ObservableList<Tennisbaan> lijstMetTennisbanen;
    private ObservableList<Tennisclub> lijstMetTennisclubs;

    private Variables() {}

    public static Variables getInstance() {
        if (variables == null) {
            variables = new Variables();
        }
        return variables;
    }

    // Speler methods
    public void setLijstMetSpelers(ObservableList<Speler> lijst) { lijstMetSpelers = lijst; }
    public void voegSpelerToAanLijst(Speler speler) { lijstMetSpelers.add(speler); }
    public int getIndexVanSpelerInLijst(Speler speler) {
        for (int i = 0; i < lijstMetSpelers.size(); i++) {
            if (lijstMetSpelers.get(i).getPersoon().getNaam().equals(speler.getPersoon().getNaam())) {
                return i;
            }
        }
        return -1;
    }
    public Speler getSpelerOpIndexInLijst(int index) { return lijstMetSpelers.get(index); }
    public void verwijderSpelerVanLijst(Speler speler) { lijstMetSpelers.remove(speler); }
    public void verwijderSpelerVanLijstOpIndex(int index) {lijstMetSpelers.remove(index); }
    public ObservableList<Speler> getLijstMetSpelers() { return lijstMetSpelers; }

    // Trainer methods
    public void setLijstMetTrainers(ObservableList<Trainer> lijst) { lijstMetTrainers = lijst; }
    public void voegTrainerToAanLijst(Trainer trainer) { lijstMetTrainers.add(trainer); }
    public int getIndexVanTrainerInLijst(Trainer trainer) {
        for (int i = 0; i < lijstMetTrainers.size(); i++) {
            if (lijstMetTrainers.get(i).getPersoon().getNaam().equals(trainer.getPersoon().getNaam())) {
                return i;
            }
        }
        return -1;
    }
    public Trainer getTrainerOpIndexInLijst(int index) { return lijstMetTrainers.get(index); }
    public void verwijderTrainerVanLijst(Trainer trainer) { lijstMetTrainers.remove(trainer); }
    public void verwijderTrainerVanLijstOpIndex(int index) {lijstMetTrainers.remove(index); }
    public ObservableList<Trainer> getLijstMetTrainers() { return lijstMetTrainers; }

    // Tennisclub methods
    public void setLijstMetTennisclubs(ObservableList<Tennisclub> lijst) { lijstMetTennisclubs = lijst; }
    public void voegTennisclubToAanLijst(Tennisclub tennisclub) { lijstMetTennisclubs.add(tennisclub); }
    public int getIndexVanTennisclubInLijst(Tennisclub tennisclub) {
        for (int i = 0; i < lijstMetTennisclubs.size(); i++) {
            if (lijstMetTennisclubs.get(i).getClubnaam().equals(tennisclub.getClubnaam())) {
                return i;
            }
        }
        return -1;
    }
    public Tennisclub getTennisclubOpIndexInLijst(int index) { return lijstMetTennisclubs.get(index); }
    public void verwijderTennisclubVanLijst(Tennisclub tennisclub) { lijstMetTennisclubs.remove(tennisclub); }
    public void verwijderTennisclubVanLijstOpIndex(int index) {lijstMetTennisclubs.remove(index); }
    public ObservableList<Tennisclub> getLijstMetTennisclubs() { return lijstMetTennisclubs; }

    // Training methods
    public void setLijstMetTrainingen(ObservableList<Training> lijst) { lijstMetTrainingen = lijst; }
    public void voegTrainingToAanLijst(Training training) { lijstMetTrainingen.add(training); }
    public int getIndexVanTrainingInLijst(Training training) {
        for (int i = 0; i < lijstMetTrainingen.size(); i++) {
            if (lijstMetTrainingen.get(i).getAfgesprokenTrainer().equals(training.getAfgesprokenTrainer())) {
                return i;
            }
        }
        return -1;
    }
    public Training getTrainingOpIndexInLijst(int index) { return lijstMetTrainingen.get(index); }
    public void verwijderTrainingVanLijst(Training training) { lijstMetTrainingen.remove(training); }
    public void verwijderTrainingVanLijstOpIndex(int index) {lijstMetTrainingen.remove(index); }
    public ObservableList<Training> getLijstMetTrainingen() { return lijstMetTrainingen; }

    // Tennisbaan methods
    public void setLijstMetTennisbanen(ObservableList<Tennisbaan> lijst) { lijstMetTennisbanen = lijst; }
    public int getIndexVanTennisbaanInLijst(Tennisbaan tennisbaan) {
        for (int i = 0; i < lijstMetTennisbanen.size(); i++) {
            if (lijstMetTennisbanen.get(i).getBaannummer().equals(tennisbaan.getBaannummer())) {
                return i;
            }
        }
        return -1;
    }

    public Tennisbaan getTennisbaanOpIndexInLijst(int index) { return lijstMetTennisbanen.get(index); }

    public ObservableList<Tennisbaan> getLijstMetTennisbanen() { return lijstMetTennisbanen; }
    public void verwijderTennisbanenVanLijst(Tennisbaan tennisbaan) {lijstMetTennisbanen.remove(tennisbaan); }
    public void verwijderTennisbanenVanLijstOpIndex(int index) {lijstMetTennisbanen.remove(index); }
}