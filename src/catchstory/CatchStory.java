package catchstory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatchStory {

    private static final String HTMLURL_REG = "<br />.+?<br />";
    // 编码
    private static final String ECODING = "gb2312";

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String url = "https://img.pic123456.com/Html/76158.html";
        String html = null;
        html = CatchStory.getHTML(url);
        // System.out.println(html);
        List<String> sb = new ArrayList<String>();
        Matcher matcher = Pattern.compile(HTMLURL_REG).matcher(html);
        while (matcher.find()) {
            sb.add(matcher.group());
        }

        File file = new File("D:test.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        // true = append file
        FileWriter fileWritter = new FileWriter(file.getAbsoluteFile(), false);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        for (String string : sb) {
            bufferWritter.write(string.replace("<br />", "") + "\r\n");
        }

        bufferWritter.close();

        System.out.println("Done");

    }

    public static String getHTML(String url) throws Exception {
        URL uri = new URL(url);
        URLConnection connection = uri.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream in = connection.getInputStream();
        byte[] buf = new byte[1024];
        StringBuffer sb = new StringBuffer();
        while ((in.read(buf, 0, buf.length)) > 0) {
            sb.append(new String(buf, ECODING));
        }
        in.close();
        return sb.toString();
    }

}
