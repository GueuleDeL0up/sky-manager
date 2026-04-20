# Conventions de code

Objectif : garder un code lisible, cohérent et simple à relire en équipe.

## Portee actuelle

- Le projet expose actuellement une application console simple.
- Les classes metier sont regroupees sous `com.sky.manager.app.classes`.
- Les composants d'entree/sortie console sont sous `com.sky.manager.app.console`.
- La logique est en memoire; aucune persistance n'est imposee dans cette phase.

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
- Prefixer/suffixer seulement quand c'est utile (exemple: `ConsoleApplication`, `ConsoleInput`, `ConsoleOutput`).
- Eviter d'introduire des couches `Service`/`Repository` tant que le projet reste en mode console + memoire.

## Constantes

- Constantes en `UPPER_SNAKE_CASE`.
- Pour une constante de classe : `private static final`.
- Grouper les constantes métier dans des classes dédiées.

## Structure de code

- Garder une separation claire entre interaction console (`app.console`) et modeles metier (`app.classes`).
- La logique metier ne depend pas d'un framework externe.
- Les methodes doivent rester simples et deterministes quand possible.
- Limiter les dependances transverses entre classes pour faciliter la migration vers une architecture modulaire ensuite.

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
