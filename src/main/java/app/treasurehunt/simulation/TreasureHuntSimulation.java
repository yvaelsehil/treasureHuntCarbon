package app.treasurehunt.simulation;

import app.treasurehunt.entity.Adventurer;
import app.treasurehunt.entity.Tile;
import app.treasurehunt.entity.WorldMap;

import java.util.List;

public class TreasureHuntSimulation {
    private WorldMap worldMap;
    private List<Adventurer> adventurerList;

    public TreasureHuntSimulation(WorldMap worldMap, List<Adventurer> adventurerList) {

        this.worldMap = worldMap;
        this.adventurerList = adventurerList;
    }

    public void run() {
        int maxStep = this.getMaxStep();
        for (int i = 0; i < maxStep; i++) {
            step(i);
        }
    }

    private void step(int step) {
        for (Adventurer adventurer : adventurerList) {
            if (step < adventurer.getPath().length()) {
                char move = adventurer.getPath().charAt(step);
                switch (move) {
                    case 'A':
                        this.advance(adventurer);
                        break;
                    case 'G':
                        adventurer.setDirection(adventurer.getDirection().rotateLeft());
                        break;
                    case 'D':
                        adventurer.setDirection(adventurer.getDirection().rotateRight());
                        break;
                }
            }
        }
    }

    private void advance(Adventurer adventurer) {
        int x = adventurer.getX();
        int y = adventurer.getY();

        switch (adventurer.getDirection()) {
            case O -> x -= 1;
            case E -> x += 1;
            case N -> y -= 1;
            case S -> y += 1;
        }

        if (this.isMoveValid(x, y)) {
            adventurer.setX(x);
            adventurer.setY(y);
            Tile tile = this.worldMap.getTile(x, y);
            if (tile.getTreasures() > 0) {
                adventurer.incrementTreasuresFound();
                tile.decrementTreasure();
            }
        }

    }

    private boolean isMoveValid(int x, int y) {
        if (x < 0 || x >= this.worldMap.getWidth() || y < 0 || y >= this.worldMap.getLength() || this.worldMap.getTile(x, y).isMountain()
        ) {
            return false;
        }
        for (Adventurer adventurer : this.adventurerList) {
            if (adventurer.getX() == x && adventurer.getY() == y) {
                return false;
            }
        }
        return true;
    }

    private int getMaxStep() {
        int max = 0;
        if (this.adventurerList != null) {
            for (Adventurer adventurer : this.adventurerList) {
                if (adventurer.getPath().length() > max) {
                    max = adventurer.getPath().length();
                }
            }
        }
        return max;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public List<Adventurer> getAdventurerList() {
        return adventurerList;
    }

    public void setAdventurerList(List<Adventurer> adventurerList) {
        this.adventurerList = adventurerList;
    }
}
