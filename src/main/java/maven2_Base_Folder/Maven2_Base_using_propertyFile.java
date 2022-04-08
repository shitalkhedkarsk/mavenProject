package maven2_Base_Folder;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import maven2_utility.UtilityClass_using_PropertyFie;

public class Maven2_Base_using_propertyFile
{
	protected WebDriver driver;
	public void launchBrowser() throws IOException
	{
		Reporter.log("opening chrome browser.....",true);
		System.setProperty("webdriver.chrome.driver", "F:\\webdriver\\chromedriver version100\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("https://kite.zerodha.com/");
		driver.get(UtilityClass_using_PropertyFie.propertyFile("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.manage().window().maximize();
		Reporter.log("Browserlaunched sussess",true);
	}
	
	

	public void closeBrowser() 
	{

		  Reporter.log("closing browser.....",true);
		  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		  driver.close();
	}
}
