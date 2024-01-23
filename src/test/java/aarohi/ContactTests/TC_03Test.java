package aarohi.ContactTests;

import java.io.IOException;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.Test;

import aarohi.GenericUtilities.BaseClass;
import aarohi.ObjectRepository.ContactInfoPage;
import aarohi.ObjectRepository.CreateContactPage;
import aarohi.ObjectRepository.HomePage;
import aarohi.ObjectRepository.NewContactPage;


public class TC_03Test extends BaseClass {

	@Test
	public void TC_03() throws IOException {
		
		String LASTNAME=eUtil.readDataFromExcel("Contact", 7, 2);
		String LEAD_DD= eUtil.readDataFromExcel("Contact", 7, 3);
		
		HomePage hp= new HomePage(driver);
		hp.getContactsLnk().click();
		
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.getCreateContactIcon().click();
		
		NewContactPage cncp= new NewContactPage(driver);
		cncp.getLastName().sendKeys(LASTNAME);
		
		WebElement leadEle = cncp.getLeadSourceDD();
		wUtil.handleDropDown(LEAD_DD, leadEle);;
		cncp.getSaveBtn().click();
		
		ContactInfoPage cip= new ContactInfoPage(driver);
		
		// Verification -
		String orginfo= cip.getHeaderTxt().getText();
		
		Assert.assertEquals(orginfo.contains(LASTNAME), true);
	}

}
