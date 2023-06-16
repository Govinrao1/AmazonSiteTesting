package Page_Class;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Utilities.WaitHelper;
import Utilities.WebUtil;

public class RegistrationPage {
      private RemoteWebDriver ldriver;
      WaitHelper waitHelper;
      
      
  	public RegistrationPage(RemoteWebDriver driver)
  	{
  		 this.ldriver = driver;
	        PageFactory.initElements(driver, this);
	        waitHelper=new WaitHelper(ldriver);
  	}
      
    @FindBy(xpath="//a[@id='nav-cart']")
    private WebElement addCartLink;

	@FindBy(xpath="(//span[@class='a-size-base-plus'])[2]")
	private WebElement signup;
	
	@FindBy(name="customerName")
	private WebElement custName;
	
	@FindBy(name="email")
	private WebElement custEmail;
	
	@FindBy(name="password")
	private WebElement custPassword;
	
	@FindBy(name="passwordCheck")
	private WebElement confirmPasswod;

	@FindBy(id="continue")
	private WebElement submitButton;
	
	
	
	public void addToCartLink() throws IOException, InterruptedException {
		waitHelper.waitForElement(addCartLink, 30);
		addCartLink.click();
	}
    public void signUpLink() throws IOException 
    {
    	waitHelper.waitForElement(signup, 30);
    	signup.click();
	}
    public void customerName(String cName) throws IOException, InterruptedException
    {
    	//waitHelper.waitForElement(custName, 30);
    	custName.sendKeys(cName);
   
    }
 
    public void customerEmail(String st) throws IOException, InterruptedException 
    {
    	//waitHelper.waitForElement(custEmail, 30);
    	custEmail.sendKeys(st);
    	
    }
    public void passwordMethod(String pwd) throws IOException, InterruptedException 
    {
    	waitHelper.waitForElement(custPassword, 30);
    	custPassword.sendKeys(pwd);
    	
    }
    public void confirmPasswordMethod(String confpwd) throws IOException, InterruptedException
    {
    	//waitHelper.waitForElement(confirmPasswod, 30);
    	confirmPasswod.sendKeys(confpwd);
    	
    }
    public void clickOnContinue() throws IOException {
    	waitHelper.waitForElement(submitButton, 30);
    	submitButton.click();
   }
}
