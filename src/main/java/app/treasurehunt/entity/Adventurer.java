package app.treasurehunt.entity;


import java.util.ArrayList;
import java.util.Stack;

public class Adventurer {

    private String name;
    private int x;
    private int y;
    private Direction direction;
    private String path;
    private int treasuresFound;

    public Adventurer(String name, int x, int y, String direction, String path) {
        this.name = name;
        this.direction = Direction.valueOf(direction);
        this.x = x;
        this.y = y;
        this.treasuresFound = 0;
        this.path = path;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getTreasuresFound() {
        return treasuresFound;
    }

    public void setTreasuresFound(int treasuresFound) {
        this.treasuresFound = treasuresFound;
    }

    public void incrementTreasuresFound() {
        this.treasuresFound++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
