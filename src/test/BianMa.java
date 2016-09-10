package test;

public class BianMa {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Code code = new Code("");
        System.out.println(code.getUnicode());
    }

}

// class Code{
// String myString;
// public Code(String myString){
// this.myString=myString;
// }
// public int getUnicode() {
// return
// }
// }
class Code {
    char myChar;

    public Code(char myChar) {
        this.myChar = myChar;
    }

    public int getUnicode() {
        return (int) myChar;
    }
}