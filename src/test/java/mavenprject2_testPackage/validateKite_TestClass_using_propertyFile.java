package mavenprject2_testPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import maven2_Base_Folder.Maven2_Base_using_propertyFile;
import maven2_utility.UtilityClass_using_PropertyFie;
import mavenprject2_PomClasses.Homepage_3;
import mavenprject2_PomClasses.LoginPage1;
import mavenprject2_PomClasses.PinPage_2;
@Listeners(listener_study.Listener_maven2.class)
public class validateKite_TestClass_using_propertyFile extends Maven2_Base_using_propertyFile
{
	 static int TCID=001;
	LoginPage1 login;
	PinPage_2 pin;
	Homepage_3 home;
	@BeforeClass
	public void launceApplicationKite() throws IOException 
	{
		launchBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		login=new LoginPage1(driver);
		pin=new PinPage_2(driver);
		home=new Homepage_3(driver);
	}
	@BeforeMethod
	
		public void loginToKiteApp() throws EncryptedDocumentException, IOException, InterruptedException
		{
			login.enterUserId(UtilityClass_using_PropertyFie.propertyFile("UN"));
			login.enterPassword(UtilityClass_using_PropertyFie.propertyFile("PWD"));
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
			
			login.clickOnLoginButton();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
			pin.enterPINno(UtilityClass_using_PropertyFie.propertyFile("PIN"));
			pin.clickSubmitButton();
		}
	
	@Test
  public void validateUserName() throws EncryptedDocumentException, IOException
	{
		int TCID=001;
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		String actualUserId = home.getactualUserId();
		String expectedUserId =UtilityClass_using_PropertyFie.propertyFile("UN");
		
		//assert
		Assert.assertEquals(actualUserId, expectedUserId, "user id are not same");
		//screenshot
		maven2_utility.UtilityClass_ExcelSheet.takeScreenshot(driver, TCID);
		Reporter.log("Validated UserName", true);
  }
	@AfterMethod
	public void logoutFromKiteAppBrowser(ITestResult result) throws IOException, InterruptedException 
	{
		home.clickOnLogOutButton();
		Reporter.log("Logging out.....", true);
	}
	@AfterClass
	public void browserClosing() throws InterruptedException
	{
		closeBrowser();
	}
}
