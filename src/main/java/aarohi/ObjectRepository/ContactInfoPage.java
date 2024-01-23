package aarohi.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
    // Create POM Class
	// Create FindBy
	 @FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement HeaderTxt;
	// Create Constructor
	 public ContactInfoPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 public WebElement getHeaderTxt() {
		 return HeaderTxt;
	 }
}
