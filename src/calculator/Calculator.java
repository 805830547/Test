package calculator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calculator {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        Date date = calendar.getTime();
        String yesterday = new SimpleDateFormat("yyyyMMdd").format(date);
        System.out.println(yesterday);
    }

}
