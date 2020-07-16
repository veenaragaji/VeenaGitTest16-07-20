package customListeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.markuputils.Markup;

import gherkin.formatter.model.Scenario;
import testBase.BaseClass;

public class BDDListener extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start executed");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On Test Success executed");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("OnTest Failure started");
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String path=System.getProperty("user.dir")+"//Screenshots/"+methodName+"/"+System.currentTimeMillis()+".png";
		String path=System.getProperty("user.dir")+"//"+System.currentTimeMillis()+".png";
		//String path=System.getProperty("user.dir")+"//Screenshots.png";
		
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			try {
				throw e;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		try {
			scenarios.fail("This scenario has Failed").addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("OnTest Failure executed");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On Test skip executed");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On  onTestFailedButWithinSuccessPercentage executed");
		
	}

	public void onStart(ITestContext context) {
		System.out.println("On  OnStart executed");
		
		report=getExtentReport();
		features=report.createTest(Feature.class,"Feature-Demo Test Framework");
		
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("On  OnFinish executed");
		
		//features.log(Status.PASS, "Feature finished");
		report.flush();
		System.out.println("Report flushed");
		//driver.close();
		driver.quit();
	}

	

}
