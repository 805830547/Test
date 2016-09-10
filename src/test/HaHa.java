package test;

public class HaHa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human human=new Human(100,new Car("baoshijie"));
		human.eat();
		human.say();
		Monkey  monkey=new XingXing();
		monkey.eat();
	}

}

abstract class Monkey{
	int age;//ƒÍ¡‰	
	abstract void eat();
}

class Human extends Monkey{
	int eq;
	Car car;
	public Human(int eq,Car car){
		this.eq=eq;
		this.car=car;
	}
	public void  eat() {
		System.out.println("I Can Eat Everything!");
	}
	public void say() {
		System.out.println("I Have A Car Name :"+this.car.name);
		System.out.println("My EQ Is :"+this.eq);
	}
}

class XingXing extends Monkey{
	public void eat() {
		System.out.println("I Can Eat Banana!");
	}
}

interface JiDongChe{ 
	abstract public void go();
}

class Car implements JiDongChe{
	String name;
	public Car(String name){
		this.name=name;
	}
	@Override
	public void go() {
		// TODO Auto-generated method stub
		System.out.println("I Can Run Fast!");
	}
}