package com.covoiturage;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class TrajetCovoiturageTest {

    @Test
    void Devrait_avoir_un_prix_de_10_si_trajet_court() {
        TrajetCovoiturage trajet = new TrajetCovoiturage("Court", 1, 2.0);

        assertThat(trajet.getPrixParPlace()).isEqualTo(10.0);
    }

    @Test
    void Devrait_avoir_un_prix_de_6_si_trajet_longue_distance() {
        TrajetCovoiturage trajet = new TrajetCovoiturage("Long", 2, 2.0);

        assertThat(trajet.getPrixParPlace()).isEqualTo(6.0);
    }

    @Test
    void Devrait_avoir_un_prix_de_8_si_trajet_navette() {
        TrajetCovoiturage trajet = new TrajetCovoiturage("Navette", 3, 2.0);

        assertThat(trajet.getPrixParPlace()).isEqualTo(8.0);
    }

    @Test
    void Devrait_avoir_un_prix_de_12_si_trajet_premium() {
        TrajetCovoiturage trajet = new TrajetCovoiturage("Premium", 4, 2.0);

        assertThat(trajet.getPrixParPlace()).isEqualTo(12.0);
    }

    @Test
    void Devrait_avoir_un_prix_de_5_si_trajet_eco() {
        TrajetCovoiturage trajet = new TrajetCovoiturage("Eco", 5, 2.0);

        assertThat(trajet.getPrixParPlace()).isEqualTo(5.0);
    }

    @Test
    void Devrait_lancer_une_exception_si_type_invalide() {
        assertThatThrownBy(() -> new TrajetCovoiturage("Erreur", 999, 2.0))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("illégal");
    }

    @Test
    void Devrait_retourner_les_bonnes_valeurs_via_les_getters() {
        TrajetCovoiturage trajet =
                new TrajetCovoiturage("Maison → Travail", 3, 1.5);

        assertThat(trajet.getDescription()).isEqualTo("Maison → Travail");
        assertThat(trajet.getTypeTrajet()).isEqualTo(3);
    }
}