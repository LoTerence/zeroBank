package zeroBank.pages;

//import org.openqa.selenium.By;
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
	@FindBy(xpath = ".//*[@id=\"alert_content\"]/span")
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
	
	@FindBy(xpath = ".//*[@id=\"alert_content\"]/span")
	WebElement paymentSuccessfulAlert;
	
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
	
	@FindBy(xpath = ".//*[@id=\"add_new_payee\"]")
	WebElement newPayeeAddButton;
	
	//purchase foreign currency tab elements
	@FindBy(xpath = ".//*[@id=\"ui-tabs-3\"]/h2") 
	WebElement purchaseForeignCurrencyHeader;
	
	@FindBy(xpath = ".//*[@id=\"pc_currency\"]")
	WebElement currencySelect;

	@FindBy(xpath = ".//*[@id=\"sp_sell_rate\"]")
	WebElement sellRate;
	
	@FindBy(xpath = ".//*[@id=\"pc_amount\"]")
	WebElement foreignCurrencyAmountInput;
	
	@FindBy(xpath = ".//*[@id=\"pc_inDollars_true\"]")
	WebElement usd_radioButton;
	
	@FindBy(xpath = ".//*[@id=\"pc_inDollars_false\"]")
	WebElement selectedCurrency_radioButton;
	
	@FindBy(xpath = ".//*[@id=\"pc_calculate_costs\"]")
	WebElement calculateCostsButton;  //this button also has a pop up I can test - todo
	
	@FindBy(xpath = ".//*[@id=\"pc_conversion_amount\"]")
	WebElement conversionAmountLabel;
	
	@FindBy(xpath = ".//*[@id=\"purchase_cash\"]")
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
	public void paySavedPayee(String payee, String account, int amount, String date, String description) {
		
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
		amountInput.sendKeys(Integer.toString(amount));
		
		//input date
		dateInput.sendKeys(date);
		
		//input desc
		descrInput.sendKeys(description);
		
	}
	
	public void clickPayButton() {
		payButton.click();
	}
	
	public boolean verifyPayment() {
		return paymentSuccessfulAlert.isDisplayed();
	}
	
	
	//methods for add new payee tab
	
	
	//methods for purchase foreign currency tab
	
	
	
}
