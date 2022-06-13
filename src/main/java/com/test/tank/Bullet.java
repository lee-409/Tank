package com.test.tank;

import java.awt.*;

public class Bullet {
    private int x, y;
    private Dir dir;
    private final static int SPEED = 10;
    private static int WIDTH = 30,HEIGHT = 30;
    private TankFrame tf = null;
    private boolean live = true;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g) {
        if (!live){
            tf.bullets.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourcesMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourcesMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourcesMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourcesMgr.bulletD,x,y,null);
                break;
            default:
                break;
        }
        move();
    }
    private void move() {
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            live = false;
        }
    }
}
