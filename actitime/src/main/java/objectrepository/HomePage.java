package objectrepository;

import java.awt.Dimension;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import generick.BaseClass;
import generick.WebDriverUtil;

public class HomePage {
	
	WebDriverUtil util = new WebDriverUtil();
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//table[@class='navTable']/tbody/tr/td/a")
	private List<WebElement> linkInHomepageAtTope;
	
	public void verifyhomepage(int link)
	{
		int count=0;
		List<WebElement> lt = linkInHomepageAtTope;
		for(int i=0;i<=lt.size()-1;i++)
		{
		   util.waitForVisiblityOfElement(lt.get(i),20);
		   Assert.assertTrue(lt.get(i).isEnabled());
		   count++;
		}
		System.out.println(count+"number of link ");
		Assert.assertEquals(count,link);
		
		org.openqa.selenium.Dimension dc =BaseClass.driver.manage().window().getSize();
		System.out.println(dc.height);
		System.out.println(dc.width);
		
		
	}
	public void logoutApp()
	{
		util.waitForVisiblityOfElement(logoutBtn,40);
		logoutBtn.click();
	}

}
