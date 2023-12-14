package Testrunner;

import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;

//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		 
	features=".//Features/Customers.feature",
		
	glue="StepDefination",
		dryRun=false,
		monochrome=true,
		tags="@sanity",
		//plugin= {"pretty","html:target/cucumber-reports/report1.html"}
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

//plugin= {"pretty","json:target/cucumber-reports/report2.json"}
//plugin= {"pretty","junit:target/cucumber-reports/report1_xml.xml"}
//features=	".//Features/",

public class Run extends AbstractTestNGCucumberTests

{
	
}
