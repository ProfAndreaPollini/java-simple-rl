package com.ap.simplerl;

import com.ap.simplerl.map.TileMap;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class SimpleRl extends PApplet {
    private Player player;
    private  TileMap map;

    @Override
    public void settings() {
        setSize(800,600);
    }

    @Override
    public void setup() {
        player = new Player(getGraphics());
        map = new TileMap(40,40,getGraphics());
    }

    @Override
    public void keyPressed() {
        var currentX = player.getX();
        var currentY = player.getY();
        var desiredX = currentX;
        var desiredY = currentY;
        if (key == CODED) {
            switch (keyCode) {
                case UP -> desiredY   += -1;
                case DOWN -> desiredY +=1;
                case LEFT -> desiredX += -1;
                case RIGHT -> desiredX += 1;
            }
        }

        if (desiredY < 0) desiredY = 0;
        if (desiredX <0) desiredX = 0;
        if (desiredX >= map.getCols()) desiredX = map.getCols()-1;
        if (desiredY >= map.getRows()) desiredY = map.getRows() -1;

        if (map.isWalkable(desiredX,desiredY)) {
            player.setX(desiredX);
            player.setY(desiredY);
            System.out.printf("moving to -> (%d, %d)%n",player.getX(),player.getY());
            var item = map.getItem(desiredX,desiredY);
            if (item != null) {
                item.use(player);
                System.out.printf("health = %d",player.getHealth());
                map.getTile(desiredX,desiredY).setItem(null);
            }
        }
    }

    @Override
    public void draw() {
        clear();
        update();
        map.draw();
        player.draw();
    }

    private void update() {
    }

    public static void main(String[] args) {
        System.out.println("Java Simple roguelike,enjoi!");
        PApplet.main("com.ap.simplerl.SimpleRl");
    }
}
