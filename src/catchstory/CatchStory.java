package catchstory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CatchStory {
    // 编码
    private static final String ECODING = "gb2312";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String url = "https://img.pic123456.com/Html/76157.html";
        String html = null;
        try {
            html = CatchStory.getHTML(url);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(html);
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
