package zeroBank.pages;

import zeroBank.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FeedbackPage extends TestBase{
	
	//Create Web Elements
	//Page Factory - OR:
	@FindBy(id="feedback-title")
	WebElement feedbackLabel;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="subject")
	WebElement subject;
	
	@FindBy(id="comment")
	WebElement comment;
	
	@FindBy(name="submit")
	WebElement sendMessageBtn;
	
	@FindBy(name="clear")
	WebElement clearBtn;
	
	@FindBy(id="faq-link")
	WebElement faqLink;
	
	//Initializing the Page Objects:
	public FeedbackPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateFeedbackPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateFeedbackLabel() {
		return feedbackLabel.isDisplayed();
	}
	
	public void sendMessageForAllTextBox(String enterName, String enterEmail, String enterSubject, String enterComment ) {
		name.sendKeys(enterName);
		email.sendKeys(enterEmail);
		subject.sendKeys(enterSubject);
		comment.sendKeys(enterComment);
		sendMessageBtn.click();
	}
	
	public void enterInformationWithoutSending(String enterName, String enterEmail, String enterSubject, String enterComment) {
		name.sendKeys(enterName);
		email.sendKeys(enterEmail);
		subject.sendKeys(enterSubject);
		comment.sendKeys(enterComment);
	}
	
	public boolean verifyAllTextboxEmpty() {
		if(name.getAttribute("value").isEmpty() && email.getAttribute("value").isEmpty() && subject.getAttribute("value").isEmpty() && comment.getAttribute("value").isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void enterOneTextBox(String textbox, String information) {
		switch (textbox) {
			case "name": name.sendKeys(information);
			             break;
			case "email": email.sendKeys(information);
			             break;
			case "subject": subject.sendKeys(information);
			             break;
			case "comment": comment.sendKeys(information);
			             break;
		}		
	}
	
	public void clickSendMessageButton() {
		sendMessageBtn.click();
	}
	
	public void clickClearButton() {
		clearBtn.click();
	}
	
	public void toFAQpage() {
		faqLink.click();
	}
	
	public boolean verifyNameFormat(String enterName) {
		char[] chars = enterName.toCharArray();
	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public boolean verifyEmailFormat(String enterEmail) {
		if(enterEmail.contains("@") && enterEmail.contains(".com")) {
			return true;
		}
		return false;
	}
	
	public boolean validateFeedbackSubmission() {
		String url = driver.getCurrentUrl();
		return url.contentEquals("http://zero.webappsecurity.com/sendFeedback.html");
	}
	
	public boolean verifyFeedbackSubmission() {
		String testName = "TestName";
		name.sendKeys(testName);
		email.sendKeys("test@test.com");
		subject.sendKeys("testSubject");
		comment.sendKeys("testComment");
		sendMessageBtn.click();
		return validateFeedbackSubmission();
	}
	
//	public boolean verifySubmissionName() {
//		// tests to see if the name displayed on feedback submission page matches the one given
//		String testName = "TestName";
//		name.sendKeys(testName);
//		email.sendKeys("test@test.com");
//		subject.sendKeys("testSubject");
//		comment.sendKeys("testComment");
//		sendMessageBtn.click();
//		
//		String message = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div")).getText();
//		return message.contains(testName);
//	}
}

