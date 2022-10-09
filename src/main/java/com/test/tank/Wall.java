package com.test.tank;

import java.awt.*;

/**
 * @program: Tank
 * @description: Η½Με
 * @author: LeeHK
 * @create: 2022-10-08 17:00
 **/
public class Wall extends GameObject{
    int w, h;
    public Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rect = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }
}
