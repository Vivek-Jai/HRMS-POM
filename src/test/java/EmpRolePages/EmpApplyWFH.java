package EmpRolePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import Utils.TestUtils;

public class EmpApplyWFH extends Base {
	
	
	@FindBy(xpath = "//span[text()='Leave Management']")

	WebElement leaveManagmentMenu;

	@FindBy(xpath = "//span[text()='Apply Work From Home']")

	WebElement applyWfhSubMenu;

	@FindBy(xpath = "//button[@onclick='applyWorkFromHome()']")

	WebElement addNewWfhRequest;

	@FindBy(id = "StartDate")

	WebElement clickStartDate;

	@FindBy(id = "EndDate")

	WebElement clickEndDate;

	@FindBy(id = "Alternateno")

	WebElement enterContactnum;

	@FindBy(id = "s2id_ODAssignedToID")

	WebElement clickWfhRequestTo;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextAssignWfhRequestTo;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickAssignWfhRequestTo;

	@FindBy(id = "ODComments")

	WebElement leaveComments;

	@FindBy(xpath = "//button[@id='apply']")

	WebElement clickApplyRequest;

	@FindBy(xpath = "//button[text()='OK']")

	WebElement confirmButton;
	
	@FindBy(xpath="//input[@type='search']")

	WebElement searchWFHRequest;
	
    @FindBy(xpath="//table[@id='tblUsers']/tbody/tr/td[3]")
	
    List<WebElement> wfhstatus ;
	
	
	
	
	 String toastMessage;
	 
	 String GetWFHStatus;
	 
	 String GetRequestDate;
	
	
	
	
	  public EmpApplyWFH()
	   {
		   PageFactory.initElements(driver, this);
	   }
	  
	  
	  public String addNewWFHRequest(String Startmonth, String Startdate, String EndMonth, String EndDate,String PhNo, String assignName, String reason)
	  {
		  driver.navigate().refresh();
		   
		   TestUtils.jsClick(leaveManagmentMenu, driver);
		   
		  TestUtils.jsClick(applyWfhSubMenu, driver);
		  
		 
		   
		  addNewWfhRequest.click();
		  
		  clickStartDate.click();
		  
		  TestUtils.selectMonth(Startmonth, driver);
		   TestUtils.selectDate(Startdate, driver);
		  
		   clickEndDate.click();
		   TestUtils.selectMonth(EndMonth, driver);
		   TestUtils.selectDate(EndDate, driver);
		   
		   enterContactnum.sendKeys(PhNo);
		   clickWfhRequestTo.click();
		   enterTextAssignWfhRequestTo.sendKeys(assignName);
		   clickAssignWfhRequestTo.click();
		   leaveComments.sendKeys(reason);
		   clickApplyRequest.click();
		   TestUtils.jsClick(confirmButton, driver);
		   
		   
		   //driver.switchTo().activeElement();

		    toastMessage= driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
		    
		   return toastMessage; 
		   
		   
		  
	  }


public String cancelWFHRequest(String WFHRequestStatus, String RequestDate)
{
	
	   driver.navigate().refresh();
	   
	   TestUtils.jsClick(leaveManagmentMenu, driver);
	   
	  TestUtils.jsClick(applyWfhSubMenu, driver);
	  
	  TestUtils.scrollDown("window.scrollBy(0,300)", driver);
	  
	  searchWFHRequest.sendKeys(WFHRequestStatus);
	  
	  for(int i=1;i<=wfhstatus.size();i++)
	   {
	   	
	    GetWFHStatus=	driver.findElement(By.xpath("//table[@id='tblUsers']/tbody/tr["+i+"]/td[3]")).getText().trim();
	
	    if(GetWFHStatus.equalsIgnoreCase(WFHRequestStatus))
		   {
		     GetRequestDate =	driver.findElement(By.xpath("//table[@id='tblUsers']/tbody/tr["+i+"]/td[4]")).getText().trim();
		   }
	
	    if(GetWFHStatus.equalsIgnoreCase(WFHRequestStatus)&& GetRequestDate.equalsIgnoreCase(RequestDate))
		   {
		   	driver.findElement(By.xpath("//table[@id='tblUsers']/tbody/tr["+i+"]/td[7]")).click();
		   	driver.findElement(By.xpath("//table[@id='tblUsers']/tbody/tr["+i+"]/td[7]/div//ul")).click();
		   	break;
		   }
	
	   }
	  
	  TestUtils.jsClick(confirmButton, driver);

	   driver.switchTo().activeElement();

	    toastMessage= driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
	    
	   return toastMessage;
}






}
