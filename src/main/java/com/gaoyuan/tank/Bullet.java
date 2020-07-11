package com.gaoyuan.tank;

import java.awt.*;

public class Bullet {

    private static final int SPEED = 50;

    public static int WIDTH = ResourceMgr.bulletL.getWidth();
    public static int HEIGHT = ResourceMgr.bulletL.getWidth();


    private int x, y;
    private Dir dir;
    public Group group;


    private TankFrame tf = null;
    private boolean living = true;

    Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = Bullet.WIDTH;
        rect.height = Bullet.HEIGHT;
    }

    public void paint(Graphics g) {

        if (!living) {
            tf.bullets.remove(this);
        }

//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HEIGHT);
//        g.setColor(c);

        switch (this.dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }

        move();
    }

    /**
     * 子弹边界检测
     */
    private void boundsCheck() {

        if (x < 0 || x > TankFrame.GAME_WIDTH || y < 0 || y > TankFrame.GAME_HEIGHT) {
            this.living = false;
        }

    }

    /**
     * 子弹移动
     */
    private void move() {

        x += dir == Dir.RIGHT ? SPEED : 0;
        x -= dir == Dir.LEFT ? SPEED : 0;
        y += dir == Dir.DOWN ? SPEED : 0;
        y -= dir == Dir.UP ? SPEED : 0;

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void die() {
        this.living = false;
    }

    /**
     * 检测子弹是否击中坦克
     *
     * @param tank
     */
    public void collideWith(Tank tank) {

        if (this.group == tank.group) {
            return;
        }


        if (this.rect.intersects(tank.rect)) {
            tank.die();
            this.die();

            int ex = tank.x + Tank.WIDTH / 2 - Boom.WIDTH / 2;
            int ey = tank.y + Tank.HEIGHT / 2 - Boom.HEIGHT / 2;

            tf.booms.add(new Boom(ex, ey, tf));
        }
    }
}
