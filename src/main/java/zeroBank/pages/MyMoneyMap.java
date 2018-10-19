package zeroBank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import zeroBank.base.TestBase;

public class MyMoneyMap extends TestBase {
	// class for the Money Map Page at the url:
	// http://zero.webappsecurity.com/bank/money-map.html
	
	// Object repository
	
	///// TOP CONTAINER ///////
	@FindBy(linkText="Zero Bank") // logo on top left
	WebElement zeroLogo;
	
	@FindBy(id="searchTerm")
	WebElement searchBox; // search field
	
	@FindBy(className="dropdown-toggle")
	WebElement settingsTab;
	
	@FindBy(linkText="Account Settings")
	WebElement accountSettings; // drops down from settings tab
	
	@FindBy(partialLinkText="Privacy Settings")
	WebElement privacySettings; // drops down from settings tab
	
	@FindBy(id="help_link")
	WebElement helpLink; // drops down from settings tab
	
	@FindBy(xpath="//div[@id='settingsBox']/ul/li[3]/a")
	WebElement userTab; // drop down menu
	
	@FindBy(linkText="My Profile")
	WebElement myProfile; //drops down from userTab
	
	@FindBy(id="logout_link")
	WebElement logout; // drops down from userTab
	
	
	///// FROM THE MAIN APPS CONTAINER  ////
	@FindBy(linkText="Account Summary")
	WebElement accountSummary;
	
	@FindBy(linkText="Account Activity")
	WebElement accountActivity;
	
	@FindBy(linkText="Transfer Funds")
	WebElement transferFunds;
	
	@FindBy(linkText="Pay Bills")
	WebElement payBills;
	
	@FindBy(linkText="Online Statements")
	WebElement onlineStatements;
	
	
	//// FROM INFLOW TABLE /////
	@FindBy(id="tool-1032-toolEl")
	WebElement collapseInflow;
	
	@FindBy(linkText="Subject: Deposits")
	WebElement collapseDeposits;
	
	
	//// FROM OUTFLOW TABLE ////
	@FindBy(id="tool-1033-toolEl")
	WebElement collapseOutflow;
	
	@FindBy(linkText="Subject: Spendings")
	WebElement collapseSpendings;
	
	
	//// FROM CREDIT CARDS TABLE
	@FindBy(id="tool-1034-toolEl")
	WebElement collapseCreditCardsTable;
	
	@FindBy(linkText="Subject: Credit Cards")
	WebElement collapseCreditCardPayments;
	
	
	//// FROM SUMMARY TABLE
	@FindBy(id="tool-1035-toolEl")
	WebElement collapseSummary;
	
	
	//// FROM THE BIG PIE ///////
	@FindBy(id="ext-sprite-1259")
	WebElement retailWedge;
	
	@FindBy(id="ext-sprite-1276")
	WebElement householdWedge;
	
	@FindBy(id="ext-sprite-1263")
	WebElement insuranceWedge;
	
	@FindBy(id="ext-sprite-1265")
	WebElement officeSupplyWedge;
	
	@FindBy(id="ext-sprite-1267")
	WebElement restaurantsWedge;
	
	@FindBy(id="ext-sprite-1269")
	WebElement telecomWedge;
	
	@FindBy(id="ext-sprite-1251")
	WebElement transportationWedge;
	
	@FindBy(id="ext-sprite-1253")
	WebElement autoWedge;
	
	@FindBy(id="ext-sprite-1255")
	WebElement charityWedge;
	
	@FindBy(id="ext-sprite-1257")
	WebElement checksWrittenWedge;
	
	@FindBy(xpath=".//*[contains(text(),'Transportation') and @dy='3.5']")
	WebElement transportationButton;
	
	@FindBy(xpath=".//*[contains(text(),'Auto') and @dy='3.5']")
	WebElement autoButton;
	
	@FindBy(xpath=".//*[contains(text(),'Charity') and @dy='3.5']")
	WebElement charityButton;
	
	@FindBy(xpath=".//*[contains(text(),'Checks Written') and @dy='3.5']")
	WebElement checksWrittenButton;
	
	@FindBy(xpath=".//*[contains(text(),'Retail') and @dy='3.5']")
	WebElement retailButton;
	
	@FindBy(xpath=".//*[contains(text(),'Household') and @dy='3.5']")
	WebElement householdButton;
	
	@FindBy(xpath=".//*[contains(text(),'Insurance') and @dy='3.5']")
	WebElement insuranceButton;
	
	@FindBy(xpath=".//*[contains(text(),'Office Supply') and @dy='3.5']")
	WebElement officeSupplyButton;
	
	@FindBy(xpath=".//*[contains(text(),'Restaurants') and @dy='3.5']")
	WebElement restaurantsButton;
	
	@FindBy(xpath=".//*[contains(text(),'Telecom') and @dy='3.5']")
	WebElement telecomButton;
	
	
	
	@FindBy(id="gridcolumn-1018-titleEl")
	WebElement sortOutflowTable;  ///
	
	
	//// Wedge Texts \\\\\\\\\\\
	//// These are arranged from 3oclock going counter clockwise around
	@FindBy(id="ext-sprite-1271")
	WebElement wedge1;
	
	@FindBy(id="ext-sprite-1272")
	WebElement wedge2;
	
	@FindBy(id="ext-sprite-1273")
	WebElement wedge3;
	
	@FindBy(id="ext-sprite-1274")
	WebElement wedge4;
	
