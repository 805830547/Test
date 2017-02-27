package reflect;

import java.io.Serializable;
import java.lang.reflect.Field;


public class Student extends Person implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void init(String name, int age) {
        System.out.println("My name is " + name + ", and age is " + age);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            sb.append(field.getName());
            sb.append("=");
            try {
                sb.append(field.get(this));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
