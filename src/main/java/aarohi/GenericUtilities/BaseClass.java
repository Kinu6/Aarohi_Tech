package aarohi.GenericUtilities;
	import java.io.IOException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;

    import aarohi.ObjectRepository.HomePage;
    import aarohi.ObjectRepository.LoginPage;
    import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		
	   public PropertyFileUtility pUtil= new PropertyFileUtility();
	   public ExcelFileUtility eUtil= new ExcelFileUtility();
	   public WebDriverUtility wUtil= new WebDriverUtility();
	   public JavaUtility jUtil= new JavaUtility();
	   
	   public WebDriver driver= null;
	   public static WebDriver sDriver;
	   
		@BeforeSuite()
		public void bsconfig() {
			System.out.println("-------------Data base Connection Sucessful------------");
		}
		
		@BeforeClass()
		public void bcConfig()  throws IOException {	
	
		String URL=pUtil.readDataFromPropertyFile("url");
		String BROWSER= pUtil.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		} else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		sDriver =driver; //this is for listeners
		
		wUtil.maximizeWindow(driver);
		wUtil.implicitlyWait(driver);
		driver.get(URL);
		}
		
		@BeforeMethod()
		public void bfConfig() throws IOException{
			String USERNAME=pUtil.readDataFromPropertyFile("username");
			String PASSWORD=pUtil.readDataFromPropertyFile("password");
			LoginPage lp= new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			System.out.println("Login Sucessful");
		}
		
		@AfterMethod()
		public void amConfig() {
			HomePage hp= new HomePage(driver);
			WebElement ele= hp.getAdministratorImg();
			wUtil.mouseHoverAction(driver, ele);
			hp.logoutOfApp(driver);
		}
		
		@AfterClass()
		public void acConfig(){	
			driver.quit();
			System.out.println("--------BROWSER CLOSED SUCCESSFUL--------");
		}
		
		@AfterSuite()
		public void asConfig() {
			System.out.println("---------DataBase connection Closed-----------");
	}
		
}

	
