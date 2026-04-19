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
    reservations.add(reservation);
  }

  public void annulerReservation(Reservation reservation) {
    reservations.remove(reservation);
  }

  public List<Reservation> obtenirReservations() {
    return reservations;
  }

}
