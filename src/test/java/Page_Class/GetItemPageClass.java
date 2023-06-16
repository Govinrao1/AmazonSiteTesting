package Page_Class;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;
import Utilities.WebUtil;

public class GetItemPageClass {
	WebUtil webUtil;
	private RemoteWebDriver driver;
	WaitHelper waitHelper;
	
	public GetItemPageClass(RemoteWebDriver driver)
	{
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	        waitHelper=new WaitHelper(driver);
	        webUtil=new WebUtil();
	 }
	@FindBy(id="twotabsearchtextbox")
	private WebElement enterProduct;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement clickEnter;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/span/a/div/img")
	private WebElement clickOnElement;
	
	@FindBy(xpath="(//span[text()='Apple iPhone 12 (64GB) - (Product) RED'])[1]")
	private WebElement getProductName;
	
	public void enterItem(String item) throws IOException {
		waitHelper.waitForElement(enterProduct, 10);
		enterProduct.sendKeys(item);
	}
	public void submitItem() throws IOException {
		waitHelper.waitForElement(clickEnter, 10);
		clickEnter.click();
	}
	public void clickOnProduct() throws IOException {
		waitHelper.waitForElement(clickOnElement, 10);
		clickOnElement.click();
	}
	public String getProductDetails() throws IOException {
	    waitHelper.waitForElement(getProductName, 10);
	    String title=getProductName.getText();
		return title;
	}
	public void closeBrowser() {
		webUtil.closeCurrentBrowser(driver);
	}
	
}








