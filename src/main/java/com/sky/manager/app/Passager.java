package com.sky.manager.app;

import com.sky.manager.planning.domain.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne{
  private int passport;
  private List<Reservation> reservations = new ArrayList<>();

  public Passager(int identifiant, String nom, String adresse, String contact, int passport) {
    super(identifiant, nom, adresse, contact);
    this.passport = passport;
    this.reservations = new ArrayList<>();
  }

  public int getPassport() {
    return passport;
  }
  public void setPassport(int passport) {
    this.passport = passport;
  }

  public void reserverVol(Reservation reservation) {
    if (reservation == null) {
      System.out.println("Réservation invalide.");
      return;
    }
    if (reservations.contains(reservation)) {
      System.out.println("Cette réservation existe déjà");
      return;
    }
    reservations.add(reservation);
    System.out.println("Réservation ajoutée");
  }

  public void annulerReservation(int numeroReservation) {
    Reservation cible = null;
    for (Reservation r : reservations) {
      if (r.getNumeroReservation() == numeroReservation) {
        cible = r;
        break;
      }
    }
    if (cible != null) {
      reservations.remove(cible);
      System.out.println("Réservation n°" + numeroReservation + " annulée.");
    } else {
      System.out.println("Réservation n°" + numeroReservation + " introuvable.");
    }
  }

  public List<Reservation> obtenirReservations() {
    return reservations;
  }

}
