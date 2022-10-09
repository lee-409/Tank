package com.test.tank.decorator;

import com.test.tank.GameModel;
import com.test.tank.GameObject;

import java.awt.*;

/**
 * @program: Tank
 * @description: ×°ÊÎÆ÷
 * @author: LeeHK
 * @create: 2022-10-09 10:21
 **/
public abstract class GODecorator extends GameObject {
    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);
}
