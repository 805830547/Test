package calculator;

import javax.swing.JFrame;


public class CalPanel {
    JFrame calJFrame = new JFrame();
    public CalPanel() {
        calJFrame.setTitle("Calculator");
        calJFrame.setSize(800, 600);
        calJFrame.setLocation(500, 200);
        calJFrame.setVisible(true);
        calJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new CalPanel();
    }


}
