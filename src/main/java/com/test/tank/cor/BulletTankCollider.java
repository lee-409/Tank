package com.test.tank.cor;

import com.test.tank.Bullet;
import com.test.tank.Explode;
import com.test.tank.GameObject;
import com.test.tank.Tank;

public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
//            b.collideWith(t);
            if (b.group == t.getGroup()){
                return true;
            }
            //如果子弹、坦克相交
            if (b.rect.intersects(t.rect)) {
                t.die();
                b.die();
                int eX = t.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
                int eY = t.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                new Explode(eX, eY);
                return false;
            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet){
            collide(o2, o1);
        }
        return true;
    }
}
