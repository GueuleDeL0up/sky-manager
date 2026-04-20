# Structure de projet (etat actuel)

Objectif: decrire l'arborescence actuellement en place dans le projet.

## Arborescence principale

```text
sky-manager/
  pom.xml
  README.md
  docs/
    architecture.md
    cahier_des_charges.md
    guidelines/
      README.md
      CONVENTIONS_CODE.md
      GIT_WORKFLOW.md
      STRUCTURE_PROJET.md
      CHECKLIST_QUALITE.md
  src/
    main/
      java/
        com/sky/manager/
          app/
            SkyManagerApplication.java
            console/
              ConsoleApplication.java
              ConsoleInput.java
              ConsoleOutput.java
            classes/
              Aeroport.java
              Avion.java
              Employe.java
              Passager.java
              Personne.java
              PersonnelCabine.java
              Pilote.java
              Reservation.java
              Vol.java
    test/
      java/
```

## Regles d'organisation (phase actuelle)

- Le package `app.console` contient uniquement l'interface utilisateur console.
- Le package `app.classes` contient les modeles metier et leurs comportements de base.
- L'entree applicative reste minimale dans `SkyManagerApplication`.
- La persistance n'est pas encore introduite: l'etat est gere en memoire dans la console.

## Cible de progression

- Introduire progressivement des services applicatifs pour alleger `ConsoleApplication`.
- Ajouter une couche de persistance une fois le comportement stabilise.
- Conserver la clarte de l'arborescence pendant la transition.
