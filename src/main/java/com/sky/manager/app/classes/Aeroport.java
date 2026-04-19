package com.sky.manager.app.classes;

import java.util.ArrayList;
import java.util.List;

public class Aeroport {
  private String nom;
  private String ville;
  private String description;
  private List<Vol> vols;

  public Aeroport(String nom, String ville, String description) {
    this.nom = nom;
    this.ville = ville;
    this.description = description;
    this.vols = new ArrayList<>();
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

  public List<Vol> getVols() {
    return vols;
  }

  /**
   * Affecte un vol à un aéroport
   */
  public void affecterVol(Vol vol) {
    if (vol == null) {
      System.out.println("Vol invalide.");
      return;
    }
    if (!vols.contains(vol)) {
      vols.add(vol);
      System.out.println("Vol n°" + vol.getNumeroVol() + " affecté à l'aéroport " + nom);
    } else {
      System.out.println("Ce vol est déjà affecté à cet aéroport.");
    }
  }

  /**
   * Affiche les informations de l'aéroport
   */
  public void afficherInfos() {
    System.out.println("=== Aéroport ===");
    System.out.println("Nom: " + nom);
    System.out.println("Ville: " + ville);
    System.out.println("Description: " + description);
    System.out.println("Nombre de vols: " + vols.size());
  }
}
