package catchimage;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Test2 extends JFrame implements ActionListener {
    JButton button;
    JButton Select;
    JButton btnOK;

    JTextField textfield;
    JPanel p;
    JFileChooser fc = new JFileChooser();
    TextArea area;

    public Test2() {
        p = new JPanel(); // 建立一个面板
        this.getContentPane().add(p);// 把面板添加到框架
        p.add(new JButton("文本"));// 把一个文本按钮添加到面板
        textfield = new JTextField(10);
        p.add(textfield); // 把一个文本框添加到面板
        Select = new JButton("浏览");
        p.add(Select); // 把一个浏览按钮添加到面板
        Select.addActionListener(this);
        btnOK = new JButton("确定");
        p.add(btnOK);// 把一个确定按钮添加到面板
        btnOK.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 当按下选择按钮，打开一个文件选择，文本框显示文件路径
        if (e.getSource() == Select) {
            int intRetVal = fc.showOpenDialog(this);
            if (intRetVal == JFileChooser.APPROVE_OPTION) {
                textfield.setText(fc.getSelectedFile().getPath());
            }
        } else if (e.getSource() == btnOK) { // 当按下确定按钮，生成一个新框架，框架里面有一个文本域，显示打开文件的内容
            JFrame f = new JFrame();
            f.setSize(400, 400);
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String extensionName = getExtensionName(textfield.getText());
            if ("txt".equals(extensionName)) {
                f.setTitle("显示文本");
                area = new TextArea();
                // 获取文本值
                String text = readTxt(textfield.getText());
                area.setText(text);
                f.add(area);
                f.setVisible(true);
            } else if ("jpg".equals(extensionName) || "png".equals(extensionName) || "gif".equals(extensionName)) {
                f.setTitle("显示图片");
                Icon img = new ImageIcon(textfield.getText());
                JLabel label = new JLabel(img);
                // 添加滚动条
                JScrollPane jsp = new JScrollPane(label);
                f.add(jsp);
                f.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "请选择txt/jpg/png/gif格式的文件！");
            }
        }
    }

    /**
     * @Description：获取文件后缀名 @param filename @return @throws
     */
    private String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * @Description：读取文件 @param path - 文件地址 @return @throws
     */
    private String readTxt(String path) {
        if (path == null || "".equals(path)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        File file = new File(path);
        InputStreamReader read = null;
        BufferedReader reader = null;
        try {
            read = new InputStreamReader(new FileInputStream(file), "gb2312");
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Test2 frame = new Test2();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
