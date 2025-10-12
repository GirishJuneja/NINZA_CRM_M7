package package1;

import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		
		Date d = new Date();
		String date = d.toString().replace(" ","_").replace(":","_");
		System.out.println(date);

	}

}
