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
        //���ò��ɸı��С
        setResizable(false);
        setTitle("tank war");
        //���ÿɼ�
        setVisible(true);
        //��Ӵ��ڼ����¼�
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
        x += 10;
//        y +=10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
//            x += 10;
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}
