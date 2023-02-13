package com.ap.simplerl.map;

import com.ap.simplerl.Player;
import processing.core.PGraphics;

abstract public class Item {
    protected final PGraphics gfx;

    protected Item(PGraphics gfx) {
        this.gfx = gfx;
    }

    abstract public void draw(int x, int y);

    public void use(Player player) {
    }
}
