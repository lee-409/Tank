package com.test.tank;

import java.awt.*;

public class Bullet extends GameObject {
    private int x, y;
    private Dir dir;
    int bulletSpeed = Integer.parseInt((String) PropertyMgr.get("bulletSpeed"));
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private boolean live = true;
    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        GameModel.getInstance().add(this);
    }
    @Override
    public void paint(Graphics g) {
        if (!live){
            GameModel.getInstance().remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            default:
                break;
        }
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

    public void die() {
        this.live = false;
    }
}
