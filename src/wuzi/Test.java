package wuzi;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiveChessFrame ffChessFrame=new FiveChessFrame();
		JOptionPane.showMessageDialog(ffChessFrame, "�ҵ���Ϣ");
		int result=JOptionPane.showConfirmDialog(ffChessFrame, "�ҵ�ȷ����Ϣ������Ҫ��ʼ��Ϸ��");
		if(result==0){
			JOptionPane.showMessageDialog(ffChessFrame, "��Ϸ��ʼ");
		}
		if(result==1){
			JOptionPane.showMessageDialog(ffChessFrame, "��Ϸ����");
		}
		if(result==2){
			JOptionPane.showMessageDialog(ffChessFrame, "������ѡ��");
		}
		String username = JOptionPane.showInputDialog("���������������");
		if(username!=null){
			System.out.println(username);
			JOptionPane.showMessageDialog(ffChessFrame, "���������Ϊ"+username);
		}else{
			JOptionPane.showMessageDialog(ffChessFrame, "�������������������");
		}
	}

}
