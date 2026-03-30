package com.covoiturage;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class carpoolingTripTest {

    @Test
    void Devrait_avoir_un_prix_de_10_si_trajet_court() {
        carpoolingTrip trajet = new carpoolingTrip("Court", 1, 2.0);

        assertThat(trajet.getPricePerPlace()).isEqualTo(10.0);
    }

    @Test
    void Devrait_avoir_un_prix_de_6_si_trajet_longue_distance() {
        carpoolingTrip trajet = new carpoolingTrip("Long", 2, 2.0);

        assertThat(trajet.getPricePerPlace()).isEqualTo(6.0);
    }

    @Test
    void Devrait_avoir_un_prix_de_8_si_trajet_navette() {
        carpoolingTrip trajet = new carpoolingTrip("Navette", 3, 2.0);

        assertThat(trajet.getPricePerPlace()).isEqualTo(8.0);
    }

    @Test
    void Devrait_avoir_un_prix_de_12_si_trajet_premium() {
        carpoolingTrip trajet = new carpoolingTrip("Premium", 4, 2.0);

        assertThat(trajet.getPricePerPlace()).isEqualTo(12.0);
    }

    @Test
    void Devrait_avoir_un_prix_de_5_si_trajet_eco() {
        carpoolingTrip trajet = new carpoolingTrip("Eco", 5, 2.0);

        assertThat(trajet.getPricePerPlace()).isEqualTo(5.0);
    }

    @Test
    void Devrait_lancer_une_exception_si_type_invalide() {
        assertThatThrownBy(() -> new carpoolingTrip("Erreur", 999, 2.0))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("illégal");
    }

    @Test
    void Devrait_retourner_les_bonnes_valeurs_via_les_getters() {
        carpoolingTrip trajet =
                new carpoolingTrip("Maison → Travail", 3, 1.5);

        assertThat(trajet.getDescription()).isEqualTo("Maison → Travail");
        assertThat(trajet.getTripType()).isEqualTo(3);
    }
}