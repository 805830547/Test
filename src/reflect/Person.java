package reflect;

public class Person {
    private String sex;
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public void say() {
        System.out.println("There is a person speaking");
    }
}
