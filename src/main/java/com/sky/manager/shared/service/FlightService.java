package com.sky.manager.shared.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sky.manager.shared.domain.Aircraft;
import com.sky.manager.shared.domain.CrewMember;
import com.sky.manager.shared.domain.Flight;

public final class FlightService {

  private final List<Flight> flights = new ArrayList<>();
  private final PlanningService planningService;

  public FlightService(PlanningService planningService) {
    this.planningService = planningService;
  }

  public Flight createFlight(String code, String departureAirport, String arrivalAirport, LocalDateTime departureTime,
      LocalDateTime arrivalTime) {
    Flight flight = new Flight(code, departureAirport, arrivalAirport, departureTime, arrivalTime);
    if (existsByCode(flight.getCode())) {
      throw new IllegalStateException("Un vol avec ce code existe deja.");
    }
    flights.add(flight);
    return flight;
  }

  public List<Flight> listFlights() {
    return List.copyOf(flights);
  }

  public Flight findFlight(String code) {
    return flights.stream()
        .filter(flight -> flight.getCode().equalsIgnoreCase(code))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Vol introuvable pour le code: " + code));
  }

  public void assignAircraft(Flight flight, Aircraft aircraft) {
    ensureNoAircraftConflict(flight, aircraft);
    flight.assignAircraft(aircraft);
  }

  public void assignCrewMember(Flight flight, CrewMember crewMember) {
    ensureNoCrewConflict(flight, crewMember);
    flight.assignCrewMember(crewMember);
  }

  private void ensureNoAircraftConflict(Flight targetFlight, Aircraft aircraft) {
    if (planningService.hasAircraftConflict(targetFlight, aircraft, flights)) {
      throw new IllegalStateException("Cet avion est deja affecte a un autre vol sur le meme creneau.");
    }
  }

  private void ensureNoCrewConflict(Flight targetFlight, CrewMember crewMember) {
    if (planningService.hasCrewConflict(targetFlight, crewMember, flights)) {
      throw new IllegalStateException("Ce membre d'equipage est deja affecte a un autre vol sur le meme creneau.");
    }
  }

  private boolean existsByCode(String code) {
    return flights.stream().anyMatch(flight -> flight.getCode().equalsIgnoreCase(code));
  }
}