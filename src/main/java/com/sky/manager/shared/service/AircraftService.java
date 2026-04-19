package com.sky.manager.shared.service;

import java.util.ArrayList;
import java.util.List;

import com.sky.manager.shared.domain.Aircraft;

public final class AircraftService {

  private final List<Aircraft> aircrafts = new ArrayList<>();

  public Aircraft addAircraft(String registration, String model, int capacity) {
    Aircraft aircraft = new Aircraft(registration, model, capacity);
    if (existsByRegistration(aircraft.getRegistration())) {
      throw new IllegalStateException("Un avion avec cette immatriculation existe deja.");
    }
    aircrafts.add(aircraft);
    return aircraft;
  }

  public List<Aircraft> listAircraft() {
    return List.copyOf(aircrafts);
  }

  public Aircraft findAircraft(String registration) {
    return aircrafts.stream()
        .filter(aircraft -> aircraft.getRegistration().equalsIgnoreCase(registration))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Avion introuvable pour l'immatriculation: " + registration));
  }

  private boolean existsByRegistration(String registration) {
    return aircrafts.stream().anyMatch(aircraft -> aircraft.getRegistration().equalsIgnoreCase(registration));
  }
}