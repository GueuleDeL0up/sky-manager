package com.sky.manager.app.console;

import java.io.InputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sky.manager.app.classes.Aeroport;
import com.sky.manager.app.classes.Avion;
import com.sky.manager.app.classes.Employe;
import com.sky.manager.app.classes.PersonnelCabine;
import com.sky.manager.app.classes.Pilote;
import com.sky.manager.app.classes.Vol;

public final class ConsoleApplication {

  private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
  private static final String DATE_PATTERN = "yyyy-MM-dd";

  private final ConsoleInput input;
  private final ConsoleOutput output;
  private final List<Vol> vols;
  private final List<Avion> avions;
  private final List<Employe> equipages;
  private final List<Aeroport> aeroports;
  private int nextFlightNumber = 1;

  public ConsoleApplication() {
    this(System.in, System.out);
  }

  public ConsoleApplication(InputStream inputStream, PrintStream printStream) {
    this.input = new ConsoleInput(new Scanner(inputStream), printStream);
    this.output = new ConsoleOutput(printStream);
    this.vols = new ArrayList<>();
    this.avions = new ArrayList<>();
    this.equipages = new ArrayList<>();
    this.aeroports = new ArrayList<>();
    seedSampleData();
  }

  public void run() {
    boolean running = true;
    while (running) {
      printMenu();
      int choice = input.readInt("Choisissez une option: ");
      try {
        running = handleChoice(choice);
      } catch (RuntimeException exception) {
        output.println("Erreur: " + exception.getMessage());
      }
      output.println("");
    }
  }

  private boolean handleChoice(int choice) {
    return switch (choice) {
      case 1 -> {
        listFlights();
        yield true;
      }
      case 2 -> {
        createFlight();
        yield true;
      }
      case 3 -> {
        assignAircraftToFlight();
        yield true;
      }
      case 4 -> {
        assignCrewToFlight();
        yield true;
      }
      case 5 -> {
        listAircraft();
        yield true;
      }
      case 6 -> {
        addAircraft();
        yield true;
      }
      case 7 -> {
        listCrew();
        yield true;
      }
      case 8 -> {
        addCrewMember();
        yield true;
      }
      case 9 -> false;
      default -> {
        output.println("Option inconnue.");
        yield true;
      }
    };
  }

  private void printMenu() {
    output.println("================ Sky Manager ================");
    output.println("1. Lister les vols");
    output.println("2. Creer un vol");
    output.println("3. Affecter un avion a un vol");
    output.println("4. Affecter un equipage a un vol");
    output.println("5. Lister les avions");
    output.println("6. Ajouter un avion");
    output.println("7. Lister les equipages");
    output.println("8. Ajouter un membre d'equipage");
    output.println("9. Quitter");
  }

  private void listFlights() {
    if (vols.isEmpty()) {
      output.println("Aucun vol enregistre.");
      return;
    }

    vols.forEach(vol -> output.println(formatFlight(vol)));
  }

  private void createFlight() {
    String origine = input.readNonBlank("Aeroport de depart: ");
    String destination = input.readNonBlank("Aeroport d'arrivee: ");
    String departureTime = readDateTime("Date et heure de depart (yyyy-MM-dd HH:mm): ");
    String arrivalTime = readDateTime("Date et heure d'arrivee (yyyy-MM-dd HH:mm): ");

    Vol vol = new Vol(nextFlightNumber++, origine, destination, departureTime, arrivalTime, "planifie");
    vols.add(vol);
    output.println("Vol cree: " + formatFlight(vol));
  }

  private void assignAircraftToFlight() {
    Vol vol = findFlight(input.readInt("Numero de vol: "));
    if (vol == null) {
      output.println("Vol introuvable.");
      return;
    }

    Avion avion = findAircraft(input.readNonBlank("Immatriculation avion: "));
    if (avion == null) {
      output.println("Avion introuvable.");
      return;
    }

    vol.setAvion(avion);
    avion.ajouterVol(vol);
    avion.setEtat("affecte");
    output.println("Avion affecte au vol.");
  }

