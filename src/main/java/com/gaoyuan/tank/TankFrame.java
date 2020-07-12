package com.gaoyuan.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    GameModel gameModel = new GameModel();

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 800;

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

        gameModel.paint(g);


//        Iterator<Bullet> bulletIterator = bList.iterator();
//        while (bulletIterator.hasNext()) {
//            Bullet b = bulletIterator.next();
//            b.paint(g);
//
//        }

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
                    gameModel.getMyTank().fire();
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

        }

        private void setMainTankDir() {

            if (!(bL || bR || bU || bD)) {
                gameModel.getMyTank().setMoving(false);
            } else {
                gameModel.getMyTank().setMoving(true);

                if (bL) gameModel.getMyTank().setDir(Dir.LEFT);
                if (bR) gameModel.getMyTank().setDir(Dir.RIGHT);
                if (bU) gameModel.getMyTank().setDir(Dir.UP);
                if (bD) gameModel.getMyTank().setDir(Dir.DOWN);
            }


        }
    }
}
