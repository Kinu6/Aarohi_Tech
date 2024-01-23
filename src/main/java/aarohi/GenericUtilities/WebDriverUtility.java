package aarohi.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is for WebDriver Utility
 * @author kravi
 *
 */
public class WebDriverUtility {

/**
 * This method will maximize window	
 * @param driver
 */
 public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
 }
 /**
  * This method is for minimizing window
  * @param driver
  */
 public void minimizeWindow(WebDriver driver) {
	 driver.manage().window().minimize();
 }
 /**
  * This method will implicit-wait for 20 sec 
  * @param driver
  */
 
 public void implicitlyWait(WebDriver driver) {
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30));
 }
 
 /**
  * THis Method will wait for 10 sec to become clickable
  * @param driver
  * @param element
  */
public void elementToBeClickable(WebDriver driver, WebElement element) {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This Method will wait for element to become visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(50));
	wait.until(ExpectedConditions.visibilityOf(element));
}
 
/**
 * This Method is for Handling Dropdown based on index
 * @param element
 * @param index
 */
 public void handleDropDown(WebElement element, int index) {
	 Select sel= new Select(element);
	 sel.selectByIndex(index);
 }
 
 // DROP DOWN--------------
 /**
  * This Method is for Handling Dropdown based on VisibleText
  * @param element
  * @param index
 * @param text 
  */
  public void handleDropDown(WebElement element,String text) {
 	 Select sel= new Select(element);
 	 sel.selectByVisibleText(text);
  }
 
  /**
   * This Method is for Handling Dropdown based on index
   * @param element
   * @param index
   */
   public void handleDropDown(String value,WebElement element) {
  	 Select sel= new Select(element);
  	 sel.selectByValue(value);
   }
/**
 * This method is for handling Mouse Hover Actions 
 * @param driver
 * @param element
 */
 public void mouseHoverAction(WebDriver driver, WebElement element) {
	 Actions acton= new Actions(driver);
	 acton.moveToElement(element).perform();
 }
 /**
  * This Mthod will do Right Click on webPage
  * @param driver
  */
 public void rightClickAction(WebDriver driver) {
	 Actions acton=new Actions(driver);
	 acton.contextClick().perform();
 }
 /**
  * This Method will do Double Click on webPage
  * @param driver
  */
 public void doubleClickAction(WebDriver driver) {
	 Actions acton=new Actions(driver);
	 acton.doubleClick().perform();
 }
 /**
  * This Method will double click on a element
  * @param element
  * @param driver
  */
 public void doubleClickAction(WebElement element, WebDriver driver) {
	 Actions acton= new Actions(driver);
	 acton.doubleClick(element).perform();;
 }
 /**
  * This Method is for drag and drop action
  * @param driver
  * @param target
  * @param source
  */
 public void dragAndDropAction(WebDriver driver, WebElement target, WebElement source) {
	 Actions acton= new Actions(driver);
	 acton.dragAndDrop(source, target).perform();
 }
 /**
  * This class will click and release enter upon calling
  * @throws AWTException
  */
 public void robotEnter() throws AWTException {
	 Robot bot=new Robot();
	 bot.keyPress(KeyEvent.VK_ENTER);
	 bot.keyRelease(KeyEvent.VK_ENTER);
	 
 }
 /**
  * Switch To Frame Method based on Index
  * @param driver
  * @param index
  */
 public void switchToFrame(WebDriver driver, String index) {
	 driver.switchTo().frame(index);
 }
 /**
  * Switch To Frame Method based on Name or ID
  * @param driver
  * @param index
  */
 public void switchToFrame( String name,WebDriver driver) {
	 driver.switchTo().frame(name);
 }
 /**
  * Switch To Frame Method based on element
  * @param driver
 * @param element 
  * @param index
  */
 public void switchToFrame(WebDriver driver, WebElement element) {
	 driver.switchTo().frame(element);
 }
 /**
  * Switch To ParentFrame Method
  * @param driver
 * @param element 
  * @param index
  */
 
 public void switchToFrame(WebDriver driver) {
	 driver.switchTo().parentFrame();
 }
 
 /**
  * Switch To Frame Method based on Default Content
  * @param driver
 * @param element 
  * @param index
  */
 public void switchToDefaultFrame(WebDriver driver) {
	 driver.switchTo().defaultContent();
 }
 /**
  * This Method is for accepting Popup
  * @param driver
  */
 public void AlertPopupAccept(WebDriver driver) {
	 driver.switchTo().alert().accept();
 }
 /**
  * This Method is for Rejecting Popup
  * @param driver
  */
 public void AlertPopupReject(WebDriver driver) {
	 driver.switchTo().alert().dismiss();
 }
 /**
  * This Method is for getting text of alert Popup
  * @param driver
  */
 public void AlertPopupText(WebDriver driver) {
	 driver.switchTo().alert().getText();
 }
 
 /**
  * This Method is for Scroll Action
  * @param driver
  */
 public void scrollAction(WebDriver driver) {
	 JavascriptExecutor jse= (JavascriptExecutor) driver; 
	 jse.executeScript("window.scrollBy(0,500);", "");
 
 }
 
 /**
	 * This method will switch to window based on window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//Step 1: Capture all the window IDs
		Set<String> allWinIDs = driver.getWindowHandles();
		
		//Step 2: Navigate to each window ID
		for(String winID:allWinIDs)
		{
			//Step 3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(winID).getTitle();
			
			//Step 4: compare the title with required title
			if(actTitle.contains(partialWinTitle))
			{
				break;
			}
			
		}
	}
 
	/**
	 * This Method will take screenshot and save it in screenshot Folder
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takesScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File((".\\ScreenShots\\") + screenshotName + ".png");
		FileUtils.copyFile(src, dest); // Commons IO Dependency

		return dest.getAbsolutePath(); // Used for Extent Reports
	}
}
