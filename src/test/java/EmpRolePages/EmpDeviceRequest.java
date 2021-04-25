package EmpRolePages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import Utils.TestUtils;

public class EmpDeviceRequest extends Base {
	
	
	@FindBy(xpath = "//span[text()='Asset Management']")

	WebElement assetMenu;
	
	@FindBy(xpath = "//span[text()='My Devices']")

	WebElement mydeviceMenu;
	
	@FindBy(xpath = "//span[text()='Device Dashboard']")

	WebElement deviceDashMenu;
	
	@FindBy(xpath = "//button[@onclick='AddNewRequest()']")

	WebElement addNewDeviceRequest;
	
	@FindBy(id = "s2id_NameOfDevice")

	WebElement modelNameDropdown;
	
	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextModelName;
	
	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextModelName;
	
	@FindBy(xpath = "//button[@onclick='SaveDetails()']")

	WebElement submitRequest;
	
	@FindBy(id = "s2id_Status")

	WebElement clickSearch;
	
	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterSearchText;
	
	@FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clickSearchText;
	
    @FindBy(xpath = "//button[@name='btn_Submit']")
	
	WebElement searchButton;
    
    @FindBy(xpath = "//div[@id='DeviceHistory_filter']/label/input")
	
	WebElement searchDeviceName;
    
    @FindBy(xpath = "//table[@id='DeviceHistory']/tbody/tr/td[9]")
	
	WebElement actionButton;
    
    @FindBy(xpath = "//table[@id='DeviceHistory']/tbody/tr/td[9]/div//ul")
	
	WebElement cancelButton;
   
    @FindBy(xpath = "//table[@id='DeviceHistory']/tbody/tr/td[9]//ul/child::li[1]")
	
	WebElement assignButton;
    
    @FindBy(xpath = "//table[@id='DeviceHistory']/tbody/tr/td[9]//ul/child::li[2]")
	
	WebElement releaseButton;
    
   @FindBy(xpath = "//button[text()='OK']")
	
	WebElement clickReleaseSubmit;
    
    @FindBy(id = "s2id_Assigne_To")
	
	WebElement AssignToDropdown;
    
    @FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextAssignToDropdown;
	
	@FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clickTextAssignToDropdown;
	
    @FindBy(xpath = "//div[@id='ActiveDeviceDetails_filter']/label/input")
	
	WebElement activeDeviceSearch;
   
    @FindBy(xpath = "//table[@id='ActiveDeviceDetails']/tbody/tr")
	
	List<WebElement> ADList;
    
    @FindBy(xpath = "//div[@id='DeviceReceivedDetails_filter']/label/input")
	
	WebElement deviceReceivedSearch;
    
    @FindBy(xpath = "//table[@id='DeviceReceivedDetails']/tbody/tr")
	
	List<WebElement> DRList;
    
    @FindBy(xpath = "//div[@id='DeviceRequestDetails_filter']/label/input")
	
   	WebElement deviceRequestSearch;
    
    @FindBy(xpath = "//table[@id='DeviceRequestDetails']/tbody/tr")
	
	List<WebElement> DReqList;
    
    
	
	String toastMessage;
	
	String AAD_ModelName;
	
	String DR_Date;
	
	String DReq_Date;
	
	
	
	 public EmpDeviceRequest()
	    {
	    	PageFactory.initElements(driver, this);
	    }
	
	
	
