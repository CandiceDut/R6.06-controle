package com.covoiturage;

public class ShortDistanceStrategy implements CarpoolingTripStrategy {
    final double SHORT_DISTANCE_PRICE = 5.0;
    @Override
    public double calculate(final double basePricePerKm) {
        return basePricePerKm * SHORT_DISTANCE_PRICE;
    }
}
