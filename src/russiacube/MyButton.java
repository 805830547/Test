package russiacube;

import java.awt.Color;

import javax.swing.JButton;

class MyButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int type=0;//��ɫ���� 0������ɫ�� �1����ɫ ��ֹ2����ɫ
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
