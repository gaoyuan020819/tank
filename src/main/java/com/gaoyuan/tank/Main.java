package com.gaoyuan.tank;

import java.awt.*;
import java.util.Random;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = new TankFrame();

        Integer initTankCount = PropertiesMgr.getInt("initTankCount");
        for(int i = 0;i<initTankCount;i++){
            tf.gameModel.tanks.add(new Tank(100+i*Tank.WIDTH,100,Dir.values()[new Random().nextInt(4)],Group.BAD,tf.gameModel));
        }


        while (true){
            Thread.sleep(100);
            tf.repaint();
        }

    }
}
