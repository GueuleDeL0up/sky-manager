package com.sky.manager.app.classes;

import java.util.Date;

public class PersonnelCabine extends Employe {
  private String qualification;

  public PersonnelCabine(int identifiant, String nom, String adresse, String contact, int numeroEmploye,
      Date dateEmbauche, String qualification) {
    super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
    this.qualification = qualification;
  }

  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

  @Override
  public String obtenirRole() {
    return "Personnel Cabine";
  }

  @Override
  public void obtenirInfos() {
    super.obtenirInfos();
    System.out.println("Qualification: " + qualification);
  }

  /**
   * Affecte le personnel cabine à un vol
   */
  public void affecterVol(Vol vol) {
    if (vol == null) {
      System.out.println("Vol invalide.");
      return;
    }
    System.out.println("Personnel cabine " + getNom() + " affecté au vol n°" + vol.getNumeroVol());
  }

  /**
   * Obtient les informations d'un vol
   */
  public void obtenirVol(int numeroVol) {
    System.out.println("Récupération des informations du vol n°" + numeroVol);
  }
}
