# Structure de projet recommandée

Objectif : avoir une base claire, évolutive et facile à maintenir.

## Arborescence conseillée

```text
mini_projet_G2/
  pom.xml
  README.md

  docs/
    cahier_des_charges.md
    guidelines/
      README.md
      STRUCTURE_PROJET.md
      CONVENTIONS_CODE.md
      GIT_WORKFLOW.md
      CHECKLIST_QUALITE.md

  src/
    main/
      java/
        com/sky/manager/
          app/                     # classes de démarrage, config applicative
          shared/                  # utilitaires transverses, exceptions, constantes
          flights/                 # domaine vols
            domain/
            application/
            infrastructure/
            presentation/
          aircrafts/               # domaine avions
            domain/
            application/
            infrastructure/
            presentation/
          crew/                    # domaine équipage
            domain/
            application/
            infrastructure/
            presentation/
          planning/                # domaine planning
            domain/
            application/
            infrastructure/
            presentation/
          notifications/           # domaine notifications
            domain/
            application/
            infrastructure/
            presentation/
      resources/
        application.yml
        db/
          migration/
    test/
      java/
        com/sky/manager/
          flights/
          aircrafts/
          crew/
          planning/
          notifications/
      resources/

  scripts/                 # scripts d'automatisation (seed, lint, build)
  data/                    # jeux de données de test, fixtures
  .github/
    workflows/             # CI (tests, lint)

  .editorconfig
  .gitignore
```

## Règles d'organisation

- Un module = un domaine métier.
- Structure Maven stricte: src/main/java, src/main/resources, src/test/java, src/test/resources.
- Pas de logique métier dans presentation ou infrastructure.
- Le package shared ne doit pas dépendre des domaines métier.
- Les tests suivent la même logique de packages que le code source.
- Tous les scripts répétitifs vont dans scripts.

## Anti-patterns à éviter

- Un dossier `utils` géant avec tout mélange.
- Des fichiers de plus de 300-400 lignes sans justification.
- Imports circulaires entre modules métier.
- Mettre les tests dans un dossier tests/ à la racine (non Maven).
