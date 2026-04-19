package com.sky.manager.shared.domain;

import java.util.Objects;

public final class CrewMember {

  private final String id;
  private final String fullName;
  private final String role;

  public CrewMember(String id, String fullName, String role) {
    this.id = validateText(id, "L'identifiant est obligatoire.");
    this.fullName = validateText(fullName, "Le nom complet est obligatoire.");
    this.role = validateText(role, "Le role est obligatoire.");
  }

  public String getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getRole() {
    return role;
  }

  public String toDisplayString() {
    return id + " | " + fullName + " | role=" + role;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    CrewMember that = (CrewMember) object;
    return id.equalsIgnoreCase(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id.toLowerCase());
  }

  private static String validateText(String value, String message) {
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException(message);
    }
    return value.trim();
  }
}