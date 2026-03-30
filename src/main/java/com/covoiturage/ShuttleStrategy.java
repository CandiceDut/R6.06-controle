package com.covoiturage;

public class ShuttleStrategy implements CarpoolingTripStrategy {
    final double SHUTTLE_PRICE = 4.0;
    @Override
    public double calculate(final double basePricePerKm) {
        return basePricePerKm * SHUTTLE_PRICE;
    }
}
