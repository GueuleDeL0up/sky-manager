# Architecture Sky Manager (MVP)

## Objectif

Décrire une architecture simple, lisible et évolutive pour implémenter le MVP Sky Manager :

- gestion des vols,
- affectation avion/équipage,
- détection de conflits de planning,
- notifications limitées à la console.

## Vue d'ensemble

Le projet suit une architecture modulaire orientée domaine.
Chaque domaine métier est organisé en couches :

- `domain` : règles métier pures,
- `application` : cas d'usage et orchestration,
- `infrastructure` : implémentations techniques (stockage, notifications, etc.),
- `presentation` : points d'entrée (CLI, API, adaptateurs d'I/O).

Principe directeur : la logique métier ne dépend pas des détails techniques.

## Domaines métier

- `flights` : création, mise à jour et consultation des vols.
- `aircrafts` : disponibilité et affectation des avions.
- `crew` : disponibilité et affectation des membres d'équipage.
- `planning` : contrôle de cohérence temporelle et détection de conflits.
- `notifications` : diffusion d'informations liées aux événements métier (MVP: console).

## Règles de dépendances

- `presentation` dépend de `application`.
- `application` dépend de `domain` et de ports/interfaces.
- `infrastructure` implémente les ports/interfaces définis par `application` ou `domain`.
- `domain` ne dépend d'aucune couche technique.

En pratique :

- les entités métier (`Flight`, `Aircraft`, `CrewMember`) restent dans `domain`,
- les services d'application coordonnent les validations métier,
- les repositories et services externes sont branchés via interfaces (ports).

## Flux principal (MVP)

### 1. Création ou modification d'un vol

1. La couche `presentation` reçoit la commande.
2. Le cas d'usage `application` valide les données d'entrée.
3. Le domaine applique les règles métier (cohérence minimale).
4. Le repository (`infrastructure`) persiste l'état.

### 2. Affectation d'un avion et d'un équipage

1. Le cas d'usage charge le vol et les ressources concernées.
2. Le domaine/planning vérifie les disponibilités.
3. En cas de conflit, une erreur métier explicite est remontée.
4. En cas de succès, l'affectation est persistée.
5. Une notification informative peut être émise via le module `notifications`.

### 3. Notification dans le MVP

Le MVP n'intègre pas de canal utilisateur temps réel (email, SMS, push).
La notification est une trace console via une implémentation type `ConsoleNotificationService`.
Cette implémentation permet de garder un point d'extension propre pour des canaux futurs.

## Gestion des erreurs

- Les erreurs métier sont explicites et contextualisées (ex: conflit d'affectation).
- Les erreurs techniques sont traduites dans la couche `application`/`presentation`.
- Aucune erreur ne doit être silencieusement ignorée.

## Tests et qualité

- Tests unitaires prioritaires sur les règles métier (`domain`, `planning`).
- Tests d'intégration sur les parcours critiques (`create/update flight`, `assign crew/aircraft`, `conflict check`).
- Les conventions de code et la checklist qualité servent de garde-fous de cohérence.

## Évolutivité prévue

L'architecture est conçue pour évoluer sans casser le cœur métier :

- remplacement de la persistance en gardant les mêmes ports,
- ajout d'une API HTTP ou UI sans modifier les règles métier,
- extension du module `notifications` vers email/SMS/push,
- ajout de règles de planning plus avancées (optimisation, contraintes réglementaires).

## Résumé

Sky Manager repose sur une séparation claire entre métier et technique.
Ce choix facilite la lisibilité, les tests, et l'extension progressive du MVP vers un produit plus complet.
