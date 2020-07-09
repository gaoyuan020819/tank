package com.gaoyuan.tank;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = new TankFrame();

        tf.tanks.add(new Tank(100,100,Dir.LEFT,Group.BAD,tf));

        while (true){
            Thread.sleep(100);
            tf.repaint();
        }
    }
}
