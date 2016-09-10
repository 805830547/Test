package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Efective {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<String>();
		stringList.add("afdf");
		stringList.add("wfdf");
		stringList.add("cfdf");
		stringList.add("afdf");
		stringList.add("efdf");
		stringList.add("kfdf");
		
		Collections.sort(stringList); 
		
		for (int i = 0; i < 6; i++) {
			System.out.println(stringList.get(i));
		}
		
	}

}
