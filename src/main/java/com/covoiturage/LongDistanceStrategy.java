package com.covoiturage;

public class LongDistanceStrategy implements CarpoolingTripStrategy {
    final double LONG_DISTANCE_PRICE = 3.0;
    @Override
    public double calculate(final double basePricePerKm) {
        return basePricePerKm * LONG_DISTANCE_PRICE;
    }
}
