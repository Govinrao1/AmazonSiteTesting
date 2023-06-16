package StepDef_Class;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import Page_Class.GetItemPageClass;
import Page_Class.LoginPage;
import Page_Class.RegistrationPage;
import Utilities.PropertiesUtil;
import Utilities.WebUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Shared {
	
	public RemoteWebDriver driver;
	public WebUtil webUtil;
	public PropertiesUtil propUtil;
	public GetItemPageClass pageClass;
	public Scenario sc;
	public RegistrationPage regPage;
	public LoginPage loginPage;
	
 @Before
 public void beforeMethod(Scenario sc)
 {
	 this.sc=sc;
	 driver=null;
	 webUtil=new WebUtil();
	 sc.log(sc.getName()+ "  The test execution is started");
	 
 }
 @After
 public void afterMethod(Scenario sc) {
	 this.sc=sc;
	 sc.log(sc.getName() +" The test execution was completed "+sc.getStatus().name());
 }
}
