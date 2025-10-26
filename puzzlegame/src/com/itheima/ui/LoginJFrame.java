package com.itheima.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginJFrame extends JFrame implements ActionListener {
    //登陆界面
    private JTextField username;
    private JPasswordField password;
    private JTextField captcha;
    JLabel loginJ = new JLabel(new ImageIcon("puzzlegame\\image\\login\\登录按钮.png"));
    JLabel registerJ = new JLabel(new ImageIcon("puzzlegame\\image\\login\\注册按钮.png"));
    JLabel captchaJ = new JLabel(new ImageIcon("puzzlegame\\image\\login\\验证码.png"));
    public LoginJFrame() {
        //初始化界面
        initLoginJFrame();

        //初始化图片
        initImage();

    }

    private void initImage() {
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("puzzlegame\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

        //添加用户名
        //添加图片
        JLabel usernameJ = new JLabel(new ImageIcon("puzzlegame\\image\\login\\用户名.png"));
        usernameJ.setBounds(115, 140, 47, 17);
        background.add(usernameJ);
        //添加文本
        username = new JTextField();
        username.setBounds(170, 140, 230, 30);
        background.add(username);

        //输入密码
        //添加图片
        JLabel passwordJ = new JLabel(new ImageIcon("puzzlegame\\image\\login\\密码.png"));
        passwordJ.setBounds(130, 200, 32, 16);
        background.add(passwordJ);
        //添加文本
        password = new JPasswordField();
        password.setBounds(170, 200, 230, 30);
        background.add(password);

        //验证码
        //添加图片
        captchaJ.setBounds(115, 260, 56, 21);
        background.add(captchaJ);
        //添加文本
        captcha = new JTextField();
        captcha.setBounds(170, 260, 150, 30);
        background.add(captcha);

        //登录键
        loginJ.setBounds(110, 320, 128, 47);
        background.add(loginJ);

        //注册键
        registerJ.setBounds(250, 320, 128, 47);
        background.add(registerJ);
    }

    private void initLoginJFrame() {
        this.setSize(488, 430);
        //设置界面的标题
        this.setTitle("拼图登录界面");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //组件默认是居中位置要取消
        this.setLayout(null);


        this.setVisible(true);
    }

    //判断用户和密码是否为空
    private boolean isRegister(JTextField un, JPasswordField pw) {
        //判断用户名是否为空
        if(un.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"用户名不能为空");
            return false;
        }
        //判断密码是否为空
        if(pw.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"密码不能为空");
            return false;
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
       if(obj==loginJ){
            //判断用户名和密码是否为空
            if(isRegister(username,password)){
                //判断验证码是否正确
                if(captcha.getText().equalsIgnoreCase("1234")){
                    //登录成功
                    JOptionPane.showMessageDialog(this,"登录成功");
                    //关闭登录界面
                    this.dispose();
                    //打开主界面
                    new GameJFrame();
                }else{
                    JOptionPane.showMessageDialog(this,"验证码错误");
                }
            }
        }

    }
}