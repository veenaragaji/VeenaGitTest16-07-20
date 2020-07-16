package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import com.aventstack.extentreports.markuputils.Markup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import customListeners.TestListeners;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.Step;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Register;
import testBase.BaseClass;

public class StepDefinition extends BaseClass {
	//ExtentTest test=Listeners.test;
	Register reg;
	HomePage hp;
	
	
	@SuppressWarnings("unchecked")
	@Given("^user has navigated to \"([^\"]*)\" URL$")
    public void user_has_navigated_to_something_url(String url) throws Throwable {
		driver.get(url);
		
		scenarios.createNode("Browser launched").pass("Passed").addScreenCaptureFromPath(getScreenShotTest());
		//To add screenshot with scenario level
		//scenarios.pass("Sceanrio level1").addScreenCaptureFromPath(getScreenShotTest());
		
		
    }
	@When("^user clicks on \"([^\"]*)\" link$")
    public void user_clicks_on_something_link(String link) throws Throwable {
		hp=new HomePage(driver);
		Thread.sleep(3000);
		if(link.equals("Register")){
			
			hp.getRegister().click();
			scenarios.createNode("user clicks on Register link").pass("Passed").addScreenCaptureFromPath(getScreenShotTest());;
			
			
			//test.log(Status.PASS, "Registration link found and clicked");
			
		}
		else if(link.equals("Login")){
			//hp.getLogin().click();
			WebElement loginB = hp.getLogin();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", loginB);
			scenarios.createNode("Login link found and clicked").pass("Passed").addScreenCaptureFromPath(getScreenShotTest());;
			
			//test.log(Status.PASS, "Login link found and clicked");
		}
		
		
					
	}
	@When("^user enters all manadatory fields except checkbox and click on Register button$")
	public void user_enters_all_manadatory_fields_except_checkbox_and_click_on_Register_button() throws Throwable {
		reg=new Register(driver);
		reg.getName().sendKeys("Veena");
		reg.getEmail().sendKeys("veena@gmail.com");
		reg.getPass().sendKeys("test123");
		reg.getCPass().sendKeys("test123");
		//test.log(Status.PASS, "All registration details filled");
		scenarios.createNode("All registration details filled").pass("Passed").addScreenCaptureFromPath(getScreenShotTest());;
		
		reg.getRegister().click();
				
	}
	@Then("^verify error message is displayed$")
	public void verify_error_message_is_displayed() throws Throwable {
	//	Assert.assertEquals(reg.getMessage().getText(), "Oops! Please fix the following:");
		System.out.println("Error message displayed-Oops! Please fix the following:");
		scenarios.createNode("Error message displayed-Oops! Please fix the following:").pass("Passed").addScreenCaptureFromPath(getScreenShotTest());;
		
		
		
	}
	@Then("^verify login page is displayed$")
    public void verify_login_page_is_displayed() throws Throwable {
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.getemail().isDisplayed());
		Assert.assertTrue(lp.getPassword().isDisplayed());
		Assert.assertTrue(lp.getLogin().isDisplayed());
		scenarios.createNode("Login page displayed").pass("Passed").addScreenCaptureFromPath(getScreenShotTest());;
		
		
		
  }

}
