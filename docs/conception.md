# Rapport de Conception

## 1. Introduction
Le projet **StarFleetReservation** est une application de gestion de réservations pour des missions spatiales. Il permet aux civils et officiers de réserver une place à bord d’un vaisseau affecté à une mission spécifique.

---

## 2. Choix de Conception

### 2.1 Architecture
L’application suit une architecture **modulaire** organisée en plusieurs packages :

- **fr.starfleet** : Contient la classe principale `Main.java`.
- **fr.starfleet.modele** : Définit les entités principales du système.
- **fr.starfleet.systeme** : Contient la logique métier.
- **fr.starfleet.ui** : Fournit une interface utilisateur en mode console.
- **fr.starfleet.util** : Contient les classes utilitaires.

Ce découpage favorise la **séparation des responsabilités** et facilite l’évolutivité du projet.

### 2.2 Modèle Objet

| Classe        | Rôle |
|--------------|------|
| `Personne` | Classe abstraite représentant un individu (Civil ou Officier). |
| `Civil` | Hérite de `Personne`, représente un passager lambda. |
| `Officier` | Hérite de `Personne`, possède un grade. |
| `Mission` | Définit une mission avec un nom et une description. |
| `Vaisseau` | Représente un vaisseau avec un nom et une capacité. |
| `Reservation` | Lie une `Personne` à une `Mission`. |
| `SystemeReservation` | Gère la gestion des réservations. |
| `InterfaceConsole` | Fournit une interface pour interagir avec le système. |
| `DateUtil` et `FileUtil` | Classes utilitaires pour la gestion des dates et des fichiers. |

### 2.3 Persistance des Données
Les réservations sont enregistrées dans le fichier `sauvegarde.dat` grâce à `FileUtil`. L’utilisation de la **sérialisation** permet de conserver l’état du système entre les sessions.

### 2.4 Interface Utilisateur
L’application fonctionne en **mode console** via `InterfaceConsole`. Une future amélioration pourrait être une interface graphique avec JavaFX ou une version web.

### 2.5 Gestion des Exceptions
Les classes implémentent des contrôles pour éviter les erreurs (ex. : réservation sur un vaisseau plein).

---

## 3. Évolutions Possibles

- **Ajout d’un système d’authentification** pour différencier les utilisateurs.
- **Gestion avancée des missions** (durée, objectifs, statut en cours/terminé).
- **Interface graphique** pour une meilleure expérience utilisateur.

---

## 4. Conclusion
Ce projet offre une solution de gestion des réservations bien structurée et modulaire. Son architecture facilite l’ajout de nouvelles fonctionnalités tout en maintenant une séparation claire des responsabilités.