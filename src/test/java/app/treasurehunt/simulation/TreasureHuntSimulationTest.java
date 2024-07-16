package app.treasurehunt.simulation;

import app.treasurehunt.entity.Adventurer;
import app.treasurehunt.entity.Direction;
import app.treasurehunt.entity.WorldMap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreasureHuntSimulationTest {

    @Test
    public void testRun() {
        // Setup
        WorldMap worldMap = new WorldMap(3, 3);
        worldMap.getTile(2, 2).setTreasures(1);

        List<Adventurer> adventurerList = new ArrayList<>();
        adventurerList.add(new Adventurer("Lara", 1, 1, "N", "DAADA"));

        TreasureHuntSimulation simulation = new TreasureHuntSimulation(worldMap, adventurerList);

        // Execute
        simulation.run();

        // Verify
        assertEquals(2, adventurerList.getFirst().getX());
        assertEquals(2, adventurerList.getFirst().getY());
        assertEquals(1, adventurerList.getFirst().getTreasuresFound());
        assertEquals(0, worldMap.getTile(2, 2).getTreasures());
    }

    @Test
    public void testAdvance() {
        // Setup
        WorldMap worldMap = new WorldMap(3, 3);
        List<Adventurer> adventurerList = new ArrayList<>();
        adventurerList.add(new Adventurer("Lara", 1, 1, "N", "A"));

        TreasureHuntSimulation simulation = new TreasureHuntSimulation(worldMap, adventurerList);

        // Execute
        simulation.run();

        // Verify
        assertEquals(1, adventurerList.getFirst().getX());
        assertEquals(0, adventurerList.getFirst().getY());
    }

    @Test
    public void testInvalidMove() {
        // Setup
        WorldMap worldMap = new WorldMap(3, 3);
        worldMap.getTile(1, 0).setMountain(true);

        List<Adventurer> adventurerList = new ArrayList<>();
        adventurerList.add(new Adventurer("Lara", 1, 1, "N", "A"));

        TreasureHuntSimulation simulation = new TreasureHuntSimulation(worldMap, adventurerList);

        // Execute
        simulation.run();

        // Verify
        assertEquals(1, adventurerList.getFirst().getX());
        assertEquals(1, adventurerList.getFirst().getY());
    }

    @Test
    public void testRotateLeft() {
        // Setup
        WorldMap worldMap = new WorldMap(3, 3);
        List<Adventurer> adventurerList = new ArrayList<>();
        adventurerList.add(new Adventurer("Lara", 1, 1, "N", "G"));

        TreasureHuntSimulation simulation = new TreasureHuntSimulation(worldMap, adventurerList);

        // Execute
        simulation.run();

        // Verify
        assertEquals(Direction.valueOf("O"), adventurerList.getFirst().getDirection());
    }

    @Test
    public void testRotateRight() {
        // Setup
        WorldMap worldMap = new WorldMap(3, 3);
        List<Adventurer> adventurerList = new ArrayList<>();
        adventurerList.add(new Adventurer("Lara", 1, 1, "N", "D"));

        TreasureHuntSimulation simulation = new TreasureHuntSimulation(worldMap, adventurerList);

        // Execute
        simulation.run();

        // Verify
        assertEquals(Direction.valueOf("E"), adventurerList.getFirst().getDirection());
    }
}