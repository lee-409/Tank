package com.test.tank.decorator;

import com.test.tank.GameObject;

import java.awt.*;

/**
 * @program: Tank
 * @description: װ����
 * @author: LeeHK
 * @create: 2022-10-09 10:21
 **/
public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;

        go.paint(g);
//        Color c = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.drawRect(super.go.x, super.go.y, super.go.getWidth()+2, super.go.getHeight()+2);
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
