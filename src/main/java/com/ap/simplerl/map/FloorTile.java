package com.ap.simplerl.map;

import com.ap.simplerl.Player;
import processing.core.PGraphics;

public class FloorTile extends Tile {

    public FloorTile(PGraphics gfx) {
        super(gfx);
        setWalkable(true);
    }

    @Override
    public void draw(int x, int y) {
        gfx.fill(155,100,75);
        gfx.rect(x*Tile.SIZE,y*Tile.SIZE, Tile.SIZE,Tile.SIZE);
    }

    @Override
    public void drawItem(int x, int y) {
        if (item != null) {
            item.draw(x*Tile.SIZE,y*Tile.SIZE);
        }
    }

}
