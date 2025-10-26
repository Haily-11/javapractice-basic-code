package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//因为界面游戏要通过键盘实现，所以可以将JFrame类实现键盘监听事件的接口,在功能部分还需要action点击事件，所以要实现他的接口ActionListener
public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //JFrame表示界面，窗体，子类也是界面和窗体

    //创建一个二维数组，用来管理数据，加载图片时会根据二维数组的数据加载
    //为什么要定义在成员位置，因为initData(),initImage();都会用到
    int[][] data=new int[4][4];
    //记录空白方块再容器的位置
    int x=0;
    int y=0;

    //定义一个变量记录当前展示图片的路径
     String choose="animal";
//     String path="puzzlegame\\image\\animal\\animal1\\";
     Random nb=new Random();
     int number=nb.nextInt(8)+1;
    String path="puzzlegame\\image\\"+choose+"\\"+choose+number+"\\";



     //定义一个二维数组，存储正确的数据
     int[][] winData=new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,0}
        };
     //定义步数
    int step=0;

    //创建选项下面的条目对象,因为这个对象会在多个方法中使用，所以要定义在从成员变量的位置
    JMenuItem replayJMenuItem=new JMenuItem("重新游戏");
    JMenuItem reloginJMenuItem=new JMenuItem("重新登录");
    JMenuItem closeJMenuItem=new JMenuItem("关闭游戏");
    //切换图片的条目
    JMenuItem girlItem=new JMenuItem("美女");
    JMenuItem animalItem=new JMenuItem("动物");
    JMenuItem sportItem=new JMenuItem("运动");



    JMenuItem accountItem=new JMenuItem("菜");

    public GameJFrame(){
        //初始化界面
        initJFrame();

        //初始化菜单,创造整个菜单对象
        initFMenuBar();

        //初始化数据
        initData();

        //初始化图片
        initImage();

        this.setVisible(true);
    }


    //打乱数组
    private void initData() {
        //定义一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //打乱数组中的数据的顺序
        //遍历数组，得到每一个元素，拿着每一个元素跟随机索引上的数据进行交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);//获得随机索引
            //从头到尾与随机索引交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            //图片路径是从1开始的，所以0的时候没有图片
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
                data[i / 4][i % 4] = tempArr[i];

        }
    }


    //初始化图片
    //要按照data数组中的数据加载图片
    private void initImage() {
        //细节：先加载的图片再上方，后加载的图片在下方
//        清空已经出现的所有图片和刷新一起使用，清空后在移动图片时会在初始化图片
        this.getContentPane().removeAll();

        if(isWin()){
            JLabel winLabel=new JLabel(new ImageIcon("puzzlegame\\image\\win.png"));
            winLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winLabel);
        }

        //根据choose选择不同的图片路径
       if(choose.equals("animal")) {
           path = "puzzlegame\\image\\" + choose + "\\" + choose + number + "\\";
       }else if(choose.equals("sport")){
           path = "puzzlegame\\image\\" + choose + "\\" + choose + number + "\\";
       }else if(choose.equals("girl")){
           path = "puzzlegame\\image\\" + choose + "\\" + choose + number + "\\";
       }

        //设置部署，定义图片对象，装到容器里
        JLabel stepLabel=new JLabel("步数："+step);
        stepLabel.setBounds(50,30,100,20);
        this.getContentPane().add(stepLabel);


        //"+中间整型+" 这样将整型转为字符串
        for (int i = 0; i < 4; i++) {
            for(int j=0;j<4;j++){
                int num=data[i][j];//num确定每一张图片的位置，也确定了图片的路径，其中图片路劲是从1开始的
                //创建一个图片ImageIcon对象
                ImageIcon icon=new ImageIcon(path+num+".jpg");
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel=new JLabel(icon);
                //指定位置，再添加之前,后面+偏移量
                jLabel.setBounds(j*105+83,i*105+134,105,105);
                //给图片添加斜面边框 0让图片凸起来，1让图片凹下去
                jLabel.setBorder(new BevelBorder(1));

                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片
        JLabel background=new JLabel(new ImageIcon("puzzlegame\\image\\background.png"));
        background.setBounds(40,40,508,560);
        //获得容器把背景添加到界面中
        this.getContentPane().add(background);

        //每次移动都要刷新一下界面
        this.getContentPane().repaint();

    }

    //初始化菜单
    private void initFMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        //创造菜单上面两个功能的对象
        JMenu  functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我");
        JMenu changeImage=new JMenu("切换图片");


        //将每个选项下面的条目添加到选项中
        functionJMenu.add(replayJMenuItem);
        functionJMenu.add(reloginJMenuItem);
        functionJMenu.add(closeJMenuItem);
        aboutJMenu.add(accountItem);
        //把切换图片添加到功能选项中
        functionJMenu.add(changeImage);
        changeImage.add(girlItem);
        changeImage.add(animalItem);
        changeImage.add(sportItem);



        //给条目绑定事件
        replayJMenuItem.addActionListener(this);
        reloginJMenuItem.addActionListener(this);
        closeJMenuItem.addActionListener(this);
        accountItem.addActionListener(this);
        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);

        //将菜单里的两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);


        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    //初始化界面
    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603,680);
        //设置界面的标题
        this.setTitle("拼图单机游戏 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);//为什么是3：只要你关掉一个界面，其他界面也会跟着关闭
        //组件默认是居中的位置，我们要取消居中
        this.setLayout(null);

        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不松时会调用这个方法，即按下一个键显示完整图片
    //假设按下空白键
    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
//        System.out.println(code);
        if(code==32){
            //删除界面中的所有图片
            this.getContentPane().removeAll();
            //加载一张完整的图片
            JLabel all=new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);

            //添加背景图片
            JLabel background=new JLabel(new ImageIcon("D:\\knowledge{勿删\\java\\basic-code\\puzzlegame\\image\\background.png"));
            background.setBounds(40,40,508,560);
            //获得容器把背景添加到界面中
            this.getContentPane().add(background);
            //每次改变图片就刷新一下界面
            this.getContentPane().repaint();
        }
        //还没完噢，注意松开键盘要返回原来打乱的界面
    }


    //键盘抬起来时触发事件
    //注意别忽略BUG，当方块再最左/上/右/下是不可再次移动需return;
    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否赢了
        if(isWin())return;
        //对上下左右进行判断
        //左：37 上：38 右：39 下：40
        //如果记不下来就用以下代码尝试，点击后观看编号就可以
          int code = e.getKeyCode();
