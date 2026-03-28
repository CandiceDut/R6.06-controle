package com.covoiturage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PassagerTest {

    private Passager passager;

    @BeforeEach
    void setUp() {
        passager = new Passager("Alice");
    }

    @Test
    void DevraitRenvoyerVraiSiPassagerNaAucuneReservation() {
        assertThat(passager.getReservations())
                .isNotNull()
                .isEmpty();
    }

    @Test
    void DevraitGenererUneFactureAvecUneSeuleReservation() {
        // Given
        TrajetCovoiturage trajet =
                new TrajetCovoiturage("Trajet court", 1, 2.0);

        Reservation reservation =
                new Reservation(trajet, 2, 10.0);

        passager.ajouterReservation(reservation);

        // When
        String facture = passager.genererFacture();

        // Then
        assertThat(facture)
                .startsWith("Facture pour Alice")
                .contains("Trajet court")
                .contains("200.0")
                .contains("Montant total : 200.0");
    }

    @Test
    void DevraitGenererUneFactureAvecPlusieursReservation() {
        //Given
        TrajetCovoiturage trajetEco =
                new TrajetCovoiturage("Eco", 5, 2.0);
        Reservation reservationEco =
                new Reservation(trajetEco, 1, 10.0);

        TrajetCovoiturage trajetPremium =
                new TrajetCovoiturage("Premium", 4, 1.0);
        Reservation reservationPremium =
                new Reservation(trajetPremium, 3, 5.0);

        passager.ajouterReservation(reservationEco);
        passager.ajouterReservation(reservationPremium);

        // When
        String facture = passager.genererFacture();

        // Then
        assertThat(facture)
                .startsWith("Facture pour Alice")
                .contains("Eco")
                .contains("Premium")
                .contains("50.0")
                .contains("90.0")
                .contains("Montant total : 140.0");
    }
}