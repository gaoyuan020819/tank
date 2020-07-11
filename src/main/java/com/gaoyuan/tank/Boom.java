package com.gaoyuan.tank;

import org.w3c.dom.css.Rect;

import java.awt.*;

public class Boom {


    public static int WIDTH = ResourceMgr.boom[0].getWidth();
    public static int HEIGHT = ResourceMgr.boom[0].getWidth();


    private int x,y;


    private TankFrame tf = null;
    private boolean living = true;

    private int step = 0;

    public Boom(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g){


        g.drawImage(ResourceMgr.boom[step++],x,y ,null);

        if (step>= ResourceMgr.boom.length){
            tf.booms.remove(this);
        }
    }






}
