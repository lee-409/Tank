package com.test.tank.observer;

import com.test.tank.Tank;

/**
 * @program: Tank
 * @description:
 * @author: LeeHK
 * @create: 2022-10-16 10:35
 **/
public class TankFireHandler implements TankFireObserver{
    @Override
    public void actionOnFire(TankFireEvent event) {
        Tank tank = event.getSource();
        tank.fire();
    }
}
