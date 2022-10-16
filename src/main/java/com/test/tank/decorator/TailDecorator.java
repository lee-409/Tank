package com.test.tank.decorator;

import com.test.tank.GameObject;

import java.awt.*;

/**
 * @program: Tank
 * @description: װ����
 * @author: LeeHK
 * @create: 2022-10-09 10:21
 **/
public class TailDecorator extends GODecorator {

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;

        go.paint(g);
//        Color c = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.drawLine(super.go.x, super.go.y, go.x + getWidth(), go.y + getHeight());
//        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
