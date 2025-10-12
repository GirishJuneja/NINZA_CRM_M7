package package1;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericutility.ExcelFileUtility;
import objectrepository.HomePage;
import objectrepository.LoginPage;

public class WorkingWithDataProvider {
	
	@Test(dataProvider = "loginDetails")
	
	public void login(String username, String password)
	{
		ChromeOptions settings =new ChromeOptions();
		Map<String,Object> prefs= new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(settings);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		String url = "http://49.249.28.218:8098/";
		driver.get(url);
		lp.loginToApp(username, password);
		HomePage hp = new HomePage(driver);
		hp.logout();
		driver.quit();
		
	}

	@DataProvider
	public Object[][] loginDetails() throws  IOException
	{
	Object[][] objArr = new Object[6][2];
	ExcelFileUtility eLib = new ExcelFileUtility();
	int rowCount=eLib.getRowCount("DataProvider");
	
	for(int i = 1;i<=rowCount;i++)
	{
		objArr[i-1][0]=eLib.readDataFromExcelFile("DataProvider", i,0);
		objArr[i-1][1]=eLib.readDataFromExcelFile("DataProvider",i, 1);
	}
	
	
	//objArr[0][0]= "rmgyantra";
	//objArr[0][1]="rmgy@9999";
	//objArr[1][0]= "rmgyantra";
	//objArr[1][1]="rmgy@9999";
	//objArr[2][0]= "rmgyantra";
	//objArr[2][1]="rmgy@9999";
	//objArr[3][0]= "rmgyantra";
	//objArr[3][1]="rmgy@9999";
	return objArr;
	}
	
}
