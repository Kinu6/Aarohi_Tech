package aarohi.ContactTests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import aarohi.GenericUtilities.BaseClass;
import aarohi.ObjectRepository.ContactInfoPage;
import aarohi.ObjectRepository.CreateContactPage;
import aarohi.ObjectRepository.CreateOrganizationsPage;
import aarohi.ObjectRepository.HomePage;
import aarohi.ObjectRepository.NewContactPage;
import aarohi.ObjectRepository.NewOrganizationsPage;
import aarohi.ObjectRepository.OrganizationInfosPage;

@Listeners(aarohi.GenericUtilities.ListernersImplementation.class)

public class TC_02Test extends BaseClass{

	@Test (retryAnalyzer = aarohi.GenericUtilities.RetryAnalyserImplementation.class)
	public void TC_02() throws IOException {
		
		String ORGNAME=eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getRandomNumber(); 
		String LASTNAME=eUtil.readDataFromExcel("Contact", 4, 3); 
		
		//Create Organization
		HomePage hp= new HomePage(driver);
		wUtil.implicitlyWait(driver);
		hp.getOrganizationsLnk().click();
		
		wUtil.implicitlyWait(driver);
		CreateOrganizationsPage cop= new CreateOrganizationsPage(driver);
		cop.getCreateOrgIcon().click();
		
		NewOrganizationsPage nop=new NewOrganizationsPage(driver);
		nop.getOrgName().sendKeys(ORGNAME);
		nop.getSaveBtn().click();
		
		OrganizationInfosPage oip= new OrganizationInfosPage(driver);
		String orgHeader= oip.getOrgHeaderTxt().getText();
		
		wUtil.implicitlyWait(driver);
		
		Assert.assertEquals(orgHeader.contains(ORGNAME), true);
		System.out.println(ORGNAME+" "+"Its Matched");
		
		//Contacts TAB
		wUtil.implicitlyWait(driver);
		hp.getContactsLnk().click();
		
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.getCreateContactIcon().click();
		
		NewContactPage ncp= new NewContactPage(driver);
		ncp.getLastName().sendKeys(LASTNAME);
		wUtil.switchToWindow(driver, "Accounts");
	    driver.switchTo().parentFrame();
		ncp.getSaveBtn().click();
		
		wUtil.implicitlyWait(driver);
		
		ContactInfoPage cip= new ContactInfoPage(driver);
		
		// Verification -
		String orginfo1= cip.getHeaderTxt().getText();
		Assert.assertEquals(orginfo1.contains(LASTNAME), true);
       
	}
}
