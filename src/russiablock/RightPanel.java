package russiablock;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class RightPanel extends JPanel {
    /**
    *
    */
    private static final long serialVersionUID = 1L;

    JButton[] jbt = new JButton[7];

    JButton[] jbt2 = new JButton[4];

    JButton jbt3;

    JTextField jtf;

    JLabel jlb;

    MyJPanel jp1, jp2;

    public RightPanel() {
        jbt[0] = new JButton("����");
        jbt[1] = new JButton("����");
        jbt[2] = new JButton("����");
        jbt[3] = new JButton("����");
        jbt[4] = new JButton("����");
        jbt[5] = new JButton("���");
        jbt[6] = new JButton("�Ҷ�");
        jbt2[0] = new JButton("����");
        jbt2[1] = new JButton("����");
        jbt2[2] = new JButton("����");
        jbt2[3] = new JButton("��ת");

        jbt3 = new JButton("��ʼ");
        jtf = new JTextField("0", 5);
        jlb = new JLabel("�÷�", JLabel.CENTER);

        jp1 = new MyJPanel(); // ��ߵ������
        jp2 = new MyJPanel(); // ��ߵ������
        jp1.setLayout(new GridLayout(4, 2, 20, 10)); // ���񲼾�
        jp2.setLayout(new GridLayout(4, 2, 20, 10)); // ���񲼾�
        this.setLayout(new BorderLayout()); // �߽粼��
        for (int i = 0; i < 7; i++)
            jp1.add(jbt[i]);

        jp1.add(jbt3);

        for (int i = 0; i < 4; i++)
            jp2.add(jbt2[i]);

        jp2.add(jlb);
        jp2.add(jtf);

        this.add(jp1, "North");
        this.add(jp2, "Center");
    }
}
