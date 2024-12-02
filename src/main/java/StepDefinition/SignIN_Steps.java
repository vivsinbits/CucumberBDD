package StepDefinition;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Pages.SignIn;
import TestUtil.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignIN_Steps extends TestBase {
	SignIn sign;
	@Given("The User is in the login page")
	public void the_user_is_in_the_login_page() {
		TestBase.Initialization();
		sign=new SignIn(driver);
		System.out.println("The Browser has launched and User is in login page");
	  
	}

	@When("User enters valid {string}, {string} and {string}")
	public void user_enters_valid_and(String UserName, String Password,String Search) {
		
		System.out.println("Username: " + UserName);
		System.out.println("Password: " + Password);
		System.out.println("Search: " + Search);
		sign.HoverSignIN();
		sign.SignIN_Page();
		sign.EmailField(UserName);
		sign.Continue_Button();
		sign.Password_Field(Password);
		sign.Final_SignIn_Button();
		sign.SearchBox(Search);
		sign.SearchIcon();
		sign.LaptopAddToCart();
		sign.AddtoCartIcon();
		
  
	    
	}

	@Then("User is in the Home Page")
	public void user_is_in_the_home_page() {
		sign.ValidatingProductInAddToCart();
	
	}

	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        try {
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + scenario.getName().replaceAll(" ", "_") + ".png";
	            FileUtils.copyFile(screenshot, new File(screenshotPath));
	            System.out.println("Screenshot saved at: " + screenshotPath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    driver.quit();
	}
}