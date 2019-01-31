package scenario;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import generick.BaseClass;
import objectrepository.HomePage;

public class VerifingHomePage extends BaseClass{
	
	@Test(groups= {"smoke"})
	public void run()
	{
		System.out.println("verifing home page");
		HomePage hp = PageFactory.initElements(driver,HomePage.class);
		hp.verifyhomepage(4);
	}

}
