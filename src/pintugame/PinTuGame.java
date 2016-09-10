package pintugame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PinTuGame extends JFrame implements MouseListener,ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//空位置
	int num=(int)(0+Math.random()*14-0+1);
	int X=num%4*150;
	int Y=num/4*150;

	JButton jb[] = new JButton[15];
	JButton restart = new JButton("RESTART");


	public PinTuGame(){
		init();

		this.setTitle("PinTuGame");
		this.setBounds(100,20,615,690);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	public void init(){
		this.setLayout(null);
		for(int i=0;i<15;i++){
			jb[i]=new JButton(String.valueOf(i+1));
			jb[i].addMouseListener(this);
			this.add(jb[i]);
		}
		this.add(restart);
		int k=0;
		for(int i=0;i<=150*3;i+=150){
			for(int j=0;j<=150*3&&k<15;j+=150){
				if(j==X&&i==Y){
					continue;
				}
				jb[k++].setBounds(j, i, 150, 150);
			}
		}
		restart.setBounds(0, 600, 600, 50);
		restart.addActionListener(this);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();

		new PinTuGame();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JButton jbtemp=(JButton)e.getSource();

		int x = jbtemp.getBounds().x;
		int y = jbtemp.getBounds().y;

		//判断是否可以移动
		if(((x-X==150||x-X==-150)&&y-Y==0)||((y-Y==150||y-Y==-150)&&x-X==0)){
			jbtemp.setLocation(X, Y);
			X=x;
			Y=y;
		}
		//判断过关
		int i=0;
		for(;i<15;i++){
			if((jb[i].getBounds().x==i%4*150)&&(jb[i].getBounds().y==i/4*150)){
				continue;
			}
			else{
				break;
			}
		}
		if(i==15){
			JOptionPane.showMessageDialog(this, "恭喜过关", "消息对话框", JOptionPane.INFORMATION_MESSAGE);
		}


	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}

