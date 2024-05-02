package com.example.vop;

import javafx.collections.ObservableList;

public class Variables {
    private static Variables variables;
    private ObservableList<Speler> lijstMetSpelers;
    private ObservableList<Trainer> lijstMetTrainers;
    private ObservableList<Training> lijstMetTrainingen;
    private ObservableList<Tennisbaan> lijstMetTennisbanen;
    private ObservableList<Tennisclub> LijstMetTennisclubs;

    Variables() {};

    public static Variables getInstance() {
        if (variables == null) {
            variables = new Variables();
        }
        return variables;
    }

    public void setLijstMetSpelers(ObservableList<Speler> lijst) {
        lijstMetSpelers = lijst;
    };

    public void insertSpelerToList(Speler speler) { lijstMetSpelers.add(speler); };

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

    public void deleteSpelerInList(Speler speler) {
        for (int i = 0; i < lijstMetSpelers.size(); i++) {
            if (lijstMetSpelers.get(i).getPersoon().getAdres().equals(speler.getPersoon().getAdres())) {
                lijstMetSpelers.remove(i);
                break;
            }
        }
    }

    public ObservableList<Speler> getListOfSpeler() { return lijstMetSpelers; }

    public void setLijstMetTrainers(ObservableList<Trainer> lijst) {
        lijstMetTrainers = lijst;
    };

    public void insertTrainerToList(Trainer trainer) { lijstMetTrainers.add(trainer); };

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

    public void deleteTrainerInList(Trainer trainer) {
        for (int i = 0; i < lijstMetTrainers.size(); i++) {
            if (lijstMetTrainers.get(i).getPersoon().getAdres().equals(trainer.getPersoon().getAdres())) {
                lijstMetTrainers.remove(i);
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

    public void deleteTrainingInList(Training training) {
        for (int i = 0; i < lijstMetTrainingen.size(); i++) {
            if (lijstMetTrainingen.get(i).getTennisbaan().getBaannummer().equals(training.getTennisbaan().getBaannummer())) {
                lijstMetTrainingen.remove(i);
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

    public void deleteTennisbaanInList(Tennisbaan tennisbaan) {
        for (int i = 0; i < lijstMetTennisbanen.size(); i++) {
            if (lijstMetTennisbanen.get(i).getBaannummer().equals(tennisbaan.getBaannummer())) {
                lijstMetTennisbanen.remove(i);
                break;
            }
        }
    }

    public ObservableList<Tennisbaan> getListOfTennisbaan () { return lijstMetTennisbanen; }

    public void setLijstMetTennisclubs(ObservableList<Tennisclub> lijst) {
        LijstMetTennisclubs = lijst;
    };

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
}
