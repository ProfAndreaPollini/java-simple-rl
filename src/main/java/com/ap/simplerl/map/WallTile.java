package com.ap.simplerl.map;

import processing.core.PGraphics;

public class WallTile extends Tile {

    protected WallTile(PGraphics gfx) {
        super(gfx);
    }

    @Override
    public void draw(int x, int y) {
        gfx.fill(55,55,55);
        gfx.rect(x*Tile.SIZE,y*Tile.SIZE, Tile.SIZE,Tile.SIZE);
    }
}
