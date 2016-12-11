package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Test5 {

    public static void main(String[] args) throws Exception {
        String content = "This is the content to write into file";

        File file = new File("D:test.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();

        System.out.println("Done");

    }

}