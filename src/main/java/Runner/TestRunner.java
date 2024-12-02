package Runner;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/vivekkumar/eclipse-workspace/Amazon_Bdd_Task/src/main/java/Feature/SignIn.feature"
		,glue={"StepDefinition"},
				plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false,
		
		monochrome=true
		
				
		
		)

public class TestRunner {

}
