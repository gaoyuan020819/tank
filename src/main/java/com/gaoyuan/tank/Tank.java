package com.gaoyuan.tank;

import java.awt.*;

public class Tank {
    private static final int SPEED = 5;

    public static int WIDTH = ResourceMgr.tankL.getWidth();
    public static int HEIGHT = ResourceMgr.tankL.getWidth();

    public int x, y;
    private Dir dir = Dir.LEFT;

    public Group group = Group.BAD;

    private TankFrame tf = null;
    private boolean moving = true;

    private boolean living = true;



    public Tank(int x, int y, Dir dir,Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

    }

    public void piant(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillRect(x, y, 50, 50);
//        g.setColor(c);

        if (!this.living){
            return;
        }

        switch (this.dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            default:
                break;
        }


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

    public void die(){
        this.living = false;
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bx, by, this.dir,this.group, this.tf));
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
