package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	 private WebDriver mDriver;

	 @FindBy(xpath = "//a[text()='Request a demo']")
	 private WebElement mRequestADemoButton;


	 public HomePage(WebDriver driver) {
		  mDriver = driver;
		  PageFactory.initElements(driver, this);
	 }


	 public void clickRequestADemoButton(){
	 	 mRequestADemoButton.click();
	 }

	 public boolean pageIsOpened() {
		  return mRequestADemoButton.isDisplayed();
	 }
}