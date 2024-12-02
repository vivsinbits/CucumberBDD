package TestUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public TestBase(){
		try {
		prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Configure/Confi.properties");

		prop.load(fis);
	
		}catch(IOException e) {
			e.getMessage();
			
		}
	}

public static void Initialization() {
	String BrowserName=prop.getProperty("browser");
	if(BrowserName.equals("chrome")) {
		driver=new ChromeDriver();
	}else if(BrowserName.equals("FF")) {
		driver=new FirefoxDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilTime.implictwait));

	driver.get(prop.getProperty("URL"));
	
	
}

}
