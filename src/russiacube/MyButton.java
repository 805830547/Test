package russiacube;

import java.awt.Color;

import javax.swing.JButton;

class MyButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int type=0;//颜色类型 0：背景色黑 活动1：黄色 静止2：蓝色
	public void paint(){
		switch(type){
		case 0:
			setBackground(Color.BLACK);
			break;
		case 1:
			setBackground(Color.YELLOW);
			break;
		case 2:
			setBackground(Color.BLUE);
			break;
		}
	}
}