//        System.out.println(code);
        //(x,y)表示空白方块，(x+1,y)表示下方方块，(x,y+1)表示右方方块,(x-1,y)表示上方方块，(x,y-1)表示左方方块

        //不要忘记对边界的判断
        if(code==37){
            //判断是否可以左移
            if(y==3)return;
                //交换数据
//                System.out.println("可以左移");
                data[x][y]=data[x][y+1];
                data[x][y+1]=0;
                y++;
                //步数增加
                step++;
                initImage();//初始化新添加的图片
        }
        else if(code==38){
            if(x==3)return;
            //判断是否可以上移
                //交换数据
                data[x][y]=data[x+1][y];
                data[x+1][y]=0;
                x++;
                step++;
                initImage();
        }else if(code==39){
            if(y==0)return;
                //交换数据
                data[x][y]=data[x][y-1];
                data[x][y-1]=0;
                y--;
                step++;
                initImage();
        }else if(code==40){
            if(x==0)return;
                //交换数据
                data[x][y]=data[x-1][y];
                data[x-1][y]=0;
                x--;
                step++;
                initImage();
        }else if(code==32){
                //删除界面中的所有图片
//    initImage();里面有的所以这个不写this.getContentPane().removeAll();
                //加载打乱后的图片
                initImage();

        }else if(code==87){//W键win
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
                initImage();//初始化新添加的图片
        }
    }

    //定义一个方法判断是否赢了
        private boolean isWin(){
            //遍历二维数组，判断每个元素是否和正确数据对应
            for(int i=0;i<data.length;i++){
                for(int j=0;j<data[i].length;j++){
                    if(data[i][j]!=winData[i][j]){
                        return false;
                    }
                }
            }
            return true;
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被点击的条目对象
        Object obj=e.getSource();
        if(obj==replayJMenuItem){
            //点击重新开始游戏
            //先清零在加载图片不可乱
            step=0;
            //初始化数据,即打乱图片
            initData();
            //加载打乱后的图片
            initImage();

        }else if(obj==reloginJMenuItem){
            //点击重新登录游戏
            //关闭当前的游戏界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        }else if(obj==closeJMenuItem){
            //点击关闭游戏
            //直接退出虚拟机
            System.exit(0);
        }else if(obj==accountItem) {
            //设置弹窗
            JDialog jDialog = new JDialog();
            //创建容器对象
            JLabel jLabel = new JLabel(new ImageIcon("puzzlegame\\image\\dialog.png"));
            //这个位置时图片相对于弹框的，不是相对于游戏界面的
            jLabel.setBounds(0, 0, 270, 199);
            //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //设置弹框大小
            jDialog.setSize(270, 199);
            //设置弹框置顶
            jDialog.setAlwaysOnTop(true);
            //设置弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭怎无法操作下面的界面
            jDialog.setModal(true);
            //显示弹框
            jDialog.setVisible(true);
        }else if(obj==animalItem){
            //随机选择一张动物图片
             choose="animal";
             step=0;
             initImage();
        }
        else if(obj==sportItem){
            //随机选择一张运动图片
             choose="sport";
             step=0;
             initImage();
        }
        else if(obj==girlItem){
            //随机选择一张女孩图片
             choose="girl";
             step=0;
             initImage();
        }
    }
}
