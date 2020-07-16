package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Timestamp;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.message.TimestampMessage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.Utf8;
import com.mongodb.internal.connection.Time;

public class BaseClass {
	public static WebDriver driver ;
	public Properties prop;
	public static ExtentReports report;
	public static ExtentHtmlReporter reporter;
	public static ExtentTest test;
	public static ExtentTest features;
	public static ExtentTest scenarios;
	
	
	public WebDriver getDriverConfig() throws IOException{
		String path=System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(path+"\\src\\main\\java\\properties\\config.properties");
		prop=new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("Browser");
		
		if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver",
					path+"\\src\\main\\java\\executables\\geckodriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver",
					path+"\\src\\main\\java\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		
		
		return driver;
	}
	@SuppressWarnings("deprecation")
	public ExtentReports getExtentReport(){
		String path = System.getProperty("user.dir") + "//ExtentReports/index.html";
		reporter = new ExtentHtmlReporter(path);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setEncoding("utf-8");
		reporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		reporter.config().setDocumentTitle("Basic Extent Report");
		reporter.config().setReportName("Demo Report");
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("tester", "veena");
		return report;
	}
	public String getScreenShot(String methodName,WebDriver driver) throws IOException{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String path=System.getProperty("user.dir")+"//Screenshots/"+methodName+"/"+System.currentTimeMillis()+".png";
		String path=System.getProperty("user.dir")+"//Screenshots/"+methodName+"/"+System.currentTimeMillis()+".png";
		//String path=System.getProperty("user.dir")+"//Screenshots.png";
		
		FileUtils.copyFile(source, new File(path));
		return path;
		
	}
	public String getScreenShotTest() throws IOException{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String path=System.getProperty("user.dir")+"//Screenshots/"+methodName+"/"+System.currentTimeMillis()+".png";
		String path=System.getProperty("user.dir")+"//Screenshots/"+"/"+System.currentTimeMillis()+".png";
		//String path=System.getProperty("user.dir")+"//Screenshots.png";
		
		FileUtils.copyFile(source, new File(path));
		return path;
		
	}
}
