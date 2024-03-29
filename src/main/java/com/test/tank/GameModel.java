package com.test.tank;

import com.test.tank.cor.BulletTankCollider;
import com.test.tank.cor.Collider;
import com.test.tank.cor.ColliderChain;
import com.test.tank.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private static final GameModel INSTANCE = new GameModel();
    static {
        INSTANCE.init();
    }
    Tank myTank = null;
    ColliderChain chain = new ColliderChain();

    List<GameObject> objects = new ArrayList<>();

    public static GameModel getInstance(){
        return INSTANCE;
    }
    public void add(GameObject go){
        this.objects.add(go);
    }
    public void remove(GameObject go){
        this.objects.remove(go);
    }

    private void init(){
        myTank = new Tank(200, 400,Dir.DOWN,Group.GOOD);
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD);
        }
        //初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
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
                chain.collide(o1, o2);
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
