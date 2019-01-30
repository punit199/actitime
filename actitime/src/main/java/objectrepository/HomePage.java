package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generick.WebDriverUtil;

public class HomePage {
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutBtn;
	public void logoutApp()
	{
		WebDriverUtil util = new WebDriverUtil();
		util.waitForVisiblityOfElement(logoutBtn,40);
		logoutBtn.click();
	}

}
