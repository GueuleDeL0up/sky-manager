package com.sky.manager.app.classes;

import java.util.Date;

public class Reservation {
  private int numeroReservation;
  private Passager passager;
  private Vol vol;
  private Date dateReservation;
  private String statut; // "confirmée", "annulée", "en attente"

  public Reservation(int numeroReservation, Passager passager, Vol vol, Date dateReservation, String statut) {
    this.numeroReservation = numeroReservation;
    this.passager = passager;
    this.vol = vol;
    this.dateReservation = dateReservation;
    this.statut = statut;
  }

  public int getNumeroReservation() {
    return numeroReservation;
  }

  public void setNumeroReservation(int numeroReservation) {
    this.numeroReservation = numeroReservation;
  }

  public Passager getPassager() {
    return passager;
  }

  public void setPassager(Passager passager) {
    this.passager = passager;
  }

  public Vol getVol() {
    return vol;
  }

  public void setVol(Vol vol) {
    this.vol = vol;
  }

  public Date getDateReservation() {
    return dateReservation;
  }

  public void setDateReservation(Date dateReservation) {
    this.dateReservation = dateReservation;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  /**
   * Confirme une réservation
   */
  public void confirmerReservation() {
    this.statut = "confirmée";
    System.out.println("Réservation n°" + numeroReservation + " confirmée.");
  }

  /**
   * Annule une réservation
   */
  public void annulerReservation() {
    this.statut = "annulée";
    System.out.println("Réservation n°" + numeroReservation + " annulée.");
  }

  /**
   * Modifie une réservation (change le vol)
   */
  public void modifierReservation(Vol newVol) {
    if (newVol != null) {
      this.vol = newVol;
      System.out.println("Réservation n°" + numeroReservation + " modifiée. Nouveau vol: n°" + newVol.getNumeroVol());
    } else {
      System.out.println("Vol invalide.");
    }
  }

  /**
   * Affiche les informations de la réservation
   */
  public void afficherInfos() {
    System.out.println("--- Réservation n°" + numeroReservation + " ---");
    System.out.println("Passager: " + (passager != null ? passager.getNom() : "N/A"));
    System.out.println("Vol: n°" + (vol != null ? vol.getNumeroVol() : "N/A"));
    System.out.println("Date de réservation: " + dateReservation);
    System.out.println("Statut: " + statut);
  }
}
