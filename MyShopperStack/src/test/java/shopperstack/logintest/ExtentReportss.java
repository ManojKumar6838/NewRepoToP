package shopperstack.logintest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportss { 

	public static void main(String[] args) {
		ExtentReports report=new ExtentReports("./AdvancedReports/first.html");
		ExtentTest var1 = report.startTest("First Module");
		var1.log(LogStatus.INFO, "Has started");
		report.endTest(var1);
		report.flush();
		
	}
}
