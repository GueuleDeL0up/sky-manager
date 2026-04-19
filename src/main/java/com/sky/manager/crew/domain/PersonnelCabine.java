package com.sky.manager.crew.domain;

public class PersonnelCabine extends Employe {
  public String qualification;

  public PersonnelCabine(int identifiant, String nom, String adresse, String contact, int numeroEmploye, java.time.LocalDate dateEmbauche, String qualification) {
    super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
    this.qualification = qualification;
  }

}

