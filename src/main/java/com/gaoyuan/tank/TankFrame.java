package com.gaoyuan.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, Dir.LEFT, this);
    List<Bullet> bList = new ArrayList<Bullet>();

    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 800;

    final int SPEED = 10;

    public TankFrame() {

        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("tank war");
        this.setVisible(true);

        this.addKeyListener(new MyKeyListener());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offscreenImage = null;

    @Override
    public void update(Graphics g) {
        if (null == offscreenImage) {
            offscreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }

        Graphics gOffScreen = offscreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offscreenImage, 0, 0, null);
    }


    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量：" + bList.size(), 10, 60);
        g.setColor(c);

        myTank.piant(g);

        for (int i = 0; i < bList.size(); i++) {
            Bullet b = bList.get(i);
            b.paint(g);
        }

        Iterator<Bullet> bulletIterator = bList.iterator();
        while (bulletIterator.hasNext()) {
            Bullet b = bulletIterator.next();
            b.paint(g);
            if (b.vaild(GAME_WIDTH, GAME_HEIGHT)) {
                bulletIterator.remove();
            }
        }

//        System.out.println("paint");
//        g.fillRect(x, y, 50, 50);
//        x+= dir == Dir.RIGHT?SPEED:0;
//        x-= dir == Dir.LEFT?SPEED:0;
//        y+= dir == Dir.DOWN?SPEED:0;
//        y-= dir == Dir.UP?SPEED:0;

        //x += 10;
        //y += 10;
    }

    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }

//            x+= bR?10:0;
//            x-= bL?10:0;
//            y+= bD?10:0;
//            y-= bU?10:0;

            setMainTankDir();
//            System.out.println("key pressed");
//            x += 30;
            //repaint();
        }


        @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                default:
                    break;
            }

            setMainTankDir();

            System.out.println("key released");
        }

        private void setMainTankDir() {

            if (!(bL || bR || bU || bD)) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);

                if (bL) myTank.setDir(Dir.LEFT);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
            }


        }
    }
}
