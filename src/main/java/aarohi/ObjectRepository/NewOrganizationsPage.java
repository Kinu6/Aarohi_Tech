package aarohi.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrganizationsPage {

	@FindBy(name="accountname") private WebElement orgName;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']") private WebElement selectIcon;
	@FindBy(name="industry") private WebElement industryDD;
	@FindBy(name="accounttype") private WebElement typeDD;
	@FindBy(xpath="//input[@accesskey='S']") private WebElement saveBtn;
	
	public NewOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSelectIcon() {
		return selectIcon;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
