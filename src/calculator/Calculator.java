package calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Calculator extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JPanel jpanel;
    JTextArea question = null;
    JTextArea answer = null;
    JScrollPane questionPane;
    JScrollPane answerPane;
    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton mul = new JButton("*");
    JButton div = new JButton("/");
    JButton equal = new JButton("=");


    String one;
    String another;
    String arith;

    public Calculator(){
        this.setVisible(true);
        this.setTitle("Calculator");
        this.setResizable(false);
        this.setLocation(300, 90);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initContent();
    }

    private void initContent(){
        //整个窗口区域
        question = new JTextArea();
        question.setTabSize(4);
        question.setFont(new Font("楷体", Font.BOLD, 20));
        question.setLineWrap(true);// 激活自动换行功能
        question.setWrapStyleWord(true);// 激活断行不断字功能

        questionPane = new JScrollPane(question);
        question.setBounds(0, 0, 380, 80);

        answer = new JTextArea();
        answer.setTabSize(4);
        answer.setFont(new Font("楷体", Font.BOLD, 20));
        answer.setLineWrap(true);// 激活自动换行功能
        answer.setWrapStyleWord(true);// 激活断行不断字功能

        answerPane = new JScrollPane(answer);
        answer.setBounds(0, 150, 380, 80);

        jpanel = new JPanel();
        jpanel.setLayout(null);

        jpanel.add(questionPane);
        jpanel.add(answerPane);
        questionPane.setBounds(10, 10, 380, 80);
        answerPane.setBounds(10, 150, 380, 80);

        add.setFont(new Font("楷体", Font.BOLD, 20));
        sub.setFont(new Font("楷体", Font.BOLD, 20));
        mul.setFont(new Font("楷体", Font.BOLD, 20));
        div.setFont(new Font("楷体", Font.BOLD, 20));

        equal.setFont(new Font("楷体", Font.BOLD, 20));

        jpanel.add(add);
        jpanel.add(sub);
        jpanel.add(mul);
        jpanel.add(div);

        jpanel.add(equal);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        equal.addActionListener(this);

        int firstLocation = 10;
        add.setBounds(firstLocation, 100, 50, 30);
        sub.setBounds(firstLocation + 50, 100, 50, 30);
        mul.setBounds(firstLocation + 100, 100, 50, 30);
        div.setBounds(firstLocation + 150, 100, 50, 30);

        equal.setBounds(firstLocation + 270, 100, 100, 30);

        this.add(jpanel);
        jpanel.setBounds(0, 0, 400, 300);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add)) {
        } else if (e.getSource().equals(sub)) {
        } else if (e.getSource().equals(mul)) {
        } else if (e.getSource().equals(div)) {
        } else if (e.getSource().equals(equal)) {
            answer.setText(Calculate.doCalculate(question.getText()));
        }

    }

    public static void main(String[] args) {
        new Calculator();
    }

}
