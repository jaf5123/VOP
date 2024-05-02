package com.example.vop;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.*;

public class Tennisclub {
    private SimpleStringProperty clubmanager, clubnaam, locatie, telefoonnummer;
    private SimpleObjectProperty<LocalTime> openingsuur, sluitingsuur;
    private ObservableList<Speler> aantalleden;
    private ObservableList<Tennisbaan> aantaltennisbanen;
    private ObservableList<Trainer> aantaltrainers;
    private ObservableList<Training> aantaltrainingsmomenten;

    public Tennisclub() {
        this.clubmanager = new SimpleStringProperty();
        this.clubnaam = new SimpleStringProperty();
        this.locatie = new SimpleStringProperty();
        this.telefoonnummer = new SimpleStringProperty();
        this.openingsuur = new SimpleObjectProperty<>();
        this.sluitingsuur = new SimpleObjectProperty<>();
        this.aantalleden = FXCollections.observableArrayList();
        this.aantaltennisbanen = FXCollections.observableArrayList();
        this.aantaltrainers = FXCollections.observableArrayList();
        this.aantaltrainingsmomenten = FXCollections.observableArrayList();
    };

    public Tennisclub(String clubmanager, String clubnaam, String locatie, String telefoonnummer, LocalTime openingsuur, LocalTime sluitingsuur) {
        this.clubmanager = new SimpleStringProperty(clubmanager);
        this.clubnaam = new SimpleStringProperty(clubnaam);
        this.locatie = new SimpleStringProperty(locatie);
        this.telefoonnummer = new SimpleStringProperty(telefoonnummer);
        this.openingsuur = new SimpleObjectProperty<LocalTime>(openingsuur);
        this.sluitingsuur = new SimpleObjectProperty<LocalTime>(sluitingsuur);
        this.aantalleden = FXCollections.observableArrayList();
        this.aantaltennisbanen = FXCollections.observableArrayList();
        this.aantaltrainers = FXCollections.observableArrayList();
        this.aantaltrainingsmomenten = FXCollections.observableArrayList();
    };

    public void setClubmanager(String clubmanager) {
        this.clubmanager.set(clubmanager);
    }

    public String getClubmanager() {
        return clubmanager.get();
    }

    public void setClubnaam(String clubnaam) {
        this.clubnaam.set(clubnaam);
    }

    public String getClubnaam() {
        return clubnaam.get();
    }

    public void setLocatie(String locatie) {
        this.locatie.set(locatie);;
    }

    public String getLocatie() {
        return locatie.get();
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer.set(telefoonnummer);
    }

    public String getTelefoonnummer() {
        return telefoonnummer.get();
    }

    public void setOpeningsuur(LocalTime openingsuur) {
        this.openingsuur.set(openingsuur);
    }

    public LocalTime getOpeningsuur() {
        return openingsuur.get();
    }

    public void setSluitingsuur(LocalTime sluitingsuur) {
        this.sluitingsuur.set(sluitingsuur);
    }

    public LocalTime getSluitingsuur() {
        return sluitingsuur.get();
    }

    @Override
    public String toString() {
        String tekst = new String();

        /*
        * hier ga ik nog aan werken op een latere periode.
        * */

        return tekst;
    }

    public void voegSpelerToeAanLijst(Speler speler) {
        aantalleden.add(speler);
    }

    public void schrapSpelerVanLijst(String naam) {
        for(int i = 0; i < aantalleden.size(); i++) {
            if (aantalleden.get(i).getPersoon().getNaam().equals(naam)) {
                aantalleden.remove(aantalleden.get(i));
            };
        };
    }

    public Speler getSpelerVanLijst(String naam) {
        Speler local = new Speler();
        for(int i = 0; i < aantalleden.size(); i++) {
            if (aantalleden.get(i).getPersoon().getNaam().equals(naam)) {
                local = aantalleden.get(i);
            };
        };
        return local;
    }
    public int getAantalSpelers() {
        return aantalleden.size();
    };

    public void voegSpelerToeAanLijst(Tennisbaan baan) {
        aantaltennisbanen.add(baan);
    }

    public void schrapSpelerVanLijst(Integer baannummer) {
        for (Tennisbaan baan : aantaltennisbanen) {
            if (baan.getBaannummer() == baannummer) {
                aantaltennisbanen.remove(baan);
            };
        };
    }

    public Tennisbaan getTennisbaanVanLijst(Integer baannummer) {
        Tennisbaan local = new Tennisbaan();
        for (Tennisbaan baan : aantaltennisbanen) {
            if (baan.getBaannummer() == baannummer) {
                local = baan;
            };
        };
        return local;
    }
    public int getAantalTennisbanen() {
        return aantaltennisbanen.size();
    };

    public void voegTrainerToeAanLijst(Trainer trainer) {
        aantaltrainers.add(trainer);
    }

    public void schrapTrainerVanLijst(String naam) {
        for (Trainer trainer : aantaltrainers) {
            if (trainer.getPersoon().getNaam().equals(naam)) {
                aantaltrainers.remove(trainer);
            };
        };
    }

    public Trainer getTrainerVanLijst(String naam) {
        Trainer local = new Trainer();
        for (Trainer trainer : aantaltrainers) {
            if (trainer.getPersoon().getNaam().equals(naam)) {
                local = trainer;
            };
        };
        return local;
    }
    public int getAantalTrainers() {
        return aantaltrainers.size();
    };

    public void voegTrainingsmomentToeAanLijst(Training training) {
        aantaltrainingsmomenten.add(training);
    }

    public void schrapTrainingsmomentVanLijst(LocalDate datum) {
        for (Training training : aantaltrainingsmomenten) {
            if (training.getDatum().equals(datum)) {
                aantaltrainingsmomenten.remove(training);
            };
        };
    }

    public Training getTrainingsmomentVanLijst(LocalDate datum) {
        Training local = new Training();
        for (Training training : aantaltrainingsmomenten) {
            if (training.getDatum().equals(datum)) {
                local = training;
            };
        };
        return local;
    }
    public int getAantalTrainingmomenten() {
        return aantaltrainingsmomenten.size();
    };
};
