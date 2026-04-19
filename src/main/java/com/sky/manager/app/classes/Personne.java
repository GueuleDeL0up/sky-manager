package com.sky.manager.app.classes;

public abstract class Personne {
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

  public int getIdentifiant() {
    return identifiant;
  }

  public void setIdentifiant(int identifiant) {
    this.identifiant = identifiant;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  /**
   * Affiche les informations d'une personne
   */
  public void obtenirInfos() {
    System.out.println("=== Informations de la personne ===");
    System.out.println("Identifiant: " + identifiant);
    System.out.println("Nom: " + nom);
    System.out.println("Adresse: " + adresse);
    System.out.println("Contact: " + contact);
  }
}
