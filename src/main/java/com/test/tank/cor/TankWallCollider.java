package com.test.tank.cor;

import com.test.tank.*;

public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall){
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;

            if (t.rect.intersects(w.rect)) {
                if(t.group == Group.GOOD){
                    t.stop();
                }else {
                    t.back();
                }
            }
        }else if (o1 instanceof Wall && o2 instanceof Tank){
            collide(o2, o1);
        }
        return true;
    }
}
