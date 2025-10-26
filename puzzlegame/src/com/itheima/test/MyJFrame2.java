package com.itheima.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 implements MouseListener {
    //创建一个按钮事件
    JButton jbt = new JButton("点它");

    public MyJFrame2() {
        JFrame jFrame = new JFrame();
        //设置界面的宽高
        jFrame.setSize(603, 680);
        //设置界面的标题
        jFrame.setTitle("事件演示");
        //设置界面置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置关闭模式
        jFrame.setDefaultCloseOperation(3);//为什么是3：只要你关掉一个界面，其他界面也会跟着关闭
        //组件默认是居中的位置，我们要取消居中
        jFrame.setLayout(null);



        //设置按钮
        jbt.setBounds(0, 0, 100, 50);
       //不要忘记把按钮添加到整个界面中，重中之重，最后一步不可忘记
        jbt.addMouseListener(this);

        //把按钮添加到界面中
        jFrame.getContentPane().add(jbt);

        jFrame.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标点击了");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
