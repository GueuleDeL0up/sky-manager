package com.sky.manager.app.console;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import com.sky.manager2.shared.domain.Aircraft;
import com.sky.manager2.shared.domain.CrewMember;
import com.sky.manager2.shared.domain.Flight;
import com.sky.manager2.shared.service.AircraftService;
import com.sky.manager2.shared.service.CrewService;
import com.sky.manager2.shared.service.FlightService;
import com.sky.manager2.shared.service.PlanningService;

public final class ConsoleApplication {

  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  private final ConsoleInput input;
  private final ConsoleOutput output;
  private final AircraftService aircraftService;
  private final CrewService crewService;
  private final FlightService flightService;
  private final PlanningService planningService;

  public ConsoleApplication() {
    this(System.in, System.out);
  }

  public ConsoleApplication(InputStream inputStream, PrintStream printStream) {
    this.input = new ConsoleInput(new Scanner(inputStream), printStream);
    this.output = new ConsoleOutput(printStream);
    this.planningService = new PlanningService();
    this.aircraftService = new AircraftService();
    this.crewService = new CrewService();
    this.flightService = new FlightService(planningService);
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
    List<Flight> flights = flightService.listFlights();
    if (flights.isEmpty()) {
      output.println("Aucun vol enregistre.");
      return;
    }

    flights.forEach(flight -> output.println(flight.toDisplayString()));
  }

  private void createFlight() {
    String code = input.readNonBlank("Code vol: ");
    String departureAirport = input.readNonBlank("Aeroport de depart: ");
    String arrivalAirport = input.readNonBlank("Aeroport d'arrivee: ");
    LocalDateTime departureTime = readDateTime("Date et heure de depart (yyyy-MM-dd HH:mm): ");
    LocalDateTime arrivalTime = readDateTime("Date et heure d'arrivee (yyyy-MM-dd HH:mm): ");
    Flight flight = flightService.createFlight(code, departureAirport, arrivalAirport, departureTime, arrivalTime);
    output.println("Vol cree: " + flight.toDisplayString());
  }

  private void assignAircraftToFlight() {
    String flightCode = input.readNonBlank("Code vol: ");
    String registration = input.readNonBlank("Immatriculation avion: ");
    Flight flight = flightService.findFlight(flightCode);
    Aircraft aircraft = aircraftService.findAircraft(registration);
    flightService.assignAircraft(flight, aircraft);
    output.println("Avion affecte au vol.");
  }

  private void assignCrewToFlight() {
    String flightCode = input.readNonBlank("Code vol: ");
    String crewId = input.readNonBlank("Identifiant equipage: ");
    Flight flight = flightService.findFlight(flightCode);
    CrewMember crewMember = crewService.findCrewMember(crewId);
    flightService.assignCrewMember(flight, crewMember);
    output.println("Membre d'equipage affecte au vol.");
  }

  private void listAircraft() {
    List<Aircraft> aircraft = aircraftService.listAircraft();
    if (aircraft.isEmpty()) {
      output.println("Aucun avion enregistre.");
      return;
    }

    aircraft.forEach(item -> output.println(item.toDisplayString()));
  }

  private void addAircraft() {
    String registration = input.readNonBlank("Immatriculation: ");
    String model = input.readNonBlank("Modele: ");
    int capacity = input.readInt("Capacite: ");
    Aircraft aircraft = aircraftService.addAircraft(registration, model, capacity);
    output.println("Avion ajoute: " + aircraft.toDisplayString());
  }

  private void listCrew() {
    List<CrewMember> crewMembers = crewService.listCrewMembers();
    if (crewMembers.isEmpty()) {
      output.println("Aucun membre d'equipage enregistre.");
      return;
    }

    crewMembers.forEach(member -> output.println(member.toDisplayString()));
  }

  private void addCrewMember() {
    String id = input.readNonBlank("Identifiant: ");
    String fullName = input.readNonBlank("Nom complet: ");
    String role = input.readNonBlank("Role: ");
    CrewMember crewMember = crewService.addCrewMember(id, fullName, role);
    output.println("Membre ajoute: " + crewMember.toDisplayString());
  }

  private LocalDateTime readDateTime(String prompt) {
    while (true) {
      String value = input.readNonBlank(prompt);
      try {
        return LocalDateTime.parse(value, DATE_TIME_FORMATTER);
      } catch (DateTimeParseException exception) {
        output.println("Format invalide. Attendu: yyyy-MM-dd HH:mm");
      }
    }
  }

  private void seedSampleData() {
    Aircraft aircraft = aircraftService.addAircraft("F-GSKY", "Airbus A320", 180);
    aircraftService.addAircraft("F-GSUN", "ATR 72", 72);

    CrewMember captain = crewService.addCrewMember("CRW-001", "Alice Martin", "Captain");
    CrewMember firstOfficer = crewService.addCrewMember("CRW-002", "Thomas Bernard", "First Officer");
    crewService.addCrewMember("CRW-003", "Sara Lopez", "Cabin Crew");

    Flight firstFlight = flightService.createFlight(
        "SM101",
        "Paris-CDG",
        "Lyon",
        LocalDateTime.of(2026, 4, 20, 8, 0),
        LocalDateTime.of(2026, 4, 20, 9, 0));
    Flight secondFlight = flightService.createFlight(
        "SM102",
        "Lyon",
        "Marseille",
        LocalDateTime.of(2026, 4, 20, 10, 30),
        LocalDateTime.of(2026, 4, 20, 11, 30));

    flightService.assignAircraft(firstFlight, aircraft);
    flightService.assignCrewMember(firstFlight, captain);
    flightService.assignCrewMember(firstFlight, firstOfficer);
    flightService.assignAircraft(secondFlight, aircraftService.findAircraft("F-GSUN"));
  }
}