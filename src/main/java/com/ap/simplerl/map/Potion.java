package com.ap.simplerl.map;

import com.ap.simplerl.Player;
import processing.core.PGraphics;

public class Potion extends Item {
    private int healingPower;

    protected Potion(PGraphics gfx) {
        super(gfx);
        healingPower = 10;
    }

    @Override
    public void draw(int x, int y) {
        gfx.fill(155,10,255);
        gfx.circle(x+8,y+8,16);
    }

    @Override
    public void use(Player player) {
        player.modifyHealthBy(healingPower);
    }
}
