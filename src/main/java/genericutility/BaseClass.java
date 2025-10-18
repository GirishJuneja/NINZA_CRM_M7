package genericutility;

import org.testng.annotations.Test;



import objectrepository.HomePage;
import objectrepository.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver=null;
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
		    
  @BeforeSuite(groups= {"smoke","regression"})
  public void beforeSuite() {
	  System.out.println("Connect to Database");
  }

  @AfterSuite(groups= {"smoke","regression"})
  public void afterSuite() {
	  System.out.println("Disconnect from Database");
  }
  
  @BeforeTest(groups= {"smoke","regression"})
  public void beforeTest() {
	  System.out.println("Preconditions for Parallel executions");
  }

  @AfterTest(groups= {"smoke","regression"})
  public void afterTest() {
	  System.out.println("Post Conditions for parallel executions");
  }
  
  //@Parameters("Browser")
  @BeforeClass(groups= {"smoke","regression"})
  //public void beforeClass(String BROWSER) throws IOException {
  public void beforeClass() throws IOException {
	  System.out.println("Launch the browser");
	  String BROWSER = pLib.readDataFromPropertyFile("Browser");
	//  String BROWSER =System.getProperty("Browser");
	  ChromeOptions settings =new ChromeOptions();
		Map<String,Object> prefs= new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
	  
	  	if(BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver(settings);
		else if(BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(BROWSER.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		
	  	sdriver=driver;
						
		driver.manage().window().maximize();
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.implicitWait(driver);
		
				
  }

  @AfterClass(groups= {"smoke","regression"})
  public void afterClass() {
	  System.out.println("Close the browser");
	  driver.quit();
  }
  
  @BeforeMethod(groups= {"smoke","regression"})
  public void beforeMethod() throws IOException {
	  System.out.println("Log in");
	  
  
	  String URL = pLib.readDataFromPropertyFile("URL");
	  String USERNAME = pLib.readDataFromPropertyFile("Username");
	  String PASSWORD = pLib.readDataFromPropertyFile("Password");
	  //String URL = System.getProperty("URL");
	 // String USERNAME = System.getProperty("Username");
	  //String PASSWORD = System.getProperty("Password");
	  driver.get(URL);
	  LoginPage lp=new LoginPage(driver);
	  lp.loginToApp(USERNAME, PASSWORD);
	  
  }

  @AfterMethod(groups= {"smoke","regression"})
  public void afterMethod() {
	  System.out.println("Log out");
	  HomePage hp = new HomePage(driver);
	  hp.logout();
  }
  

 

  
  

}
