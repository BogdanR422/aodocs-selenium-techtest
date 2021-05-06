package tests;

import base.ConfProperties;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.ConnectWithUsPage;
import pages.GoogleSearch;
import pages.GoogleSearchResults;
import pages.HomePage;
import selenium.driver.Browser;
import selenium.driver.WebDriverUtility;

public class Test1 {
	 private WebDriver mDriver;

	 private GoogleSearch mGoogleSearchPage;
	 private GoogleSearchResults mGoogleSearchResultsPage;
	 private HomePage mHomePage;
	 private ConnectWithUsPage mConnectWithUsPage;

	 @BeforeEach
	 //@Parameters("browser")
	 public void setup() {
		  Browser b = Browser.CHROME;

		  mDriver = WebDriverUtility.getWebDriver(b);

		  mGoogleSearchPage = new GoogleSearch(mDriver);
		  mGoogleSearchResultsPage = new GoogleSearchResults(mDriver);
		  mHomePage = new HomePage(mDriver);
		  mConnectWithUsPage = new ConnectWithUsPage(mDriver);
	 }

	 @Test
	 public void test() {
		  //STEP: open Google search page
		  mDriver.get(ConfProperties.getProperty("page.google.url"));

		  //STEP: Assert Google search page is opened
		  Assertions.assertTrue(mGoogleSearchPage.pageIsOpened());

		  //STEP: Input 'AODocs' search query
		  mGoogleSearchPage.inputSearchQuery("AODocs");

		  //STEP: Initiate search
		  mGoogleSearchPage.initiateSearch();

		  //STEP: Assert Google search results page is opened
		  Assertions.assertTrue(mGoogleSearchResultsPage.pageIsOpened());

		  //STEP: Assert Google search results page contains required link
		  Assertions.assertTrue(mGoogleSearchResultsPage.searchResultsContainLink(ConfProperties.getProperty("page.aodocs.url")));

		  //STEP: Click specified link
		  mGoogleSearchResultsPage.clickALink(ConfProperties.getProperty("page.aodocs.url"));

		  //STEP: Assert AODocs home page is opened
		  Assertions.assertTrue(mHomePage.pageIsOpened());

		  //STEP: Click "Request a demo" button
		  mHomePage.clickRequestADemoButton();

		  //STEP: Assert AODocs "Connect with us" page is opened
		  Assertions.assertTrue(mConnectWithUsPage.pageIsOpened());

		  //STEP: Fill out the "first name" field
		  mConnectWithUsPage.inputFirstName("Abcd");

		  //STEP: Focus and leave the "last name" field empty
		  mConnectWithUsPage.inputLastName("");

		  //STEP: Input incorrect email into the "your email" field
		  mConnectWithUsPage.inputEmail("12345");

		  //STEP: Select a random option from the "company size" dropdown list
		  mConnectWithUsPage.selectRandomOptionFromCompanySizeDropdown();

		  //STEP: Make sure all the error messages are displayed correctly
		  Assertions.assertFalse(mConnectWithUsPage.firstNameFieldHasErrorMessages());
		  Assertions.assertTrue(mConnectWithUsPage.lastNameFieldHasErrorMessages());
		  Assertions.assertTrue(mConnectWithUsPage.emailFieldHasErrorMessages());
		  Assertions.assertFalse(mConnectWithUsPage.companySizeDropdownHasErrorMessages());
	 }

	 @AfterEach
	 public void quit() {
		  WebDriverUtility.closeWebDriver(mDriver);
	 }
}