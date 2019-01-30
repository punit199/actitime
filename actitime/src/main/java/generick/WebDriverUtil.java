package generick;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {
	
	public void waitforpageLoad(int time)
	{
		BaseClass.driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	public void waitForVisiblityOfElement(WebElement wb,int time)
	{
		WebDriverWait wait = new WebDriverWait(BaseClass.driver,time);
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	
	public void waitForInVisiblityOfElement(WebElement wb,int time)
	{
		WebDriverWait wait = new WebDriverWait(BaseClass.driver,time);
		wait.until(ExpectedConditions.invisibilityOf(wb));
	}

}
