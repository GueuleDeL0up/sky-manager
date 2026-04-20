package com.sky.manager.app.classes;

import java.util.Date;

public class Pilote extends Employe {
  private String licence;
  private String heureDeVol;

  public Pilote(int identifiant, String nom, String adresse, String contact, int numeroEmploye, Date dateEmbauche,
      String licence, String heureDeVol) {
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

  @Override
  public void obtenirInfos() {
    super.obtenirInfos();
    System.out.println("Licence: " + licence);
    System.out.println("Heures de vol: " + heureDeVol);
  }

  /**
   * Affecte un pilote à un vol
   */
  public void affecterVol(Vol vol) {
    if (vol == null) {
      System.out.println("Vol invalide.");
      return;
    }
    System.out.println("Pilote " + getNom() + " affecté au vol n°" + vol.getNumeroVol());
  }

  /**
   * Obtient les informations d'un vol
   */
  public void obtenirVol(int numeroVol) {
    System.out.println("Récupération des informations du vol n°" + numeroVol);
  }
}
