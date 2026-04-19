package com.sky.manager.crew.domain;

import com.sky.manager.app.Personne;

import java.time.LocalDate;

public class Employe extends Personne {
  private int numeroEmploye;
  private LocalDate dateEmbauche;

  public Employe(int identifiant, String nom, String adresse, String contact, int numeroEmploye, LocalDate dateEmbauche) {
    super(identifiant, nom, adresse, contact);
    this.numeroEmploye = numeroEmploye;
    this.dateEmbauche = dateEmbauche;
  }
}
