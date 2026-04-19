package com.sky.manager.crew.domain;

public class Pilote extends Employe{
  private String licence;
  private String heureDeVol;

  public Pilote(int identifiant, String nom, String adresse, String contact, int numeroEmploye, java.time.LocalDate dateEmbauche, String licence, String heureDeVol) {
    super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
    this.licence = licence;
    this.heureDeVol = heureDeVol;
  }
}
