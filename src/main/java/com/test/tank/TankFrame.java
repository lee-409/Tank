package com.test.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    public TankFrame() {
        setSize(800,600);
        //���ò��ɸı��С
        setResizable(false);
        setTitle("tank war");
        //���ÿɼ�
        setVisible(true);
        //��Ӵ����¼�
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
