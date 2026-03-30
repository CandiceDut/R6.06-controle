package com.covoiturage;

public class carpoolingTrip {
    private String tripDescription;
    private int tripType; // 1: courte distance, 2: longue distance, 3: navette, 4: premium, 5: eco
    private double pricePerPlace;

    public carpoolingTrip(String description, int type, double basePricePerKm) {
        this.tripDescription = description;
        this.tripType = type;
        fixPricePerPlace(basePricePerKm);
    }

    public String getDescription() {
        return tripDescription;
    }

    public int getTripType() {
        return tripType;
    }

    public double getPricePerPlace() {
        return pricePerPlace;
    }

    private void fixPricePerPlace(double basePricePerKm) {
        switch (this.tripType) {
            case 1: this.pricePerPlace = basePricePerKm * 5.0; break;   // courte distance
            case 2: this.pricePerPlace = basePricePerKm * 3.0; break;   // longue distance
            case 3: this.pricePerPlace = basePricePerKm * 4.0; break;   // navette
            case 4: this.pricePerPlace = basePricePerKm * 6.0; break;   // premium
            case 5: this.pricePerPlace = basePricePerKm * 2.5; break;   // eco
            default: throw new RuntimeException("Type de trajet illégal");
        }
    }
}