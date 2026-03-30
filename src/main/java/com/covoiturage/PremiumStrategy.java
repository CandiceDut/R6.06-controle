package com.covoiturage;

public class PremiumStrategy implements CarpoolingTripStrategy{
    final double PREMIUM_PRICE = 6.0;
    @Override
    public double calculate(final double basePricePerKm) {
        return basePricePerKm * PREMIUM_PRICE;
    }
}
