package com.test.tank;

import com.test.tank.cor.BulletTankCollider;
import com.test.tank.cor.Collider;
import com.test.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    Tank myTank = new Tank(200, 400,Dir.DOWN,Group.GOOD, this);
//    java.util.List<Bullet> bullets = new ArrayList<>();
//    java.util.List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();

    Collider collider = new BulletTankCollider();
    Collider collider2 = new TankTankCollider();

    List<GameObject> objects = new ArrayList<>();

    public void add(GameObject go){
        this.objects.add(go);
    }
    public void remove(GameObject go){
        this.objects.remove(go);
    }

    public GameModel(){
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, this));
        }
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹数量：" + bullets.size(),10,60);
//        g.drawString("敌人数量：" + tanks.size(),10,80);
//        g.drawString("爆炸数量：" + tanks.size(),10,100);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i <objects.size(); i++){
            objects.get(i).paint(g);
        }
        //相互相撞
        for (int i = 0; i <objects.size(); i++){
            for (int j = i+1; j <objects.size(); j++){
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                collider.collide(o1, o2);
                collider2.collide(o1, o2);
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
