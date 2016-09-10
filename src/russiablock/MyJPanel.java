package russiablock;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

//重写MyPanel类，使Panel的四周留空间
public class MyJPanel extends JPanel {
    /**
    *
    */
    private static final long serialVersionUID = 1L;

    public Insets getInsets() {
        return new Insets(10, 30, 30, 30);
    }
}

class MyActionListener implements ActionListener {
    RightPanel rp;
    Block bl;
    LeftShowCanvas lsc;

    public MyActionListener(RightPanel rp, Block bl, LeftShowCanvas lsc) {
        this.rp = rp;
        this.bl = bl;
        this.lsc = lsc;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(rp.jbt3)) {
            // 这样子则按几次开始按钮就创建几个相同的线程，控制着相同的数据
            Thread th = new Thread(bl);
            th.start();
        }
        for (int i = 0; i < Block.type; i++)
            if (e.getSource().equals(rp.jbt[i])) // 看是画哪个
            {
                bl.reInitRowCol();
                bl.drawBlock(i);
                lsc.requestFocusInWindow(); // 获得焦点
                return;
            }
        if (e.getSource().equals(rp.jbt2[0]))
            bl.leftMove();
        else if (e.getSource().equals(rp.jbt2[1]))
            bl.rightMove();
        else if (e.getSource().equals(rp.jbt2[2]))
            bl.fallMove();
        else if (e.getSource().equals(rp.jbt2[3]))
            bl.leftTurn();
        lsc.requestFocusInWindow(); // 获得焦点
    }
}

class MyKeyAdapter extends KeyAdapter {
    Block bl;

    public MyKeyAdapter(Block bl) {
        this.bl = bl;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            bl.leftMove();
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            bl.rightMove();
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            bl.fallMove();
        else if (e.getKeyCode() == KeyEvent.VK_SPACE)
            bl.leftTurn();
    }
}
