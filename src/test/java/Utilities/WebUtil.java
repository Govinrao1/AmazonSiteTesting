package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;


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
    	driver.manage().window().maximize();
    	driver.manage().timeouts().getPageLoadTimeout();
    	driver.manage().deleteAllCookies();
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
    }
    public static WebElement waitForElementToBeClickable(RemoteWebDriver driver,WebElement element, int timeoutInSeconds) {
        FluentWait<RemoteWebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
                 return wait.until(ExpectedConditions.visibilityOf((WebElement) element));
        
    }
    
    public void launchSite(RemoteWebDriver driver, String url) {
    	driver.get(url);
    }
    public String captureScreenshot(RemoteWebDriver driver) throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		String fn=System.getProperty("user.dir")+"\\target\\"+sf.format(dt)+".png";
		File dest=new File(fn); //create a new file in HDD
		File src=driver.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,dest);
		return(dest.getAbsolutePath());
	}
    public boolean isAlertPresent(RemoteWebDriver driver)
    {
    	try {
    		driver.switchTo().alert();
    		return true;
    	}catch(Exception e) {
    		return false;	
    	}
    }
	
    public void closeCurrentBrowser(RemoteWebDriver driver) {
    	driver.close();
    }
    public void closeAllBrowser(RemoteWebDriver driver) {
    	driver.quit();
    }
}

















