# ✈️ Sky Manager

Application de gestion opérationnelle pour organiser des vols, des avions, des équipages et la planification associée.

## 🚀 Aperçu rapide

Sky Manager est un mini projet Java structuré avec Maven, pensé pour :

- **Centraliser** la gestion des vols
- **Préparer** l'affectation des avions et équipages
- **Poser** une base de planification évolutive

Le projet est organisé pour rester lisible, testable et facile à faire évoluer.

## 🎯 Objectifs du projet

- **Construire** un socle propre pour un MVP de gestion aérienne
- **Respecter** une architecture claire et des conventions communes
- **Documenter** les choix pour faciliter la collaboration et la soutenance

## 📚 Documentation du projet

- [Cahier des charges](docs/cahier_des_charges.md) : périmètre MVP, objectifs, user stories et critères d'acceptation
- [Architecture](docs/architecture.md) : organisation des couches, des domaines et des flux métier
- [Guidelines](docs/guidelines/README.md) : structure projet, conventions de code, workflow Git et checklist qualité
- [Structure projet](docs/guidelines/STRUCTURE_PROJET.md) : arborescence Maven et règles d'organisation
- [Conventions de code](docs/guidelines/CONVENTIONS_CODE.md) : nommage, formatage, tests et gestion des erreurs
- [Workflow Git](docs/guidelines/GIT_WORKFLOW.md) : branches, commits et rythme de travail
- [Checklist qualité](docs/guidelines/CHECKLIST_QUALITE.md) : vérifications avant remise

## 💻 Stack technique

- **Java SE 25**
- **Maven**

## ⚙️ Installation

### Prérequis

- Java 25
- Maven 3.9+ ou compatible
- Git

### Étapes

1. Cloner le dépôt.
2. Se placer à la racine du projet.
3. Vérifier l'environnement avec Maven.

```bash
mvn clean test
```

Cette commande télécharge les dépendances, compile le projet et exécute la suite de tests.

## ▶️ Lancement

Le projet est actuellement centré sur la structure, la documentation et le socle Maven.
Le lancement utile à ce stade consiste donc à valider le build localement :

```bash
mvn test
```

Quand l'entrée applicative sera ajoutée, cette section pourra être complétée avec la commande d'exécution dédiée.

## 👥 Auteurs

| Nom                 | Rôles                          | GitHub                                            |
| :------------------ | :----------------------------- | :------------------------------------------------ |
| **Nicolas CLEMENT** | Product Owner • Lead Developer | [@GueuleDeL0up](https://github.com/GueuleDeL0up/) |
| **Maxime BOGNON**   | Development Team               | [@HighMax524](https://github.com/HighMax524/)     |
