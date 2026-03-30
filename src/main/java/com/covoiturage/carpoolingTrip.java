package com.covoiturage;

public class carpoolingTrip {
    private String tripDescription;
    private TripType tripType; // 1: courte distance, 2: longue distance, 3: navette, 4: premium, 5: eco
    private double pricePerPlace;

    public carpoolingTrip(String description, TripType type, double basePricePerKm) {
        this.tripDescription = description;
        this.tripType = type;
        fixPricePerPlace(basePricePerKm);
    }

    public String getDescription() {
        return tripDescription;
    }

    public TripType getTripType() {
        return tripType;
    }

    public double getPricePerPlace() {
        return pricePerPlace;
    }

    private void fixPricePerPlace(double basePricePerKm) {
        switch (this.tripType) {
            case SHORT_DISTANCE_TRIP: this.pricePerPlace = new ShortDistanceStrategy().calculate(basePricePerKm); break;   // courte distance
            case LONG_DISTANCE_TRIP: this.pricePerPlace = new LongDistanceStrategy().calculate(basePricePerKm); break;   // longue distance
            case SHUTTLE_TRIP: this.pricePerPlace = new ShuttleStrategy().calculate(basePricePerKm); break;   // navette
            case PREMIUM_TRIP: this.pricePerPlace = new PremiumStrategy().calculate(basePricePerKm); break;   // premium
            case ECO_TRIP: this.pricePerPlace = new EcoStrategy().calculate(basePricePerKm); break;   // eco
            default: throw new RuntimeException("Type de trajet illégal");
        }
    }
}