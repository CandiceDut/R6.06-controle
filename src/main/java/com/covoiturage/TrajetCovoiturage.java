package com.covoiturage;

public class TrajetCovoiturage {
    private String descriptionTrajet;
    private int typeTrajet; // 1: courte distance, 2: longue distance, 3: navette, 4: premium, 5: eco
    private double prixParPlace;

    public TrajetCovoiturage(String description, int type, double prixBaseParKm) {
        this.descriptionTrajet = description;
        this.typeTrajet = type;
        fixerPrixParPlace(prixBaseParKm);
    }

    public String getDescription() {
        return descriptionTrajet;
    }

    public int getTypeTrajet() {
        return typeTrajet;
    }

    public double getPrixParPlace() {
        return prixParPlace;
    }

    private void fixerPrixParPlace(double prixBaseParKm) {
        switch (this.typeTrajet) {
            case 1: this.prixParPlace = prixBaseParKm * 5.0; break;   // courte distance
            case 2: this.prixParPlace = prixBaseParKm * 3.0; break;   // longue distance
            case 3: this.prixParPlace = prixBaseParKm * 4.0; break;   // navette
            case 4: this.prixParPlace = prixBaseParKm * 6.0; break;   // premium
            case 5: this.prixParPlace = prixBaseParKm * 2.5; break;   // eco
            default: throw new RuntimeException("Type de trajet illégal");
        }
    }
}