package com.sky.manager.app;

public class Passager extends Personne{
  private int passport;

  public Passager(int identifiant, String nom, String adresse, String contact, int passport) {
    super(identifiant, nom, adresse, contact);
    this.passport = passport;
  }
}
