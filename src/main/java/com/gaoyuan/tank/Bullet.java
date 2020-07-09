package com.gaoyuan.tank;

import java.awt.*;

public class Bullet {

    private static final int SPEED = 10;

    public static int WIDTH = ResourceMgr.bulletL.getWidth();
    public static int HEIGHT = ResourceMgr.bulletL.getWidth();


    private int x,y;
    private Dir dir;
    public Group group;


    private TankFrame tf = null;
    private boolean living = true;

    public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g){

        if (!living){
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

    private void vaild(int width,int height){

        if (x<0 || x>width || y<0 || y>height){
            this.living = false;
        }

    }


    private void move() {

        x += dir == Dir.RIGHT ? SPEED : 0;
        x -= dir == Dir.LEFT ? SPEED : 0;
        y += dir == Dir.DOWN ? SPEED : 0;
        y -= dir == Dir.UP ? SPEED : 0;

        vaild(TankFrame.GAME_WIDTH,TankFrame.GAME_HEIGHT);

    }

    private void die(){
        this.living = false;
    }

    public void collideWith(Tank tank){

        if (this.group == tank.group){
            return;
        }

        Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rect2 = new Rectangle(tank.x,tank.y,Tank.WIDTH,Tank.HEIGHT);

        if (rect1.intersects(rect2)){
            tank.die();
            this.die();
        }
    }
}
