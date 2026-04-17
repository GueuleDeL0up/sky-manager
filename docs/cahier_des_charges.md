# Cahier des charges (MVP)

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

- Centraliser la création, consultation et mise à jour des vols.
- Permettre l'affectation d'un avion et d'un équipage à chaque vol.
- Détecter et signaler les conflits de planning simples avant validation.

## Utilisateurs cibles

- Agent d'exploitation: prépare et met à jour le planning des vols.
- Responsable opérations: valide la cohérence globale des affectations.

## User stories prioritaires

1. En tant qu'agent d'exploitation, je veux créer et modifier un vol (numéro, aéroport départ/arrivée, horaires), afin de maintenir un planning à jour.
2. En tant qu'agent d'exploitation, je veux affecter un avion à un vol, afin de garantir qu'un appareil est prévu pour chaque rotation.
3. En tant que responsable opérations, je veux être alerté en cas de conflit de disponibilité (avion ou équipage déjà affecté au même horaire), afin d'éviter les incohérences de planning.

## Hors périmètre

- Gestion de la maintenance détaillée des avions.
- Optimisation avancée du planning (algorithmes de minimisation de coûts/retards).
- Notifications temps réel (email, SMS, push).
- Pour le MVP, les notifications sont limitées à une sortie console (trace informative) et ne constituent pas un canal utilisateur complet.
- Gestion multi-aéroports complexe avec fuseaux horaires avancés.
- Authentification/rôles avancés (un rôle opérateur simple suffit pour le MVP).

## Critères d'acceptation globaux

- Le système doit permettre de créer, lister, modifier et consulter des vols sans perte de données.
- L'utilisateur doit pouvoir affecter un avion et un équipage à un vol via des règles simples et lisibles.
- Le système doit bloquer ou signaler explicitement toute double affectation sur un même intervalle horaire.
- Les erreurs doivent être compréhensibles, contextualisées et exploitables (cause + action attendue).
- Les parcours critiques (gestion d'un vol, affectation avion/équipage, détection de conflit) doivent être couverts par des tests automatisés.
