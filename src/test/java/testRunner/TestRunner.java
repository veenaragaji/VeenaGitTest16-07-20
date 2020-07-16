package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/*@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features",glue={"stepDefinition"},tags="@Login")
public class TestRunner {

}*/

//To run with TestNG suite
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features",glue={"stepDefinition"},format={"html:htmlReport","json:jsonReports/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
