package com.covoiturage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PassengerTest {

    private Passenger passenger;

    @BeforeEach
    void setUp() {
        passenger = new Passenger("Alice");
    }

    @Test
    void should_return_true_if_passenger_have_0_reservation() {
        // Given
        // When
        // Then
        assertThat(passenger.getReservations())
                .isNotNull()
                .isEmpty();
    }

    @Test
    void should_generate_bill_with_only_one_reservation() {
        // Given
        carpoolingTrip trip =
                new carpoolingTrip("Trajet court", 1, 2.0);

        Reservation reservation =
                new Reservation(trip, 2, 10.0);

        passenger.addReservation(reservation);

        // When
        String bill = passenger.generateBill();

        // Then
        assertThat(bill)
                .startsWith("Facture pour Alice")
                .contains("Trajet court")
                .contains("200.0")
                .contains("Montant total : 200.0");
    }

    @Test
    void should_generate_bill_with_multiple_reservations() {
        //Given
        carpoolingTrip ecoTrip =
                new carpoolingTrip("Eco", 5, 2.0);
        Reservation ecoReservation =
                new Reservation(ecoTrip, 1, 10.0);

        carpoolingTrip premiumTrip =
                new carpoolingTrip("Premium", 4, 1.0);
        Reservation premiumReservation =
                new Reservation(premiumTrip, 3, 5.0);

        passenger.addReservation(ecoReservation);
        passenger.addReservation(premiumReservation);

        // When
        String bill = passenger.generateBill();

        // Then
        assertThat(bill)
                .startsWith("Facture pour Alice")
                .contains("Eco")
                .contains("Premium")
                .contains("50.0")
                .contains("90.0")
                .contains("Montant total : 140.0");
    }
}