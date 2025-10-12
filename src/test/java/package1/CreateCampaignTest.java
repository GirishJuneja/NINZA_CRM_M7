package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateCampaignTest {
	
	@Test(invocationCount=5,threadPoolSize=2, enabled=false)
	
	public void createCampaignWithMandatoryFields()
	{
		WebDriver driver = new ChromeDriver();
		System.out.println("Create Campaign with mandatory fields");
	}
	
	@Test(dependsOnMethods = {"register", "openApplication"})
	
	public void login()
	{
		System.out.println("login");
	}
	
	@Test(dependsOnMethods = "openApplication")
	
	public void register()
	{
		System.out.println("register");
	}
	
	@Test
	
	public void openApplication()
	{
		System.out.println("openApplication");
	}
	
	//@Test(priority=-2, invocationCount=2)
	
	//public void createCampaignWithStatus()
	{
	//	System.out.println("Create Campaign with Status");
		
		
	}

	//@Test(priority=-2,invocationCount=0)
	
	//public void createCampaignWithExpectedCloseDate()
	{
	//	System.out.println("createCampaign with Expected Close Date");
	}
	
}