	public String addDeviceRequest(String ModelName)
	{
		
		   driver.navigate().refresh();
		   
		   TestUtils.scrollDown("window.scrollBy(0,400)", driver);
		   
		   TestUtils.jsClick(assetMenu, driver);
		   
		  TestUtils.jsClick(mydeviceMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  addNewDeviceRequest.click();
		  
		  modelNameDropdown.click();
		
		  enterTextModelName.sendKeys(ModelName);
		  
		  clickTextModelName.click();
		  
		  submitRequest.click();
		  
		  toastMessage=driver.findElement(By.className("toast-message")).getText();
		
		return toastMessage;
			
	}
	
	public String cancelDeviceRequest(String DeviceStatus,String DeviceName)
	{
		
		   driver.navigate().refresh();
		   
		   TestUtils.scrollDown("window.scrollBy(0,400)", driver);
		   
		   TestUtils.jsClick(assetMenu, driver);
		   
		  TestUtils.jsClick(mydeviceMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  clickSearch.click();
		
		  enterSearchText.sendKeys(DeviceStatus);
		
		  clickSearchText.click();
		  
		  searchButton.click();
		  
		  searchDeviceName.sendKeys(DeviceName);
		
		  actionButton.click();
		  
		  cancelButton.click();
		
		  toastMessage=driver.findElement(By.className("toast-message")).getText();
			
			return toastMessage;
	}
	
	public String assignDevice(String DeviceName,String AssignUser )
	{
		driver.navigate().refresh();
		   
		   TestUtils.scrollDown("window.scrollBy(0,400)", driver);
		   
		   TestUtils.jsClick(assetMenu, driver);
		   
		  TestUtils.jsClick(mydeviceMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
          searchButton.click();
		  
		  searchDeviceName.sendKeys(DeviceName);
		  
		  actionButton.click();
		  
		  assignButton.click();
		  
		  modelNameDropdown.click();
			
		  enterTextModelName.sendKeys(DeviceName);
		  
		  clickTextModelName.click();
		  
		  AssignToDropdown.click();
		  
		  enterTextAssignToDropdown.sendKeys(AssignUser);
		  
		  clickTextAssignToDropdown.click();
		  
          submitRequest.click();
		  
		  toastMessage=driver.findElement(By.className("toast-message")).getText();
		
		return toastMessage;
		  
		  
	}
	
	
	public String releaseDevice(String DeviceName)
	{
	
		   driver.navigate().refresh();
		   
		   TestUtils.scrollDown("window.scrollBy(0,400)", driver);
		   
		   TestUtils.jsClick(assetMenu, driver);
		   
		  TestUtils.jsClick(mydeviceMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
           searchButton.click();
		  
		  searchDeviceName.sendKeys(DeviceName);
		  
		  actionButton.click();
		
		  releaseButton.click();
		  
		  TestUtils.jsClick(clickReleaseSubmit, driver);
		  
		  toastMessage=driver.findElement(By.className("toast-message")).getText();
			
			return toastMessage;
		
		
	}
	

	
	
	
	public void searchDeviceDashboard(String AD_DeviceName, String AD_Count, String EAD_ModelName, String DR_DeviceName, String EDR_Count, String EDR_Date, String DREQ_DeviceName, String EDREQ_Count,String EDREQ_Date )
	{
		
		   driver.navigate().refresh();
		   
		   TestUtils.scrollDown("window.scrollBy(0,400)", driver);
		   
		   TestUtils.jsClick(assetMenu, driver);
		   
		  TestUtils.jsClick(deviceDashMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
		
		  activeDeviceSearch.sendKeys(AD_DeviceName);
		
		  int AADcount = ADList.size();
		  
		  int EADcount =Integer.parseInt(AD_Count);
		  
		  AAD_ModelName=  driver.findElement(By.xpath("//table[@id='ActiveDeviceDetails']/tbody/tr/td[3]")).getText().trim();		
		
		  Assert.assertEquals(AADcount, EADcount);
		  
		  Assert.assertEquals(AAD_ModelName, EAD_ModelName);
		  
		  
		   TestUtils.scrollDown("window.scrollBy(0,600)", driver);

		   deviceReceivedSearch.sendKeys(DR_DeviceName);
		   
		 int ADRCount=  DRList.size();
		 
		 int EDRCount =Integer.parseInt(EDR_Count);
		 
		 DR_Date = driver.findElement(By.xpath("//table[@id='DeviceReceivedDetails']/tbody/tr/td[4]")).getText().trim();	
		 
		 Assert.assertEquals(ADRCount, EDRCount);
		 
		 Assert.assertEquals(DR_Date, EDR_Date);
		 
		 TestUtils.scrollDown("window.scrollBy(0,600)", driver);
		 
		 
		 deviceRequestSearch.sendKeys(DREQ_DeviceName);
		
		int ADREQCount =DReqList.size();
		
		int EDREQCount= Integer.parseInt(EDREQ_Count);
		
		DReq_Date = driver.findElement(By.xpath("//table[@id='DeviceRequestDetails']/tbody/tr/td[4]")).getText().trim();
		
		Assert.assertEquals(ADREQCount, EDREQCount);
		
		Assert.assertEquals(DReq_Date, EDREQ_Date);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
