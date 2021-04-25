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

public class EmpConferenceBooking extends Base{
	
	@FindBy(xpath = "//span[text()='Conference Room Booking']")

	WebElement conferenceMenu;
	
	@FindBy(xpath = "//input[@onclick='AddBooking()']")

	WebElement addNewBooking;
	
	@FindBy(id = "s2id_purpose")

	WebElement purpose;
	
	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextPurpose;
	
	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextPurpose;
	
	@FindBy(xpath = "//a[@class='select2-search-choice-close']")

	WebElement clearDept;
	
	@FindBy(xpath = "//div[@id='s2id_department']//input")

	WebElement enterDeptName;
	
	@FindBy(xpath = "//div[@id='select2-drop']")

	WebElement clickDeptName;
	
	@FindBy(id = "txtarea_Description")

	WebElement trainingName;
	
	@FindBy(id = "txt_BookedDate")

	WebElement trainingDate;
	
	@FindBy(xpath = "(//input[@class='tp_hr'])[1]")

	WebElement startHour;
	
	@FindBy(xpath = "(//input[@class='tp_min'])[1]")

	WebElement startMinute;
	
	@FindBy(xpath = "(//input[@class='tp_am_pm'])[1]")

	WebElement startOcassion;
	
	@FindBy(xpath = "(//input[@class='tp_hr'])[2]")

	WebElement endHour;
	
	@FindBy(xpath = "(//input[@class='tp_min'])[2]")

	WebElement endMinute;
	
	@FindBy(xpath = "(//input[@class='tp_am_pm'])[2]")

	WebElement endOcassion;
	
	@FindBy(id = "s2id_projectNameId")

	WebElement projectName;
	
	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextProject;
	
	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextProject;
	
	@FindBy(id = "btnAdd")

	WebElement submit;
	
	@FindBy(xpath="//input[@onclick='AddNotAvailable()']")
	
	WebElement cfNotavailable;
	
	@FindBy(id="txt_BookedDate")
	
	WebElement bookingDate;
	
    @FindBy(id="cb0")
	
	WebElement bookedSlot;
    
    @FindBy(xpath="//button[@onclick='SaveNewBooking()']")
	
   	WebElement confirmBS;
    
    @FindBy(xpath="//input[@onclick='Meeting()']")
    
    WebElement myMeet;
    
    @FindBy(xpath="//div[@id='tblUserBookedList_filter']//input")
    
    WebElement mybookSearch;
    
   @FindBy(xpath="//div[@id='tblUserReBookedList_filter']//input")
    
    WebElement CRNASearch;
    
    @FindBy(xpath="//table[@id='tblUserBookedList']/tbody/tr")
	
    List<WebElement> myBookRows ;
    
    @FindBy(xpath="//table[@id='tblUserReBookedList']/tbody/tr")
	
    List<WebElement> CRNARows ;
	
	String toastMessage;
	
	String GetMyBookMeetName;
	
	String GetCRNAdate;
	
	
	 public EmpConferenceBooking()
	    {
	    	PageFactory.initElements(driver, this);
	    }
	
	
	public String bookConferenceRoom(String pText, String depText, String tName, String Mon, String Date, String startHR,String startMin, String startCcc, String endHR, String endMin, String endOcc, String pName)
	{
		
		   driver.navigate().refresh();
		   
		   TestUtils.jsClick(conferenceMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  addNewBooking.click();
		  
		  purpose.click();
		  
		  enterTextPurpose.sendKeys(pText);
		  
		  clickTextPurpose.click();
		  
		  clearDept.click();
		  
		  enterDeptName.sendKeys(depText);
		  
		  clickDeptName.click();
		  
		  trainingName.sendKeys(tName);
		  
		  trainingDate.click();
		  
		  TestUtils.selectMonth(Mon, driver);
		  
		  TestUtils.selectDate(Date, driver);
		  
		  TestUtils.enterTime(driver, startHour, startHR);
		  
		  TestUtils.enterTime(driver, startMinute, startMin);
		  
		  TestUtils.enterTime(driver, startOcassion, startCcc);
		  
		  TestUtils.enterTime(driver, endHour, endHR);
		  
		  TestUtils.enterTime(driver, endMinute, endMin);
		  
		  TestUtils.enterTime(driver, endOcassion, endOcc);
		  
		  projectName.click();
		  
		  enterTextProject.sendKeys(pName);
		
		  clickTextProject.click();
		  
		  submit.click();
		  
		  toastMessage=driver.findElement(By.className("toast-message")).getText();
	    	
	    	
	    return toastMessage;
		
	}
	
	
	
	
	
	
	public String bookedSlots(String Month, String Date)
	{
		
		   driver.navigate().refresh();
		   
		   TestUtils.jsClick(conferenceMenu, driver);
		  
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   cfNotavailable.click();
		
		   bookingDate.click();
		   
		   TestUtils.selectMonth(Month, driver);
		   
		   TestUtils.selectDate(Date, driver);
		
		   bookedSlot.click();
		   
		   confirmBS.click();
		
		   toastMessage=driver.findElement(By.className("toast-message")).getText();
		   
		return toastMessage;
		
	}
	
	
	
	public void myMeetingTable(String MeetName, String bookDate, String expMeetname, String expBookDate)
	{
		
		   driver.navigate().refresh();
		   
		   TestUtils.jsClick(conferenceMenu, driver);
		  
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		   myMeet.click();
		   
		   TestUtils.scrollDown("window.scrollBy(0,500)", driver);
		
		   mybookSearch.sendKeys(MeetName);
		   
		   for(int i=1; i<=myBookRows.size();i++)
		   {
			   GetMyBookMeetName=  driver.findElement(By.xpath("//table[@id='tblUserBookedList']/tbody/tr["+i+"]/td[6]")).getText().trim();
		   }
		   
		   TestUtils.scrollDown("window.scrollBy(0,400)", driver); 
		   
		   
		   CRNASearch.sendKeys(bookDate);
		   
		   for(int i=1; i<=CRNARows.size();i++)
		   {
			   GetCRNAdate = driver.findElement(By.xpath("//table[@id='tblUserBookedList']/tbody/tr["+i+"]/td[3]")).getText().trim();
		   }
		   
		
		   Assert.assertEquals(GetMyBookMeetName, expMeetname);
		   Assert.assertEquals(GetCRNAdate, expBookDate);
		   
		   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
