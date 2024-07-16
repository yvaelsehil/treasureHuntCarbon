package app.treasurehunt.io;

import app.treasurehunt.entity.Adventurer;
import app.treasurehunt.entity.WorldMap;
import app.treasurehunt.simulation.TreasureHuntSimulation;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    private static final String TEST_FILE_PATH = "src/test/resources/maps/map";
    @Test
    void testRead() throws IOException {
        assertTrue(Files.exists(Path.of(TEST_FILE_PATH)));
        TreasureHuntSimulation simulation = FileReader.read(TEST_FILE_PATH);

        WorldMap worldMap = simulation.getWorldMap();
        List<Adventurer> adventurers = simulation.getAdventurerList();

        // verify map size
        assertEquals(3, worldMap.getWidth());
        assertEquals(4, worldMap.getLength());

        // verify mountain and treasures
        assertTrue(worldMap.getTile(1, 1).isMountain());
        assertEquals(2, worldMap.getTile(2, 3).getTreasures());

        // verify adventurer
        assertEquals(1, adventurers.size());
        Adventurer adventurer = adventurers.getFirst();
        assertEquals("Lara", adventurer.getName());
        assertEquals(1, adventurer.getX());
        assertEquals(1, adventurer.getY());
        assertEquals("S", adventurer.getDirection().toString());
        assertEquals("AADADAGGA", adventurer.getPath());
    }
}