package EmpRolePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import Utils.TestUtils;

public class EmpViewEditTimeSheet extends Base {
	
	@FindBy(xpath = "//span[text()='Time Sheet Management']")

	WebElement timesheetManagmentMenu;

	@FindBy(xpath = "//span[text()='View / Edit Time Sheet']")

	WebElement timesheetsubMenu;
	
	@FindBy(id="StartDatevalue")
	
	WebElement StartDate;
	
	@FindBy(id="Datevalue")
	
	WebElement EndDate;
	
	@FindBy(xpath="//button[@onclick='DateChange()']")
	
	WebElement ShowButton;
	
	@FindBy(xpath="//table[@id='tblMeeting']/tbody/tr")
	
	List<WebElement> tablerow;
	
	
	String ActualTaskDate;
	
	String ActualTaskID;
	
	String TimesheetStatus;
	
	 public EmpViewEditTimeSheet()
	   {
		   PageFactory.initElements(driver, this);
	   }
	
	 
	 public String viewTimesheet(String startmonth, String startdate, String endmonth, String enddate, String exptaskdate, String exptaskid)
	 {
		 
		 
		 driver.navigate().refresh();
		   
		   TestUtils.jsClick(timesheetManagmentMenu, driver);
		   
		  TestUtils.jsClick(timesheetsubMenu, driver);
		  
		  
		  
		  StartDate.click();
		  
		  TestUtils.selectMonth(startmonth, driver);
		  TestUtils.selectDate(startdate, driver);
		  
		  EndDate.click();
		  
		  TestUtils.selectMonth(endmonth, driver);
		  TestUtils.selectDate(enddate, driver);
		  
		  ShowButton.click();
		  
		  TestUtils.scrollDown("window.scrollBy(0,600)", driver);
		  
		  for(int i=1;i<=tablerow.size();i++)
		  {
			  
			  ActualTaskDate= driver.findElement(By.xpath("//table[@id='tblMeeting']/tbody/tr["+i+"]/td[3]")).getText().trim();
			  
			  System.out.println(ActualTaskDate);
			  
			  if(ActualTaskDate.equalsIgnoreCase(exptaskdate))
			  {
				  ActualTaskID = driver.findElement(By.xpath("//table[@id='tblMeeting']/tbody/tr["+i+"]/td[5]")).getText().trim();
				  
				  System.out.println(ActualTaskID);
			  }
			  
			  if(ActualTaskDate.equalsIgnoreCase(exptaskdate)&& ActualTaskID.equalsIgnoreCase(exptaskid) )
			  {
			  
				  TimesheetStatus = driver.findElement(By.xpath("//table[@id='tblMeeting']/tbody/tr["+i+"]/td[9]")).getText().trim();
				  
				  System.out.println(TimesheetStatus);
				  
				  break;
			  }
			  
			  
		  }

		  return TimesheetStatus;
		  
		 
		 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
