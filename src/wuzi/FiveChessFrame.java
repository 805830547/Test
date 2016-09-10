package wuzi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class FiveChessFrame extends JFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FiveChessFrame(){
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((width-600)/2, (height-600)/2);
		this.setTitle("Îå×ÓÆå");
		this.setSize(600, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
		init();
		repaint();
	}
	
	public void init() {
		drawFiveChess(50,50,this.getGraphics());
	}
	
    public void paint(Graphics g) {
    	g.setColor(Color.WHITE);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++){
            	g.fillRect(i*30, j*30, 29, 29);
            }

        }
    }
    public void drawFiveChess(int x,int y,Graphics g) {
    	g.setColor(Color.RED);
		g.fillOval(x, y, 29,29);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
