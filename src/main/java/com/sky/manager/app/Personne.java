package com.sky.manager.app;

public class Personne {
  private int identifiant;
  private String nom;
  private String adresse;
  private String contact;

  public Personne(int identifiant, String nom, String adresse, String contact) {
    this.identifiant = identifiant;
    this.nom = nom;
    this.adresse = adresse;
    this.contact = contact;
  }
}
