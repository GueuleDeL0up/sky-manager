package com.sky.manager.flights;

public class Aeroport {
  private String nom;
  private String ville;
  private String description;

  public Aeroport(String nom, String ville, String description) {
    this.nom = nom;
    this.ville = ville;
    this.description = description;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
