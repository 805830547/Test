package russiacube;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RussiaCube extends JFrame implements ActionListener,Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int xp=0;//初始位置X
	int yp=4;//初始位置Y
	int mystyle=0;//初始形状
	int scorenum=0;//初始分数
	int direction=0;//初始方向
	Thread falldown;//下落线程
	boolean GoDownFlag=true;//下落可行标志
	JPanel jp1 = new JPanel();//左面板上4个
	JPanel jp2 = new JPanel();//左面板下16个
	JPanel jp3 = new JPanel();//右面板 图形按钮
	JButton aniu[] = new JButton[13];//按钮数组
	MyButton jb[][] = new MyButton[20][10];//自定义按钮数组
	JLabel score = new JLabel("分数:  "+scorenum);//分数标签

	public RussiaCube(){//
		init();
		this.setTitle("RussiaCube");
		this.setBounds(100,20,640,660);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	public void init(){//初始化面板
		this.setLayout(null);
		jp1.setLayout(new GridLayout(4,10,1,1));
		jp2.setLayout(new GridLayout(16,10,1,1));
		jp3.setLayout(new GridLayout(4,2,1,1));
		for(int i=0;i<4;i++){
			for(int j=0;j<10;j++){
				jb[i][j]=new MyButton();
				jb[i][j].type=0;
				jb[i][j].paint();
				jp1.add(jb[i][j]);
			}
		}

		for(int i=4;i<20;i++){
			for(int j=0;j<10;j++){
				jb[i][j]=new MyButton();
				jb[i][j].type=0;
				jb[i][j].paint();
				jp2.add(jb[i][j]);
			}
		}
		aniu[0]=new JButton("左二");
		aniu[1]=new JButton("长条");
		aniu[2]=new JButton("右二");
		aniu[3]=new JButton("方块");
		aniu[4]=new JButton("左三");
		aniu[5]=new JButton("三角");
		aniu[6]=new JButton("右三");
		aniu[7]=new JButton("左移");
		aniu[8]=new JButton("右移");
		aniu[9]=new JButton("翻转");
		aniu[10]=new JButton("下落");
		aniu[11]=new JButton("开始");
		aniu[12]=new JButton("重新开始");
		
		//为控制按钮添加事件监听
		for(int i=0;i<13;i++){
			aniu[i].addActionListener(this);
			aniu[i].setActionCommand(String.valueOf(i));
		}

		//将按钮组添加到面板中
		for(int i=0;i<7;i++){
			jp3.add(aniu[i]);
		}
		for(int i=7;i<13;i++){
			this.add(aniu[i]);
		}

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(score);
		aniu[7].setBounds(320, 350, 150, 50);
		aniu[8].setBounds(470, 350, 150, 50);
		aniu[9].setBounds(320, 300, 300, 50);
		aniu[10].setBounds(320, 400, 300, 50);
		aniu[11].setBounds(320, 500, 150, 50);
		aniu[12].setBounds(470, 500, 150, 50);
		jp1.setBackground(Color.RED);
		jp2.setBackground(Color.WHITE);
		jp1.setBounds(10, 10, 300, 120);
		jp2.setBounds(10, 130, 300, 480);
		jp3.setBounds(320, 10, 300, 200);
		score.setBounds(350, 150, 300, 200);
		score.setFont(new Font("宋体",Font.BOLD,30));
		validate();
	}
	public void repaint(){//重绘面板
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				jb[i][j].paint();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {//按钮监听事件处理
		if(e.getActionCommand().equals("0")){
			drawTuxing(mystyle,0,direction);
			mystyle=0;
		}
		else if(e.getActionCommand().equals("1")){
			drawTuxing(mystyle,0,direction);
			mystyle=1;
		}
		else if(e.getActionCommand().equals("2")){
			drawTuxing(mystyle,0,direction);
			mystyle=2;
		}
		else if(e.getActionCommand().equals("3")){
			drawTuxing(mystyle,0,direction);
			mystyle=3;
		}
		else if(e.getActionCommand().equals("4")){
			drawTuxing(mystyle,0,direction);
			mystyle=4;
		}
		else if(e.getActionCommand().equals("5")){
			drawTuxing(mystyle,0,direction);
			mystyle=5;
		}
		else if(e.getActionCommand().equals("6")){
			drawTuxing(mystyle,0,direction);
			mystyle=6;
		}
		else if(e.getActionCommand().equals("7")){
			GoDownFlag=false;
			yp--;
			int Flag=drawTuxing(mystyle,0,direction);
			if(Flag==0){
				yp++;
				drawTuxing(mystyle,0,direction);//zuo
				yp--;
				drawTuxing(mystyle,1,direction);
				repaint();
			}
			else{
				yp++;
			}
			GoDownFlag=true;

		}
		else if(e.getActionCommand().equals("8")){
			GoDownFlag=false;
			yp++;
			int Flag=drawTuxing(mystyle,0,direction);
			if(Flag==0){
				yp--;
				drawTuxing(mystyle,0,direction);//you
				yp++;
				drawTuxing(mystyle,1,direction);
				repaint();
			}
			else{
				yp--;
			}
			GoDownFlag=true;
		}
		else if(e.getActionCommand().equals("9")){
			GoDownFlag=false;
			direction++;
			if(direction==4){
				direction=0;
			}
			int Flag=drawTuxing(mystyle,0,direction);
			if(Flag==0){
				direction--;
				if(direction==-1){
					direction=3;
				}
				drawTuxing(mystyle,0,direction);
				direction++;
				if(direction==4){
					direction=0;
				}
			}
			else{
				direction--;
			}
			drawTuxing(mystyle,1,direction);
			repaint();
			GoDownFlag=true;
		}
		else if(e.getActionCommand().equals("10")){
			goDown();
		}
		else if(e.getActionCommand().equals("11")){
			falldown = new Thread(this);
			falldown.start();
		}
		else if(e.getActionCommand().equals("12")){
			restart();
		}
		drawTuxing(mystyle,1,direction);
		repaint();
	}
	public void restart(){//重新开始函数
		dispose();
		new RussiaCube();
	}
	public int drawButtonEnable(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,int color){//判断画按钮可行函数

		if((xp+x1<20&&xp+x2<20&&xp+x3<20&&xp+x4<20)//xia
				&&(yp+y1<10&&yp+y2<10&&yp+y3<10&&yp+y4<10&&yp+y1>=0&&yp+y2>=0&&yp+y3>=0&&yp+y4>=0)//zuoyou
				&&(jb[xp+x1][yp+y1].type!=2)&&(jb[xp+x2][yp+y2].type!=2)&&(jb[xp+x3][yp+y3].type!=2)&&(jb[xp+x4][yp+y4].type!=2)){//sekuai
			drawButton(x1,y1,x2,y2,x3,y3,x4,y4,color);
			return 0;//下落
		}
		else{
			return 1;
		}
	}
	public void drawButton(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4,int color){//画按钮函数
		jb[xp+x1][yp+y1].type=color;
		jb[xp+x2][yp+y2].type=color;
		jb[xp+x3][yp+y3].type=color;
		jb[xp+x4][yp+y4].type=color;
}
	public int drawTuxing(int style,int color,int direction){//画图形函数
		int flag=0;
		switch(style){
		case 0://左二
			switch(direction){
			case 0:
				flag=drawButtonEnable(1,0,2,0,0,1,1,1,color);
				break;
			case 1:
				flag=drawButtonEnable(1,0,2,2,2,1,1,1,color);
				break;
			case 2:
				flag=drawButtonEnable(1,0,2,0,0,1,1,1,color);
				break;
			case 3:
				flag=drawButtonEnable(1,0,2,2,2,1,1,1,color);
				break;
			}
			break;
		case 1://长条
			switch(direction){
			case 0:
				flag=drawButtonEnable(0,0,1,0,2,0,3,0,color);
				break;
			case 1:
				flag=drawButtonEnable(2,-1,2,0,2,1,2,2,color);
				break;
			case 2:
				flag=drawButtonEnable(0,0,1,0,2,0,3,0,color);
				break;
			case 3:
				flag=drawButtonEnable(2,-1,2,0,2,1,2,2,color);
				break;
			}
			break;
		case 2://右二
			switch(direction){
			case 0:
				flag=drawButtonEnable(0,0,1,0,1,1,2,1,color);
				break;
			case 1:
				flag=drawButtonEnable(2,0,1,0,1,1,2,-1,color);
				break;
			case 2:
				flag=drawButtonEnable(0,0,1,0,1,1,2,1,color);
				break;
			case 3:
				flag=drawButtonEnable(2,0,1,0,1,1,2,-1,color);
				break;
			}
			break;
		case 3://方块
			flag=drawButtonEnable(0,0,1,0,0,1,1,1,color);
			break;
		case 4://左三
			switch(direction){
			case 0:
				flag=drawButtonEnable(0,0,1,0,2,0,0,1,color);
				break;
			case 1:
				flag=drawButtonEnable(1,-1,1,0,1,1,2,1,color);
				break;
			case 2:
				flag=drawButtonEnable(0,0,1,0,2,0,2,-1,color);
				break;
			case 3:
				flag=drawButtonEnable(1,-1,1,0,1,1,0,-1,color);
				break;
			}

			break;
		case 5://三角
			switch(direction){
			case 0:
				flag=drawButtonEnable(0,0,1,0,2,0,1,1,color);
				break;
			case 1:
				flag=drawButtonEnable(1,-1,1,0,2,0,1,1,color);
				break;
			case 2:
				flag=drawButtonEnable(0,0,1,0,2,0,1,-1,color);
				break;
			case 3:
				flag=drawButtonEnable(1,-1,1,0,0,0,1,1,color);
				break;
			}

			break;
		case 6://右三\
			switch(direction){
			case 0:
				flag=drawButtonEnable(0,0,1,1,2,1,0,1,color);
				break;
			case 1:
				flag=drawButtonEnable(1,-1,1,0,1,1,0,1,color);
				break;
			case 2:
				flag=drawButtonEnable(0,0,1,0,2,1,2,0,color);
				break;
			case 3:
				flag=drawButtonEnable(2,-1,1,-1,1,0,1,1,color);
				break;
			}
			break;
		}
		return flag;

	}
	public void goDown(){//下落函数
    	xp++;
    	int Flag=drawTuxing(mystyle,1,direction);
		if(Flag==0){
			xp--;
			drawTuxing(mystyle,0,direction);//下落
			xp++;
			drawTuxing(mystyle,1,direction);
			repaint();
		}
		else {
			for(int i=0;i<20;i++){
				for(int j=0;j<10;j++){
    				if(jb[i][j].type==1||jb[i][j].type==2){
    					jb[i][j].type=2;
    				}
				}
			}
			repaint();
			xp=0;//初始位置
			yp=4;
			mystyle=(int)(0+Math.random()*6-0+1);
			drawTuxing(mystyle,1,direction);
			repaint();
			delate();
			judgePass();
		}
	}
	public void judgePass(){//判断过关函数
		for(int i=0;i<10;i++){
			if(jb[3][i].type==2){
				GoDownFlag=false;
				JOptionPane.showMessageDialog(this, "GAME OVER", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
				restart();
			}
		}
	}
	public void delate(){//消除方块函数
		//消块
		for(int w=4;w<20;w++){
			int l=0;
			for(;l<10;l++){
				if(jb[w][l].type!=2){
					break;
				}
			}
			if(l==10){
				for(int m=w;m>0;m--){
					for(int n=0;n<10;n++){
						jb[m][n].type=jb[m-1][n].type;
					}
				}
				repaint();
				score.setText("分数:  "+(scorenum+=100));//分数
			}
		}
	}
	@Override
	public void run() {//下落线程 run函数
	        while (GoDownFlag) {
	        	try {
	                	goDown();
		    			Thread.sleep(500); // 控制下落速度
	                } catch (InterruptedException e) {

	                }
	        }
	}
}


