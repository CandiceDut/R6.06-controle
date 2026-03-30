package com.covoiturage;

public class Reservation {
    private carpoolingTrip trajet;
    private int nombrePlaces;
    private double distanceEnKm;

    public Reservation(carpoolingTrip trajet, int nombrePlaces, double distanceEnKm) {
        this.trajet = trajet;
        this.nombrePlaces = nombrePlaces;
        this.distanceEnKm = distanceEnKm;
    }

    public carpoolingTrip getTrajet() {
        return trajet;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public double getDistanceEnKm() {
        return distanceEnKm;
    }

    public double calculerMontantReservation() {
        double prixPlace = getTrajet().getPricePerPlace();
        int places = getNombrePlaces();
        double distance = getDistanceEnKm();
        return prixPlace * places * distance;
    }
}