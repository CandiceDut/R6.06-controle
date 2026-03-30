package com.covoiturage;

import java.util.ArrayList;
import java.util.List;

public class Passager {
    private String nom;
    private List<Reservation> reservations;

    public Passager(String nom) {
        this.nom = nom;
        this.reservations = new ArrayList<>();
    }

    public void ajouterReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public String getNom() {
        return nom;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public String genererFacture() {
        double montantTotal = 0;
        StringBuilder resultat = new StringBuilder("Facture pour " + getNom() + "\n");

        for (Reservation reservation : reservations) {
            double montantReservation = reservation.calculerMontantReservation();
            resultat.append("\t")
                    .append(reservation.getTrajet().getDescription())
                    .append("\t")
                    .append(montantReservation)
                    .append("\n");
            montantTotal += montantReservation;
        }

        resultat.append("Montant total : ").append(montantTotal);
        return resultat.toString();
    }
}