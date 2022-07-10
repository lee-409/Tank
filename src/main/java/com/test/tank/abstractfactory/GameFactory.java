package com.test.tank.abstractfactory;

import com.test.tank.Dir;
import com.test.tank.Group;
import com.test.tank.TankFrame;

public abstract class GameFactory {
    public abstract BaseTank creatTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode creatExplode(int x, int y, TankFrame tf);
    public abstract BaseBullet creatBullet(int x, int y, Dir dir, Group group, TankFrame tf);
}
