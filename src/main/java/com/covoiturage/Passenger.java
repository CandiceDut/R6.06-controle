package com.covoiturage;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private List<Reservation> reservations;

    public Passenger(String pName) {
        this.name = pName;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public String getName() {
        return name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public String generateBill() {
        double totalAmount = 0;
        StringBuilder result = new StringBuilder("Facture pour " + getName() + "\n");

        for (Reservation reservation : reservations) {
            double reservationAmount = reservation.calculerMontantReservation();
            result.append("\t")
                    .append(reservation.getTrip().getDescription())
                    .append("\t")
                    .append(reservationAmount)
                    .append("\n");
            totalAmount += reservationAmount;
        }

        result.append("Montant total : ").append(totalAmount);
        return result.toString();
    }
}