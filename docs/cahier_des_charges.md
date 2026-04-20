# Cahier des charges (MVP)

## Etat actuel (implante)

- Interface utilisateur en console via un menu interactif.
- Gestion en memoire (pas de base de donnees persistante).
- Parcours disponibles:
  - lister les vols;
  - creer un vol;
  - affecter un avion a un vol;
  - affecter un equipage (pilote + personnel cabine) a un vol;
  - lister/ajouter des avions;
  - lister/ajouter des membres d'equipage.

## Contexte

Les opérations de planning aérien sont souvent gérées via des fichiers dispersés,
ce qui rend le suivi des vols fragile et source d'erreurs.
Lorsqu'un vol change d'horaire, l'impact sur l'avion assigné et l'équipage n'est pas
toujours visible immédiatement.
Cette absence de vision centralisée provoque des conflits (double affectation,
équipage indisponible, avion déjà réservé) et des retards de décision.
Sky Manager vise à fournir un point unique de gestion pour structurer ces informations,
fiabiliser les affectations et préparer une planification évolutive.
Le MVP doit couvrir les besoins essentiels pour une démonstration claire et défendable.

## Objectif du MVP

- Centraliser en console la creation et la consultation des vols.
- Permettre l'affectation d'un avion et d'un equipage a chaque vol.
- Fournir un socle fonctionnel simple, executable localement, pour la demonstration.

## Utilisateurs cibles

- Agent d'exploitation: prépare et met à jour le planning des vols.
- Responsable opérations: valide la cohérence globale des affectations.

## User stories prioritaires

1. En tant qu'agent d'exploitation, je veux creer un vol (numero, aeroport depart/arrivee, horaires), afin de maintenir un planning a jour.
2. En tant qu'agent d'exploitation, je veux affecter un avion a un vol, afin de garantir qu'un appareil est prevu pour chaque rotation.
3. En tant qu'agent d'exploitation, je veux affecter un equipage (pilote + personnel cabine) a un vol, afin de preparer l'operation du vol.

## Hors périmètre

- Gestion de la maintenance détaillée des avions.
- Optimisation avancée du planning (algorithmes de minimisation de coûts/retards).
- Notifications temps réel (email, SMS, push).
- Pour le MVP, les notifications sont limitées à une sortie console (trace informative) et ne constituent pas un canal utilisateur complet.
- Gestion multi-aeroports complexe avec fuseaux horaires avances.
- Authentification/roles avances (un role operateur simple suffit pour le MVP).
- Persistance en base de donnees.
- Detection avancee des conflits de planning sur intervalles horaires.

## Critères d'acceptation globaux

- Le systeme doit permettre de creer et lister des vols pendant l'execution de l'application.
- L'utilisateur doit pouvoir affecter un avion et un equipage a un vol via des regles simples et lisibles.
- Les erreurs de saisie utilisateur (nombre invalide, format date invalide, identifiant introuvable) doivent etre explicites.
- Le lancement de l'application doit etre possible depuis la classe principale et le projet doit compiler avec Maven.
