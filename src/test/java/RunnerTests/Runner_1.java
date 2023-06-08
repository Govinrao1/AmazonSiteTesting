package RunnerTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class Runner_1 {
	@CucumberOptions(
			features={"src\\test\\resources\\Features\\GetItem_1.feature"},
			glue={"StepDef_Class"},
			//tags="@smoketest",
			monochrome=true,
			plugin={"pretty","html:target/smoketestres",
					               "rerun:target/failedsmoketestscenarios.txt"}
			)
	public class Runner1 extends AbstractTestNGCucumberTests
	{
		// This class will be empty by default 
	}
}