  private void assignCrewToFlight() {
    Vol vol = findFlight(input.readInt("Numero de vol: "));
    if (vol == null) {
      output.println("Vol introuvable.");
      return;
    }

    Pilote pilote = findPilot(input.readInt("Numero employe du pilote: "));
    if (pilote == null) {
      output.println("Pilote introuvable.");
      return;
    }

    String cabinIds = input.readNonBlank("Numeros employe du personnel cabine (separes par des virgules): ");
    List<PersonnelCabine> personnelCabine = new ArrayList<>();
    for (String token : cabinIds.split(",")) {
      String trimmed = token.trim();
      if (trimmed.isEmpty()) {
        continue;
      }

      PersonnelCabine member = findCabinCrew(parseIntOrFail(trimmed, "Numero employe invalide: " + trimmed));
      if (member == null) {
        output.println("Personnel cabine introuvable: " + trimmed);
        return;
      }
      personnelCabine.add(member);
    }

    if (personnelCabine.isEmpty()) {
      output.println("Au moins un membre du personnel cabine est requis.");
      return;
    }

    vol.setPilote(pilote);
    vol.getPersonnelCabine().clear();
    vol.getPersonnelCabine().addAll(personnelCabine);
    output.println("Equipage affecte au vol.");
  }

  private void listAircraft() {
    if (avions.isEmpty()) {
      output.println("Aucun avion enregistre.");
      return;
    }

    avions.forEach(avion -> output.println(formatAircraft(avion)));
  }

  private void addAircraft() {
    String immatriculation = input.readNonBlank("Immatriculation: ");
    String modele = input.readNonBlank("Modele: ");
    int capacite = input.readInt("Capacite: ");

    Avion avion = new Avion(immatriculation, modele, capacite);
    avions.add(avion);
    output.println("Avion ajoute: " + formatAircraft(avion));
  }

  private void listCrew() {
    if (equipages.isEmpty()) {
      output.println("Aucun membre d'equipage enregistre.");
      return;
    }

    equipages.forEach(member -> output.println(formatCrewMember(member)));
  }

  private void addCrewMember() {
    output.println("Type de membre d'equipage: 1. Pilote  2. Personnel cabine");
    int type = input.readInt("Choix: ");

    int identifiant = input.readInt("Identifiant: ");
    String nom = input.readNonBlank("Nom: ");
    String adresse = input.readNonBlank("Adresse: ");
    String contact = input.readNonBlank("Contact: ");
    int numeroEmploye = input.readInt("Numero d'employe: ");
    Date dateEmbauche = readDate("Date d'embauche (yyyy-MM-dd): ");

    Employe employe;
    if (type == 1) {
      String licence = input.readNonBlank("Licence: ");
      String heureDeVol = input.readNonBlank("Heures de vol: ");
      employe = new Pilote(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche, licence, heureDeVol);
    } else if (type == 2) {
      String qualification = input.readNonBlank("Qualification: ");
      employe = new PersonnelCabine(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche, qualification);
    } else {
      output.println("Type de membre d'equipage invalide.");
      return;
    }

    equipages.add(employe);
    output.println("Membre ajoute: " + formatCrewMember(employe));
  }

  private String readDateTime(String prompt) {
    while (true) {
      String value = input.readNonBlank(prompt);
      try {
        new SimpleDateFormat(DATE_TIME_PATTERN, Locale.ROOT).parse(value);
        return value;
      } catch (ParseException exception) {
        output.println("Format invalide. Attendu: yyyy-MM-dd HH:mm");
      }
    }
  }

  private Date readDate(String prompt) {
    while (true) {
      String value = input.readNonBlank(prompt);
      try {
        return new SimpleDateFormat(DATE_PATTERN, Locale.ROOT).parse(value);
      } catch (ParseException exception) {
        output.println("Format invalide. Attendu: yyyy-MM-dd");
      }
    }
  }

