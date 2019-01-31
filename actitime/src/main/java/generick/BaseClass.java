package generick;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.HomePage;
import objectrepository.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	Fileutil data = new Fileutil();
	WebDriverUtil util = new WebDriverUtil();
	@BeforeTest(groups= {"smoke"})
	public void conficBc() throws Throwable
	{
		Properties pobj =data.getPropertyFileData();	
		String browser=pobj.getProperty("BROWSER");
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firfox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	@BeforeMethod(groups= {"smoke"})
	public void conficBm() throws Throwable
	{
		Properties pobj =data.getPropertyFileData();
		String url =pobj.getProperty("URL");
		String user=data.getXmlData("meanu//logindata/username");
		String pass = data.getXmlData("meanu//logindata/password");
		driver.manage().deleteAllCookies();
		util.waitforpageLoad(50);
		driver.get(url);
		LoginPage lg = PageFactory.initElements(driver,LoginPage.class);
		lg.verifyTheLoginpage();
		lg.loginToApp(user, pass);
	}
	@AfterMethod(groups= {"smoke"})
	public void conficAm() 
	{
		System.out.println("logout");
		HomePage hp = PageFactory.initElements(driver,HomePage.class);
		hp.logoutApp();
		
	}
	@AfterTest(groups= {"smoke"})
	public void conficAc()
	{
		driver.close();
	}

}
