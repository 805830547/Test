package batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test5 {

    public static void main(String[] args) throws Exception {
//        String content = "This is the content to write into file";
//
//        File file = new File("D:test.txt");
//
//        // if file doesnt exists, then create it
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//
//        FileWriter fw = new FileWriter(file.getAbsoluteFile());
//        BufferedWriter bw = new BufferedWriter(fw);
//        bw.write(content);
//        bw.close();
//
//        System.out.println("Done");
//        line 1: INSERT INTO "batch_process_calendar_data" ("Process_Code", "Process_Name", "Process_Type", "Scenario", "Year", "Month", "Day", "Hour", "Minute", "DayOfWeek", "Holiday_Flag", "Process_Flag", "operator", "time_stamp") VALUES ('A01_201701', '洗替、概算(フォーキャスト)(一週目)', 'F', 'Forecast', 2017, 1, 18, 0, 40, NULL, NULL, 0, NULL, '2016-12-31 00:00:00.000');
        File file = new File("D:/sql.txt");
        List<SqlFormat> sqlList = new ArrayList<SqlFormat>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                sqlList.add(new SqlFormat(tempString, tempString.substring(tempString.indexOf("2017,"), tempString.indexOf(", NULL, NULL, 0, NULL,"))));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }


        Collections.sort(sqlList);
        for (SqlFormat sqlFormat : sqlList) {
            System.out.println(sqlFormat.getSql());
        }

    }

}

class SqlFormat implements Comparable<SqlFormat>{
    private String sql;
    private String date;

    public String getSql() {
        return sql;
    }
    public SqlFormat(String sql, String date) {
        super();
        this.sql = sql;
        this.date = date;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(SqlFormat o) {
        String[] datef = date.trim().split(",", -1);
        String[] of = o.getDate().trim().split(",", -1);

        return getDateString(datef).compareTo(getDateString(of));
    }

    private String getDateString(String[] datef ) {
        StringBuffer sBuffer = new StringBuffer();
        for (String string : datef) {
            sBuffer.append(add0(string.trim()));
        }
        return sBuffer.toString();
    }

    private String add0(String dString) {
        if (Integer.parseInt(dString) < 10) {
            return "0" + dString;
        } else {
            return dString;
        }
    }

}