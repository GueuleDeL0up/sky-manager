package com.sky.manager.planning.domain;

import java.util.Date;

public class Reservation {
  private int numeroReservation;
  private String identifiant;
  private Date dateReservation;
  private String statut;

  public Reservation(int numeroReservation, String identifiant, Date dateReservation, String statut) {
    this.numeroReservation = numeroReservation;
    this.identifiant = identifiant;
    this.dateReservation = dateReservation;
    this.statut = statut;
  }
}
