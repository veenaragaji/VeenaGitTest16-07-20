package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

//import com.aventstack.extentreports.gherkin.model.Scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import testBase.BaseClass;

public class Hooks extends BaseClass {
	//WebDriver driver;
	@Before
	public void initialize(Scenario s) throws IOException{
		System.out.println("Before hook executed");
		driver=getDriverConfig();
		scenarios=features.createNode(s.getName());
		
	}
	
	@After
	public void tearDown(Scenario s) throws IOException{
		System.out.println("After hook executed-"+s.getStatus()+"-"+s.getStatus());
		System.out.println(s.getName());
		if(s.getStatus().equals("failed")){
			scenarios.fail("This scenario has been failed").addScreenCaptureFromPath(getScreenShotTest());
			driver.close();
		}
		//driver.close();
		//System.out.println("After hook executed");
	}
}
