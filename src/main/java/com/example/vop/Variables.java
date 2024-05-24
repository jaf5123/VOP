package com.example.vop;

import javafx.collections.ObservableList;

public class Variables {
    private static Variables variables;
    private ObservableList<Speler> lijstMetSpelers;
    private ObservableList<Trainer> lijstMetTrainers;

    private ObservableList<Training> lijstMetTrainingen;
    private ObservableList<Tennisbaan> lijstMetTennisbanen;

    private ObservableList<Tennisclub> lijstMetTennisclubs;
    private ObservableList<Training> lijstMetWedstrijden;

    Variables() {}

    public static Variables getInstance() {
        if (variables == null) {
            variables = new Variables();
        }
        return variables;
    }

    public void setLijstMetSpelers(ObservableList<Speler> lijst) {
        lijstMetSpelers = lijst;
    }

    public void voegSpelerToAanLijst(Speler speler) {
        lijstMetSpelers.add(speler);
    }

    public int getIndexVanSpelerInLijst(Speler speler) {
        int index = 0;
        for (int i = 0; i < lijstMetSpelers.size(); i++) {
            if (lijstMetSpelers.get(i).getPersoon().getNaam().equals(speler.getPersoon().getNaam())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Speler getSpelerOpIndexInLijst(int index) {
        return lijstMetSpelers.sorted().get(index);
    }

    public void verwijderSpelerVanLijst(Speler speler) {
        for(int index = 0; index < lijstMetSpelers.size(); index++) {
            if (lijstMetSpelers.get(index).getPersoon().getNaam().equals(speler.getPersoon().getNaam())) {
                lijstMetSpelers.remove(index);
                break;
            }
        }
    }

    public ObservableList<Speler> getListOfSpeler() { return lijstMetSpelers; }

    public void setLijstMetTrainers(ObservableList<Trainer> lijst) {
        lijstMetTrainers = lijst;
    }

    public ObservableList<Speler> getLijstMetSpelers() {
        return lijstMetSpelers;
    }

    public void voegTrainerToAanLijst(Trainer trainer) {
        lijstMetTrainers.add(trainer);
    }

    public int getIndexVanTrainerInLijst(Trainer trainer) {
        int index = 0;
        for (int i = 0; i < lijstMetTrainers.size(); i++) {
            if (lijstMetTrainers.get(i).getPersoon().getNaam().equals(trainer.getPersoon().getNaam())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Trainer getTrainerOpIndexInLijst(int index) {
        return lijstMetTrainers.sorted().get(index);
    }

    public void verwijderTrainerVanLijst(Trainer trainer) {
        for(int index = 0; index < lijstMetTrainers.size(); index++) {
            if (lijstMetTrainers.get(index).getPersoon().getNaam().equals(trainer.getPersoon().getNaam())) {
                lijstMetTrainers.remove(index);

                break;
            }
        }
    }

    public ObservableList<Trainer> getListOfTrainer() { return lijstMetTrainers; }

    public void setLijstMetTrainingen(ObservableList<Training> lijst) {
        lijstMetTrainingen = lijst;
    };

    public ObservableList<Trainer> getLijstMetTrainers() {
        return lijstMetTrainers;
    }

    public void setLijstMetTennisclubs(ObservableList<Tennisclub> lijstMetTennisclubs) {
        this.lijstMetTennisclubs = lijstMetTennisclubs;
    }

    public void voegTennisclubToAanLijst(Tennisclub tennisclub) {
        lijstMetTennisclubs.add(tennisclub);
    }

    public int getIndexVanTennisclubInLijst(Tennisclub tennisclub) {
        int index = 0;
        for (int i = 0; i < lijstMetTennisclubs.size(); i++) {
            if (lijstMetTennisclubs.get(i).getClubnaam().equals(tennisclub.getClubnaam())) {

                index = i;
                break;
            }
        }
        return index;
    }

    public Tennisclub getTennisclubOpIndexInLijst(int index) {
        return lijstMetTennisclubs.sorted().get(index);
    }

    public void verwijderTennisclubVanLijst(Tennisclub tennisclub) {
        for(int index = 0; index < lijstMetTennisclubs.size(); index++) {
            if (lijstMetTennisclubs.get(index).getClubnaam().equals(tennisclub.getClubnaam())) {
                lijstMetTennisclubs.remove(index);

                break;
            }
        }
    }

    public ObservableList<Training> getListOfTrainingen() { return lijstMetTrainingen; }

    public void setLijstMetTennisbanen(ObservableList<Tennisbaan> lijst) {
        lijstMetTennisbanen = lijst;
    };

    public int getIndexOfTennisbaanInList(Tennisbaan tennisbaan) {
        int index = 0;
        for (int i = 0; i < lijstMetTennisbanen.size(); i++) {
            if (lijstMetTennisbanen.get(i).getBaannummer().equals(tennisbaan.getBaannummer())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public ObservableList<Tennisclub> getLijstMetTennisclubs() {
        return lijstMetTennisclubs;
    }

    public void setLijstMetTraining(ObservableList<Training> lijstMetWedstrijden) {
        this.lijstMetWedstrijden = lijstMetWedstrijden;
    }

    public void voegTrainingToAanLijst(Training training) {
        lijstMetWedstrijden.add(training);
    }

    public int getIndexVanTrainingInLijst(Training training) {
        int index = 0;
        for (int i = 0; i < lijstMetWedstrijden.size(); i++) {
            if (lijstMetWedstrijden.get(i).getAfgesprokenTrainer().equals(training.getAfgesprokenTrainer())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Training getTrainingOpIndexInLijst(int index) {
        return lijstMetWedstrijden.sorted().get(index);
    }

    public void verwijderTrainingVanLijst(Training training) {
        for(int index = 0; index < lijstMetWedstrijden.size(); index++) {
            if (lijstMetWedstrijden.get(index).getAfgesprokenTrainer().equals(training.getAfgesprokenTrainer())) {
                lijstMetWedstrijden.remove(index);

                break;
            }
        }
    }

    public ObservableList<Tennisbaan> getListOfTennisbaan() { return lijstMetTennisbanen; }

    public void voegTennisclubToList(Tennisclub tennisclub) { lijstMetTennisclubs.add(tennisclub); };

    public int getIndexOfTennisclubInList(Tennisclub tennisclub) {
        int index = 0;
        for (int i = 0; i < lijstMetTennisclubs.size(); i++) {
            if (lijstMetTennisclubs.get(i).getClubnaam().equals(tennisclub.getClubnaam())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void verwijderTennisclubInList(Tennisclub tennisclub) {
        for (int i = 0; i < lijstMetTennisclubs.size(); i++) {
            if (lijstMetTennisclubs.get(i).getClubnaam().equals(tennisclub.getClubnaam())) {
                lijstMetTennisclubs.remove(i);
                break;
            }
        }
    }

    public ObservableList<Tennisclub> getListOfTennisclub () { return lijstMetTennisclubs; }

    public ObservableList<Training> getLijstMetWedstrijden() {
        return lijstMetWedstrijden;

    }
}
