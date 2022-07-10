package com.test.tank.abstractfactory;

import com.test.tank.Audio;
import com.test.tank.ResourceMgr;
import com.test.tank.TankFrame;

import java.awt.*;

public class RectExplode extends BaseExplode{
    private int x, y;
    private TankFrame tf = null;
    private int step = 0;

    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
//        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10*step, 10*step);
        step++;
        if (step >= 5){
            tf.explodes.remove(this);
        }
        g.setColor(c);
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
