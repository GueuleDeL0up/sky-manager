package com.sky.manager.shared.service;

import java.util.ArrayList;
import java.util.List;

import com.sky.manager.shared.domain.CrewMember;

public final class CrewService {

  private final List<CrewMember> crewMembers = new ArrayList<>();

  public CrewMember addCrewMember(String id, String fullName, String role) {
    CrewMember crewMember = new CrewMember(id, fullName, role);
    if (existsById(crewMember.getId())) {
      throw new IllegalStateException("Un membre d'equipage avec cet identifiant existe deja.");
    }
    crewMembers.add(crewMember);
    return crewMember;
  }

  public List<CrewMember> listCrewMembers() {
    return List.copyOf(crewMembers);
  }

  public CrewMember findCrewMember(String id) {
    return crewMembers.stream()
        .filter(crewMember -> crewMember.getId().equalsIgnoreCase(id))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Membre d'equipage introuvable pour l'identifiant: " + id));
  }

  private boolean existsById(String id) {
    return crewMembers.stream().anyMatch(crewMember -> crewMember.getId().equalsIgnoreCase(id));
  }
}