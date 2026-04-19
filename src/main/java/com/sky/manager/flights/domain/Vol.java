package com.sky.manager.flights.domain;

public class Vol {
  private int numeroVol;
  private String origine;
  private String destination;
  private String dateHeureDepart;
  private String dateHeureArrive;
  private String etat;

  public Vol(int numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrive, String etat) {
    this.numeroVol = numeroVol;
    this.origine = origine;
    this.destination = destination;
    this.dateHeureDepart = dateHeureDepart;
    this.dateHeureArrive = dateHeureArrive;
    this.etat = etat;
  }
}
