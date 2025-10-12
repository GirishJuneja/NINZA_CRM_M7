package campaigntest;

import java.io.IOException;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import genericutility.ExcelFileUtility;
import genericutility.JavaUtility;
import genericutility.PropertyFileUtility;
import genericutility.WebDriverUtility;
import objectrepository.CampaignsPage;
import objectrepository.CreateCampaignPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;

@Listeners(genericutility.ListenerImplementation.class)
public class CreateCampaignTest extends BaseClass {
	
	@Test(groups= {"smoke","regression"})
	public void CreateCampaignwithMandatoryFieldsTest() throws IOException {
		
		//PropertyFileUtility pLib = new PropertyFileUtility();
		//String BROWSER = pLib.readDataFromPropertyFile("Browser");
		//String URL = pLib.readDataFromPropertyFile("URL");
		//String USERNAME = pLib.readDataFromPropertyFile("Username");
		//String PASSWORD = pLib.readDataFromPropertyFile("Password");
		
		//WebDriverUtility wLib = new WebDriverUtility();

		//FileInputStream fis = new FileInputStream("C:\\Users\\Girish\\Desktop\\Commondata2.properties");
		//Properties prop = new Properties();
		//prop.load(fis);
		//String BROWSER = prop.getProperty("Browser");
		//String URL = prop.getProperty("URL");
		//String USERNAME = prop.getProperty("Username");
		
		//String PASSWORD = prop.getProperty("Password");
		
		//ExcelFileUtility eLib = new ExcelFileUtility();
		String campaignname = eLib.readDataFromExcelFile("Campaign",1, 2);
		String targetsize = eLib.readDataFromExcelFile("Campaign",1,3);
		
		
		//FileInputStream fis1 = new FileInputStream("C:\\Users\\Girish\\Desktop\\NinzaCRM_M7.xlsx");
		
     	//	Workbook wb = WorkbookFactory.create(fis1);
		
		//Sheet sh = wb.getSheet("Campaign");
		
		//Row r = sh.getRow(1);
		
		//Cell c = r.getCell(2);
		
		//String campaignname = c.getStringCellValue();
		
 //Sheet sh2 = wb.getSheet("Campaign");
		
		//Row r2 = sh.getRow(1);
		
		//Cell c2 = r.getCell(3);
		
		//String targetsize = c2.getStringCellValue();
		
//		ChromeOptions settings =new ChromeOptions();
//		Map<String,Object> prefs= new HashMap<>();
//		prefs.put("profile.password_manager_leak_detection", false);
//		settings.setExperimentalOption("prefs", prefs);
//		
				
			//	WebDriver driver = null;
			//	if(BROWSER.equalsIgnoreCase("chrome"))
			//		driver = new ChromeDriver(settings);
			//	else if(BROWSER.equalsIgnoreCase("edge"))
			//		driver = new EdgeDriver();
			//	else if(BROWSER.equalsIgnoreCase("firefox"))
			//		driver = new FirefoxDriver();
			//	else if(BROWSER.equalsIgnoreCase("safari"))
			//		driver = new SafariDriver();
				
								
				//driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				
				//driver.get(URL);
				//LoginPage lp=new LoginPage(driver);
				//lp.loginToApp(USERNAME, PASSWORD);
				
				
				//driver.findElement(By.id("username")).sendKeys(USERNAME);
				//driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
				//driver.findElement(By.xpath("//button[text()='Sign In']")).click();
				
				CampaignsPage cp = new CampaignsPage(driver);
				cp.getAddCreateCampaignBtn().click();
				
				//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				
				CreateCampaignPage cp1 = new CreateCampaignPage(driver);
				cp1.getCampaignName().sendKeys(campaignname);
				
				
				//driver.findElement(By.name("campaignName")).sendKeys(campaignname);
				
				WebElement TarSize = cp1.getTargetSize();
				
				//WebElement targetsizeTF = driver.findElement(By.name("targetSize"));
				TarSize.clear();
				TarSize.sendKeys(targetsize);
				
				cp1.getCreateCampaignBtn().click();
				//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
				
				HomePage hp = new HomePage(driver);
				
				WebElement toastMsg = hp.getToastMsg();
				wLib.waitForVisibilityOfWebElement(driver,toastMsg);
				
				
				//WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
				//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
				//wait.until(ExpectedConditions.visibilityOf(toastmsg));
				//if(toastMsg.getText().contains(campaignname))
				//	System.out.println("Campaign created");
				//else
				//	System.out.println("Campaign not created");
				
				Assert.assertTrue(toastMsg.getText().contains(campaignname));
				//Assert.assertTrue(toastMsg.getText().contains("z"));
				System.out.println("From new workspace");
				
				hp.getCloseToastMsg().click();
				
				//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
								
				
				
				
				//Actions action = new Actions(driver);
				//WebElement usericon = driver.findElement(By.className("user-icon"));
				//action.moveToElement(usericon).perform();
				//WebElement logoutbtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
				//action.moveToElement(logoutbtn).click().perform();
				//driver.quit();
			
				

			}

