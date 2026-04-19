package com.sky.manager.crew.domain;

import com.sky.manager.app.Personne;
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

  public String obtenirRole() {
    return "Employe";
  }
}
