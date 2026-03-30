package com.covoiturage;

public class EcoStrategy implements CarpoolingTripStrategy{
    final double ECO_PRICE = 2.5;
    @Override
    public double calculate(final double basePricePerKm) {
        return basePricePerKm * ECO_PRICE;
    }
}
