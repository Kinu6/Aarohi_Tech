package aarohi.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationsPage {
	@FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement CreateOrgIcon;                            
	public CreateOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateOrgIcon() {
		return CreateOrgIcon;
	}
	
}
