package com.test.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    int x = 200,y = 200;

    public TankFrame() {
        setSize(800,600);
        //设置不可改变大小
        setResizable(false);
        setTitle("tank war");
        //设置可见
        setVisible(true);
        //添加窗口监听事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fill3DRect(x,y,50,50,true);
//        g.fillRect(100,100,50,50);
//        x += 10;
//        y +=10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    x -= 10;
                    break;
                case KeyEvent.VK_UP:
                    y -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 10;
                    break;
                case KeyEvent.VK_DOWN:
                    y += 10;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}
