package com.ap.simplerl;

import processing.core.PGraphics;

public class Player {
    public static int SIZE = 16;
    private final PGraphics gfx;
    private int x;
    private int y;
    private int health;

    public Player(PGraphics gfx) {
        this.gfx = gfx;
        this.x = 0;
        this.y = 0;
        health = 100;
    }

    public void moveY(int dy){
        y += dy;
    }

    public void moveX(int dx){
        x += dx ;
    }

    public void move(int dx, int dy) {
        moveX(dx);
        moveY(dy);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void modifyHealthBy(int dHealth) {
        health += dHealth;
    }

    public void draw() {
        gfx.fill(255,0,0);
        gfx.rect(x* Player.SIZE,y* Player.SIZE,Player.SIZE,Player.SIZE);
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
}
