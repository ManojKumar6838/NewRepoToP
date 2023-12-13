package shopperstack.logintest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import shoppersstack.baseclass.BaseClass;
@Listeners(listnerimplementation.ListnersImplimentation.class)
public class AddAdressTest extends BaseClass {

	@Test(retryAnalyzer = listnerimplementation.RetryListner.class)
	public void addAddress() {
		Assert.fail();
		Reporter.log("Address added Succssfully", true);
		test.log(LogStatus.INFO, "Added address Successfully");
	}
}
