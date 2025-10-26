package com.itheima.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame implements ActionListener{
    //创建一个按钮事件
    JButton jbt = new JButton("点它");

    public MyJFrame() {
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
        //addActionListener：表示我要给组件添加那个事件监听，动作监听鼠标左键点击，空格）
        jbt.addActionListener(this);
        //把按钮添加到整个界面中
        this.getContentPane().add(jbt);

        //把按钮添加到界面中
        jFrame.getContentPane().add(jbt);

        jFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source==jbt){
            jbt.setSize(200,100);
        }
    }
}
