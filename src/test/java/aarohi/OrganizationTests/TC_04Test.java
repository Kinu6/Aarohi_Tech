package aarohi.OrganizationTests;

import org.testng.annotations.Test;
import aarohi.GenericUtilities.BaseClass;
import aarohi.ObjectRepository.CreateOrganizationsPage;
import aarohi.ObjectRepository.HomePage;
import aarohi.ObjectRepository.NewOrganizationsPage;
import aarohi.ObjectRepository.OrganizationInfosPage;
import java.io.IOException;
import org.testng.Assert;

public class TC_04Test extends BaseClass {
	@Test()
	public void TC_04() throws IOException {
		 
		String ORGNAME=eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber(); 
		HomePage hp= new HomePage(driver);
		wUtil.waitForElementToBeVisible(driver, hp.getOrganizationsLnk());	
		hp.getOrganizationsLnk().click();
		
		CreateOrganizationsPage cop= new CreateOrganizationsPage(driver);
		wUtil.waitForElementToBeVisible(driver, cop.getCreateOrgIcon());
		cop.getCreateOrgIcon().click();
		
		NewOrganizationsPage cno= new NewOrganizationsPage(driver);
		cno.getOrgName().sendKeys(ORGNAME);
		cno.getSaveBtn().click();
		
		OrganizationInfosPage oip= new OrganizationInfosPage(driver);
        wUtil.waitForElementToBeVisible(driver, oip.getOrgHeaderTxt());
		
        String orginfo= oip.getOrgHeader();		
		
        Assert.assertEquals(orginfo.contains(ORGNAME),true);
        System.out.println("Hi its "+ORGNAME);	
        }
	@Test
	public void demo() {
		System.out.println("DEMO T.S");
	}
	
}
