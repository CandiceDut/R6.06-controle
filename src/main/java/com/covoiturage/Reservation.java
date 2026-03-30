package com.covoiturage;

public class Reservation {
    private carpoolingTrip trip;
    private int placeNumber;
    private double distanceInKm;

    public Reservation(carpoolingTrip trip, int placeNumber, double distanceInKm) {
        this.trip = trip;
        this.placeNumber = placeNumber;
        this.distanceInKm = distanceInKm;
    }

    public carpoolingTrip getTrip() {
        return trip;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public double calculerMontantReservation() {
        double pricePlace = getTrip().getPricePerPlace();
        int places = getPlaceNumber();
        double distance = getDistanceInKm();
        return pricePlace * places * distance;
    }
}