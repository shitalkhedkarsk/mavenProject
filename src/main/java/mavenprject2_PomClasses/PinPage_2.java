package mavenprject2_PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinPage_2
{//1.locator
	//1.variables declare
		@FindBy(xpath = "//input[@id='pin']") private WebElement enterPin;
		@FindBy(xpath = "//button[@type='submit']") private WebElement submitButton;
		//2.constructor
		public PinPage_2 (WebDriver driver)
		{
		PageFactory.initElements(driver, this);	
		}
		//3.methods
		public void enterPINno(String pin)
		{
			enterPin.sendKeys(pin);
		}
		public void clickSubmitButton()
		{
			submitButton.click();
		}
	
}
