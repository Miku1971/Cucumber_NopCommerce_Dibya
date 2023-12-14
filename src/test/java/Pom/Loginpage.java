package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{

	
	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	WebElement emailtxtfield;
	
	@FindBy(id="Password")
	WebElement passwordtxtfield;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement Loginbutton;
	
	@FindBy(linkText = "Logout")
	WebElement logoutbutton;
	
	
	public void enteremailaddress(String email1) 
	{
		emailtxtfield.clear();
		emailtxtfield.sendKeys(email1);
	}
	
	
	public void enterpassword(String password1) 
	{
		passwordtxtfield.clear();
		passwordtxtfield.sendKeys(password1);
		
	}
	
	public void clickonloginbutton() 
	{
		Loginbutton.click();
	}
	
	public void clickonlogoutbutton() 
	{
		logoutbutton.click();
	}
	
	
	
	
	
	
	
	
	
	
}
