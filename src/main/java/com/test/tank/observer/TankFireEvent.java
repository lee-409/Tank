package com.test.tank.observer;

import com.test.tank.Tank;

/**
 * @program: Tank
 * @description:
 * @author: LeeHK
 * @create: 2022-10-16 10:28
 **/
public class TankFireEvent {
    Tank tank;
    public Tank getSource(){
        return tank;
    }
    public TankFireEvent(Tank tank){
        this.tank = tank;
    }
}
