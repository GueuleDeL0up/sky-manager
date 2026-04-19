package com.sky.manager.crew.domain;

import java.util.Date;

public class PersonnelCabine extends Employe {
  public String qualification;

  public PersonnelCabine(int identifiant, String nom, String adresse, String contact, int numeroEmploye, Date dateEmbauche, String qualification) {
    super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
    this.qualification = qualification;
  }

  public String getQualification() {
    return qualification;
  }

  public void setQualification(String qualification) {
    this.qualification = qualification;
  }

}

