package package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCampaign {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("test");
		
		WebElement targetsizeTF = driver.findElement(By.name("targetSize"));
		targetsizeTF.clear();
		targetsizeTF.sendKeys("7");
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		if(toastmsg.getText().contains("test"))
			System.out.println("Campaign created");
		else
			System.out.println("Campaign not created");
		
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		Actions action = new Actions(driver);
		WebElement usericon = driver.findElement(By.className("user-icon"));
		action.moveToElement(usericon).perform();
		WebElement logoutbtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		action.moveToElement(logoutbtn).click().perform();
		driver.quit();
				
		

	}

}
