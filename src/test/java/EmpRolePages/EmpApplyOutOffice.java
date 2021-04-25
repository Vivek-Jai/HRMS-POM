package EmpRolePages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import Utils.TestUtils;

public class EmpApplyOutOffice extends Base  {
	
	@FindBy(xpath = "//span[text()='Leave Management']")

	WebElement leaveManagmentMenu;

	@FindBy(xpath = "//span[text()='Apply Out Of Office']")

	WebElement applyOutOfficeSubMenu;
	
	@FindBy(xpath = "//button[@onclick='Apply()']")

	WebElement addNewOutOfficeRequest;
	
	@FindBy(id = "StartDate")

	WebElement clickStartDate;

	@FindBy(id = "EndDate")

	WebElement clickEndDate;
	
	@FindBy(id = "Alternateno")

	WebElement enterContactnum;
	
	@FindBy(id = "s2id_ODPlaceID")

	WebElement clickWorkingPlace;
	
	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterThePlace;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickThePlace;
	
	@FindBy(id = "s2id_ODAssignedToID")

	WebElement clickAssingto;
	
	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextAssingto;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextAssingto;
	
	@FindBy(id = "ODComments")

	WebElement leaveComments;
	
	@FindBy(xpath = "//button[@id='apply']")

	WebElement clickApplyRequest;
	
	@FindBy(xpath = "//button[text()='OK']")

	WebElement confirmButton;
	
	@FindBy(xpath="//input[@type='search']")

	WebElement searchOutOfficeRequest;
	
    @FindBy(xpath="//table[@id='tblUsers']/tbody/tr/td[3]")
	
    List<WebElement> outofficestatus ;
    
    @FindBy(xpath="//button[@onclick='Redirect1()']")
    
    WebElement updateLater;
	
	
	
	String toastMessage;
	 String GetOutOfficeStatus;
	 
	 String GetRequestDate;
	
	
	 public EmpApplyOutOffice()
	   {
		   PageFactory.initElements(driver, this);
	   }
	 
	 public String applyOutOffice(String Startmonth, String Startdate, String Endmonth, String Enddate, String ContactNo, String Place, String Assign, String comments)
	 {
		 driver.navigate().refresh();
		   
		   TestUtils.jsClick(leaveManagmentMenu, driver);
		   
		  TestUtils.jsClick(applyOutOfficeSubMenu, driver);
		  
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  addNewOutOfficeRequest.click();
		  
		  clickStartDate.click();
		   TestUtils.selectMonth(Startmonth, driver);
		   TestUtils.selectDate(Startdate, driver);
		   
		   clickEndDate.click();
		   TestUtils.selectMonth(Endmonth, driver);
		   TestUtils.selectDate(Enddate, driver);
		   
		   enterContactnum.sendKeys(ContactNo);
		    
		   clickWorkingPlace.click();
		   enterThePlace.sendKeys(Place);
		   clickThePlace.click();
		   
		   clickAssingto.click();
		   enterTextAssingto.sendKeys(Assign);
		   clickTextAssingto.click();
		   
		   leaveComments.sendKeys(comments);
		   
		   clickApplyRequest.click();
		   
		   TestUtils.expilicitWaittoClick(driver, "//button[text()='OK']", 20);
		   
		  
		   
		   toastMessage= driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		    
		   return toastMessage;
		   
	 }
	 
	 public String cancelOutOfficeRequest(String RequestStatus, String RequestDate)
	 {
		 updateLater.click();
		  driver.navigate().refresh();
		  
		  
		  
		   TestUtils.jsClick(leaveManagmentMenu, driver);
		   
		  TestUtils.jsClick(applyOutOfficeSubMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  searchOutOfficeRequest.sendKeys(RequestStatus);
		 
		  for(int i=1;i<=outofficestatus.size();i++)
		   {
		   	
		    GetOutOfficeStatus=	driver.findElement(By.xpath("//table[@id='tblUsers']/tbody/tr["+i+"]/td[3]")).getText().trim();
		
		    if(GetOutOfficeStatus.equalsIgnoreCase(RequestStatus))
			   {
			     GetRequestDate =	driver.findElement(By.xpath("//table[@id='tblUsers']/tbody/tr["+i+"]/td[4]")).getText().trim();
			   }
		
		    if(GetOutOfficeStatus.equalsIgnoreCase(RequestStatus)&& GetRequestDate.equalsIgnoreCase(RequestDate))
			   {
			   	driver.findElement(By.xpath("//table[@id='tblUsers']/tbody/tr["+i+"]/td[6]")).click();
			   	driver.findElement(By.xpath("//table[@id='tblUsers']/tbody/tr[1]/td[6]/div//ul/li[2]")).click();
			   	break;
			   }
		
		   }
		  
		  TestUtils.expilicitWaittoClick(driver, "//button[text()='OK']", 20);
		  
		  //TestUtils.jsClick(confirmButton, driver);

		   

		    toastMessage= driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		    
		   return toastMessage;
		 
	 }
	
	
	

}
