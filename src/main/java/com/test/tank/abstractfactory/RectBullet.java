package com.test.tank.abstractfactory;

import com.test.tank.*;

import java.awt.*;

public class RectBullet extends BaseBullet {
    private int x, y;
    private Dir dir;
    int bulletSpeed = Integer.parseInt((String) PropertyMgr.get("bulletSpeed"));
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private TankFrame tf = null;
    private boolean live = true;
    private Group group = Group.BAD;
    Rectangle rect = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

//        tf.rectBullets.add(this);
        tf.bullets.add(this);
    }
    public void paint(Graphics g) {
        if (!live){
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 20, 20);
        g.setColor(c);
        move();
    }
    private void move() {
        switch (dir){
            case LEFT:
                x -= bulletSpeed;
                break;
            case UP:
                y -= bulletSpeed;
                break;
            case RIGHT:
                x += bulletSpeed;
                break;
            case DOWN:
                y += bulletSpeed;
                break;
            default:
                break;
        }
        //uptate rect
        rect.x = this.x;
        rect.y = this.y;
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            live = false;
        }
    }

    //子弹与坦克相撞
    public void collideWith(BaseTank tank) {
        if (this.group == tank.getGroup()){
            return;
        }
        //如果子弹、坦克相交
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tf.explodes.add(tf.gf.creatExplode(eX, eY, tf));
        }
    }

    private void die() {
        this.live = false;
    }
}
