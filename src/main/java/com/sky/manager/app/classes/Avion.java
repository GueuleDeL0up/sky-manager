package com.sky.manager.app.classes;

import java.util.ArrayList;
import java.util.List;

public class Avion {
  private String immatriculation;
  private String modele;
  private int capacite;
  private String etat; // "disponible", "en maintenance", "affecté"
  private List<Vol> vols;

  public Avion(String immatriculation, String modele, int capacite) {
    this.immatriculation = immatriculation;
    this.modele = modele;
    this.capacite = capacite;
    this.etat = "disponible";
    this.vols = new ArrayList<>();
  }

  public String getImmatriculation() {
    return immatriculation;
  }

  public void setImmatriculation(String immatriculation) {
    this.immatriculation = immatriculation;
  }

  public String getModele() {
    return modele;
  }

  public void setModele(String modele) {
    this.modele = modele;
  }

  public int getCapacite() {
    return capacite;
  }

  public void setCapacite(int capacite) {
    this.capacite = capacite;
  }

  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

  public List<Vol> getVols() {
    return vols;
  }

  /**
   * Affecte un avion à un vol
   */
  public void affecterVol(Vol vol) {
    if (vol == null) {
      System.out.println("Vol invalide.");
      return;
    }
    if (!verifierDisponibilite(vol)) {
      System.out.println("L'avion n'est pas disponible pour ce vol.");
      return;
    }
    vol.setAvion(this);
    vols.add(vol);
    this.etat = "affecté";
    System.out.println("Avion " + immatriculation + " affecté au vol n°" + vol.getNumeroVol());
  }

  /**
   * Vérifie la disponibilité de l'avion pour un vol donné
   */
  public boolean verifierDisponibilite(Vol vol) {
    if (vol == null) {
      return false;
    }
    // Vérifier si l'avion n'est pas en maintenance
    if ("en maintenance".equals(etat)) {
      System.out.println("Avion en maintenance, non disponible.");
      return false;
    }
    // Vérifier les conflits horaires avec d'autres vols
    for (Vol v : vols) {
      // Chevauchement simple - peut être amélioré avec une meilleure logique de temps
      if (v.getDateHeureDepart().equals(vol.getDateHeureDepart())) {
        System.out.println("Conflit horaire détecté: l'avion est déjà affecté à un autre vol à cette heure.");
        return false;
      }
    }
    return true;
  }

  /**
   * Affiche les informations de l'avion
   */
  public void afficherInfos() {
    System.out.println("=== Avion ===");
    System.out.println("Immatriculation: " + immatriculation);
    System.out.println("Modèle: " + modele);
    System.out.println("Capacité: " + capacite + " passagers");
    System.out.println("État: " + etat);
    System.out.println("Vols affectés: " + vols.size());
  }

  /**
   * Ajoute un vol à la liste des vols
   */
  public void ajouterVol(Vol vol) {
    if (vol != null && !vols.contains(vol)) {
      vols.add(vol);
    }
  }
}
