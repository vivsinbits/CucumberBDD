package Pages;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestUtil.TestBase;




public class SignIn extends TestBase{
	WebDriver driver;
	
	@FindBy(xpath ="//span[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement Hover;
	
	@FindBy(xpath ="//div[@class=\"nav-template nav-flyout-content\"]//child::span[text()=\"Sign in\"]")
	WebElement SignIn;
	
	@FindBy(xpath ="//input[@id='ap_email']")
	WebElement Email;
	
	@FindBy(xpath ="//input[@class='a-button-input']")
	WebElement ContinueButton;
				
	@FindBy(xpath ="//input[@id=\"ap_password\"]")
	WebElement Password;
	
	@FindBy(xpath ="//input[@id=\"signInSubmit\"]")
	WebElement FinalSignIn;
	
	@FindBy(xpath ="//input[@id=\"twotabsearchtextbox\"]")
	WebElement Searchbox;
	
	@FindBy(xpath ="//input[@id=\"nav-search-submit-button\"]")
	WebElement SearchIcon;
	
	@FindBy(xpath ="//button[@id=\"a-autoid-1-announce\"]")
	WebElement LaptopAddToCart;
	
	@FindBy(xpath ="//a[@id='nav-cart']")
	WebElement AddtoCartIcon;
	
	@FindBy(xpath ="//span[contains(text(),\"Dell 15 Thin\") and @class=\"a-truncate-cut\"] ")
	WebElement ValidatingLaptop;
	
	public SignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void HoverSignIN() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Hover).perform();
	}
	public void SignIN_Page() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(SignIn));
		SignIn.click();
	}
	public void EmailField(String input) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Email));
		Email.sendKeys(input);
		
	}
	
	public void Continue_Button() {
		ContinueButton.click();
	}
	
	public void Password_Field(String input) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Password));
		Password.sendKeys(input);
	}
	
	public void Final_SignIn_Button() {
		FinalSignIn.click();
	}
	
	public void SearchBox(String Input) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Searchbox));
		Searchbox.sendKeys(Input);
	}
	
	public void SearchIcon() {
		SearchIcon.click();
	}
	public void LaptopAddToCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		LaptopAddToCart.click();
	}
	public void AddtoCartIcon() {
//		Actions ac=new Actions(driver);
//		ac.moveToElement(AddtoCartIcon);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(AddtoCartIcon));
		AddtoCartIcon.click();
	}
	
	public void ValidatingProductInAddToCart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100);");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ValidatingLaptop));
		String laptopname=ValidatingLaptop.getText();
		System.out.println(laptopname);
		
	}
	}
