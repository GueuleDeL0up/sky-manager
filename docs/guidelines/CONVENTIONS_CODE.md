# Conventions de code

Objectif : garder un code lisible, cohérent et simple à relire en équipe.

## Nommage

## Maven

- `groupId` en reverse-domain, en minuscules. Exemple: `com.sky.manager`.
- `artifactId` en `kebab-case`. Exemple: `sky-manager`.
- Structure Maven obligatoire :
  - `src/main/java`
  - `src/main/resources`
  - `src/test/java`
  - `src/test/resources`

## Packages Java

- Noms de packages en minuscules.
- Pas de tiret dans un package.
- Base du projet: `com.sky.manager`.

## Fichiers Java

- Un fichier Java contient une classe publique principale.
- Nom du fichier identique au nom de la classe publique.
- Classes en `PascalCase`. Exemples: `FlightService`, `CrewRepository`.

## Variables

- Variables locales en `camelCase`.
- Noms explicites, jamais `data`, `tmp`, `value` sans contexte.
- Booléens : préfixes `is`, `has`, `can`, `should`.

## Fonctions

- Méthodes en `camelCase`.
- Verbe + objet: `createFlightPlan`, `validateCrewAvailability`.
- Une méthode = une responsabilité.
- Taille cible : 20 à 40 lignes max (hors cas spéciaux).

## Classes

- Classes en `PascalCase`.
- Services : suffixe `Service`.
- Repositories : suffixe `Repository`.
- DTOs / Models : suffixes explicites (`Dto`, `Model`, `Entity`).
- Interfaces : préfixes ou suffixes explicites (`FlightRepository`, `NotificationPort`).

## Constantes

- Constantes en `UPPER_SNAKE_CASE`.
- Pour une constante de classe : `private static final`.
- Grouper les constantes métier dans des classes dédiées.

## Structure de code

- Séparer : présentation / application / domaine / infrastructure.
- La logique métier ne dépend pas du framework.
- Les méthodes doivent être déterministes quand possible.
- Respecter les packages de la structure définie dans `docs/guidelines/STRUCTURE_PROJET.md`.

## Formatage

- 1 style unique de formatage pour tout le repo.
- Indentation et fins de ligne gérées par `.editorconfig`.
- Formatter/linter Java recommandés (Checkstyle, Spotless ou équivalent).
- Pas de commentaire inutile. Commenter seulement le pourquoi complexe.

## Gestion des erreurs

- Ne jamais masquer une erreur silencieusement.
- Lever des exceptions explicites avec contexte métier.
- Centraliser la transformation des erreurs techniques vers erreurs produit.

## Tests

- Classes de test unitaire suffixées `Test`.
- Classes de test intégration suffixées `IT`.
- Noms de méthodes de test en `shouldResultWhenCondition`.
- Un test valide un comportement unique.
- Priorité aux cas limites et règles métier critiques.

## Définition minimale de qualité

- Pas de warning linter.
- Pas de test rouge.
- Aucun secret en dur dans le code.
- PR relisible en moins de 15 minutes.
