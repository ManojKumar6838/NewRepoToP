package shopperstack.logintest;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		
		String name="Hello";
		System.out.println(name+demo());
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time);
	}
	
	public static String demo() {
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date1=sdf.format(date);
		System.out.println(date1);
		return date1;
	}
	
}
