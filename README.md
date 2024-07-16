# La Carte aux Trésors

## Description
Ce projet est une simulation d'une carte aux trésors en Java. Il lit une configuration d'une carte à partir d'un fichier, place des montagnes et des trésors, et déplace des aventuriers selon des instructions prédéfinies, tout en respectant certaines règles.

## Prérequis
- Java 11 ou version ultérieure
- Gradle 7 ou version ultérieure

## Configurer Gradle
   Assurez-vous que vous avez Gradle installé sur votre machine. Si ce n'est pas le cas, vous pouvez le télécharger et l'installer depuis le site officiel de Gradle.

Build le projet 

``````
$> gradlew build
$> java -jar build/libs/treasureHuntCarbon-1.0-SNAPSHOT.jar <map-file> [<output-file>]
``````

## Ficher d'entrée

Voici un exemple de contenu pour ce fichier :

````
C - 3 - 4
M - 1 - 0
M - 2 - 1
T - 0 - 3 - 2
T - 1 - 3 - 3
A - Lara - 1 - 1 - S - AADADAGGA
````

## Ficher de sortie

Si aucun ficher de sortie n'est précisé, un ficher "output" sera généré dans le répertoire de travail.