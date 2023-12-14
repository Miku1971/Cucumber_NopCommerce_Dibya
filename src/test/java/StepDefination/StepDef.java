package StepDefination;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Asserts;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pom.AddNewCustomer;
import Pom.Loginpage;
import Utilities.Readconfig;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends Baseclass
{

@Before
public void setup() 
{
	readconfig=new Readconfig();
	
	log=org.apache.logging.log4j.LogManager.getLogger("StepDef");
	String browser=readconfig.getBrowser();
	switch (browser.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		
	case "msedge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		
		default:
			driver=null;
			break;
}
	//WebDriverManager.chromedriver().setup();
	//driver=new ChromeDriver();
	
}


@Given("User launch Chrome browser")
public void user_launch_chrome_browser() 
{
	
	loginpg=new Loginpage(driver);
	addnewcustpg=new AddNewCustomer(driver);
	log.info("browser is launched");
}

@When("User enter Email as {string} and Password as {string}")
public void user_enter_email_as_and_password_as(String email2, String pwd2) 
{
	loginpg.enteremailaddress(email2); 
	   loginpg.enterpassword(pwd2);
	   log.info("user enter email and password");
    
}

@When("click on Login button")
public void click_on_login_button() 
{
	loginpg.clickonloginbutton();
	log.info("user click on log in button");
    
}


















//@Given("User launch the Chrome browser")
public void user_launch_the_chrome_browser() 
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	loginpg=new Loginpage(driver);
	addnewcustpg=new AddNewCustomer(driver);
}

@When("User open URL {string}")
public void user_open_url(String url) 
{
    driver.get(url);
    log.info("url is opened");
}

//@When("User give Email as {string} and Password as {string}")
public void user_give_email_as_and_password_as(String email2, String pwd2) 
{
   loginpg.enteremailaddress(email2); 
   loginpg.enterpassword(pwd2);
}

@When("click on Login")
public void click_on_login() 
{
	loginpg.clickonloginbutton();
    
}

@Then("page title should be {string}")
public void page_title_should_be(String expectedTitle) 
{
	String actualTitle=driver.getTitle();
	if(actualTitle.equals(expectedTitle))
	{
	org.junit.Assert.assertTrue(true);
	}
	else 
	{
		org.junit.Assert.assertTrue(false);
		
	}
    
}

@When("User click on Logout link")
public void user_click_on_logout_link() 
{
loginpg.clickonlogoutbutton();
    
}

@Then("close browser")
public void close_browser() 
{
    driver.close();
   // driver.quit();
}


////////////////////////////////////AddnewCustomer///////////////////////


@Then("User view the dashboard")
public void user_view_the_dashboard() 
{
  String actualTitle=addnewcustpg.getPageTitle();
  String expectedTitle="Dashboard / nopCommerce administration";
  if(actualTitle.equals(expectedTitle))
  {
	  
	  org.junit.Assert.assertTrue(true);
	  log.warn("page title matched");
  }
  else 
  {
	org.junit.Assert.assertTrue(false);
	log.info("test failed");
  }
}

@When("User click on the Customer menu")
public void user_click_on_the_customer_menu() 
{
 addnewcustpg.clickoncustomermenu();
}

@When("click on the Customer menu item")
public void click_on_the_customer_menu_item() 
{
	addnewcustpg.clickoncustomeritem();
   
}

@When("click on Add new button")
public void click_on_add_new_button() 
{
    addnewcustpg.clickonaddnewbutton();
}

@Then("User can view Add a new customer page")
public void user_can_view_add_a_new_customer_page() 
{
  String actualtitle=addnewcustpg.getPageTitle();
  String expectedtitle="Add a new customer / nopCommerce administration";
  if(actualtitle.equals(expectedtitle)) 
  {
	 org.junit.Assert.assertTrue(true); 
  }
  else 
  {
	  org.junit.Assert.assertTrue(false);
	  
  }
  
}

@When("User enter all Customer info")
public void user_enter_all_customer_info() 
{
  
	//addnewcustpg.entercustomeremail("subham909090@gmail.com");
	addnewcustpg.entercustomeremail(generateEmailId() + "@gmail.com");
	addnewcustpg.entercustomerpassword("test1");
	addnewcustpg.entercustomerfirstname("subham");
	addnewcustpg.entercustomerlastname("mohanty");
	addnewcustpg.entergender("Male");
	addnewcustpg.enterdob("06/12/1995");
	addnewcustpg.entercompanyname("tatamotors");
	addnewcustpg.entermanagervendor("Vendor 1");
	addnewcustpg.enteradmincomment("admincmnt");
	
	}

@When("click on Save button")
public void click_on_save_button() 
{
	addnewcustpg.clickonsavebutton();
    
}

@Then("User can view the Confirmation message {string}")
public void user_can_view_the_confirmation_message(String expectedconfirmationmessage) 
{
    String bodyTagText=driver.findElement(By.tagName("Body")).getText();
    if(bodyTagText.contains(expectedconfirmationmessage))
    {
    	org.junit.Assert.assertTrue(true);
    }
    else 
    {
    	org.junit.Assert.assertTrue(false);
    	
    }
    
}

//@After
public void teardown(Scenario sc) throws IOException 
{
	if(sc.isFailed()==true) 
	{
		String filewithpath="C:\\Users\\DELL\\eclipse-workspace\\Cucumber_v1\\Screenshot\\test1.png";
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(filewithpath);
		FileUtils.copyFile(src, dest);
	}
	
	driver.quit();
}

//TakesScreenshot screenshot=((TakesScreenshot)driver);
//File src=screenshot.getScreenshotAs(OutputType.FILE);
//File dest=new File(filewithpath);
//FileUtils.copyFile(src, dest);

@AfterStep
public void addscreenshot(Scenario sc) 
{
	 
	if(sc.isFailed()) {
		final byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(screenshot, "image/png", sc.getName());
	}
}

@After
public void teardown() 
{
	driver.quit();
	
}


	
	
	
	
	
	
	
	
	
	
}
