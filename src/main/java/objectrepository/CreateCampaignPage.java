package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

WebDriver driver;
	
	public CreateCampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="campaignName")
	private WebElement CampaignName;
	
	@FindBy(name="targetSize")
	private WebElement TargetSize;
	
	@FindBy(name="expectedCloseDate")
	private WebElement ExpectedCloseDate;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement CreateCampaignBtn;
	
	@FindBy(name="campaignStatus")
	private WebElement CampaignStatus;

	public WebElement getCampaignStatus() {
		return CampaignStatus;
	}

	public WebElement getCampaignName() {
		return CampaignName;
	}

	public WebElement getTargetSize() {
		return TargetSize;
	}

	public WebElement getExpectedCloseDate() {
		return ExpectedCloseDate;
	}

	public WebElement getCreateCampaignBtn() {
		return CreateCampaignBtn;
	}
	
	
	
	}
	

