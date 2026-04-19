# Architecture actuelle

## Vue d'ensemble

Sky Manager est actuellement une application Java console, lancee via la classe principale `SkyManagerApplication`.

Le flux principal est:

1. Demarrage de l'application.
2. Creation d'une instance de `ConsoleApplication`.
3. Boucle de menu en console.
4. Actions utilisateur (creation de vols, affectations, consultations).

## Organisation des packages

- `com.sky.manager.app`
  - point d'entree applicatif (`SkyManagerApplication`)
- `com.sky.manager.app.console`
  - interaction utilisateur (menu, lecture, affichage)
  - classes: `ConsoleApplication`, `ConsoleInput`, `ConsoleOutput`
- `com.sky.manager.app.classes`
  - modeles metier
  - classes: `Vol`, `Avion`, `Employe`, `Pilote`, `PersonnelCabine`, `Passager`, `Reservation`, `Aeroport`, `Personne`

## Mode de fonctionnement

- Le stockage est en memoire, au sein de `ConsoleApplication`:
  - liste des vols;
  - liste des avions;
  - liste des equipages;
  - liste des aeroports.
- Les donnees d'exemple sont chargees au demarrage (`seedSampleData`).
- Les entrees utilisateur sont validees a la saisie:
  - verification des entiers;
  - verification des formats de date.

## Capacites actuellement implementees

- Lister les vols.
- Creer un vol.
- Affecter un avion a un vol.
- Affecter un equipage (pilote + personnel cabine) a un vol.
- Lister et ajouter des avions.
- Lister et ajouter des membres d'equipage.

## Limites connues

- Pas de persistance (etat perdu a l'arret).
- Pas de couche service/repository dediee.
- Pas de detection avancee des conflits de planning multi-criteres.
- Pas d'API web ni interface graphique.

## Evolution cible (prochaine etape)

- Isoler les regles metier dans des services applicatifs.
- Introduire une persistance.
- Ajouter des tests unitaires/integration pour les parcours critiques.
