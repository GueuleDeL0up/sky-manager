package com.sky.manager.aircrafts.domain;

public class Avion {
  public String immatriculation;
  public String modele;
  public int capacite;

  public Avion(String immatriculation, String modele, int capacite) {
    this.immatriculation = immatriculation;
    this.modele = modele;
    this.capacite = capacite;
  }
}
