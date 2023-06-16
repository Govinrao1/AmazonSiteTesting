package Page_Class;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class LoginPage {
	RemoteWebDriver ldriver;
	WaitHelper waitHelper;
	
	public LoginPage(RemoteWebDriver driver) {
		this.ldriver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(ldriver);
	}
	
	    @FindBy(id="nav-link-accountList-nav-line-1")
	    private WebElement signInLink;
		
		@FindBy(name="email")
		private WebElement custEmail;
		
		@FindBy(id="continue")
		private WebElement continueBt1;
		
		@FindBy(id="ap_password")
		private WebElement custPasswd;
		
		@FindBy(id="signInSubmit")
		private WebElement signInBt;
		
		public void signInMethod() {
			waitHelper.waitForElement(signInLink, 10);
			signInLink.click();
		}
		public void customerEmail(String cEmail) {
			waitHelper.waitForElement(custEmail, 10);
			custEmail.sendKeys(cEmail);
		}
		public void clickOnContinue() {
			waitHelper.waitForElement(continueBt1, 10);
			continueBt1.click();
		}
		public void customerPassword(String pwd) {
			waitHelper.waitForElement(custPasswd, 10);
			custPasswd.sendKeys(pwd);
		}
		public void clickOnSubmit() {
			waitHelper.waitForElement(signInBt, 10);
			signInBt.click();
		}
}






