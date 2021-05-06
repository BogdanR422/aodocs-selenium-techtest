package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch extends BasePage {
	 private WebDriver mDriver;

	 @FindBy(css = "input[name='q']")
	 private WebElement mSearchField;


	 public GoogleSearch(WebDriver driver) {
		  mDriver = driver;
		  PageFactory.initElements(driver, this);
	 }


	 public boolean pageIsOpened() {
		  return mSearchField.isDisplayed();
	 }

	 public void inputSearchQuery(String searchQuery) {
		  mSearchField.sendKeys(searchQuery);
	 }

	 public void initiateSearch() {
		  mSearchField.sendKeys(Keys.ENTER);
	 }
}