package aarohi.ContactTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import aarohi.GenericUtilities.BaseClass;
import aarohi.ObjectRepository.ContactInfoPage;
import aarohi.ObjectRepository.CreateContactPage;
import aarohi.ObjectRepository.HomePage;
import aarohi.ObjectRepository.NewContactPage;

@Listeners(aarohi.GenericUtilities.ListernersImplementation.class)

public class TC_01Test extends BaseClass{	
	@Test 
	public void TC_01() throws IOException{
		
		String LASTNAME=eUtil.readDataFromExcel("Contact",1,2); 
		
		HomePage hp= new HomePage(driver);
		wUtil.implicitlyWait(driver);
		wUtil.waitForElementToBeVisible(driver,hp.getContactsLnk() );
		hp.getContactsLnk().click();
		
		CreateContactPage ccp= new CreateContactPage(driver);
		wUtil.implicitlyWait(driver);
        wUtil.waitForElementToBeVisible(driver,ccp.getCreateContactIcon());
		ccp.getCreateContactIcon().click();
		
		NewContactPage cncp= new NewContactPage(driver);
		wUtil.waitForElementToBeVisible(driver, cncp.getLastName());
		wUtil.implicitlyWait(driver);
		cncp.getLastName().sendKeys(LASTNAME);
		cncp.getSaveBtn().click();

		ContactInfoPage cip= new ContactInfoPage(driver);
		wUtil.waitForElementToBeVisible(driver, cip.getHeaderTxt());
		
		String orginfo= cip.getHeaderTxt().getText();
		Assert.assertEquals(orginfo.contains(LASTNAME), true);
		
		wUtil.implicitlyWait(driver);
	}
	@Test
	public void demo() {
		Assert.assertTrue(true);;
	}
}
