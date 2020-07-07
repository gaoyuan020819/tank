package com.gaoyuan.tank;

import java.awt.*;

public class Tank {
    private static final int SPEED = 5;

    private int x, y;
    private Dir dir = Dir.LEFT;

    private TankFrame tf;
    private boolean moving = false;

    public Tank(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void piant(Graphics g) {
        Color c = g.getColor();

        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        move();

    }

    private void move() {

        if (!moving) {
            return;
        }

        x += dir == Dir.RIGHT ? SPEED : 0;
        x -= dir == Dir.LEFT ? SPEED : 0;
        y += dir == Dir.DOWN ? SPEED : 0;
        y -= dir == Dir.UP ? SPEED : 0;

    }

    public void fire(){
        tf.bList.add(new Bullet(this.x,this.y,this.dir));
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
