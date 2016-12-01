package calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View extends JFrame implements ActionListener{

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

	public View(){
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

//	private void clickJb1() {
//		String jta1String = jta1.getText();
//		if (jta1String.contains(" ")) {
//			JOptionPane.showMessageDialog( null , "不许输入空格" ,"不许调皮" , JOptionPane.WARNING_MESSAGE) ;
//		} else if (jta1String.contains("\n")) {
//			JOptionPane.showMessageDialog( null , "输入回车干嘛？ 上边不是有按钮吗！" ,"不许调皮" , JOptionPane.WARNING_MESSAGE) ;
//		} else if (!CharUtil.isChinese(jta1String)) {
//			JOptionPane.showMessageDialog( null , "又不是汉字，我才不转换呢！哼！" ,"不许调皮" , JOptionPane.WARNING_MESSAGE) ;
//		} else {
//			GB2312 gb2312 = new GB2312();
//			String jta2String = gb2312.convertGB2312StringToGB2312Code(jta1String);
//			jta2.setText(jta2String);
//			MumConvert aConvert = new MumConvert();
//			String jta3String = aConvert.integerToBinary(jta2String);
//			jta3.setText(jta3String);
//		}
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add)) {
            one = question.getText();
            arith = "add";
            question.setText(null);
        } else if (e.getSource().equals(sub)) {
            one = question.getText();
            arith = "sub";
            question.setText(null);
        } else if (e.getSource().equals(mul)) {
            one = question.getText();
            arith = "mul";
            question.setText(null);
        } else if (e.getSource().equals(div)) {
            one = question.getText();
            arith = "div";
            question.setText(null);
        } else if (e.getSource().equals(equal)) {
            another = question.getText();
            CalculatedValue();
        }

	}

	private void CalculatedValue() {
	    String answerString = null;
        if (arith.equals("add")) {
            answerString = Arith.add(one, another);
        } else if (arith.equals("sub")) {
            answerString = Arith.sub(one, another);
        } else if (arith.equals("mul")) {
            answerString = Arith.mul(one, another);
        } else if (arith.equals("div")) {
            answerString = Arith.div(one, another);
        }
        answer.setText(answerString);
    }

	   public static void main(String[] args) {
	        new View();
	    }

}
