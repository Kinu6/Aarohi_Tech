package aarohi.OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import aarohi.GenericUtilities.BaseClass;
import aarohi.ObjectRepository.CreateOrganizationsPage;
import aarohi.ObjectRepository.HomePage;
import aarohi.ObjectRepository.NewOrganizationsPage;
import aarohi.ObjectRepository.OrganizationInfosPage;

public class TC_06Test extends BaseClass {
@Test
	public void TC_06() throws IOException {
		
		String ORGNAME= eUtil.readDataFromExcel("Organization", 7, 2)+jUtil.getRandomNumber();
		String INDUSTRYDD= eUtil.readDataFromExcel("Organization", 7, 3);
		String TYPE=eUtil.readDataFromExcel("Organization", 7, 4);
		
		HomePage hp= new HomePage(driver);
		hp.getOrganizationsLnk().click();
		
		wUtil.implicitlyWait(driver);
		
		CreateOrganizationsPage cop= new CreateOrganizationsPage(driver);
		cop.getCreateOrgIcon().click();
		
		NewOrganizationsPage cnop= new NewOrganizationsPage(driver);
		cnop.getOrgName().sendKeys(ORGNAME);
		
		WebElement IND_DD = cnop.getIndustryDD();
		
		wUtil.handleDropDown(INDUSTRYDD, IND_DD);
		
		WebElement TYPE_DD= cnop.getTypeDD();
		wUtil.handleDropDown(TYPE_DD, TYPE);
		
		cnop.getSaveBtn().click();
		
		OrganizationInfosPage oip= new OrganizationInfosPage(driver);
		String HD_TEXT= oip.getOrgHeaderTxt().getText();
		
		Assert.assertEquals(HD_TEXT.contains(ORGNAME), true);
		
	}
}
