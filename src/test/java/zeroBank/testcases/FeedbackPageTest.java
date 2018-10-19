package zeroBank.testcases;

import zeroBank.base.TestBase;
import zeroBank.pages.LoginPage;
import zeroBank.pages.HomePage;
import zeroBank.pages.AccountSummary;
import zeroBank.pages.FeedbackPage;
import zeroBank.util.*;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class FeedbackPageTest extends TestBase{

	//LoginPage loginPage;
	HomePage homePage;
	FeedbackPage feedbackPage;
	TestUtil testUtil;
	//AccountSummary accountSummaryPage;

	String sheetName = "feedbackData1";

	public FeedbackPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		//loginPage = new LoginPage();
		//accountSummaryPage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		testUtil = new TestUtil();
		//TestUtil.runTimeInfo("error", "login successful");
		//testUtil.switchToFrame();
		feedbackPage = homePage.clickOnFeedbackLink();
	}

	

	// 1. verify on the right page
	
	@Test(priority=1)
	public void verifyFeedbackPageLabel() {
		Assert.assertTrue(feedbackPage.validateFeedbackLabel(), "Feedback label is missing on the page");
		
		System.out.println("passed test 1 ");
	}

	
	
	// 2. validate if feedback message is submitted
	
	@Test(priority=2)
	public void validateSubmissionPage() {
		
		//check if on submitted page
		boolean feedbackSubmitted = validateFeedbackSubmission();
		String message = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div")).getText();
		
		//check if the name appears on the submitted page is correct
		boolean nameCorrect = message.contains("TestName");
		Assert.assertTrue((feedbackSubmitted && nameCorrect ), "Feedback not submitted correctly");
		
		System.out.println("passed test 2 ");
	}

	public boolean validateFeedbackSubmission() {
		return feedbackPage.verifyFeedbackSubmission();
	}

	

	// 3. validate "send" and "clear" buttons
	
	@Test(priority=3)
	public void validateButtonsWithBlankTextBoxes() {
		
		//validateSendClearButtonWithoutInformationEntered();
		feedbackPage.clickClearButton();
		boolean boxesCleared = feedbackPage.verifyAllTextboxEmpty();
		Assert.assertTrue(boxesCleared, "Boxes did not clear");
		
		//validateSendMessageButtonWithoutInformationEntered();
		feedbackPage.clickSendMessageButton();
		boolean feedbackSent = feedbackPage.validateFeedbackSubmission();
		Assert.assertFalse(feedbackSent, "Feedback submitted without content");

		System.out.println("passed test 3 ");
	}


	

	// 4. validate "send" and "clear" buttons with full information and messages
	
	@Test(priority=4, dataProvider="getFeedbackData")
	public void validateButtonsWithFullInformation(String name, String email, String subject, String comment) {
		
		//validateNameFormat(name);
		Assert.assertTrue(feedbackPage.verifyNameFormat(name),"The format of entered name is not valid");
		
		//validateEmailFormat(email);
		Assert.assertTrue(feedbackPage.verifyEmailFormat(email),"The format of entered email is not valid");
		
		//validateClearButton(name, email, subject, comment);
		feedbackPage.enterInformationWithoutSending(name, email, subject, comment);
		feedbackPage.clickClearButton();
		Assert.assertTrue(feedbackPage.verifyAllTextboxEmpty(), "Text boxes not cleared");
		
		//validateNormalSendMessage(name, email, subject, comment);
		feedbackPage.sendMessageForAllTextBox(name, email, subject, comment);
		Assert.assertTrue(feedbackPage.validateFeedbackSubmission(), "Feedback submitted successfully");
		
		System.out.println("passed test 4");
	}


	

	// 5. only fill out one text box
	
	@Test(priority=5, dataProvider="getFeedbackData")
	public void validateSubmissionWithOneTextbox(String name, String email, String subject, String comment) {
		
		//validateSendMessageOnlyNameIsEntered(name);
		feedbackPage.enterOneTextBox("name", name);
		feedbackPage.clickSendMessageButton();
		Assert.assertFalse(feedbackPage.validateFeedbackSubmission(), "Feedback submitted with missed information except 'Name'");
		feedbackPage.clickClearButton();
		
		//validateSendMessageOnlyEmailIsEntered(email);
		feedbackPage.enterOneTextBox("email", email);
		feedbackPage.clickSendMessageButton();
		Assert.assertFalse(feedbackPage.validateFeedbackSubmission(), "Feedback submitted with missed information except 'Email'");
		feedbackPage.clickClearButton();
		
		//validateSendMessageOnlySubjectIsEntered(subject);
		feedbackPage.enterOneTextBox("subject", subject);
		feedbackPage.clickSendMessageButton();
		Assert.assertFalse(feedbackPage.validateFeedbackSubmission(), "Feedback submitted with missed information except 'Subject'");
		feedbackPage.clickClearButton();
		
		//validateSendMessageOnlyCommentIsEntered(comment);
		feedbackPage.enterOneTextBox("comment", comment);
		feedbackPage.clickSendMessageButton();
		Assert.assertFalse(feedbackPage.validateFeedbackSubmission(), "Feedback submitted with missed information except 'Message'");
		
		System.out.println("passed test 5");
	}


	@DataProvider
	public Object[][] getFeedbackData() throws InvalidFormatException, org.apache.commons.compress.archivers.dump.InvalidFormatException{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}


	
	// 6. check if the FAQ link is working
	
	@Test(priority=6)
	public void validateFAQlink() {
		feedbackPage.toFAQpage();
		
		System.out.println("passed test 6");
	}



	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}
}


