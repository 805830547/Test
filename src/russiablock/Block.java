package russiablock;

import java.awt.*;

class Block implements Runnable// ������
{
    static final int type = 7, state = 4;

    static final int[][] patten = { // 16���ƴ���ÿ�ַ���
    { 0x0f00, 0x4444, 0x0f00, 0x4444 },// ����
            { 0x6600, 0x6600, 0x6600, 0x6600 },// ������
            { 0x04e0, 0x0464, 0x00e4, 0x04c4 },// ����
            { 0x08e0, 0x0644, 0x00e2, 0x044c },// ����һ�£�1��3��1��
            { 0x02e0, 0x0446, 0x00e8, 0x0c44 },// ����һ�£�1��3��1��
            { 0x0462, 0x006c, 0x0462, 0x006c },// �������£�1��2��1��1���ϣ�1����
            { 0x0264, 0x00c6, 0x0264, 0x00c6 } // �������£�1��2��1��1���ϣ�1����
    };

    private int blockType = -1; // �������ͣ�7�֣���С��Χ0-6

    private int blockState;// ����״̬��4�֣���С��Χ0-3

    private int row, col; // �������ڵ�����������

    private int oldRow, oldCol; // ��¼����仯ǰ���ڵ�����������

    private int oldType = -1, oldState; // ��¼����仯ǰ�����ͺ�״̬

    private int isfall = 1; // �������������ʲô��ɫ�ģ�

    // 1��ʾ�������䣬��Ϊ��ɫ��0��ʾ�������䣬��Ϊ��ɫ

    private boolean end = false;// ������ǣ�Ϊtrueʱ��ʾ����

    LeftShowCanvas lsc;

    public Block(LeftShowCanvas lsc) {
        this.lsc = lsc;
        row = 0;
        col = 3;
        oldRow = row;
        oldCol = col;
    }

    public void reInit() // һ�������޷���������³�ʼ��
    {
        blockType = -1;
        isfall = 1;
    }

    public void reInitRowCol() // ��ʼ��������ʼ��
    {
        row = 0;
        col = 3;
    }

    public void run() // �����߳�
    {
        lsc.requestFocusInWindow(); // ��ý���
        while (!end) {
            int blocktype = (int) (Math.random() * 100) % 7;
            drawBlock(blocktype);
            do {
                try {
                    Thread.sleep(500); // ���������ٶ�
                } catch (InterruptedException e) {

                }
            } while (fallMove()); // ����
            for (int j = 0; j < lsc.maxcols; j++)
                // �ж��Ƿ����
                if (lsc.unitState[3][j] == 2)
                    end = true;
        }
    }

    public synchronized void drawBlock(int blockType) // ������
    {
        if (this.blockType != blockType)
            blockState = (int) (Math.random() * 100) % 4; // ״̬
        this.blockType = blockType; // ��ʽ
        if (!isMove(3)) // �ж��Ƿ��ܻ�
        {
            this.blockType = oldType;
            this.blockState = oldState;
            return;
        }
        int comIndex = 0x8000;
        if (this.oldType != -1) {
            for (int i = oldRow; i < oldRow + 4; i++)
                for (int j = oldCol; j < oldCol + 4; j++) {
                    if ((patten[oldType][oldState] & comIndex) != 0
                            && lsc.unitState[i][j] == 1)
                        // lsc.drawUnit(i, j, 0); // �Ȼ�ԭ
                        lsc.unitState[i][j] = 0;// ��״̬��¼�ı䣬���ڻ�����ͼ
                    comIndex = comIndex >> 1;
                }
        }
        comIndex = 0x8000;
        for (int i = row; i < row + 4; i++)
            for (int j = col; j < col + 4; j++) {
                if ((patten[blockType][blockState] & comIndex) != 0) {
                    if (isfall == 1)
                        // lsc.drawUnit(i, j, 1); // �ٻ�����ΪRED
                        lsc.unitState[i][j] = 1; // ��״̬��¼�ı�
                    else if (isfall == 0) {
                        // lsc.drawUnit(i, j, 2); // �޷����䣬��ΪBLUE
                        lsc.unitState[i][j] = 2;// ��״̬��¼�ı䣬���ڻ�����ͼ
                        lsc.deleteFullLine(i); // �жϴ����Ƿ������
                    }
                }
                comIndex = comIndex >> 1;
            }

        Image image; // ��������ͼƬ,����˫����������˸�������¸�״̬ͼ
        image = lsc.createImage(lsc.getWidth(), lsc.getHeight());
        Graphics g = image.getGraphics();
        lsc.paint(g);
        g.drawImage(image, 0, 0, lsc);

        if (isfall == 0) // �޷����䣬���ж��Ƿ������У������³�ʼ��
        {
            // lsc.deleteFullLine(row,col);
            reInit();
            reInitRowCol();
        }
        oldRow = row;
        oldCol = col;
        oldType = blockType;
        oldState = blockState;
    }

    public void leftTurn() // ��ת����ת
    {
        if (this.blockType != -1) {
            blockState = (blockState + 1) % 4;
            if (isMove(3))
                drawBlock(blockType);
            else
                blockState = (blockState + 3) % 4;
        }
    }

    public void leftMove() // ����
    {
        if (this.blockType != -1 && isMove(0)) {
            col -= 1;
            drawBlock(blockType);
        }
    }

    public void rightMove() // ����
    {
        if (this.blockType != -1 && isMove(1)) {
            col += 1;
            drawBlock(blockType);
        }
    }

    public boolean fallMove() // ����
    {
        if (this.blockType != -1) {
            if (isMove(2)) {
                row += 1;
                drawBlock(blockType);
                return true;
            } else {
                isfall = 0;
                drawBlock(blockType);
                return false;
            }
        }
        return false;
    }

    public synchronized boolean isMove(int tag) // �� 0 ���� 1 ���� 2 ,��ת 3
    {
        int comIndex = 0x8000;
        for (int i = row; i < row + 4; i++)
            for (int j = col; j < col + 4; j++) {
                if ((patten[blockType][blockState] & comIndex) != 0) {
                    if (tag == 0 && (j == 0 || lsc.unitState[i][j - 1] == 2))// �Ƿ�������
                        return false;
                    else if (tag == 1 && // �Ƿ�������
                            (j == lsc.maxcols - 1 || lsc.unitState[i][j + 1] == 2))
                        return false;
                    else if (tag == 2 && // �Ƿ�������
                            (i == lsc.maxrows - 1 || lsc.unitState[i + 1][j] == 2))
                        return false;
                    else if (tag == 3 && // �Ƿ�����ת
                            (i > lsc.maxrows - 1 || j < 0
                                    || j > lsc.maxcols - 1 || lsc.unitState[i][j] == 2))
                        return false;
                }
                comIndex = comIndex >> 1;
            }
        return true;
    }
}
