package zeroBank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import zeroBank.base.TestBase;

public class PayBillsPage extends TestBase {

	//tab links
	@FindBy(xpath = ".//*[@id=\"tabs\"]/ul/li[1]/a")
	WebElement paySavedPayeeLink;
	
	@FindBy(xpath = ".//*[@id=\"tabs\"]/ul/li[2]/a")
	WebElement addNewPayeeLink;
	
	@FindBy(xpath = ".//*[@id=\"tabs\"]/ul/li[3]/a")
	WebElement purchaseForCurrLink;
	
	//success message
	@FindBy(id = "alert_content")
	WebElement alertMessage;
	
	//pay saved payee tab elements
	@FindBy(xpath = ".//*[@id=\"ui-tabs-1\"]/h2")
	WebElement paySavedPayeeHeader;
	
	@FindBy(xpath = ".//*[@id=\"sp_payee\"]")
	WebElement payeeSelect;
	
	@FindBy(xpath = ".//*[@id=\"sp_get_payee_details\"]")
	WebElement payeeDetailButton;
	
	@FindBy(xpath = ".//*[@id=\"sp_account\"]")
	WebElement accountSelect;
	
	@FindBy(xpath = ".//*[@id=\"sp_amount\"]")
	WebElement amountInput;
	
	@FindBy(xpath = ".//*[@id=\"sp_date\"]")
	WebElement dateInput;
	
	@FindBy(xpath = ".//*[@id=\"sp_description\"]")
	WebElement descrInput;
	
	@FindBy(xpath = ".//*[@id=\"pay_saved_payees\"]")
	WebElement payButton;
	
	//add new payee tab elements
	@FindBy(xpath = ".//*[@id=\"ui-tabs-2\"]/h2") 
	WebElement addNewPayeeHeader;
	
	@FindBy(xpath = ".//*[@id=\"np_new_payee_name\"]")
	WebElement payeeNameInput;

	@FindBy(xpath = ".//*[@id=\"np_new_payee_address\"]")
	WebElement payeeAddressInput;
	
	@FindBy(xpath = ".//*[@id=\"np_new_payee_account\"]")
	WebElement payeeAccountInput;
	
	@FindBy(xpath = ".//*[@id=\"np_new_payee_details\"]")
	WebElement payeeDetailsInput;
	
	@FindBy(id = "add_new_payee")
	WebElement addButton;
	
	//purchase foreign currency tab elements
	@FindBy(id = "ui-tabs-3") 
	WebElement purForCurrHeader;
	
	@FindBy(id = "pc_currency")
	WebElement currencySelect;

	@FindBy(id = "sp_sell_rate")
	WebElement sellRate;
	
	@FindBy(id = "pc_amount")
	WebElement foreignCurrencyAmountInput;
	
	@FindBy(id = "pc_inDollars_true")
	WebElement usd_radioButton;
	
	@FindBy(id = "pc_inDollars_false")
	WebElement selectedCurrency_radioButton;
	
	@FindBy(id = "pc_calculate_costs")
	WebElement calculateCostsButton;  //this button also has a pop up I can test - todo
	
	@FindBy(id = "pc_conversion_amount")
	WebElement conversionAmountLabel;
	
	@FindBy(id = "purchase_cash")
	WebElement purchaseButton;
	
	
	//initializing page objects:
	public PayBillsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	public void clickPaySavedPayeeLink() {
		paySavedPayeeLink.click();
	}
	
	public void clickAddNewPayeeLink() {
		addNewPayeeLink.click();
	}
	
	public void clickPurchaseForCurrLink() {
		purchaseForCurrLink.click();
	}
	
	// ------------- methods for pay saved payee tab --------------
	public boolean verifyPspHeader() {
		return paySavedPayeeHeader.isDisplayed();
	}
	
