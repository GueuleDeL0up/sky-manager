package com.sky.manager.shared.domain;

import java.util.Objects;

public final class Aircraft {

  private final String registration;
  private final String model;
  private final int capacity;

  public Aircraft(String registration, String model, int capacity) {
    this.registration = validateText(registration, "L'immatriculation est obligatoire.");
    this.model = validateText(model, "Le modele est obligatoire.");
    if (capacity <= 0) {
      throw new IllegalArgumentException("La capacite doit etre superieure a zero.");
    }
    this.capacity = capacity;
  }

  public String getRegistration() {
    return registration;
  }

  public String getModel() {
    return model;
  }

  public int getCapacity() {
    return capacity;
  }

  public String toDisplayString() {
    return registration + " | " + model + " | places=" + capacity;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Aircraft aircraft = (Aircraft) object;
    return registration.equalsIgnoreCase(aircraft.registration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registration.toLowerCase());
  }

  private static String validateText(String value, String message) {
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException(message);
    }
    return value.trim();
  }
}