package StepDef_Class;

import java.io.IOException;

import org.testng.Assert;

import Page_Class.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDef {
    public Shared sh;
    public RegistrationStepDef(Shared s) 
    {
	    this.sh=s;
    }
    @Given("User is on the Amazon Registration Website {string}")
    public void userIsOnAmazonRegistrationWebsite(String url) throws IOException, InterruptedException {
    	sh.driver= sh.webUtil.openBrowser("chrome");
        sh.webUtil.launchSite(sh.driver, url);
        sh.regPage=new RegistrationPage(sh.driver);
    	sh.regPage.addToCartLink();
    	sh.regPage.signUpLink();
    	
    }
    @When("User checks the current page title should be {string}")
    public void checkPageTitle(String pageTitle) {
    	String title=sh.driver.getTitle();
    	if(title.equalsIgnoreCase(pageTitle)) 
    	{
    		Assert.assertTrue(true);
    		sh.sc.log("The page title is matched");
    	
    	}else {
    		Assert.assertTrue(false);
    		sh.sc.log("The page title is not matched");
    	}
    }
    @And("User fills in the registration form with {string}, {string}, {string}, and {string}")
    public void userFillsInRegistrationForm(String custName, String custEmail, String passwd, String reenterPasswd) throws IOException, InterruptedException {
    	sh.regPage.customerName(custName);
    	sh.regPage.customerEmail(custEmail);
    	sh.regPage.passwordMethod(passwd);
    	sh.regPage.confirmPasswordMethod(reenterPasswd);
    }

    @Then("User submits the registration form")
    public void userSubmitsRegistrationForm() throws Exception {
        sh.regPage.clickOnContinue();
        if(sh.webUtil.isAlertPresent(sh.driver)==true) {
        	sh.driver.switchTo().alert().accept();
        	sh.driver.switchTo().defaultContent();
        	Assert.assertTrue(false);
        	sh.sc.log("Registration failed");
        }else {
        	Assert.assertTrue(true);
        	sh.sc.log("Registration passed");
        }
        sh.webUtil.captureScreenshot(sh.driver);
    }

    @Then("User closes the Amazon site")
    public void userClosesAmazonSite() {
    	sh.webUtil.closeCurrentBrowser(sh.driver);
    }
}