	@FindBy(id="ext-sprite-1275")
	WebElement wedge5;
	
	@FindBy(id="ext-sprite-1276")
	WebElement wedge6;
	
	@FindBy(id="ext-sprite-1277")
	WebElement wedge7;
	
	@FindBy(id="ext-sprite-1278")
	WebElement wedge8;
	
	@FindBy(id="ext-sprite-1279")
	WebElement wedge9;
	
	@FindBy(id="ext-sprite-1280")
	WebElement wedge10;
	
	
	
	
	public MyMoneyMap() {
		// page constructor
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	
	public boolean verifyTitle() {
		// returns true if the page is correct
		// else returns false
		return (driver.getTitle().equals("Zero - My Money Map"));
		
	}
	
	public boolean verifyZeroLogo() {
		// returns true (false) if the logo is (is not) displayed
		return zeroLogo.isDisplayed();
				
	}
	
	
	// navigator methods
	public AccountSummary clickAccountSummary() {
		accountSummary.click();
		return new AccountSummary();
	}
	
	public AccountActivity clickAccountActivity() {
		accountActivity.click();
		return new AccountActivity();
	}
	
	public HomePage clickZeroLogo() {
		zeroLogo.click();
		return new HomePage();
	}
	
	public PayBillsPage clickPayBills() {
		payBills.click();
		return new PayBillsPage();
	}
	
	
	
	// Big pie methods
	public boolean isDisplayedOnPie(String wedgeName) {
		// method for determining if a particular wedge is displayed
		// see below for appropriate keywords
		
		boolean result;
		switch(wedgeName) {
		
		case "transportation" : result = transportationWedge.isDisplayed();
		                        break;
		case "auto"           : result = autoWedge.isDisplayed();
		                        break;
		case "charity"        : result = charityWedge.isDisplayed();
		                        break;
		case "checks written" : result = checksWrittenWedge.isDisplayed();
		                        break;
		case "retail"         : result = retailWedge.isDisplayed();
		                        break;
		case "household"      : result = householdWedge.isDisplayed();
		                        break;
		case "insurance"      : result = insuranceWedge.isDisplayed();
		                        break;
		case "office supply"  : result = officeSupplyWedge.isDisplayed();
		                        break;
		case "restaurants"    : result = restaurantsWedge.isDisplayed();
		                        break;
		case "telecom"        : result = telecomWedge.isDisplayed();
		                        break;
		default               : result = false;
								System.out.println("No such wedge");
		                        break;
		}
		
		return result;
		
	}
	
	public void toggleWedge(String wedgeName) {
		// toggles the given wedge on and off
		// see below for appropriate keywords
		
		switch(wedgeName) {
		
		case "transportation" : transportationButton.click();
								transportationButton = driver.findElement(By.xpath(".//*[contains(text(),'Transportation') and @dy='3.5']"));
		                        break;
		case "auto"           : autoButton.click();
								autoButton = driver.findElement(By.xpath(".//*[contains(text(),'Auto') and @dy='3.5']"));
		                        break;
		case "charity"        : charityButton.click();
								charityButton = driver.findElement(By.xpath(".//*[contains(text(),'Charity') and @dy='3.5']"));
		                        break;
		case "checks written" : checksWrittenButton.click();
								checksWrittenButton = driver.findElement(By.xpath(".//*[contains(text(),'Checks Written') and @dy='3.5']"));
		                        break;
		case "retail"         : retailButton.click();
								retailButton = driver.findElement(By.xpath(".//*[contains(text(),'Retail') and @dy='3.5']"));
		                        break;
		case "household"      : householdButton.click();
								householdButton = driver.findElement(By.xpath(".//*[contains(text(),'Household') and @dy='3.5']"));
		                        break;
		case "insurance"      : insuranceButton.click();
								insuranceButton = driver.findElement(By.xpath(".//*[contains(text(),'Insurance') and @dy='3.5']"));
		                        break;
		case "office supply"  : officeSupplyButton.click();
								officeSupplyButton = driver.findElement(By.xpath(".//*[contains(text(),'Office Supply') and @dy='3.5']"));
		                        break;
		case "restaurants"    : restaurantsButton.click();
								restaurantsButton = driver.findElement(By.xpath(".//*[contains(text(),'Restaurants') and @dy='3.5']"));
		                        break;
		case "telecom"        : telecomButton.click();
								telecomButton = driver.findElement(By.xpath(".//*[contains(text(),'Telecom') and @dy='3.5']"));
		                        break;
		default               : System.out.println("No such wedge");
		                        break;
		}
		
	}
	
	
	
	public void toggleTables(String tableName) {
		// clicks the display/collapse buttons on the four tables
		switch(tableName) {
		
		case "inflow"   : collapseInflow.click();       // "Inflow"
		                  break;
		case "outflow"  : collapseOutflow.click();     // "OutFlow"
		                  break;
		case "payments" : collapseCreditCardsTable.click(); /// "Payments made from..."
		                  break;
		case "summary"  : collapseSummary.click();     // "Summary"
		                  break;
		default         : System.out.println("No such table");
		                  break;
		                  
		}
	}
	
	public HomePage logOut() {
		userTab.click();
		logout.click();
		return new HomePage();
	}
	
	
	public void toggleOutFlowTableSort() {
		sortOutflowTable.click();
	}
	
	public String getWedge1Text() {
		return wedge1.getAttribute("text");
	}
	
}
