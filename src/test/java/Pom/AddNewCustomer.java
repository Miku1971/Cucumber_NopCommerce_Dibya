package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomer 
{
	
	
	WebDriver ldriver;
	public AddNewCustomer(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]")
	WebElement customermenu;
	
	@FindBy(xpath = "//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]")
	WebElement customeritem;
	
	@FindBy(xpath = "//body/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]")
	WebElement addnewbutton;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement customeremail;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement customerpassword;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement customerfirstname;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement customerlastname;
	
	@FindBy(id="Gender_Male")
	WebElement gendermale;
	
	@FindBy(id="Gender_Female")
	WebElement genderfemale;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement dob;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyname;
	
	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement managerofvendor;
	
	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement admincomment;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement savebutton;
	
	public String getPageTitle() 
	{
		return ldriver.getTitle();
	}
	
	public void clickoncustomermenu() 
	{
		customermenu.click();
	}
	
	public void clickoncustomeritem() 
	{
		customeritem.click();
	}
	
	public void clickonaddnewbutton() 
	{
		addnewbutton.click();;
	}
	
	public void entercustomeremail(String email3)
	{
		customeremail.sendKeys(email3);;
	}
	
	public void entercustomerpassword(String pwd3)
	{
		customerpassword.sendKeys(pwd3);
	}
	
	public void entercustomerfirstname(String fname)
	{
		customerfirstname.sendKeys(fname);
	}
	
	public void entercustomerlastname(String lname)
	{
		customerlastname.sendKeys(lname);
	}
	
	
	
	public void entergender(String gender) 
	{
		if(gender.equals("Male")) 
		{
			gendermale.click();
			
		}
		
		else if (gender.equals("Female")) 
		{
			genderfemale.click();
		}
		
		else {
			gendermale.click();
		}
		
	}
	
	public void enterdob(String dob1)
	{
		dob.sendKeys(dob1);
	}
	
	public void entercompanyname(String companyname1)
	{
		companyname.sendKeys(companyname1);
	}
	
	public void entermanagervendor(String value)
	{
		Select sel=new Select(managerofvendor);
		sel.selectByVisibleText(value);
	}
	
	public void enteradmincomment(String comment)
	{
		admincomment.sendKeys(comment);
	}
	
	public void clickonsavebutton()
	{
		savebutton.click();
	}
	
	
	
	
	
	
	
	

}
