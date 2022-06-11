package com.test.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200, 200,Dir.DOWN);
    static final int GAME_WIDTH = 800;
    static final int GAME_HEIGHT = 600;

    public TankFrame() {
        setSize(GAME_WIDTH,GAME_HEIGHT);
        //设置不可改变大小
        setResizable(false);
        setTitle("tank war");
        //设置可见
        setVisible(true);
        //添加窗口监听事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
    }

    Image offScreenImage = null;
//    @Override
//    public void update(Graphics g) {
//        if (offScreenImage == null) {
//            this.createImage(GAME_WIDTH,GAME_HEIGHT);
//        }
//        Graphics gOffScreen = offScreenImage.getGraphics();
//        Color c = gOffScreen.getColor();
//        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
//        gOffScreen.setColor(c);
//        paint(gOffScreen);
//        g.drawImage(offScreenImage,0,0,null);
//    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bL && !bU && !bR && !bD){
                myTank.setMoving(false);
            }else {
                myTank.setMoving(true);
                if (bL) myTank.setDir( Dir.LEFT);
                if (bU) myTank.setDir( Dir.UP);
                if (bR) myTank.setDir( Dir.RIGHT);
                if (bD) myTank.setDir( Dir.DOWN);
            }
        }

    }
}
