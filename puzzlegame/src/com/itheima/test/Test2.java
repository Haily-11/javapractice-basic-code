//package com.itheima.test;
//
//import javax.swing.*;
//
//public class Test2  {
//    public static void main(String[] args) {
//        JFrame jFrame = new JFrame();
//        //设置界面的宽高
//        jFrame.setSize(603, 680);
//        //设置界面的标题
//        jFrame.setTitle("事件演示");
//        //设置界面置顶
//        jFrame.setAlwaysOnTop(true);
//        //设置界面居中
//        jFrame.setLocationRelativeTo(null);
//        //设置关闭模式
//        jFrame.setDefaultCloseOperation(3);//为什么是3：只要你关掉一个界面，其他界面也会跟着关闭
//        //组件默认是居中的位置，我们要取消居中
//        jFrame.setLayout(null);
//
//
//        //创建一个按钮事件
//        JButton jbt = new JButton("点它");
//        //设置按钮
//        jbt.setBounds(0, 0, 100, 50);
//        jbt.addActionListener(this);
//
//        //把按钮添加到整个界面当中
//        this.getCoutpane().add(jbt);
//
//        jFrame.setVisible(true);
//    }
//}
//
