package com.test.tank;

import com.test.tank.strategy.DefaultFireStrategy;
import com.test.tank.strategy.FireStrategy;
import com.test.tank.strategy.FourDirFireStrategy;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    public int oldX, oldY;
    public Dir dir = Dir.DOWN;
    int tankSpeed = Integer.parseInt((String) PropertyMgr.get("tankSpeed"));
    private boolean moving = true;
    private boolean living = true;
    private Random random = new Random();
    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();

    public Rectangle getRect() {
        return rect;
    }

    FireStrategy fs;

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        if (group == Group.GOOD){
            String goodFsName = (String) PropertyMgr.get("goodFs");
            try {
                fs = (FireStrategy) Class.forName(goodFsName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            fs = new FourDirFireStrategy();
        }else {
            fs = new DefaultFireStrategy();
        }
        GameModel.getInstance().add(this);
    }

    public void fire() {
        fs.fire(this);
    }
    public void back() {
        x = oldX;
        y = oldY;
    }

    @Override
    public void paint(Graphics g) {
        if (!living){
            GameModel.getInstance().remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y,null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        oldX = x;
        oldY = y;
        if (!moving) return;
        switch (dir){
            case LEFT:
                x -= tankSpeed;
                break;
            case UP:
                y -= tankSpeed;
                break;
            case RIGHT:
                x += tankSpeed;
                break;
            case DOWN:
                y += tankSpeed;
                break;
            default:
                break;
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95){
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) > 95){
            randomDir();
        }
        boundsCheck();
        //uptate rect
        rect.x = this.x;
        rect.y = this.y;
    }
    //¼ì²é±ß½ç
    private void boundsCheck() {
        if (this.x < 2 ){
            x = 2;
        }
        if (this.y < 28){
            y = 28;
        }
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2){
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2){
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void die() {
        living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void stop() {
        moving = false;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
