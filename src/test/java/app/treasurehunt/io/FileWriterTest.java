package app.treasurehunt.io;

import app.treasurehunt.entity.Adventurer;
import app.treasurehunt.entity.WorldMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FileWriterTest {

    private static final String TEST_FILE_PATH = "testFile.txt";

    @AfterEach
    void cleanup(){
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
    @Test
    void testWriteFile() throws IOException {
        // Setup

        WorldMap worldMap = new WorldMap(10, 10);
        worldMap.getTile(2,2).setTreasures(4);
        worldMap.getTile(1,3).setMountain(true);

        Adventurer adventurer = new Adventurer("toto", 0,0, "S", "");

        String expectedOutputContent = String.join(System.lineSeparator(),
                "C - 10 - 10",
                "M - 1 - 3",
                "T - 2 - 2 - 4",
                "A - toto - 0 - 0 - S - 0"
        );

        // Test begins

        FileWriter.writeFile(worldMap, Collections.singletonList(adventurer), TEST_FILE_PATH);

        File writenFile = new File(TEST_FILE_PATH);

        assertTrue(writenFile.exists());

        String content = Files.readString(writenFile.toPath());

        assertEquals(expectedOutputContent, content.trim());
    }
}