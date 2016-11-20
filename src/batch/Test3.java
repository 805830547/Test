package batch;

public class Test3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String fileName = "012a456test.java";

        System.out.println(fileName.charAt(3));
        System.out.println(fileName.codePointAt(3));
        System.out.println(fileName.concat("1"));
        System.out.println(fileName.substring(fileName.lastIndexOf(".") + 1));
    }

}
