package com.example.ext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Tennisclub {
    private String clubmanager, clubnaam, locatie, telefoonnummer;
    private LocalTime openingsuur, sluitingsuur;
    private ArrayList<Speler> aantalleden;
    private ArrayList<Tennisbaan> aantaltennisbanen;
    private ArrayList<Trainer> aantaltrainers;
    private ArrayList<Training> aantaltrainingsmomenten;

    public Tennisclub() {
        this.clubmanager = new String();
        this.clubnaam = new String();
        this.locatie = new String();
        this.telefoonnummer = new String();
        this.openingsuur = null;
        this.sluitingsuur = null;
        this.aantalleden = new ArrayList<>();
        this.aantaltennisbanen = new ArrayList<>();
        this.aantaltrainers = new ArrayList<>();
        this.aantaltrainingsmomenten = new ArrayList<>();
    };

    public Tennisclub(String clubmanager, String clubnaam, String locatie, String telefoonnummer, LocalTime openingsuur, LocalTime sluitingsuur) {
        this.clubmanager = clubmanager;
        this.clubnaam = clubnaam;
        this.locatie = locatie;
        this.telefoonnummer = telefoonnummer;
        this.openingsuur = openingsuur;
        this.sluitingsuur = sluitingsuur;
        this.aantalleden = new ArrayList<>();
        this.aantaltennisbanen = new ArrayList<>();
        this.aantaltrainers = new ArrayList<>();
        this.aantaltrainingsmomenten = new ArrayList<>();
    };

    public void setClubmanager(String clubmanager) {
        this.clubmanager = clubmanager;
    }

    public String getClubmanager() {
        return clubmanager;
    }

    public void setClubnaam(String clubnaam) {
        this.clubnaam = clubnaam;
    }

    public String getClubnaam() {
        return clubnaam;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setOpeningsuur(LocalTime openingsuur) {
        this.openingsuur = openingsuur;
    }

    public LocalTime getOpeningsuur() {
        return openingsuur;
    }

    public void setSluitingsuur(LocalTime sluitingsuur) {
        this.sluitingsuur = sluitingsuur;
    }

    public LocalTime getSluitingsuur() {
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
