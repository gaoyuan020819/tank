package com.gaoyuan.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private static final int SPEED = 10;

    public static int WIDTH = ResourceMgr.badTankU.getWidth();
    public static int HEIGHT = ResourceMgr.badTankU.getWidth();

    public int x, y;
    private Dir dir = Dir.LEFT;

    public Group group = Group.BAD;

    private TankFrame tf = null;
    private boolean moving = true;

    private boolean living = true;

    private Random random = new Random();

    public Rectangle rect = new Rectangle();

    GameModel gm;


    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = Tank.WIDTH;
        rect.height = Tank.HEIGHT;
    }

    public void piant(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillRect(x, y, 50, 50);
//        g.setColor(c);

        if (!this.living) {
            gm.tanks.remove(this);
        }

        switch (this.dir) {
            case LEFT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankL : ResourceMgr.goodTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankR : ResourceMgr.goodTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankU : ResourceMgr.goodTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankD : ResourceMgr.goodTankD, x, y, null);
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

        if (this.group == Group.BAD) {
            if (random.nextInt(100) > 95) {
                this.fire();
            }

            if (random.nextInt(100) > 95) {
                randomDir();
            }
        }

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;

    }

    public void randomDir() {
        this.dir = dir.values()[random.nextInt(4)];
    }

    public void die() {
        this.living = false;
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        gm.bullets.add(new Bullet(bx, by, this.dir, this.group, this.gm));
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

    /**
     * 坦克边界检测
     */
    private void boundsCheck() {

        this.x = this.x<2?2:this.x;
        this.x = this.x>TankFrame.GAME_WIDTH-Tank.WIDTH-2?TankFrame.GAME_WIDTH-Tank.WIDTH-2:this.x;
        this.y = this.y<28?28:this.y;
        this.y = this.y>TankFrame.GAME_HEIGHT-Tank.HEIGHT-2?TankFrame.GAME_HEIGHT-Tank.HEIGHT-2:this.y;

    }
}
