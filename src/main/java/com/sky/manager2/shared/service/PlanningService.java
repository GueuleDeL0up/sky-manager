package com.sky.manager.shared.service;

import java.util.List;

import com.sky.manager.shared.domain.Aircraft;
import com.sky.manager.shared.domain.CrewMember;
import com.sky.manager.shared.domain.Flight;

public final class PlanningService {

  public boolean hasAircraftConflict(Flight targetFlight, Aircraft aircraft, List<Flight> flights) {
    return flights.stream()
        .filter(flight -> flight != targetFlight)
        .filter(Flight::hasAircraftAssigned)
        .filter(flight -> flight.getAircraft().equals(aircraft))
        .anyMatch(targetFlight::overlapsWith);
  }

  public boolean hasCrewConflict(Flight targetFlight, CrewMember crewMember, List<Flight> flights) {
    return flights.stream()
        .filter(flight -> flight != targetFlight)
        .filter(flight -> flight.getCrewMembers().contains(crewMember))
        .anyMatch(targetFlight::overlapsWith);
  }
}