	//@param date should be YYYY-MM-DD format
	public void paySavedPayee(String payee, String account, String amount, String date, String description) {
		
		//select payee
		Select pSelect = new Select(payeeSelect);
		switch(payee.toLowerCase()) {
		case "sprint":
			pSelect.selectByVisibleText("Sprint");
			break;
		case "bank of america":
			pSelect.selectByVisibleText("Bank of America");
			break;
		case "apple":
			pSelect.selectByVisibleText("Apple");
			break;
		case "wells fargo":
			pSelect.selectByVisibleText("Wells Fargo");
			break;
		default:
			System.out.println("pay Saved Payee function error: payee param not found in payee select");
			break;
		}

		//select account
		//defect: two accounts that have the same name: "Savings"
		pSelect = new Select(accountSelect);
		switch(account.toLowerCase()) {
		case "savings":
			pSelect.selectByIndex(1);
			break;
		case "checking":
			pSelect.selectByIndex(2);
			break;
		case "loan":
			pSelect.selectByIndex(4);
			break;
		case "credit card":
			pSelect.selectByIndex(5);
			break;
		case "brokerage":
			pSelect.selectByIndex(6);
			break;
		default:
			System.out.println("pay Saved Payee function error: account param not found in account select");
			break;
		}
		
		//input amount
		amountInput.sendKeys(amount);
		
		//input date
		dateInput.sendKeys(date);
		
		//input desc
		descrInput.sendKeys(description);
		
	}
	
	public void clickPayButton() {
		payButton.click();
	}
	
	public boolean verifySuccess() {
		return alertMessage.isDisplayed();
	}
	
	//methods for add new payee tab
	public boolean verifyANPHeader() {
		return addNewPayeeHeader.isDisplayed();
	}
	
	public void addNewPayee(String name, String address, String account, String details) {
		payeeNameInput.sendKeys(name);
		payeeAddressInput.sendKeys(address);
		payeeAccountInput.sendKeys(account);
		payeeDetailsInput.sendKeys(details);
	}
	
	public void clickAddButton() {
		addButton.click();
	}
	
	
	//methods for purchase foreign currency tab
	public boolean verifyPurForCurrHeader() {
		return purForCurrHeader.isDisplayed();
	}
	
	//@param curr should be a currency's 3 letter ticker symbol ex:USD
	public void purchaseForeignCurrency(String curr, String amount, String forCurrSelect) {
		
		Select cSelect = new Select(currencySelect);
		switch(curr) {
		case "AUD":
			cSelect.selectByValue("AUD");
			break;
		case "CAD":
			cSelect.selectByValue("CAD");
			break;
		case "CHF":
			cSelect.selectByValue("CHF");
			break;
		case "CNY":
			cSelect.selectByValue("CNY");
			break;
		case "DKK":
			cSelect.selectByValue("DKK");
			break;
		case "EUR":
			cSelect.selectByValue("EUR");
			break;
		case "GBP":
			cSelect.selectByValue("GBP");
			break;
		case "HKD":
			cSelect.selectByValue("HKD");
			break;
		case "JPY":
			cSelect.selectByValue("JPY");
			break;
		case "MXN":
			cSelect.selectByValue("MXN");
			break;
		case "NOK":
			cSelect.selectByValue("NOK");
			break;
		case "NZD":
			cSelect.selectByValue("NZD");
			break;
		case "SEK":
			cSelect.selectByValue("SEK");
			break;
		case "SGD":
			cSelect.selectByValue("SGD");
			break;
		case "THB":
			cSelect.selectByValue("THB");
			break;
		default:
			System.out.println("purchaseForeignCurrency error: currSelect invalid");
			break;
		}
		foreignCurrencyAmountInput.sendKeys(amount);
		
		if (forCurrSelect.equals("USD")) {
			usd_radioButton.click();
		}else if(forCurrSelect.equals("")) {
			//click no radio buttons
		}
		else {
			selectedCurrency_radioButton.click();
		}
	}
	
	public void handleAlert() {
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
	}
	
	public void calculateCosts() {
		
	}
	
	public void clickPurchaseButton() {
		purchaseButton.click();
	}
	
	
	
	
}
