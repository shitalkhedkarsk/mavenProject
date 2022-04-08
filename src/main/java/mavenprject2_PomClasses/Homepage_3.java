package mavenprject2_PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_3
{
	//variable
		@FindBy(xpath = "//span[@class='user-id']") private WebElement UserIDno;
		@FindBy(xpath = "//a[@target='_self']") private WebElement logOut;
		//2.constructor
		public  Homepage_3 (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//3.method
		public String getactualUserId()
		{
			
			String actualUserId = UserIDno.getText();
			return actualUserId;
			 
		}
		
		public void clickOnLogOutButton() throws InterruptedException
		{
			UserIDno.click();
			Thread.sleep(500);
			logOut.click();
		}

}
