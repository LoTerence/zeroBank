package zeroBank.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.host.Window;

import zeroBank.base.TestBase;
import zeroBank.pages.AccountSummary;
import zeroBank.pages.HomePage;
import zeroBank.pages.LoginPage;
import zeroBank.pages.MyMoneyMap;
import zeroBank.util.TestUtil;

public class LogoutSecurityTest extends TestBase {
	
	
	AccountSummary accountSummary;
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	MyMoneyMap myMoneyMap;
	
	public LogoutSecurityTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = homePage.clickSignIn();
		//accountSummary = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	// test to see if sign out is done correctly
	@Test(priority=1)
	public void verifyUserLoggedOut() {
		accountSummary = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		homePage = accountSummary.logout();
		Assert.assertTrue(homePage.signInDisplayed(), "Logout was not successful");
	}
	
	// test to see if information can be accessed using the browser back button
	@Test
	public void backButtonAfterLogout() {
		accountSummary = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		homePage = accountSummary.logout();
		driver.navigate().back();
		Assert.assertEquals(driver.getTitle(), "Zero - Log in");
	}
	
	// check to see if autocomplete is turned off on username and password fields
	@Test
	public void validateAutoCompleteIsOff() {
		boolean flag;
		if(loginPage.checkPasswordAutoComplete() || loginPage.checkUserNameAutoComplete()) {
			flag = true;
		} else {
			flag = false;
		}
		
		Assert.assertFalse(flag, "Autocomplete is enabled for login fields");
	}
	
	// check to see if new tabs remain signed in
	@Test
	public void checkNewTabLogout() throws InterruptedException, AWTException {
		accountSummary = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		
		// open second tab and navigate to zerobank
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		
		Thread.sleep(1000);
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
		
		// return to previous tab
		driver.switchTo().window(tabs.get(0));
		accountSummary.logout();
		
		Thread.sleep(1000);
		// navigate to other tab and attempt to access restricted data
		driver.switchTo().window(tabs.get(1));
		homePage = new HomePage();
		myMoneyMap = homePage.clickMyMoneyMapLink();
		Assert.assertTrue(driver.getTitle().contentEquals("Zero - Log in"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
