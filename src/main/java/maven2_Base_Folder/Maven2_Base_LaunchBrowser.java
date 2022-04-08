package maven2_Base_Folder;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
public class Maven2_Base_LaunchBrowser
{
	//protected WebDriver driver;
	protected static WebDriver driver;
public void launchBrowser() throws IOException
{
	Reporter.log("opening chrome browser.....",true);
	System.setProperty("webdriver.chrome.driver", "F:\\webdriver\\chromedriver version100\\chromedriver_win32 (1)\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://kite.zerodha.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	driver.manage().window().maximize();
	Reporter.log("Browserlaunched sussess",true);
}


public  void takeScreenshot(String TcName) throws IOException
{
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination=new File("F:\\screenshot\\kite "+TcName+".png");
	FileHandler.copy(source, destination);
	Reporter.log("screenshot taken for TC "+TcName,true);
	}
public void closeBrowser() 
{

	  Reporter.log("closing browser.....",true);
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	  driver.close();
}
}
