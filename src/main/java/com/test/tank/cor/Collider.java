package com.test.tank.cor;

import com.test.tank.GameObject;

public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
