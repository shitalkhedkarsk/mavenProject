package mavenprject2_PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 
{
	//1.Find locator 
	@FindBy(id = "userid") private WebElement userId;
	@FindBy(id = "password") private WebElement password;
	@FindBy(xpath = "//button[@type='submit']") private WebElement loginButton;
	@FindBy(xpath = "//span[contains(text(),'User ID should be')]") private WebElement errorMsg;
	//@FindBy(xpath = "//span[contains(text(),'Password should be ')]") private WebElement pwdErrorMsg;
	//2.constructor for pagefactory
	public LoginPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//3.method
	public void enterUserId(String uid) 
	{
		userId.sendKeys(uid);
	}
	public void enterPassword(String pw)
	{
		password.sendKeys(pw);
	}
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	public String getUserIdErrorMsg()
	{
		String errormsg = errorMsg.getText();
		return errormsg;
		
	}
//	public String getErrorMsgforPwd()
//	{
//		String actualPwdErrorMsg = pwdErrorMsg.getText();
//		return actualPwdErrorMsg;
//	}
	
	
	
}
