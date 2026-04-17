# Workflow Git recommandé

Objectif : historique lisible, retours arrière simples, moins de conflits.

## Branches

- `main` : stable, toujours déployable/presentable.
- `dev` : branche de synchronisation.
- `feature/<sujet>` : nouvelle fonctionnalité.
- `fix/<sujet>` : correction de bug.
- `chore/<sujet>` : maintenance technique.

Exemples :

- `feature/16-flight-creation`
- `fix/32-planning-conflict-check`

## Commits

Convention conseillée :

- `feat: add flight creation use case`
- `fix: prevent crew double assignment`
- `test: add planning conflict unit tests`
- `docs: clarify project setup`
- `refactor: isolate validation logic`

Règles :

- 1 commit = 1 intention.
- Commits petits et relisibles.
- Message en anglais court et explicite.

## Pull Request

Checklist PR :

- Le scope est limité et clair.
- Les tests passent localement.
- Le linter est vert.
- Les cas limites ont été vérifiés.
- La PR contient une description du pourquoi.

## Rythme conseillé

- Push régulier en fin de bloc de travail.
- Rebase/merge depuis `dev` souvent pour éviter un gros conflit final.
- Ne pas garder une branche feature plus de 2-3 jours sans synchro.
