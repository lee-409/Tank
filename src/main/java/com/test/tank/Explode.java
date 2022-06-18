package com.test.tank;

import java.awt.*;
import java.util.Random;

public class Explode {
    private int x, y;
    private TankFrame tf = null;
    private int step = 0;

    public static int WIDTH = ResourcesMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourcesMgr.explodes[0].getHeight();

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourcesMgr.explodes[step++],200,200,null);
        if (step >= ResourcesMgr.explodes.length){
            tf.explodes.remove(this);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
