package shoppersstack.baseclass;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import listnerimplementation.ListnersImplimentation;
import shopperstack.fileutility.ReadProperties;
import shopperstack.objectrepository.LoginPage;
import shopperstack.objectrepository.WelcomePage;

public class BaseClass extends ListnersImplimentation{
	
	
	
	public WebDriver driver;
	public static WebDriver sdriver=null;
	ReadProperties properties=new ReadProperties();
	@BeforeClass
	public void launchBrowser() throws Throwable {
		driver=new ChromeDriver();
		sdriver=driver;
		driver.manage().window().maximize();
		String url=properties.getDataFromProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	@BeforeMethod
	public void login() throws Throwable {
		String username=properties.getDataFromProperty("username");
		String password=properties.getDataFromProperty("password");
		WelcomePage welcome=new WelcomePage(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(welcome.getLoginButton()));
		welcome.getLoginButton().click();
		
		LoginPage login=new LoginPage(driver);
		login.getEmailTextField().sendKeys(username);
		login.getPasswordTextField().sendKeys(password);
		login.getLoginButton().click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterMethod
	public void logout() {
		Reporter.log("Logged out", true);
	}
	
	 
	
}
