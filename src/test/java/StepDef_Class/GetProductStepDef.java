package StepDef_Class;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import Page_Class.GetItemPageClass;
import Utilities.PropertiesUtil;
import Utilities.WebUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetProductStepDef  {
	Shared sh;
	
	public GetProductStepDef(Shared s) {
		this.sh=s;
	}
	
	@Given("I am on the Amazon website")
	public void openAmazonWebsite() throws IOException {
	    sh.driver = sh.webUtil.openBrowser("chrome");
	    sh.webUtil.launchSite(sh.driver, PropertiesUtil.getProperty("url"));
	}

	@When("I search for {string}")
	public void searchForProduct(String string) throws IOException {
		sh.pageClass=new GetItemPageClass(sh.driver);
		sh.pageClass.enterItem(string);  
	}

	@Then("I should see search results")
	public void seeSearchResults() throws IOException {
		sh.pageClass.submitItem();
	}

	@When("I select the first product from the list")
	public void selectTheFirstProduct() throws IOException, InterruptedException {
		sh.pageClass.clickOnProduct();

	}

	@Then("I should see the product details")
	public void seeTheProductDetails() throws IOException {
		String details=sh.pageClass.getProductDetails();
		sh.sc.log("-> The mobile name is:  "+details);
	}
	@And("close the all browser")
	public void closeTheCurrentBrowser() {
		sh.webUtil.closeAllBrowser(sh.driver);
	}
}
