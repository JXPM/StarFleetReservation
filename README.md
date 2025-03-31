# StarFleetReservation

## 1. Présentation
StarFleetReservation est une application Java permettant de gérer les réservations de missions spatiales pour les civils et les officiers.

---

## 2. Prérequis

Avant d’exécuter l’application, assurez-vous d’avoir :
- **Java 8 ou supérieur** installé
- **Un terminal ou un IDE (IntelliJ, Eclipse, VS Code, etc.)**

---

## 3. Installation

Clonez le projet depuis le dépôt GitHub ou copiez les fichiers dans un répertoire local :
```sh
git clone https://github.com/JXPM/StarFleetReservation.git
cd StarFleetReservation
```

---

## 4. Compilation et Exécution

### 4.1 Compilation
Si vous utilisez un terminal, placez-vous dans le dossier `src/main/java/` et exécutez :
```sh
javac -d ../../bin fr/starfleet/Main.java
```

### 4.2 Exécution
Dans le dossier `bin`, exécutez :
```sh
java fr.starfleet.Main
```

Ou depuis un IDE, exécutez directement `Main.java`.

Si vous rencontré des problème, entrer dans le dossier en lui même avec cd ~/StarFleetReservation

puis exécutez :
```sh
java -cp src/main/java fr.starfleet.Main
 ```

---

## 5. Utilisation

Une fois l’application lancée, l’interface console propose plusieurs options :
1. **Afficher les missions disponibles**
2. **Créer une réservation** (en entrant un nom, un âge et un type de personne)
3. **Afficher toutes les réservations**
4. **Quitter l’application**

Naviguez via les choix numériques.

---

## 6. Sauvegarde des données

Les réservations sont enregistrées automatiquement dans le fichier `data/sauvegarde.dat`. Lors du prochain lancement, elles seront rechargées.

---

## 7. Améliorations possibles

- Ajout d’une interface graphique (JavaFX, Swing, Web)
- Gestion des rôles et permissions
- Persistance via une base de données

---

## 8. Auteur
**BILE Kouamé**

---

