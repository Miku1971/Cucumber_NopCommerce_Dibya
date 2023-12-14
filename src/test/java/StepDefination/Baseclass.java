package StepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import Pom.AddNewCustomer;
import Pom.Loginpage;
import Utilities.Readconfig;

public class Baseclass 
{

	public WebDriver driver;

	public Loginpage loginpg;

	public AddNewCustomer addnewcustpg;
	
	public static Logger log;
	
	public Readconfig readconfig;
	
	public String generateEmailId() 
	{
		return (RandomStringUtils.randomAlphabetic(6));
		
	}
	
}
