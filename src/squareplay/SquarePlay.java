package squareplay;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SquarePlay {

    /**
    * @param args
    *            make by chensirui
    */
    private JFrame f;
    private JButton[] btn = new JButton[16];

    SquarePlay() {
        madeFrame();
    }

    public void madeFrame() {
        f = new JFrame("16方格");
        f.setLayout(new GridLayout(4, 4));
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i <= 15; i++) {
            String temp = "";
            if (i != 15) {
                temp = (i + 1) + "";
                btn[i] = new JButton(temp);
            } else
                btn[i] = new JButton(temp);

            f.add(btn[i]);
            myevent(i);
        }

        fRandom();
        f.setVisible(true);
    }

    public boolean JudgeUnOrder()// 判断逆序
    {
        int j = 0;
        int[] a = new int[16];
        for (int i = 0; i <= 15; i++) {
            String temp1 = btn[i].getText();
            if (temp1 != "") {
                int x = Integer.parseInt(temp1);
                a[j++] = x;
            } else
                a[j++] = 0;
        }
        j = 0;
        for (int i = 1; i <= 15; i++) {
            if (a[i] - a[i - 1] == -1)
                j++;

        }
        if (j == 14)
            return true;
        else
            return false;
    }

    public boolean JudgeOrder()// 判断顺序
    {
        int j = 0;
        int[] a = new int[16];
        for (int i = 0; i <= 15; i++) {
            String temp1 = btn[i].getText();
            if (temp1 != "") {
                int x = Integer.parseInt(temp1);
                a[j++] = x;
            } else
                a[j++] = 0;
        }
        j = 0;
        for (int i = 1; i <= 15; i++) {
            if (a[i] - a[i - 1] == 1) {
                j++;
            }
        }
        if (j == 14)
            return true;
        else
            return false;
    }

    public void fRandom()// 产生随机布局
    {
        Random rd = new Random();
        int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        for (int i = 0; i < a.length; i++) {
            int j = i + rd.nextInt(a.length - i);
            String temp = btn[j].getText();
            btn[j].setText(btn[i].getText());
            btn[i].setText(temp);
        }
    }

    public boolean Judge(int i)// 方格的边角不能置换
    {
        if (i == 3 || i == 7 || i == 11)
            return false;
        else
            return true;
    }

    public void myevent(final int i)// 按钮事件
    {
        btn[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (i + 4 <= 15) {
                    if (btn[i + 4].getText() == "") {
                        String temp = btn[i + 4].getText();
                        // System.out.println(temp);
                        btn[i + 4].setText(btn[i].getText());
                        btn[i].setText(temp);
                        if (JudgeUnOrder() || JudgeOrder()) {
                            JOptionPane.showMessageDialog(null, "成功");
                            fRandom();
                        }
                        return;
                    }
                }
                if (i - 4 >= 0) {
                    if (btn[i - 4].getText() == "") {
                        String temp = btn[i - 4].getText();
                        // System.out.println(temp);
                        btn[i - 4].setText(btn[i].getText());
                        btn[i].setText(temp);
                        if (JudgeUnOrder() || JudgeOrder()) {
                            JOptionPane.showMessageDialog(null, "成功");
                            fRandom();
                        }
                        return;
                    }
                }
                if (i + 1 <= 15) {
                    if (btn[i + 1].getText() == "") {
                        String temp = btn[i + 1].getText();
                        // System.out.println(temp);
                        btn[i + 1].setText(btn[i].getText());
                        btn[i].setText(temp);
                        if (JudgeUnOrder() || JudgeOrder()) {
                            JOptionPane.showMessageDialog(null, "成功");
                            fRandom();
                        }
                        return;
                    }
                }
                if (i - 1 >= 0) {
                    if (btn[i - 1].getText() == "" && Judge(i - 1)) {
                        String temp = btn[i - 1].getText();
                        // System.out.println(temp);
                        btn[i - 1].setText(btn[i].getText());
                        btn[i].setText(temp);
                        if (JudgeUnOrder() || JudgeOrder()) {
                            JOptionPane.showMessageDialog(null, "成功");
                            fRandom();
                        }
                        return;
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new SquarePlay();
    }
}
