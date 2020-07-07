package com.gaoyuan.tank;

import java.awt.*;

public class Bullet {

    private static final int SPEED = 10;

    private static int WIDTH = 5;
    private static int HEIGHT = 5;


    private int x,y;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);

        move();
    }

    public boolean vaild(int width,int height){

        if (x<0 || x>width || y<0 || y>height){
            return true;
        }

        return false;

    }


    private void move() {

        x += dir == Dir.RIGHT ? SPEED : 0;
        x -= dir == Dir.LEFT ? SPEED : 0;
        y += dir == Dir.DOWN ? SPEED : 0;
        y -= dir == Dir.UP ? SPEED : 0;

    }
}
