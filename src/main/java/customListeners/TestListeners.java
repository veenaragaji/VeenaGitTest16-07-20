package customListeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import testBase.BaseClass;

public class  TestListeners extends BaseClass implements ITestListener{
	public static ExtentTest test;
	ExtentReports report=getExtentReport();
	//ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());	
		
		//extentTest.set(test);	
		System.out.println("Test Listener OnTest Start executed - "+result.getMethod().getMethodName());
		//extentTest.get().log(Status.PASS, "Test execution started through listener"+result.getMethod().getMethodName());
		test.log(Status.PASS, "Test execution started through listener"+result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//	test.log(Status.PASS, "Passed-"+result.getMethod().getMethodName());
		//For Thread safe- use below
		test.log(Status.PASS, "Passed-"+result.getMethod().getMethodName());
		System.out.println("Test Listener Test successfully executed - "+result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String path = "";
		String methodName=result.getMethod().getMethodName();
		/*WebDriver driver = null;
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e2) {
			e2.printStackTrace();
		} */
		try {
			path = getScreenShot(methodName,driver);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			test.log(Status.FAIL, "Failed-"+result.getMethod().getMethodName()+MediaEntityBuilder.createScreenCaptureFromPath(path));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test Listener Test faied - "+result.getMethod().getMethodName());
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		test.log(Status.PASS, "Test execution finished");
		report.flush();
		System.out.println("Test Listener Report flushed - "+context.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
}