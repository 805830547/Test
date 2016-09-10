package test;

/*
 * 封装类成员 权限声明用private 类成员可以是其他类 
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CPU cup = new CPU();
//		HardDisk hardDisk = new HardDisk();
//		
//		cup.setSpeed(2200);
//		hardDisk.setAmount(200);
//		PC pc = new PC();
//		pc.setCup(cup);
//		pc.setHardDisk(hardDisk);
//		pc.show();
		
//		ArrayList<String> aaaArrayList  = new ArrayList<String>();
//		aaaArrayList.add("aaa");
//		aaaArrayList.add("bbb");
//		aaaArrayList.add("ccc");
//		aaaArrayList.add("ddd");
//		for (String Record : aaaArrayList) {
//			System.out.println(Record);
//	    }
//		String myTeString = "1011";
//		int Record = Integer.parseInt(myTeString)+10;
		
		
//		StringBuilder recordBuilder = new StringBuilder();
//		recordBuilder.append("abcd");
//		recordBuilder.insert(0, "11111");
		
//		int recordBuilder = (int) (System.currentTimeMillis() / 1000L);
		String recordBuilder = "\\/Date(1456790400000)\\/";
		
		//recordBuilder.replace(new RegExp('/"\\\/(Date\([0-9-]+\))\\\/"/gi'), 'new $1');
		System.out.println(recordBuilder);
		
	}

}

class PC{
	CPU cup;
	HardDisk hardDisk;
	
	public CPU getCup() {
		return cup;
	}
	public void setCup(CPU cup) {
		this.cup = cup;
	}
	public HardDisk getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}
	
	public void show(){
		System.out.println("cpu speed:"+cup.getSpeed());
		System.out.println("harddisk amount:"+hardDisk.getAmount());
	}
	
}
class CPU{
	private int speed;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
class HardDisk{
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}