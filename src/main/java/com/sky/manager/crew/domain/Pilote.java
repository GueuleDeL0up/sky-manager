package com.sky.manager.crew.domain;

import java.util.Date;

public class Pilote extends Employe{
  private String licence;
  private String heureDeVol;

  public Pilote(int identifiant, String nom, String adresse, String contact, int numeroEmploye, Date dateEmbauche, String licence, String heureDeVol) {
    super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
    this.licence = licence;
    this.heureDeVol = heureDeVol;
  }

  public String getLicence() {
    return licence;
  }

  public void setLicence(String licence) {
    this.licence = licence;
  }

  public String getHeureDeVol() {
    return heureDeVol;
  }

  public void setHeureDeVol(String heureDeVol) {
    this.heureDeVol = heureDeVol;
  }

  @Override
  public String obtenirRole() {
    return "Pilote";
  }
}
