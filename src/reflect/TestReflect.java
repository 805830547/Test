package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {

    public static void main(String[] args) throws Exception {
        Class<?> clazz1 = Class.forName("reflect.Student");
        System.out.println(clazz1.getName());
        System.out.println(clazz1.isInterface());
        System.out.println(clazz1.isInstance(new Student()));

        System.out.println(Eat.class.isInterface());

        Field field = clazz1.getDeclaredField("name");
        Student student = (Student)clazz1.newInstance();
        field.setAccessible(true);
        field.set(student, "XiaoMing");
        student.setAge(10);
        System.out.println(student);

        Method method = clazz1.getDeclaredMethod("init", String.class, int.class);
        method.invoke(clazz1.newInstance(), "hahah", 20);
    }
}
