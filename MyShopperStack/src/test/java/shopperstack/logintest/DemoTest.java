package shopperstack.logintest;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {

	@Test
	public void demo() {
		String value=System.getProperty("browser");
		System.out.println(value);
		Reporter.log("Demo Executing", true);
	}
}
