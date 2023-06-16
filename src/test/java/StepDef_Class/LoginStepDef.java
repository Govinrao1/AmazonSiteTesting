package StepDef_Class;

import org.testng.Assert;

import Page_Class.LoginPage;
import Utilities.PropertiesUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	public Shared sh;
	public LoginStepDef(Shared s) {
		this.sh=s;
	}
     
	@Given("I am on the Amazon homepage {string}")
	public void i_am_on_the_amazon_homepage(String string)
	{
		sh.driver=sh.webUtil.openBrowser("chrome");
		sh.propUtil=new PropertiesUtil();
		sh.webUtil.launchSite(sh.driver, PropertiesUtil.getProperty("url"));
		String title=sh.driver.getTitle();
		if(title.equalsIgnoreCase(string)) {
			Assert.assertTrue(true);
			sh.sc.log("Amazon home page title was mathced");
		}else {
			Assert.assertTrue(false);
			sh.sc.log("Amazon home page title was not mathced");
		}
	    }

	@When("I click on the Sign In button {string}")
	public void i_click_on_the_sign_in_button(String string) 
	{
        sh.loginPage=new LoginPage(sh.driver);
        sh.loginPage.signInMethod();
        String title= sh.driver.getTitle();
        if(title.equalsIgnoreCase(string)) {
        	Assert.assertTrue(true);
	    	sh.sc.log("Amazon Login page title is matched");
        }else {
        	Assert.assertTrue(false);
	    	sh.sc.log("Amazon Login page title is not matched");
        }
	}

	@When("I enter my valid email {string}")
	public void i_enter_my_valid_email(String string)
	{
	    sh.loginPage.customerEmail(string);
	    sh.loginPage.clickOnContinue();
	}

	@When("I enter my valid password {string}")
	public void i_enter_my_valid_password(String string)
	{
	    sh.loginPage.customerPassword(string);
	    
	}

	@When("I click on the Continue button")
	public void i_click_on_the_continue_button() throws Exception 
	{
	    sh.loginPage.clickOnSubmit();
	 
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() throws Exception
	{
		 sh.webUtil.captureScreenshot(sh.driver);
	     sh.webUtil.closeCurrentBrowser(sh.driver);
	}

}
