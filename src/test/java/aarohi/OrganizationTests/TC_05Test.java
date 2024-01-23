package aarohi.OrganizationTests;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import aarohi.GenericUtilities.BaseClass;
import aarohi.ObjectRepository.CreateOrganizationsPage;
import aarohi.ObjectRepository.HomePage;
import aarohi.ObjectRepository.NewOrganizationsPage;
import aarohi.ObjectRepository.OrganizationInfosPage;

public class TC_05Test extends BaseClass{
	
@Test
public void TC_04() throws EncryptedDocumentException, IOException 
      {
	   String INDUSTRY=eUtil.readDataFromExcel("Organization", 4, 3);
	   String ORGNAME= eUtil.readDataFromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		
	    HomePage hp= new HomePage(driver);
		hp.getOrganizationsLnk().click();
		
		wUtil.implicitlyWait(driver);
		
		CreateOrganizationsPage cop= new CreateOrganizationsPage(driver);
		cop.getCreateOrgIcon().click();
		
		NewOrganizationsPage cnop= new NewOrganizationsPage(driver);
		cnop.getOrgName().sendKeys(ORGNAME);
		
		WebElement IND_DD=cnop.getIndustryDD();
		
		wUtil.handleDropDown(INDUSTRY, IND_DD);
		cnop.getSaveBtn().click();
		
		OrganizationInfosPage oip= new OrganizationInfosPage(driver);
		wUtil.waitForElementToBeVisible(driver,oip.getOrgHeaderTxt() );
		String HD_TEXT= oip.getOrgHeaderTxt().getText();
		
		Assert.assertTrue(HD_TEXT.contains(ORGNAME));	
	}

  }
