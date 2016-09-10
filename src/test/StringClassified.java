package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringClassified {
    public static void main(String[] args) {
        checkfilename("输入一段字符串，ssss判断是否有中文dd，有的话并输d出，共有多w少个大小5写字母、数字空e6格号跟其他符号，并f分别列s出来");

    }

    public static void checkfilename(String s) {
        s = new String(s.getBytes());// 用GBK编码
        String pattern = "[\u4e00-\u9fa5]+";
        Pattern p = Pattern.compile(pattern);
        Matcher result = p.matcher(s);
        while (result.find()) {
            System.out.println(result.group());
        }
    }
}
