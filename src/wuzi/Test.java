package wuzi;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FiveChessFrame ffChessFrame=new FiveChessFrame();
		JOptionPane.showMessageDialog(ffChessFrame, "我的信息");
		int result=JOptionPane.showConfirmDialog(ffChessFrame, "我的确认信息：现在要开始游戏吗？");
		if(result==0){
			JOptionPane.showMessageDialog(ffChessFrame, "游戏开始");
		}
		if(result==1){
			JOptionPane.showMessageDialog(ffChessFrame, "游戏结束");
		}
		if(result==2){
			JOptionPane.showMessageDialog(ffChessFrame, "请重新选择");
		}
		String username = JOptionPane.showInputDialog("请输入你的姓名：");
		if(username!=null){
			System.out.println(username);
			JOptionPane.showMessageDialog(ffChessFrame, "输入的姓名为"+username);
		}else{
			JOptionPane.showMessageDialog(ffChessFrame, "请重新输入你的姓名！");
		}
	}

}
