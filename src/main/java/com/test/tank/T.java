package com.test.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(800,600);
        //���ò��ɸı��С
        f.setResizable(false);
        f.setTitle("tank war");
        //���ÿɼ�
        f.setVisible(true);
        //��Ӵ����¼�
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
