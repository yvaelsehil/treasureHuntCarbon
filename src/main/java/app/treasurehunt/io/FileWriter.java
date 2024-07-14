package app.treasurehunt.io;

import app.treasurehunt.entity.Adventurer;
import app.treasurehunt.entity.Tile;
import app.treasurehunt.entity.WorldMap;
import app.treasurehunt.simulation.TreasureHuntSimulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileWriter {

    public static void writeFile(WorldMap worldMap, List<Adventurer> adventurerList, String outputPath) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("C - " + worldMap.getWidth() + " - " + worldMap.getLength());
        for (int i = 0; i < worldMap.getWidth(); i++) {
            for (int j = 0; j < worldMap.getLength(); j++) {
                Tile currentTile = worldMap.getTile(i, j);
                if (currentTile.getTreasures() > 0) {
                    lines.add("T - " + i + " - " + j + " - " + currentTile.getTreasures());
                }
                if (currentTile.isMountain()) {
                    lines.add("M - " + i + " - " + j);
                }
            }
        }

        for (Adventurer adventurer : adventurerList) {
            lines.add("A - " + adventurer.getName() + " - " + adventurer.getX() + " - " + adventurer.getY() + " - " + adventurer.getDirection() + " - " + adventurer.getTreasuresFound());
        }
        Files.write(Paths.get(outputPath), lines);
    }
}
