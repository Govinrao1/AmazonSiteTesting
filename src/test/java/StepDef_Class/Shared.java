package StepDef_Class;

import org.openqa.selenium.remote.RemoteWebDriver;

import Page_Class.GetItemPageClass;
import Utilities.PropertiesUtil;
import Utilities.WebUtil;
import io.cucumber.java.Before;

public class Shared {
	
	public RemoteWebDriver driver;
	public WebUtil webUtil;
	public PropertiesUtil propUtil;
	public GetItemPageClass pageClass;
	
 @Before
 public void beforeMethod()
 {
	 driver=null;
	 webUtil=new WebUtil();
	 
 }
}
