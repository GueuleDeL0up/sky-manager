package com.sky.manager.app.classes;

import java.util.Date;

public class Employe extends Personne {
  private int numeroEmploye;
  private Date dateEmbauche;

  public Employe(int identifiant, String nom, String adresse, String contact, int numeroEmploye, Date dateEmbauche) {
    super(identifiant, nom, adresse, contact);
    this.numeroEmploye = numeroEmploye;
    this.dateEmbauche = dateEmbauche;
  }

  public int getNumeroEmploye() {
    return numeroEmploye;
  }

  public void setNumeroEmploye(int numeroEmploye) {
    this.numeroEmploye = numeroEmploye;
  }

  public Date getDateEmbauche() {
    return dateEmbauche;
  }

  public void setDateEmbauche(Date dateEmbauche) {
    this.dateEmbauche = dateEmbauche;
  }

  /**
   * Retourne le rôle d'un employé par son identifiant
   */
  public String obtenirRole() {
    return "Employe";
  }

  @Override
  public void obtenirInfos() {
    super.obtenirInfos();
    System.out.println("Numero d'employé: " + numeroEmploye);
    System.out.println("Date d'embauche: " + dateEmbauche);
  }
}
