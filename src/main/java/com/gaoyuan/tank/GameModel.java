package com.gaoyuan.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 门面模式：门面，把碰撞检测画图抽离出来
 *
 */
public class GameModel {

    java.util.List<Bullet> bullets = new ArrayList<Bullet>();
    java.util.List<Tank> tanks = new ArrayList<Tank>();
    List<Boom> booms = new ArrayList<Boom>();

    // Boom boom = new Boom(80,80,this);

    Tank myTank = new Tank(200,200,Dir.LEFT,Group.GOOD,this);

    public GameModel() {
    }

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量："+ tanks.size(),10,90);
        g.drawString("爆炸的数量："+ booms.size(),10,120);

        g.setColor(c);

        // 画子弹
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        // 画坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).piant(g);
        }

        // 画爆炸
        for(int i = 0; i<booms.size();i++){
            booms.get(i).paint(g);
        }

        myTank.piant(g);

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {

                bullets.get(i).collideWith(tanks.get(j));
            }
        }

    }

    public Tank getMyTank(){
        return myTank;
    }
}
