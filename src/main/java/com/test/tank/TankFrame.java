package com.test.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200, 400,Dir.DOWN,Group.GOOD, this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();
//    Bullet bullet= new Bullet(300,300,Dir.DOWN);
static int GAME_WIDTH = Integer.parseInt((String) PropertyMgr.get("gameWidth"));
    static int GAME_HEIGHT = Integer.parseInt((String) PropertyMgr.get("gameHeight"));
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
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量：" + bullets.size(),10,60);
        g.drawString("敌人数量：" + tanks.size(),10,80);
        g.drawString("爆炸数量：" + tanks.size(),10,100);
        g.setColor(c);

        myTank.paint(g);
//        for (Bullet bullet: bullets) {
//            bullet.paint(g);
//        }
        for (int i = 0; i <bullets.size(); i++){
            bullets.get(i).paint(g);
        }
        for (int i = 0; i <tanks.size(); i++){
            tanks.get(i).paint(g);
        }
        for (int i = 0; i <explodes.size(); i++){
            explodes.get(i).paint(g);
        }
        //子弹和坦克相撞
        for (int i = 0; i <bullets.size(); i++){
            for (int j = 0; j <tanks.size(); j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
//        for (Iterator<Bullet> it = bullets.iterator(); it.hasNext();){
//            Bullet b = it.next();
//            if (!b.live){
//                it.remove();
//            }
//        }
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
            new Thread(()->new Audio("audio/tank_move.wav").play()).start();
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
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
//                    new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
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
