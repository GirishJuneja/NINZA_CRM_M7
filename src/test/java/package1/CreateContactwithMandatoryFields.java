package package1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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

import objectrepository.HomePage;

public class CreateContactwithMandatoryFields {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Girish\\Desktop\\Commondata2.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("URL");
		String USERNAME = prop.getProperty("Username");
		
		String PASSWORD = prop.getProperty("Password");
		
				
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
				driver.findElement(By.id("username")).sendKeys(USERNAME);
				driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//button[text()='Sign In']")).click();
				
				
				driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				driver.findElement(By.name("campaignName")).sendKeys("testg");
				
				WebElement targetsizeTF = driver.findElement(By.name("targetSize"));
				targetsizeTF.clear();
				targetsizeTF.sendKeys("7");
				driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
				
				WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
				wait.until(ExpectedConditions.visibilityOf(toastmsg));
				if(toastmsg.getText().contains("testg"))
					System.out.println("Campaign created");
				else
					System.out.println("Campaign not created");
				
				driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
				driver.findElement(By.linkText("Contacts")).click();
				String parentid = driver.getWindowHandle();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
				driver.findElement(By.name("organizationName")).sendKeys("test org");
				driver.findElement(By.name("title")).sendKeys("GJ");
				driver.findElement(By.name("contactName")).sendKeys("Juneja");
				driver.findElement(By.name("mobile")).sendKeys("9999999999");
				driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
				String windowid = driver.getWindowHandle();
				driver.switchTo().window(windowid);
				Thread.sleep(3000);
				
				//driver.switchTo().frame(1);
				 driver.findElement(By.xpath("(//button[text()='Select'])[1]")).click();
				 
				 
				 //driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
				 
				//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
				
				driver.switchTo().window(parentid);
				Thread.sleep(3000);
				
				
				
				//driver.findElement(By.xpath("//td[text()='Campaigntest']")).click();
				
				HomePage hp = new HomePage(driver);
				hp.logout();
				
				
				//Actions action = new Actions(driver);
				//WebElement usericon = driver.findElement(By.className("user-icon"));
				//action.moveToElement(usericon).perform();
				//WebElement logoutbtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
				//action.moveToElement(logoutbtn).click().perform();
				driver.quit();
			
				

			}

		}

		
		
		

	