	@Test(groups="regression")
	public void CreateCampaignwithExpectedCloseDateTest() throws IOException {
		
//		PropertyFileUtility pLib = new PropertyFileUtility();
//		String BROWSER = pLib.readDataFromPropertyFile("Browser");
//		String URL = pLib.readDataFromPropertyFile("URL");
//		String USERNAME = pLib.readDataFromPropertyFile("Username");
//		String PASSWORD = pLib.readDataFromPropertyFile("Password");
		
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\Girish\\Desktop\\Commondata2.properties");
		//Properties prop = new Properties();
		//prop.load(fis);
		//String BROWSER = prop.getProperty("Browser");
		//String URL = prop.getProperty("URL");
		//String USERNAME = prop.getProperty("Username");
		
		//String PASSWORD = prop.getProperty("Password");
		
		//ExcelFileUtility eLib = new ExcelFileUtility();
		String campaignname = eLib.readDataFromExcelFile("Campaign",7, 2);
		String targetsize = eLib.readDataFromExcelFile("Campaign",7,3);
		
		
		
//FileInputStream fis1 = new FileInputStream("C:\\Users\\Girish\\Desktop\\NinzaCRM_M7.xlsx");
		
		//Workbook wb = WorkbookFactory.create(fis1);
		
		//Sheet sh = wb.getSheet("Campaign");
		
		//Row r = sh.getRow(7);
		
		//Cell c = r.getCell(2);
		
		//String campaignname = c.getStringCellValue();
		
 //Sheet sh2 = wb.getSheet("Campaign");
		
		//Row r2 = sh.getRow(7);
		
		//Cell c2 = r.getCell(3);
		
		//String targetsize = c2.getStringCellValue();

		//JavaUtility jLib = new JavaUtility();
		String requiredDate = jLib.getRequiredDate(100);
		System.out.println(requiredDate);
		
		
		//Date date = new Date();
		//SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		//sim.format(date);
		//Calendar cal = sim.getCalendar();
		//cal.add(cal.DAY_OF_MONTH, 30);
		//String requiredDate = sim.format(cal.getTime());
		//System.out.println(requiredDate);
//		ChromeOptions settings =new ChromeOptions();
//		Map<String,Object> prefs= new HashMap<>();
//		prefs.put("profile.password_manager_leak_detection", false);
//		settings.setExperimentalOption("prefs", prefs);
//		
//				WebDriver driver = null;
//				if(BROWSER.equalsIgnoreCase("chrome"))
//					driver = new ChromeDriver(settings);
//				else if(BROWSER.equalsIgnoreCase("edge"))
//					driver = new EdgeDriver();
//				else if(BROWSER.equalsIgnoreCase("firefox"))
//					driver = new FirefoxDriver();
//				else if(BROWSER.equalsIgnoreCase("safari"))
//					driver = new SafariDriver();
//				
//								
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
//				driver.get(URL);
//				driver.findElement(By.id("username")).sendKeys(USERNAME);
//				driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
//				driver.findElement(By.xpath("//button[text()='Sign In']")).click();
				
				CampaignsPage cp = new CampaignsPage(driver);
				cp.getAddCreateCampaignBtn().click();
				
				//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				
				CreateCampaignPage cp1 = new CreateCampaignPage(driver);
				cp1.getCampaignName().sendKeys(campaignname);
				
				
				//driver.findElement(By.name("campaignName")).sendKeys(campaignname);
				
				WebElement TarSize = cp1.getTargetSize();
				
				//WebElement targetsizeTF = driver.findElement(By.name("targetSize"));
				TarSize.clear();
				TarSize.sendKeys(targetsize);
				
				cp1.getExpectedCloseDate().sendKeys(requiredDate);
				
				cp1.getCreateCampaignBtn().click();
				//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
				
								
				HomePage hp = new HomePage(driver);
				
				
				WebElement toastMsg = hp.getToastMsg();
				
				//WebDriverUtility wLib = new WebDriverUtility();
				
				wLib.waitForVisibilityOfWebElement(driver,toastMsg);
				
				
				//WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
				//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
				//wait.until(ExpectedConditions.visibilityOf(toastmsg));
				//if(toastMsg.getText().contains(campaignname))
				//	System.out.println("Campaign created");
				//else
				//	System.out.println("Campaign not created");
				
				Assert.assertTrue(toastMsg.getText().contains(campaignname));
								
				hp.getCloseToastMsg().click();
				
				//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
								
				
				
				
				//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				//driver.findElement(By.name("campaignName")).sendKeys(campaignname);
				
				// targetsizeTF = driver.findElement(By.name("targetSize"));
				//targetsizeTF.clear();
				//targetsizeTF.sendKeys(targetsize);
				//driver.findElement(By.name("expectedCloseDate")).sendKeys(requiredDate);
				//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
				
				//WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
				//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
				//wait.until(ExpectedConditions.visibilityOf(toastmsg));
				//if(toastmsg.getText().contains(campaignname))
				//	System.out.println("Campaign created");
				//else
				//	System.out.println("Campaign not created");
				
				//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
				//HomePage hp = new HomePage(driver);
				
				//hp.logout();
				
				//Actions action = new Actions(driver);
				//WebElement usericon = driver.findElement(By.className("user-icon"));
				//action.moveToElement(usericon).perform();
				//WebElement logoutbtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
				//action.moveToElement(logoutbtn).click().perform();
				//driver.quit();
			
				

			}
	@Test(groups="regression")
	public void CreateCampaignWithStatusTest() throws IOException {
		
//		PropertyFileUtility pLib = new PropertyFileUtility();
//		String BROWSER = pLib.readDataFromPropertyFile("Browser");
//		String URL = pLib.readDataFromPropertyFile("URL");
//		String USERNAME = pLib.readDataFromPropertyFile("Username");
//		String PASSWORD = pLib.readDataFromPropertyFile("Password");
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\Girish\\Desktop\\Commondata2.properties");
		//Properties prop = new Properties();
		//prop.load(fis);
		//String BROWSER = prop.getProperty("Browser");
		//String URL = prop.getProperty("URL");
		//String USERNAME = prop.getProperty("Username");
		
		//String PASSWORD = prop.getProperty("Password");
		
		//ExcelFileUtility eLib = new ExcelFileUtility();
		String campaignname = eLib.readDataFromExcelFile("Campaign",4, 2);
		String targetsize = eLib.readDataFromExcelFile("Campaign",4,3);
		String status = eLib.readDataFromExcelFile("Campaign",4,4);
		
		
		
//FileInputStream fis2 = new FileInputStream("C:\\Users\\Girish\\Desktop\\NinzaCRM_M7.xlsx");
		
		//Workbook wb = WorkbookFactory.create(fis2);
		
		//Sheet sh = wb.getSheet("Campaign");
		
		//Row r = sh.getRow(4);
		
		//Cell c = r.getCell(2);
		
		//String campaignname = c.getStringCellValue();
		
 //Sheet sh2 = wb.getSheet("Campaign");
		
		//Row r2 = sh.getRow(4);
		
		//Cell c2 = r.getCell(3);
		
		//String targetsize = c2.getStringCellValue();
		
		
     //Sheet sh3 = wb.getSheet("Campaign");
		
		//Row r3 = sh.getRow(4);
		
		//Cell c4 = r.getCell(4);
		
		//String status = c4.getStringCellValue();
//		ChromeOptions settings =new ChromeOptions();
//		Map<String,Object> prefs= new HashMap<>();
//		prefs.put("profile.password_manager_leak_detection", false);
//		settings.setExperimentalOption("prefs", prefs);
//		
//				
//				WebDriver driver = null;
//				if(BROWSER.equalsIgnoreCase("chrome"))
//					driver = new ChromeDriver(settings);
//				else if(BROWSER.equalsIgnoreCase("edge"))
//					driver = new EdgeDriver();
//				else if(BROWSER.equalsIgnoreCase("firefox"))
//					driver = new FirefoxDriver();
//				else if(BROWSER.equalsIgnoreCase("safari"))
//					driver = new SafariDriver();
//							
//				
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//				
//				driver.get(URL);
//				driver.findElement(By.id("username")).sendKeys(USERNAME);
//				driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
//				driver.findElement(By.xpath("//button[text()='Sign In']")).click();
				
				CampaignsPage cp = new CampaignsPage(driver);
				cp.getAddCreateCampaignBtn().click();
				
				CreateCampaignPage cp1 = new CreateCampaignPage(driver);
				cp1.getCampaignName().sendKeys(campaignname);
				
				WebElement TarSize = cp1.getTargetSize();
				
				TarSize.clear();
				TarSize.sendKeys(targetsize);
								
				
				//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				//driver.findElement(By.name("campaignName")).sendKeys(campaignname);
				
				//WebElement targetsizeTF = driver.findElement(By.name("targetSize"));
				//targetsizeTF.clear();
				//targetsizeTF.sendKeys(targetsize);
				
				cp1.getCampaignStatus().sendKeys(status);
				
				//driver.findElement(By.name("campaignStatus")).sendKeys(status);
				
				cp1.getCreateCampaignBtn().click();
				
				//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
				
				HomePage hp = new HomePage(driver);
				
				//WebDriverUtility wLib= new WebDriverUtility();
				
				WebElement toastMsg = hp.getToastMsg();
				wLib.waitForVisibilityOfWebElement(driver,toastMsg);
				
				
				//WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
				//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
				//wait.until(ExpectedConditions.visibilityOf(toastmsg));
				//if(toastMsg.getText().contains(campaignname))
				//	System.out.println("Campaign created");
				//else
				//	System.out.println("Campaign not created");
				
				Assert.assertTrue(toastMsg.getText().contains(campaignname));
				System.out.println("Status added");
				
				hp.getCloseToastMsg().click();
				
				
				//WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
				//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
				//wait.until(ExpectedConditions.visibilityOf(toastmsg));
				//if(toastmsg.getText().contains(campaignname))
				//	System.out.println("Campaign created");
				//else
				//	System.out.println("Campaign not created");
				
				//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
				
				
				//Actions action = new Actions(driver);
				//WebElement usericon = driver.findElement(By.className("user-icon"));
				//action.moveToElement(usericon).perform();
				//WebElement logoutbtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
				//action.moveToElement(logoutbtn).click().perform();
				//driver.quit();
			
				

			}


}
