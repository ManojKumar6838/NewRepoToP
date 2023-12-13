package listnerimplementation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import genricutility.UtilityVariables;
import shoppersstack.baseclass.BaseClass;

public class ListnersImplimentation implements ITestListener, ISuiteListener{
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		String imgPath="./FailedScreenshots/"+result.getName()+".png";
		Reporter.log(result.getName()+" has failed", true);
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		System.out.println(ts);
		File screenshot=ts.getScreenshotAs(OutputType.FILE);
		File path=new File(imgPath);
		try {
			FileHandler.copy(screenshot, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, test.addScreenCapture("."+imgPath));
		test.log(LogStatus.FAIL, result.getName()+" has Failed");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" has Started", true);
		
		test=report.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+" has started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" has excecuted Successfully", true);
		test.log(LogStatus.PASS, result.getName()+" has passed");
	}
	
	@Override
	public void onStart(ISuite suite) {
		Reporter.log(suite.getName()+" has Started", true);
		report=new ExtentReports("./AdvancedReports/"+suite.getName()+".html");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" has skipped");
		test.log(LogStatus.SKIP, result.getName()+" has skipped");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		
		Reporter.log(suite.getName()+" has Finished", true);
		//test.log(LogStatus.INFO, suite.getName()+" has finished");
		report.endTest(test);
		report.flush();
	}
	
	
	
}
