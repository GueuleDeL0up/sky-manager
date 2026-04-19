package com.sky.manager.shared.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Flight {

  private final String code;
  private final String departureAirport;
  private final String arrivalAirport;
  private final LocalDateTime departureTime;
  private final LocalDateTime arrivalTime;
  private final List<CrewMember> crewMembers;
  private Aircraft aircraft;

  public Flight(String code, String departureAirport, String arrivalAirport, LocalDateTime departureTime,
      LocalDateTime arrivalTime) {
    this.code = validateText(code, "Le code vol est obligatoire.");
    this.departureAirport = validateText(departureAirport, "L'aeroport de depart est obligatoire.");
    this.arrivalAirport = validateText(arrivalAirport, "L'aeroport d'arrivee est obligatoire.");
    this.departureTime = Objects.requireNonNull(departureTime, "La date de depart est obligatoire.");
    this.arrivalTime = Objects.requireNonNull(arrivalTime, "La date d'arrivee est obligatoire.");
    if (!arrivalTime.isAfter(departureTime)) {
      throw new IllegalArgumentException("La date d'arrivee doit etre apres la date de depart.");
    }
    this.crewMembers = new ArrayList<>();
  }

  public String getCode() {
    return code;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public String getArrivalAirport() {
    return arrivalAirport;
  }

  public LocalDateTime getDepartureTime() {
    return departureTime;
  }

  public LocalDateTime getArrivalTime() {
    return arrivalTime;
  }

  public Aircraft getAircraft() {
    return aircraft;
  }

  public List<CrewMember> getCrewMembers() {
    return Collections.unmodifiableList(crewMembers);
  }

  public boolean hasAircraftAssigned() {
    return aircraft != null;
  }

  public void assignAircraft(Aircraft aircraft) {
    this.aircraft = Objects.requireNonNull(aircraft, "L'avion est obligatoire.");
  }

  public void assignCrewMember(CrewMember crewMember) {
    CrewMember validatedCrewMember = Objects.requireNonNull(crewMember, "Le membre d'equipage est obligatoire.");
    boolean alreadyAssigned = crewMembers.stream()
        .anyMatch(member -> member.getId().equalsIgnoreCase(validatedCrewMember.getId()));
    if (alreadyAssigned) {
      throw new IllegalStateException("Ce membre d'equipage est deja affecte a ce vol.");
    }
    crewMembers.add(validatedCrewMember);
  }

  public boolean overlapsWith(Flight otherFlight) {
    Objects.requireNonNull(otherFlight, "Le vol compare est obligatoire.");
    return departureTime.isBefore(otherFlight.arrivalTime) && otherFlight.departureTime.isBefore(arrivalTime);
  }

  public String toDisplayString() {
    String aircraftLabel = aircraft == null ? "aucun avion" : aircraft.getRegistration();
    return code
        + " | "
        + departureAirport
        + " -> "
        + arrivalAirport
        + " | "
        + departureTime
        + " -> "
        + arrivalTime
        + " | avion="
        + aircraftLabel
        + " | equipage="
        + crewMembers.size();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Flight flight = (Flight) object;
    return code.equalsIgnoreCase(flight.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code.toLowerCase());
  }

  private static String validateText(String value, String message) {
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException(message);
    }
    return value.trim();
  }
}