package com.ap.simplerl.map;

import processing.core.PGraphics;

import java.util.Random;

public class TileMap {
    private final int rows;
    private final int cols;
    private final PGraphics gfx;
    private final Tile[] tiles;

    public TileMap(int rows, int cols, PGraphics gfx) {
        this.rows = rows;
        this.cols = cols;
        this.gfx = gfx;

        var rng = new Random();

        tiles = new Tile[rows*cols];
        for (int i = 0; i < rows*cols; i++) {
            var n = rng.nextFloat();
            if (n < 0.7) {
                tiles[i] = new FloorTile(gfx);
                if (rng.nextFloat() <0.1) {
                    tiles[i].setItem(new Potion(gfx));
                }
            } else {
                tiles[i] = new WallTile(gfx);
            }
        }
    }

    public Tile getTile(int x, int y) {
        int idx = cols*y + x;
        return tiles[idx];
    }

    public boolean isWalkable(int x, int y){
        var tile = getTile(x,y);
        return tile.isWalkable();
    }

    public void draw(){
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                var tile = getTile(x,y);
                tile.draw(x,y);
                tile.drawItem(x,y);
            }
        }
    }

    public Item getItem(int desiredX, int desiredY) {
        return getTile(desiredX,desiredY).getItem();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
