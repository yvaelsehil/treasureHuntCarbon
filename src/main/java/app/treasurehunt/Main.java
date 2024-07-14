package app.treasurehunt;

import app.treasurehunt.io.FileReader;
import app.treasurehunt.io.FileWriter;
import app.treasurehunt.simulation.TreasureHuntSimulation;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String mapPath = args[0];
        try {
            TreasureHuntSimulation treasureHuntSimulation = FileReader.read(mapPath);
            treasureHuntSimulation.run();
            FileWriter.writeFile(treasureHuntSimulation.getWorldMap(), treasureHuntSimulation.getAdventurerList(), "./output");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}