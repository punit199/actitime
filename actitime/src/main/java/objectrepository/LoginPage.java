package objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(css="input#username")
	private WebElement userTextBox;
	
	@FindBy(css="input[name='pwd']")
	private WebElement passwordText;
	
	@FindBy(css="#loginButton")
	private WebElement logintab;
	
	public void loginToApp(String username,String password)
	{
		userTextBox.sendKeys(username);
		passwordText.sendKeys(password);
		logintab.click();
	}

}
