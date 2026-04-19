package com.sky.manager.flights.domain;

public class Vol {
  private int numeroVol;
  private String origine;
  private String destination;
  private String dateHeureDepart;
  private String dateHeureArrive;
  private String etat;

  public Vol(int numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrive,
      String etat) {
    this.numeroVol = numeroVol;
    this.origine = origine;
    this.destination = destination;
    this.dateHeureDepart = dateHeureDepart;
    this.dateHeureArrive = dateHeureArrive;
    this.etat = etat;
  }

  public int getNumeroVol() {
    return numeroVol;
  }

  public void setNumeroVol(int numeroVol) {
    this.numeroVol = numeroVol;
  }

  public String getOrigine() {
    return origine;
  }

  public void setOrigine(String origine) {
    this.origine = origine;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getDateHeureDepart() {
    return dateHeureDepart;
  }

  public void setDateHeureDepart(String dateHeureDepart) {
    this.dateHeureDepart = dateHeureDepart;
  }

  public String getDateHeureArrive() {
    return dateHeureArrive;
  }

  public void setDateHeureArrive(String dateHeureArrive) {
    this.dateHeureArrive = dateHeureArrive;
  }

  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }
}
