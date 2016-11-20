package dirfloder;

import java.io.File;

public class ListFileName {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File dir = new File("D:");
        if (dir.isDirectory()) {
            String[] fileNames = dir.list();
            for (String fileName : fileNames) {
                File file = new File(dir.getPath() + File.separator + fileName);
                if (file.isDirectory()) {
                    System.out.println("Dictionary:" + file.getName());
                } else if (file.isFile()) {
                    System.out.println("File:" + file.getName());
                }
            }
        }
    }
}
