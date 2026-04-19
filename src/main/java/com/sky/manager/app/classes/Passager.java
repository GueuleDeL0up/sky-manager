package com.sky.manager.app.classes;

import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne {
  private int passport;
  private List<Reservation> reservations;

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

  public List<Reservation> getReservations() {
    return reservations;
  }

  @Override
  public void obtenirInfos() {
    super.obtenirInfos();
    System.out.println("Passport: " + passport);
    System.out.println("Nombre de réservations: " + reservations.size());
  }

  /**
   * Permet à un passager de réserver un vol
   */
  public void reserverVol(Reservation reservation) {
    if (reservation == null) {
      System.out.println("Réservation invalide.");
      return;
    }
    if (reservations.contains(reservation)) {
      System.out.println("Cette réservation existe déjà pour ce passager.");
      return;
    }
    reservations.add(reservation);
    System.out.println("Réservation n°" + reservation.getNumeroReservation() + " ajoutée pour le passager "
        + getNom());
  }

  /**
   * Annule une réservation donnée par son ID
   */
  public void annulerReservation(int numeroReservation) {
    Reservation toRemove = null;
    for (Reservation r : reservations) {
      if (r.getNumeroReservation() == numeroReservation) {
        toRemove = r;
        break;
      }
    }
    if (toRemove != null) {
      reservations.remove(toRemove);
      System.out.println("Réservation n°" + numeroReservation + " annulée avec succès.");
    } else {
      System.out.println("Réservation n°" + numeroReservation + " non trouvée.");
    }
  }

  /**
   * Obtient les informations d'une réservation donnée par son ID
   */
  public Reservation obtenirReservations(int numeroReservation) {
    for (Reservation r : reservations) {
      if (r.getNumeroReservation() == numeroReservation) {
        return r;
      }
    }
    System.out.println("Réservation n°" + numeroReservation + " non trouvée.");
    return null;
  }

  /**
   * Retourne toutes les réservations du passager
   */
  public List<Reservation> obtenirReservations() {
    return reservations;
  }

  /**
   * Affiche toutes les réservations du passager
   */
  public void afficherReservations() {
    if (reservations.isEmpty()) {
      System.out.println("Aucune réservation pour ce passager.");
      return;
    }
    System.out.println("=== Réservations du passager " + getNom() + " ===");
    for (Reservation r : reservations) {
      r.afficherInfos();
    }
  }
}
