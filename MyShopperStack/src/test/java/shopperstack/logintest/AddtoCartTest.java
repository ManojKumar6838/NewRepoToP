package shopperstack.logintest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import shoppersstack.baseclass.BaseClass;
@Listeners(listnerimplementation.ListnersImplimentation.class)
public class AddtoCartTest extends BaseClass{

	@Test(retryAnalyzer = listnerimplementation.RetryListner.class)
	public void addToCartTest() {
		Assert.fail();
		Reporter.log("Successfully Added to Cart", true);
		test.log(LogStatus.INFO, "Added to cart successfully");
		
	}
}
