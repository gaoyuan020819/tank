package com.gaoyuan.tank;


import java.awt.*;

public class Boom {


    public static int WIDTH = ResourceMgr.boom[0].getWidth();
    public static int HEIGHT = ResourceMgr.boom[0].getWidth();


    private int x,y;


    private GameModel gm = null;
    private boolean living = true;

    private int step = 0;

    public Boom(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }

    public void paint(Graphics g){


        g.drawImage(ResourceMgr.boom[step++],x,y ,null);

        if (step>= ResourceMgr.boom.length){
            gm.booms.remove(this);
        }
    }






}
