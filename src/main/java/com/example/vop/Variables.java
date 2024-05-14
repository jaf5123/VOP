package com.example.vop;

import javafx.collections.ObservableList;

public class Variables {
    private static Variables variables;
    private ObservableList<Speler> lijstMetSpelers;
    private ObservableList<Trainer> lijstMetTrainers;

    private ObservableList<Training> lijstMetTrainingen;
    private ObservableList<Tennisbaan> lijstMetTennisbanen;
    private ObservableList<Tennisclub> LijstMetTennisclubs;

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

    public void insertSpelerToList(Speler speler) { lijstMetSpelers.add(speler); }

    public int getIndexOfSpelerInList(Speler speler) {
        int index = 0;
        for (int i = 0; i < lijstMetSpelers.size(); i++) {
            if (lijstMetSpelers.get(i).getPersoon().getAdres().equals(speler.getPersoon().getAdres())) {
                index = i;
                break;
            }
        }
        return index;
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


    public void deleteSpelerInList(Speler speler) {
        for (int i = 0; i < lijstMetSpelers.size(); i++) {
            if (lijstMetSpelers.get(i).getPersoon().getAdres().equals(speler.getPersoon().getAdres())) {
                lijstMetSpelers.remove(i);
                break;
            }
        }
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

    public void insertTrainerToList(Trainer trainer) { lijstMetTrainers.add(trainer); }

    public int getIndexOfTrainerInList(Trainer trainer) {
        int index = 0;
        for (int i = 0; i < lijstMetTrainers.size(); i++) {
            if (lijstMetTrainers.get(i).getPersoon().getAdres().equals(trainer.getPersoon().getAdres())) {
                index = i;
                break;
            }
        }
        return index;
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


    public void deleteTrainerInList(Trainer trainer) {
        for (int i = 0; i < lijstMetTrainers.size(); i++) {
            if (lijstMetTrainers.get(i).getPersoon().getAdres().equals(trainer.getPersoon().getAdres())) {
                lijstMetTrainers.remove(i);
                break;
            }
        }
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

    public ObservableList<Trainer> getListOfTrainer () { return lijstMetTrainers; }

    public void setLijstMetTrainingen(ObservableList<Training> lijst) {
        lijstMetTrainingen = lijst;
    };

    public void insertTrainingToList(Training training) { lijstMetTrainingen.add(training); };

    public int getIndexOfTrainingInList(Training training) {
        int index = 0;
        for (int i = 0; i < lijstMetTrainingen.size(); i++) {
            if (lijstMetTrainingen.get(i).getTennisbaan().getBaannummer().equals(training.getTennisbaan().getBaannummer())) {
                index = i;
                break;
            }
        }
        return index;
    }

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


    public void deleteTrainingInList(Training training) {
        for (int i = 0; i < lijstMetTrainingen.size(); i++) {
            if (lijstMetTrainingen.get(i).getTennisbaan().getBaannummer().equals(training.getTennisbaan().getBaannummer())) {
                lijstMetTrainingen.remove(i);
                break;
            }
        }
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


    public ObservableList<Training> getListOfTrainginen () { return lijstMetTrainingen; }

    public void setLijstMetTennisbanen(ObservableList<Tennisbaan> lijst) {
        lijstMetTennisbanen = lijst;
    };

    public void insertTennisbaanToList(Tennisbaan tennisbaan) { lijstMetTennisbanen.add(tennisbaan); };

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

    public void setLijstMetWedstrijden(ObservableList<Training> lijstMetWedstrijden) {
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


    public void deleteTennisbaanInList(Tennisbaan tennisbaan) {
        for (int i = 0; i < lijstMetTennisbanen.size(); i++) {
            if (lijstMetTennisbanen.get(i).getBaannummer().equals(tennisbaan.getBaannummer())) {
                lijstMetTennisbanen.remove(i);
                break;
            }
        }
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

    public void insertTennisclubToList(Tennisclub tennisclub) { LijstMetTennisclubs.add(tennisclub); };

    public int getIndexOfTennisclubInList(Tennisclub tennisclub) {
        int index = 0;
        for (int i = 0; i < LijstMetTennisclubs.size(); i++) {
            if (LijstMetTennisclubs.get(i).getClubnaam().equals(tennisclub.getClubnaam())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void deleteTennisclubInList(Tennisclub tennisclub) {
        for (int i = 0; i < LijstMetTennisclubs.size(); i++) {
            if (LijstMetTennisclubs.get(i).getClubnaam().equals(tennisclub.getClubnaam())) {
                LijstMetTennisclubs.remove(i);
                break;
            }
        }
    }

    public ObservableList<Tennisclub> getListOfTennisclub () { return LijstMetTennisclubs; }

    public ObservableList<Training> getLijstMetWedstrijden() {
        return lijstMetWedstrijden;

    }

}
