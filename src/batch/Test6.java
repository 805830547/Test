package batch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test6 {

    private static final Pattern NUMBERPATTERN = Pattern.compile("[0-9]+");

    private static final Pattern CALCULATEPATTERN = Pattern.compile("[\\+,\\-,\\*,\\/]");

    public static void main(String[] args) throws Exception {

        String que = "10+20-3*4/5";

        List<String> queList = new ArrayList<String>();

        List<String> calList = new ArrayList<String>();

        Matcher matcher = NUMBERPATTERN.matcher(que);
        while (matcher.find()) {
            queList.add(matcher.group());
            System.out.println(matcher.group());
        }

        matcher = CALCULATEPATTERN.matcher(que);
        while (matcher.find()) {
            calList.add(matcher.group());
            System.out.println(matcher.group());
        }
        String result = queList.get(0);
        for (int i = 0; i < calList.size(); i++) {
            System.out.print(result + calList.get(i) + queList.get(i + 1) +"=");
            result = Arith.cal(result, queList.get(i + 1), calList.get(i));
            System.out.print(result);
            System.out.println();
            //            System.out.println(result + calList.get(i) + queList.get(i + 1) +"="+ result);
        }

        System.out.println("=============="+ result);
    }

}