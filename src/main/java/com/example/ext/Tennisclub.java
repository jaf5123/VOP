package com.example.ext;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.*;

public class Tennisclub {
    private StringProperty clubmanager, clubnaam, locatie, telefoonnummer;
    private ObjectProperty<LocalTime> openingsuur, sluitingsuur;
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

    public Tennisclub(SimpleStringProperty clubmanager, SimpleStringProperty clubnaam, SimpleStringProperty locatie, SimpleStringProperty telefoonnummer, ObjectProperty<LocalTime> openingsuur, ObjectProperty<LocalTime> sluitingsuur) {
        this.clubmanager = clubmanager;
        this.clubnaam = clubnaam;
        this.locatie = locatie;
        this.telefoonnummer = telefoonnummer;
        this.openingsuur = openingsuur;
        this.sluitingsuur = sluitingsuur;
        this.aantalleden = FXCollections.observableArrayList();
        this.aantaltennisbanen = FXCollections.observableArrayList();
        this.aantaltrainers = FXCollections.observableArrayList();
        this.aantaltrainingsmomenten = FXCollections.observableArrayList();
    };

    public void setClubmanager(StringProperty clubmanager) {
        this.clubmanager = clubmanager;
    }

    public StringProperty getClubmanager() {
        return clubmanager;
    }

    public void setClubnaam(StringProperty clubnaam) {
        this.clubnaam = clubnaam;
    }

    public StringProperty getClubnaam() {
        return clubnaam;
    }

    public void setLocatie(StringProperty locatie) {
        this.locatie = locatie;
    }

    public StringProperty getLocatie() {
        return locatie;
    }

    public void setTelefoonnummer(StringProperty telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public StringProperty getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setOpeningsuur(ObjectProperty<LocalTime> openingsuur) {
        this.openingsuur = openingsuur;
    }

    public ObjectProperty<LocalTime> getOpeningsuur() {
        return openingsuur;
    }

    public void setSluitingsuur(ObjectProperty<LocalTime> sluitingsuur) {
        this.sluitingsuur = sluitingsuur;
    }

    public ObjectProperty<LocalTime> getSluitingsuur() {
        return sluitingsuur;
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

    public void schrapSpelerVanLijst(int baannummer) {
        for (Tennisbaan baan : aantaltennisbanen) {
            if (baan.getBaannummer() == baannummer) {
                aantaltennisbanen.remove(baan);
            };
        };
    }

    public Tennisbaan getTennisbaanVanLijst(int baannummer) {
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
