package com.covoiturage;

public class Reservation {
    private TrajetCovoiturage trajet;
    private int nombrePlaces;
    private double distanceEnKm;

    public Reservation(TrajetCovoiturage trajet, int nombrePlaces, double distanceEnKm) {
        this.trajet = trajet;
        this.nombrePlaces = nombrePlaces;
        this.distanceEnKm = distanceEnKm;
    }

    public TrajetCovoiturage getTrajet() {
        return trajet;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public double getDistanceEnKm() {
        return distanceEnKm;
    }
}