  private int parseIntOrFail(String value, String errorMessage) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException exception) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  private Vol findFlight(int numeroVol) {
    for (Vol vol : vols) {
      if (vol.getNumeroVol() == numeroVol) {
        return vol;
      }
    }
    return null;
  }

  private Avion findAircraft(String immatriculation) {
    for (Avion avion : avions) {
      if (avion.getImmatriculation().equalsIgnoreCase(immatriculation)) {
        return avion;
      }
    }
    return null;
  }

  private Pilote findPilot(int numeroEmploye) {
    for (Employe employe : equipages) {
      if (employe instanceof Pilote pilote && pilote.getNumeroEmploye() == numeroEmploye) {
        return pilote;
      }
    }
    return null;
  }

  private PersonnelCabine findCabinCrew(int numeroEmploye) {
    for (Employe employe : equipages) {
      if (employe instanceof PersonnelCabine personnelCabine && personnelCabine.getNumeroEmploye() == numeroEmploye) {
        return personnelCabine;
      }
    }
    return null;
  }

  private String formatFlight(Vol vol) {
    String aircraft = vol.getAvion() != null ? vol.getAvion().getImmatriculation() : "Non affecte";
    String pilot = vol.getPilote() != null ? vol.getPilote().getNom() : "Non affecte";
    String cabinCrew = vol.getPersonnelCabine().isEmpty()
        ? "Aucun"
        : vol.getPersonnelCabine().stream().map(PersonnelCabine::getNom).collect(Collectors.joining(", "));

    return "Vol n°" + vol.getNumeroVol()
        + " | " + vol.getOrigine()
        + " -> " + vol.getDestination()
        + " | Depart: " + vol.getDateHeureDepart()
        + " | Arrivee: " + vol.getDateHeureArrive()
        + " | Etat: " + vol.getEtat()
        + " | Avion: " + aircraft
        + " | Pilote: " + pilot
        + " | Personnel cabine: " + cabinCrew;
  }

  private String formatAircraft(Avion avion) {
    return "Avion " + avion.getImmatriculation()
        + " | Modele: " + avion.getModele()
        + " | Capacite: " + avion.getCapacite()
        + " | Etat: " + avion.getEtat()
        + " | Vols: " + avion.getVols().size();
  }

  private String formatCrewMember(Employe employe) {
    String base = "Employe " + employe.getNumeroEmploye()
        + " | Id: " + employe.getIdentifiant()
        + " | Nom: " + employe.getNom();

    if (employe instanceof Pilote pilote) {
      return base + " | Role: Pilote | Licence: " + pilote.getLicence() + " | Heures de vol: " + pilote.getHeureDeVol();
    }

    if (employe instanceof PersonnelCabine personnelCabine) {
      return base + " | Role: Personnel cabine | Qualification: " + personnelCabine.getQualification();
    }

    return base + " | Role: " + employe.obtenirRole();
  }

  private void seedSampleData() {
    avions.add(new Avion("F-GSKY", "Airbus A320", 180));
    avions.add(new Avion("F-GSUN", "ATR 72", 72));

    Pilote captain = new Pilote(1, "Alice Martin", "Paris", "alice@example.com", 1001, new Date(), "ATPL-001", "4200h");
    Pilote firstOfficer = new Pilote(2, "Thomas Bernard", "Lyon", "thomas@example.com", 1002, new Date(), "CPL-002",
        "2100h");
    PersonnelCabine cabin1 = new PersonnelCabine(3, "Sara Lopez", "Marseille", "sara@example.com", 2001, new Date(),
        "Cabin Crew");

    equipages.add(captain);
    equipages.add(firstOfficer);
    equipages.add(cabin1);

    Vol firstFlight = new Vol(nextFlightNumber++, "Paris-CDG", "Lyon", "2026-04-20 08:00", "2026-04-20 09:00",
        "planifie");
    Vol secondFlight = new Vol(nextFlightNumber++, "Lyon", "Marseille", "2026-04-20 10:30", "2026-04-20 11:30",
        "planifie");

    firstFlight.setAvion(avions.get(0));
    firstFlight.setPilote(captain);
    firstFlight.getPersonnelCabine().add(cabin1);
    avions.get(0).ajouterVol(firstFlight);
    avions.get(0).setEtat("affecte");

    secondFlight.setAvion(avions.get(1));
    avions.get(1).ajouterVol(secondFlight);
    avions.get(1).setEtat("affecte");

    vols.add(firstFlight);
    vols.add(secondFlight);
    aeroports.add(new Aeroport("Paris-CDG", "Paris", "Aeroport de depart principal"));
    aeroports.add(new Aeroport("Lyon-Saint-Exupery", "Lyon", "Aeroport de correspondance"));
  }
}