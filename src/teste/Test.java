package teste;

public class Test{

    public static void animalSay(Animal a) {
        a.say();
    }

    public static void main(String[] args) {
//        animalSay(new Dog());
//        animalSay(new Cat());
        System.out.print("test:");
        for (String string : args) {
            System.out.print(string);
        }
    }
}