package russiablock;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class LeftShowCanvas extends Canvas {
    /**
    *
    */
    private static final long serialVersionUID = 1L;

    int maxrows, maxcols; // �����������������

    int unitSize; // ��Ԫ��Ĵ�С��С������

    int[][] unitState; // ÿ��С�����״̬ 0��1��2��ʾ

    RightPanel rp;

    int score;

    public LeftShowCanvas(RightPanel rp) {
        this.rp = rp;
        score = Integer.valueOf(rp.jtf.getText());
        maxrows = 20;
        maxcols = 10;
        unitSize = 20;
        unitState = new int[maxrows][maxcols];
        initCanvas();
    }

    public void initCanvas() // ��ʼ������������
    {
        for (int i = 0; i < maxrows; i++)
            for (int j = 0; j < maxcols; j++)
                unitState[i][j] = 0;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < maxrows; i++) {
            for (int j = 0; j < maxcols; j++)
                drawUnit(i, j, unitState[i][j]); // ������
            if (i == 3) {
                g.setColor(Color.RED);
                g.drawLine(0, (i + 1) * (unitSize + 1) - 1, maxcols
                        * (unitSize + 1) - 1, (i + 1) * (unitSize + 1) - 1);
            }
        }
    }

    public void drawUnit(int row, int col, int tag) // ������
    {
        unitState[row][col] = tag; // ��¼״̬
        Graphics g = getGraphics();
        switch (tag) {
        case 0: // ��ʼ��ɫ
            g.setColor(Color.BLACK);
            break;
        case 1: // �����ɫ
            g.setColor(Color.RED);
            break;
        case 2:
            g.setColor(Color.BLUE);
            break;
        }
        g.fillRect(col * (unitSize + 1), row * (unitSize + 1), unitSize,
                unitSize);
    }

    public void deleteFullLine(int row) // �жϴ����Ƿ��������ͬʱ����������
    {
        for (int j = 0; j < maxcols; j++)
            if (unitState[row][j] != 2)
                return;

        for (int i = row; i > 3; i--)
            // ���˼�Ϊ�����������������������
            for (int j = 0; j < maxcols; j++)
                // drawUnit(i, j, unitState[i - 1][j]);
                unitState[i][j] = unitState[i - 1][j];// ��״̬��¼�ı䣬���ڻ�����ͼ
        score++;
        rp.jtf.setText(String.valueOf(score));
    }
}
