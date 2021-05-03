package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class executeTest {

	String driverPath = "C:\\chromedriver.exe";
	WebDriver driver;
	Exercise objects;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.exercise1.com/values");

	}

	/**
	 * 
	 * This test case will go to url https://www.exercise1.com/values and check for
	 * the text values and perform validations
	 * 
	 */

	@Test(testName = "verify values displayed", priority = 0, enabled = true)
	public void verify_Values_Displayed() {
		try {
			objects = new Exercise(driver);
			Assert.assertTrue(objects.checkValuePresentOnScreen(objects.value1), "Value1 is displayed");
			Assert.assertTrue(objects.checkValuePresentOnScreen(objects.value2), "Value2 is displayed");
			Assert.assertTrue(objects.checkValuePresentOnScreen(objects.value3), "Value3 is displayed");
			Assert.assertTrue(objects.checkValuePresentOnScreen(objects.value4), "Value4 is displayed");
			Assert.assertTrue(objects.checkValuePresentOnScreen(objects.value4), "Value5 is displayed");
			Assert.assertTrue(objects.checkValuePresentOnScreen(objects.totalValue), "Total Balance is displayed");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			driver.quit();		
		}
	}

	@Test(testName = "verify values are greater than 0", priority = 1, enabled = true)
	public void verify_Values_Greater_Than_Zero() {
		try {
			Assert.assertTrue(objects.valueGreaterThanZero(objects.value1), "Value1 is greater than 0");
			Assert.assertTrue(objects.valueGreaterThanZero(objects.value2), "Value2 is greater than 0");
			Assert.assertTrue(objects.valueGreaterThanZero(objects.value3), "Value3 is greater than 0");
			Assert.assertTrue(objects.valueGreaterThanZero(objects.value4), "Value4 is greater than 0");
			Assert.assertTrue(objects.valueGreaterThanZero(objects.value5), "Value5 is greater than 0");
			Assert.assertTrue(objects.valueGreaterThanZero(objects.totalValue), "totalValue is greater than 0");
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}
	}

	@Test(testName = "verify total balance is correct", priority = 2, enabled = true)
	public void verify_Total_Balance() {
		try {
			Assert.assertTrue(objects.valueMatches(objects.totalValue, 1000000.00), "Total Balance matches");
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}
	}

	@Test(testName = "verify total balance matches sum of values", priority = 3, enabled = true)
	public void verify_Total_Balance_Matches_Sum_Of_Values() throws Exception {

		Assert.assertTrue(objects.totalBalanceMatchesSum(), "Total Balance matches the sum of values");

	}

	@Test(testName = "verify currencies", priority = 4,  enabled = true)

	public void verify_Currenncy() throws Exception {
		try {
			Assert.assertTrue(objects.verifyCurrency(objects.value1));
			Assert.assertTrue(objects.verifyCurrency(objects.value2));
			Assert.assertTrue(objects.verifyCurrency(objects.value3));
			Assert.assertTrue(objects.verifyCurrency(objects.value4));
			Assert.assertTrue(objects.verifyCurrency(objects.value5));
			Assert.assertTrue(objects.verifyCurrency(objects.totalValue));
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}
	}
}
