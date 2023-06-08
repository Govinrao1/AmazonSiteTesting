package Page_Class;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WebUtil;

public class GetItemPageClass {
	private RemoteWebDriver driver;
	
	public GetItemPageClass(RemoteWebDriver driver)
	{
		 this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	@FindBy(id="twotabsearchtextbox")
	private WebElement enterProduct;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement clickEnter;
	
	@FindBy(xpath="(//div[@class='a-section aok-relative s-image-fixed-height'])[1]")
	private WebElement clickOnElement;
	
	@FindBy(xpath="//div[@id='centerCol']")
	private WebElement getProductName;
	
	public void enterItem(String item) throws IOException {
		WebElement product=WebUtil.waitForElement(driver, enterProduct);
		product.sendKeys(item);
	}
	public void submitItem() throws IOException {
		WebElement product=WebUtil.waitForElement(driver, clickEnter);
		product.click();
	}
	public void clickOnProduct() throws IOException {
		WebElement product=WebUtil.waitForElement(driver, clickOnElement);
		product.click();
	}
	public String getProductDetails() throws IOException {
	return WebUtil.waitForElement(driver, clickOnElement).getText();
	
	}
	
}








