package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class ConnectWithUsPage extends BasePage {
	 private WebDriver mDriver;

	 @FindBy(css = "input[id^='firstname']")
	 private WebElement mFirstNameField;

	 @FindBy(xpath = "//input[starts-with(@id, 'firstname')]/ancestor::div[@class='input']/../ul/*/label")
	 private List<WebElement> mFirstNameFieldErrorMessages;

	 @FindBy(css = "input[id^='lastname']")
	 private WebElement mLastNameField;

	 @FindBy(xpath = "//input[starts-with(@id, 'lastname')]/ancestor::div[@class='input']/../ul/*/label")
	 private List<WebElement> mLastNameFieldErrorMessages;

	 @FindBy(css = "input[id^='email']")
	 private WebElement mEmailField;

	 @FindBy(xpath = "//input[starts-with(@id, 'email')]/ancestor::div[@class='input']/../ul/*/label")
	 private List<WebElement> mEmailFieldErrorMessages;

	 @FindBy(css = "select[id^='company_size']")
	 private WebElement mCompanySizeDropdown;

	 @FindBy(xpath = "//select[starts-with(@id, 'company_size')]/ancestor::div[@class='input']/../ul/*/label")
	 private List<WebElement> mCompanySizeDropdownErrorMessages;

	 @FindBy(css = "input[type='submit']")
	 private WebElement mSubmitButton;


	 public ConnectWithUsPage(WebDriver driver) {
		  mDriver = driver;
		  PageFactory.initElements(driver, this);
	 }


	 public void inputFirstName(String firstName){
	 	 mFirstNameField.sendKeys(firstName);
	 }

	 public boolean firstNameFieldHasErrorMessages(){
	 	 return mFirstNameFieldErrorMessages.size() > 0;
	 }

	 public void inputLastName(String lastName){
		  mLastNameField.sendKeys(lastName);
	 }

	 public boolean lastNameFieldHasErrorMessages(){
		  return mLastNameFieldErrorMessages.size() > 0;
	 }

	 public void inputEmail(String email){
		  mEmailField.sendKeys(email);
	 }

	 public boolean emailFieldHasErrorMessages(){
		  return mEmailFieldErrorMessages.size() > 0;
	 }

	 public void selectRandomOptionFromCompanySizeDropdown(){
	 	 List<WebElement> options = mCompanySizeDropdown.findElements(By.xpath("./option[not(@disabled)]"));

	 	 WebElement randomOption = options.get(new Random().nextInt(options.size() - 1) + 1);

	 	 randomOption.click();
	 }

	 public boolean companySizeDropdownHasErrorMessages(){
		  return mCompanySizeDropdownErrorMessages.size() > 0;
	 }

	 public boolean pageIsOpened() {
		  return mSubmitButton.isDisplayed();
	 }
}