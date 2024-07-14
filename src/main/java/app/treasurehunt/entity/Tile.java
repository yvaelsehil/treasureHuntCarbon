package app.treasurehunt.entity;

public class Tile {
    private boolean mountain;
    private int treasures;

    public Tile() {
        this.mountain = false;
        this.treasures = 0;
    }

    public boolean isMountain() {
        return mountain;
    }

    public void setMountain(boolean mountain) {
        this.mountain = mountain;
    }

    public int getTreasures() {
        return treasures;
    }

    public void setTreasures(int treasures) {
        this.treasures = treasures;
    }

    public void decrementTreasure() {
        if (this.treasures > 0) {
            this.treasures--;
        }
    }
}
