package contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectrepository.CampaignsPage;
import objectrepository.ContactsPage;
import objectrepository.CreateCampaignPage;
import objectrepository.CreateContactPage;
import objectrepository.HomePage;
import objectrepository.SelectCampaignPage;

public class CreateContactTest extends BaseClass{
	
	@Test(groups= {"smoke","regression"})
	
	public void createContactWithMandatoryFieldsTest() throws EncryptedDocumentException, IOException
	{
		String CAMPAIGN_NAME = eLib.readDataFromExcelFile("Contact", 1, 2);
		String TARGET_SIZE = eLib.readDataFromExcelFile("Contact", 1,3);
		String TITLE = eLib.readDataFromExcelFile("Contact", 1, 5);
		String CONTACT_NAME = eLib.readDataFromExcelFile("Contact", 1, 6);
		String ORGANIZATION_NAME = eLib.readDataFromExcelFile("Contact", 1, 4);
		
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getAddCreateCampaignBtn().click();
		
		CreateCampaignPage ccp= new CreateCampaignPage(driver);
		ccp.getCampaignName().sendKeys(CAMPAIGN_NAME);
		ccp.getTargetSize().clear();
		ccp.getTargetSize().sendKeys(TARGET_SIZE);
		ccp.getCreateCampaignBtn().click();
		
		HomePage hp = new HomePage(driver);
		WebElement toastMsg = hp.getToastMsg();
		wLib.waitForVisibilityOfWebElement(driver,toastMsg);
		hp.getCloseToastMsg().click();
		
		hp.getContactsLink().click();
		ContactsPage contactPage= new ContactsPage(driver);
		contactPage.getAddCreateContactBtn().click();
		CreateContactPage createContactPage=new CreateContactPage(driver);
		createContactPage.getOrganizationNameTF().sendKeys(ORGANIZATION_NAME);
		createContactPage.getTitleTF().sendKeys(TITLE);
		createContactPage.getContactNameTF().sendKeys(CONTACT_NAME);
		createContactPage.getMobileTF().sendKeys("8562736230");
		String parentId = driver.getWindowHandle();
		createContactPage.getPlusBtn().click();
		wLib.switchToWindowOnTitle(driver, "Select Campaign");
		SelectCampaignPage scp=new SelectCampaignPage(driver);
		http://wLib.select(scp.getCampaignDD(), "campaignName");
		scp.getSearchBar().sendKeys(CAMPAIGN_NAME);
		wLib.waitForVisibilityOfWebElement(driver, scp.getSelectBtn());
		scp.getSelectBtn().click();
		wLib.switchBackToParentId(driver,parentId);
		createContactPage.getCreateContactSubmitBtn().click();
		WebElement toastMsg1 = hp.getToastMsg();
		wLib.waitForVisibilityOfWebElement(driver, toastMsg1);
		//if (toastMsg1.getText().contains(CONTACT_NAME))
		//	System.out.println("Contact Created");
		//else
		//	System.out.println("Contact Not Created");
		
		Assert.assertTrue(toastMsg1.getText().contains(CONTACT_NAME));
		hp.getCloseToastMsg().click();
		
			
}
		
		
	}
	


