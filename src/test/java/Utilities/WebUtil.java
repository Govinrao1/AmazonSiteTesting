package Utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class WebUtil {
	//RemoteWebDriver driver;
	
    public RemoteWebDriver openBrowser(String browserName) 
    {
    	RemoteWebDriver driver;
    	if(browserName.equalsIgnoreCase("chrome")) 
    	{
			 driver=new ChromeDriver();
    	}else if(browserName.equalsIgnoreCase("firefox")) 
    	{
    		driver=new FirefoxDriver();
    	}else 
    	{
    		driver=new EdgeDriver();
    	}
		return driver;
    }
    
    public static WebElement waitForElement(RemoteWebDriver driver, WebElement locator) throws IOException {
        String value1 = PropertiesUtil.getProperty("maxTime");
        int max = Integer.parseInt(value1);
        String value2 = PropertiesUtil.getProperty("intervalTime");
        int interval = Integer.parseInt(value2);
        
        Wait<RemoteWebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(max))
                .pollingEvery(Duration.ofMillis(interval));

        return wait.until(ExpectedConditions.visibilityOf(locator));
    }
    
    public void launchSite(String url, RemoteWebDriver driver) {
    	driver.get(url);
    }
    public void closeCurrentBrowser(RemoteWebDriver driver) {
    	driver.close();
    }
    public void closeAllBrowser(RemoteWebDriver driver) {
    	driver.quit();
    }
}

















