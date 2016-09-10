package catchimage;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * java抓取网络图片
 * 
 * @author swinglife
 * 
 */
public class CatchImage {
    private String mypath;
    // 17775
    private static int nameNumber = 124206;
    // 编码
    private static final String ECODING = "UTF-8";
    // 获取htmlwangye正则
    private static final String HTMLURL_REG = "<a.*href=(.*?)[^>]*?>";
    // 获取Html src路径的正则
    // private static final String HTMLSRC_REG = "/Html/\"?(.*?)(\"|>|\\s+)";
    private static final String HTMLSRC_REG = "/Html/\\d+.html";
    // 获取img标签正则
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
    // 获取src路径的正则
    private static final String IMGSRC_REG = "/\\S*.jpg";

    // private static final String IMGSRC_REG = "https:\"?(.*?)(\"|>|\\s+)";
    private static final String LOCALPATH = "https://img.pic123456.com";

    public String getMypath() {
        return mypath;
    }

    public void setMypath(String mypath) {
        this.mypath = mypath;
    }

    /***
     * 获取HTML内容
     * 
     * @param url
     * @return
     * @throws Exception
     */
    public void getHTML(String url) throws Exception {
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
        getHtmlUrl(sb.toString());
    }

    /***
     * 获取HTML内容 return
     * 
     * @param url
     * @return
     * @throws Exception
     */
    private String getHTMLForPrivate(String url) throws Exception {
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

    /***
     * 获取HtmlUrl地址
     * 
     * @param HTML
     * @return
     */
    private void getHtmlUrl(String HTML) {
        Matcher matcher = Pattern.compile(HTMLURL_REG).matcher(HTML);
        List<String> listImgUrl = new ArrayList<String>();
        while (matcher.find()) {
            listImgUrl.add(matcher.group());
        }
        getHtmlSrc(listImgUrl);
    }

    /***
     * 获取HtmlSrc地址
     * 
     * @param listImageUrl
     * @return
     */
    private void getHtmlSrc(List<String> listHtmlUrl) {
        List<String> listImgSrc = new ArrayList<String>();
        for (String image : listHtmlUrl) {
            Matcher matcher = Pattern.compile(HTMLSRC_REG).matcher(image);
            while (matcher.find()) {
                listImgSrc.add(matcher.group().substring(0, matcher.group().length()));
            }
        }
        redictToNewHtml(listImgSrc);
    }

    /***
     * 跳到不同的页面
     * 
     * @param listImgSrc
     */
    private void redictToNewHtml(List<String> listHtmlSrc) {
        for (String urlString : listHtmlSrc) {
            // 获得html文本内容
            String HTML;
            try {
                System.out.println("********************************************下载页面：" + LOCALPATH + urlString);
                HTML = getHTMLForPrivate(LOCALPATH + urlString);
                // 获取图片标签
                List<String> imgUrl = getImageUrl(HTML);
                // 获取图片src地址
                List<String> imgSrc = getImageSrc(imgUrl);
                // 下载图片
                Download(imgSrc);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    /***
     * 获取ImageUrl地址
     * 
     * @param HTML
     * @return
     */
    private List<String> getImageUrl(String HTML) {
        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(HTML);
        List<String> listImgUrl = new ArrayList<String>();
        while (matcher.find()) {
            listImgUrl.add(matcher.group());
        }
        return listImgUrl;
    }

    /***
     * 获取ImageSrc地址
     * 
     * @param listImageUrl
     * @return
     */
    private List<String> getImageSrc(List<String> listImageUrl) {
        List<String> listImgSrc = new ArrayList<String>();
        for (String image : listImageUrl) {
            Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(image);
            while (matcher.find()) {
                listImgSrc.add(matcher.group().substring(0, matcher.group().length()));
            }
        }
        return listImgSrc;
    }

    /***
     * 下载图片
     * 
     * @param listImgSrc
     */
    private void Download(List<String> listImgSrc) {
        try {
            for (String urlString : listImgSrc) {
                downloadOneImage(LOCALPATH + urlString);
            }
        } catch (Exception e) {
            System.out.println("下载失败");
        }
    }

    /**
     * 下载一张网络图片到本地磁盘
     * 
     * @param args
     */
    /**
     * @param args
     */

    public void downloadOneImage(String urlString) throws Exception {

        System.out.println("正在下载：" + urlString);
        // new一个URL对象
        URL url = new URL(urlString);

        // 打开链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        // parser = new Parser(conn);
        // conn.setEncoding("gb2312");

        // 设置请求方式为"GET"
        conn.setRequestMethod("GET");
        // 超时响应时间为5秒
        conn.setConnectTimeout(5 * 1000);// 设置连接超时:500ms
        conn.setReadTimeout(5 * 1000);// 设置读取超时:500ms
        // 通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();
        // 得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = readInputStream(inStream);
        if (data != null) {
            // new一个文件对象用来保存图片，默认保存当前工程根目录
            String fileName = mypath + "\\" + String.valueOf(nameNumber++) + ".jpg";
            // "D:\\pictures\\"
            File imageFile = new File(fileName);
            // 创建输出流
            FileOutputStream outStream = new FileOutputStream(imageFile);
            // 写入数据
            outStream.write(data);
            // 关闭输出流
            outStream.close();
            System.out.println("下载完成：" + String.valueOf(nameNumber));
        }

    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        // 创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        // 每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        // 使用一个输入流从buffer里把数据读取出来
        while ((len = inStream.read(buffer)) != -1) {
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        // 关闭输入流
        inStream.close();
        // 把outStream里的数据写入内存
        return outStream.toByteArray();
    }

}
