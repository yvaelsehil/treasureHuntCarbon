package app.treasurehunt;

import app.treasurehunt.io.FileReader;
import app.treasurehunt.io.FileWriter;
import app.treasurehunt.simulation.TreasureHuntSimulation;

import java.io.IOException;


public class Main {

    private static final String DEFAULT_OUPTPUT_PATH = "output";

    public static void main(String[] args) {
        String mapPath = args[0];
        String outputPath = args.length > 1 ? args[1] : DEFAULT_OUPTPUT_PATH;
        try {
            TreasureHuntSimulation treasureHuntSimulation = FileReader.read(mapPath);
            treasureHuntSimulation.run();
            FileWriter.writeFile(treasureHuntSimulation.getWorldMap(), treasureHuntSimulation.getAdventurerList(), outputPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}