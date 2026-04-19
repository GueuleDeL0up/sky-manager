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

  public int getNumeroReservation() {
    return numeroReservation;
  }

  public void setNumeroReservation(int numeroReservation) {
    this.numeroReservation = numeroReservation;
  }

  public String getIdentifiant() {
    return identifiant;
  }

  public void setIdentifiant(String identifiant) {
    this.identifiant = identifiant;
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
}
