package com.test.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //��ʼ���з�̹��
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, tf));
        }
        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
