package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    
	public RemoteWebDriver driver;
	public WaitHelper(RemoteWebDriver driver) {
		this.driver=driver;
	}
	public void waitForElement(WebElement element, int time) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
