package com.sky.manager.app.classes;

import java.util.ArrayList;
import java.util.List;

public class Vol {
  private int numeroVol;
  private String origine;
  private String destination;
  private String dateHeureDepart;
  private String dateHeureArrive;
  private String etat; // "planifié", "décollé", "atterri", "annulé"
  private Avion avion;
  private Pilote pilote;
  private List<PersonnelCabine> personnelCabine;
  private List<Passager> passagers;
  private Aeroport aeroportOrigine;
  private Aeroport aeroportDestination;

  public Vol(int numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrive,
      String etat) {
    this.numeroVol = numeroVol;
    this.origine = origine;
    this.destination = destination;
    this.dateHeureDepart = dateHeureDepart;
    this.dateHeureArrive = dateHeureArrive;
    this.etat = etat;
    this.personnelCabine = new ArrayList<>();
    this.passagers = new ArrayList<>();
  }

  public int getNumeroVol() {
    return numeroVol;
  }

  public void setNumeroVol(int numeroVol) {
    this.numeroVol = numeroVol;
  }

  public String getOrigine() {
    return origine;
  }

  public void setOrigine(String origine) {
    this.origine = origine;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getDateHeureDepart() {
    return dateHeureDepart;
  }

  public void setDateHeureDepart(String dateHeureDepart) {
    this.dateHeureDepart = dateHeureDepart;
  }

  public String getDateHeureArrive() {
    return dateHeureArrive;
  }

  public void setDateHeureArrive(String dateHeureArrive) {
    this.dateHeureArrive = dateHeureArrive;
  }

  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

  public Avion getAvion() {
    return avion;
  }

  public void setAvion(Avion avion) {
    this.avion = avion;
  }

  public Pilote getPilote() {
    return pilote;
  }

  public void setPilote(Pilote pilote) {
    this.pilote = pilote;
  }

  public List<PersonnelCabine> getPersonnelCabine() {
    return personnelCabine;
  }

  public List<Passager> getPassagers() {
    return passagers;
  }

  public Aeroport getAeroportOrigine() {
    return aeroportOrigine;
  }

  public void setAeroportOrigine(Aeroport aeroportOrigine) {
    this.aeroportOrigine = aeroportOrigine;
  }

  public Aeroport getAeroportDestination() {
    return aeroportDestination;
  }

  public void setAeroportDestination(Aeroport aeroportDestination) {
    this.aeroportDestination = aeroportDestination;
  }

  /**
   * Affecte un équipage à un vol. Un pilote et une équipe cabine doivent être
   * assignés.
   */
  public void affecterVol(Pilote pilote, List<PersonnelCabine> personnelCabine) {
    if (pilote == null || personnelCabine == null || personnelCabine.isEmpty()) {
      System.out.println("Équipage invalide. Un pilote et du personnel cabine sont obligatoires.");
      return;
    }
    this.pilote = pilote;
    this.personnelCabine = new ArrayList<>(personnelCabine);
    System.out.println("Équipage affecté au vol n°" + numeroVol + ":");
    System.out.println("  Pilote: " + pilote.getNom());
    System.out.println("  Personnel cabine: " + personnelCabine.size() + " membres");
  }

  /**
   * Obtient les informations d'un vol donné par son ID
   */
  public void obtenirVol() {
    System.out.println("=== Informations du Vol n°" + numeroVol + " ===");
    System.out.println("De: " + origine + " (" + (aeroportOrigine != null ? aeroportOrigine.getNom() : "N/A") + ")");
    System.out.println(
        "Vers: " + destination + " (" + (aeroportDestination != null ? aeroportDestination.getNom() : "N/A") + ")");
    System.out.println("Départ: " + dateHeureDepart);
    System.out.println("Arrivée prévue: " + dateHeureArrive);
    System.out.println("État: " + etat);
    System.out.println("Avion: " + (avion != null ? avion.getImmatriculation() : "Non affecté"));
    System.out.println("Pilote: " + (pilote != null ? pilote.getNom() : "Non affecté"));
    System.out.println("Passagers: " + passagers.size() + " / " + (avion != null ? avion.getCapacite() : "N/A"));
  }

  /**
   * Planifie les vols - ajoute une liste de vols sur une période donnée
   */
  public void planifierVol() {
    System.out.println("Vol n°" + numeroVol + " planifié pour " + dateHeureDepart);
    this.etat = "planifié";
  }

  /**
   * Annule un vol donné par son ID
   */
  public void annulerVol() {
    this.etat = "annulé";
    System.out.println("Vol n°" + numeroVol + " annulé.");
    // Notifier les passagers
    for (Passager passager : passagers) {
      System.out.println("Notification: Vol annulé pour le passager " + passager.getNom());
    }
  }

  /**
   * Modifie un vol
   */
  public void modifierVol(String dateHeureDepart, String dateHeureArrive) {
    this.dateHeureDepart = dateHeureDepart;
    this.dateHeureArrive = dateHeureArrive;
    System.out.println("Vol n°" + numeroVol + " modifié. Nouveau départ: " + dateHeureDepart);
  }

  /**
   * Liste les passagers d'un vol
   */
  public void listingPassager() {
    System.out.println("=== Passagers du Vol n°" + numeroVol + " ===");
    if (passagers.isEmpty()) {
      System.out.println("Aucun passager enregistré.");
      return;
    }
    for (int i = 0; i < passagers.size(); i++) {
      System.out
          .println((i + 1) + ". " + passagers.get(i).getNom() + " (ID: " + passagers.get(i).getIdentifiant() + ")");
    }
  }

  /**
   * Ajoute un passager au vol
   */
  public void ajouterPassager(Passager passager) {
    if (passager == null) {
      System.out.println("Passager invalide.");
      return;
    }
    if (avion != null && passagers.size() >= avion.getCapacite()) {
      System.out.println("Capacité de l'avion atteinte. Impossible d'ajouter plus de passagers.");
      return;
    }
    if (!passagers.contains(passager)) {
      passagers.add(passager);
      System.out.println("Passager " + passager.getNom() + " ajouté au vol n°" + numeroVol);
    } else {
      System.out.println("Le passager est déjà enregistré sur ce vol.");
    }
  }
}
