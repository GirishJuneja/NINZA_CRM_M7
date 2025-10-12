package package1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericutility.ExcelFileUtility;
import genericutility.PropertyFileUtility;
import genericutility.WebDriverUtility;
import objectrepository.CampaignsPage;
import objectrepository.CreateCampaignPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;

public class UsingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String BROWSER = pLib.readDataFromPropertyFile("Browser");
		String URL = pLib.readDataFromPropertyFile("URL");
		String USERNAME = pLib.readDataFromPropertyFile("Username");
		String PASSWORD = pLib.readDataFromPropertyFile("Password");
		
		WebDriverUtility wLib = new WebDriverUtility();

		//FileInputStream fis = new FileInputStream("C:\\Users\\Girish\\Desktop\\Commondata2.properties");
		//Properties prop = new Properties();
		//prop.load(fis);
		//String BROWSER = prop.getProperty("Browser");
		//String URL = prop.getProperty("URL");
		//String USERNAME = prop.getProperty("Username");
		
		//String PASSWORD = prop.getProperty("Password");
		
		ExcelFileUtility eLib = new ExcelFileUtility();
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
		
				
				WebDriver driver = null;
				if(BROWSER.equalsIgnoreCase("chrome"))
					driver = new ChromeDriver();
				else if(BROWSER.equalsIgnoreCase("edge"))
					driver = new EdgeDriver();
				else if(BROWSER.equalsIgnoreCase("firefox"))
					driver = new FirefoxDriver();
				else if(BROWSER.equalsIgnoreCase("safari"))
					driver = new SafariDriver();
				
								
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				driver.get(URL);
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				
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
				if(toastMsg.getText().contains(campaignname))
					System.out.println("Campaign created");
				else
					System.out.println("Campaign not created");
				
				hp.getCloseToastMsg().click();
				
				//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
								
				hp.logout();
				
				
				//Actions action = new Actions(driver);
				//WebElement usericon = driver.findElement(By.className("user-icon"));
				//action.moveToElement(usericon).perform();
				//WebElement logoutbtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
				//action.moveToElement(logoutbtn).click().perform();
				//driver.quit();
			
				

			}

		}

		

	


