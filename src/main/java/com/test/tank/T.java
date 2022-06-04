package com.test.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(800,600);
        //设置不可改变大小
        f.setResizable(false);
        f.setTitle("tank war");
        //设置可见
        f.setVisible(true);
        //添加窗口事件
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
