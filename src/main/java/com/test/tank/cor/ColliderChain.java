package com.test.tank.cor;

import com.test.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {
    private List<Collider> colliders = new LinkedList<>();
    public ColliderChain(){
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }
    public void add(Collider c){
        colliders.add(c);
    }

    public void collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            colliders.get(i).collide(o1, o2);
        }
    }
}