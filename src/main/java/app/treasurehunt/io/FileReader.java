package app.treasurehunt.io;

import app.treasurehunt.entity.Adventurer;
import app.treasurehunt.entity.WorldMap;
import app.treasurehunt.simulation.TreasureHuntSimulation;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    /**
     * @param path filepath
     * @return TreasureHuntSimulation
     */
    public static TreasureHuntSimulation read(String path) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(path));
        List<Adventurer> adventurers = new ArrayList<>();
        WorldMap worldMap = null;

        for (String line : lines) {
            if (line.trim().startsWith("#")) continue;

            String[] lineArray = line.split(" - ");
            String type = lineArray[0];
            int x, y;
            switch (type) {
                case "C":
                    x = Integer.parseInt(lineArray[1]);
                    y = Integer.parseInt(lineArray[2]);
                    worldMap = new WorldMap(x, y);
                    break;
                case "M":
                    x = Integer.parseInt(lineArray[1]);
                    y = Integer.parseInt(lineArray[2]);
                    if (worldMap != null) {
                        worldMap.getWorldMap()[x][y].setMountain(true);
                    }
                    break;
                case "T":
                    x = Integer.parseInt(lineArray[1]);
                    y = Integer.parseInt(lineArray[2]);
                    if (worldMap != null) {
                        worldMap.getWorldMap()[x][y].setTreasures(Integer.parseInt(lineArray[3]));
                    }
                    break;
                case "A":
                    String name = lineArray[1];
                    x = Integer.parseInt(lineArray[2]);
                    y = Integer.parseInt(lineArray[3]);
                    String moves = lineArray[5];
                    adventurers.add(new Adventurer(name, x, y, lineArray[4], moves));
                    break;
            }
        }
        return new TreasureHuntSimulation(worldMap, adventurers);
    }
}
