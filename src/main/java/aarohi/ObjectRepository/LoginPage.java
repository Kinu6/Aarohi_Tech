package aarohi.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="user_name") private WebElement userNameEdt;
	
	@FindBy(name="user_password") private WebElement passwordEdt;
	
	@FindBy(id="submitButton") private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement userNameEdt() {
		return userNameEdt;
	}
	
	public WebElement passwordEdt() {
		return passwordEdt;
	}
	
	public WebElement loginBtn() {
		return loginBtn;
	}
	
	/**
	 * This method is for Logging in 
	 * @param PASSWORD
	 * @param USERNAME
	 */
	//This is a method for 
	public void loginToApp(String PASSWORD, String USERNAME) {
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
