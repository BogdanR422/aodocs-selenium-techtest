package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResults extends BasePage {
	 private WebDriver mDriver;

	 @FindBy(css = "input[name='q']")
	 private WebElement mSearchField;


	 public GoogleSearchResults(WebDriver driver) {
		  mDriver = driver;
		  PageFactory.initElements(driver, this);
	 }


	 public boolean searchResultsContainLink(String link) {
	 	 if(mDriver.findElements(By.cssSelector("div#result-stats")).isEmpty()) { return false; }

	 	 List<WebElement> searchResults = mDriver.findElements(By
					 .xpath("//cite[contains(text(), '" + link + "')]"));

	 	 return searchResults.size() > 0;
	 }

	 public void clickALink(String link) {
	 	 WebElement a = mDriver.findElement(By.xpath("//cite[contains(text(), '" + link + "')]/ancestor::a"));
	 	 a.click();
	 }

	 public boolean pageIsOpened() {
		  return !mDriver.findElements(By.cssSelector("div#top_nav")).isEmpty();
	 }
}