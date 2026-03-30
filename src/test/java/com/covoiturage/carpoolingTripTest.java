package com.covoiturage;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class carpoolingTripTest {

    @Test
    void should_have_price_of_10_if_short_trip() {
        carpoolingTrip trip = new carpoolingTrip("Court", 1, 2.0);

        assertThat(trip.getPricePerPlace()).isEqualTo(10.0);
    }

    @Test
    void should_have_price_of_6_if_long_distance_trip() {
        carpoolingTrip trip = new carpoolingTrip("Long", 2, 2.0);

        assertThat(trip.getPricePerPlace()).isEqualTo(6.0);
    }

    @Test
    void should_have_price_of_8_if_shuttle_trip() {
        carpoolingTrip trip = new carpoolingTrip("Navette", 3, 2.0);

        assertThat(trip.getPricePerPlace()).isEqualTo(8.0);
    }

    @Test
    void should_have_price_of_12_if_premium_trip() {
        carpoolingTrip trip = new carpoolingTrip("Premium", 4, 2.0);

        assertThat(trip.getPricePerPlace()).isEqualTo(12.0);
    }

    @Test
    void should_have_price_of_5_if_eco_trip() {
        carpoolingTrip trip = new carpoolingTrip("Eco", 5, 2.0);

        assertThat(trip.getPricePerPlace()).isEqualTo(5.0);
    }

    @Test
    void should_throw_exception_if_invalid_type() {
        assertThatThrownBy(() -> new carpoolingTrip("Erreur", 999, 2.0))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("illégal");
    }

    @Test
    void should_return_right_values_with_getters() {
        carpoolingTrip trip =
                new carpoolingTrip("Maison → Travail", 3, 1.5);

        assertThat(trip.getDescription()).isEqualTo("Maison → Travail");
        assertThat(trip.getTripType()).isEqualTo(3);
    }
}