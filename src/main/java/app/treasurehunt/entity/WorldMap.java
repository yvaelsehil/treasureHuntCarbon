package app.treasurehunt.entity;

public class WorldMap {

    private final int length;
    private final int width;
    private Tile[][] worldMap;

    public WorldMap(int width, int length) {
        this.width = width;
        this.length = length;
        this.worldMap = new Tile[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                this.worldMap[i][j] = new Tile();
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Tile[][] getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(Tile[][] worldMap) {
        this.worldMap = worldMap;
    }

    public Tile getTile(int x, int y) {
        if (x >= 0 && x < this.worldMap.length && y >= 0 && y < this.worldMap[0].length) {
            return this.worldMap[x][y];
        }
        return null;
    }
}
