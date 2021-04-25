package EmpRolePages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.Base;
import Utils.TestUtils;

public class EmpApplyLeave extends Base{
	
	@FindBy(xpath="//span[text()='Leave Management']")
	
    WebElement leaveManagmentMenu;
	
	@FindBy(xpath="//span[text()='Apply Leave']")
	
	WebElement applyleaveSubMenu;
	
    @FindBy(xpath="//button[@onclick='AddNewLeaveRequest()']")
	
	WebElement addNewLeaveRequest;
    
    @FindBy(xpath="//input[@type='checkbox']")
	
   	WebElement halfdayLeaveCheckbox;
    
    @FindBy(id="s2id_LeaveTypeList")
	
   	WebElement leaveTypeDropDownClick;
    
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
   	WebElement enterTextLeaveType;
    
    @FindBy(xpath="//ul[@class='select2-results']//div/span")
	
   	WebElement clickTextLeaveType;
    
    @FindBy(id="StartDateTime")
	
   	WebElement clickStartDate;
    
    @FindBy(id="EndDateTime")
	
   	WebElement clickEndDate;
    
    @FindBy(id="s2id_LeaveRequestTo")
	
   	WebElement clickLeaveRequestTo;
    
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
   	WebElement enterTextAssignLeaveRequestTo;
    
    @FindBy(xpath="//ul[@class='select2-results']//div/span")
	
   	WebElement clickAssignLeaveRequestTo;
    
    @FindBy(id="Details")
	
   	WebElement enterDetail;
    
    @FindBy(id="btnAddLeaveRequest")
	
   	WebElement clickApplyRequest;
    
   @FindBy(xpath="//input[@type='search']")
	
   	WebElement searchLeave;
   
   @FindBy(xpath="//table[@id='tblLeaveRequests']/tbody/tr/td[2]")
	
    List<WebElement> leaveRows ;
   
   @FindBy(xpath="//button[text()='OK']")
   
   WebElement confirmButton;
    
    
    
    static String toastMessage;
    
    static String Getleavetype;
    
    static String Getleavestatus;
    
   public EmpApplyLeave()
   {
	   PageFactory.initElements(driver, this);
   }
    
   
   public String addNewFullLeaveRequest(String Halfday, String leaveType, String startmonth, String startdate, String endmonth, String endate, String assignName, String reason) throws InterruptedException
   
   {
	   driver.navigate().refresh();
	   
	   TestUtils.jsClick(leaveManagmentMenu, driver);
	   
	  TestUtils.jsClick(applyleaveSubMenu, driver);
	  
	  TestUtils.scrollDown("window.scrollBy(0,400)", driver);
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   addNewLeaveRequest.click();
	   
	   if(Halfday.equalsIgnoreCase("YES"))
	   {
	   
	   halfdayLeaveCheckbox.click();
	   leaveTypeDropDownClick.click();
	   enterTextLeaveType.sendKeys(leaveType);
	   clickTextLeaveType.click();
	   clickStartDate.click();
	   
	   TestUtils.selectMonth(startmonth, driver);
	   TestUtils.selectDate(startdate, driver);
	   
	   clickLeaveRequestTo.click();
	   enterTextAssignLeaveRequestTo.sendKeys(assignName);
	   clickAssignLeaveRequestTo.click();
	   enterDetail.sendKeys(reason);
	   clickApplyRequest.click();
	   
	   toastMessage=driver.findElement(By.className("toast-message")).getText();
	   }
	   
	   else {
	   
	   leaveTypeDropDownClick.click();
	   enterTextLeaveType.sendKeys(leaveType);
	   clickTextLeaveType.click();
	   Thread.sleep(3000);
	   clickStartDate.click();
	   
	   TestUtils.selectMonth(startmonth, driver);
	   TestUtils.selectDate(startdate, driver);
	   
	   
	   clickEndDate.click();
	   TestUtils.selectMonth(endmonth, driver);
	   TestUtils.selectDate(endate, driver);
	   clickLeaveRequestTo.click();
	   enterTextAssignLeaveRequestTo.sendKeys(assignName);
	   clickAssignLeaveRequestTo.click();
	   enterDetail.sendKeys(reason);
	   clickApplyRequest.click();
	   
	   toastMessage=driver.findElement(By.className("toast-message")).getText();
	   
	   
	   
}
	   return toastMessage;
   }
   
   public String cancelLeave(String leaveStatus, String leaveType)
   {
        driver.navigate().refresh();
	   
	   TestUtils.jsClick(leaveManagmentMenu, driver);
	   
	  TestUtils.jsClick(applyleaveSubMenu, driver);
	   TestUtils.scrollDown("window.scrollBy(0,400)", driver);
	   
	   searchLeave.sendKeys(leaveStatus);

	   for(int i=1;i<=leaveRows.size();i++)
	   {
	   	
	    Getleavetype=	driver.findElement(By.xpath("//table[@id='tblLeaveRequests']/tbody/tr["+i+"]/td[2]")).getText();


	   if(Getleavetype.equalsIgnoreCase(leaveType))
	   {
	     Getleavestatus=	driver.findElement(By.xpath("//table[@id='tblLeaveRequests']/tbody/tr["+i+"]/td[3]")).getText();
	   }

	   if(Getleavetype.equalsIgnoreCase(leaveType)&& Getleavestatus.equalsIgnoreCase(leaveStatus))
	   {
	   	driver.findElement(By.xpath("//table[@id='tblLeaveRequests']/tbody/tr["+i+"]/td[7]//a")).click();
	   	break;
	   }
	   	   
	   }

	   TestUtils.jsClick(confirmButton, driver);

	   driver.switchTo().activeElement();

	    toastMessage= driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
	    
	   return toastMessage;             

   }
    
    
    
    
    
    
    
	
	

}
