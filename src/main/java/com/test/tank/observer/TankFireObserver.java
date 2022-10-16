package com.test.tank.observer;

/**
 * @program: Tank
 * @description:
 * @author: LeeHK
 * @create: 2022-10-16 10:33
 **/
public interface TankFireObserver {
    void actionOnFire(TankFireEvent event);
}
