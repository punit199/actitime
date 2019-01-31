package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import generick.WebDriverUtil;

public class LoginPage {
	
	WebDriverUtil util = new WebDriverUtil();
	@FindBy(css="input#username")
	private WebElement userTextBox;
	
	@FindBy(css="input[name='pwd']")
	private WebElement passwordText;
	
	@FindBy(css="#loginButton")
	private WebElement logintab;
	
	@FindBy(css=".productNameContainer img")
	private WebElement actitimeImg;
	
	@FindBy(css="#demoCredentials")
	private WebElement logindetailTable;
	
	@FindBy(xpath="//td[text()='Please identify yourself']")
	private WebElement textgivenAbTable;
	
	public void verifyTheLoginpage()
	{
	util.waitForVisiblityOfElement(actitimeImg, 20);
	Assert.assertTrue(actitimeImg.isDisplayed());
	
	util.waitForVisiblityOfElement(logindetailTable, 20);
	Assert.assertTrue((logindetailTable.isEnabled()));
	
	util.waitForVisiblityOfElement(textgivenAbTable, 20);
	Assert.assertTrue(textgivenAbTable.isDisplayed());
	System.out.println("login page is verifed");
	}
	
	public void loginToApp(String username,String password)
	{
		userTextBox.sendKeys(username);
		passwordText.sendKeys(password);
		logintab.click();
	}

}
