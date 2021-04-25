package EmpRolePages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import Utils.TestUtils;

public class EmpAddTraining extends Base {
	
	
	@FindBy(xpath = "//span[text()='Training Management']")

	WebElement traningManagmentMenu;
	
	@FindBy(xpath="//span[text()='Manage Training']")
	
	WebElement manageTraningMenu;
	
	@FindBy(xpath="//button[@onclick='AddDetails()']")
	
	WebElement addNewTraning;
	
    @FindBy(id="Course0")
	
	WebElement trainingName;;
	
	@FindBy(id="s2id_TechnologyId0")
		
	WebElement clickTechnologyDropdown;
	
	@FindBy(xpath = "//div[@id='select2-drop']//input")
	
	WebElement enterTextTecnology;
	
	@FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clickTechnology;
	
	@FindBy(id="s2id_LevelId0")
	
	WebElement leveldropdown;
	
   @FindBy(xpath="//div[@id='select2-drop']//input")
	
	WebElement enterTextlevel;
   
   @FindBy(xpath="//ul[@class='select2-results']//div/span")
	
  	WebElement clickTextlevel;
   
   @FindBy(id="ScheduleStartdate0")
   
   WebElement startDate;
   
   @FindBy(id="ScheduleEnddate0")
   
   WebElement endDate;
   
   @FindBy(xpath="(//input[@class='tp_hr'])[1]")
   
   WebElement startHour;
   
   @FindBy(xpath="(//input[@class='tp_min'])[1]")
   
   WebElement startMin;
   
   @FindBy(xpath="(//input[@class='tp_am_pm'])[1]")
   
   WebElement startOccasion;
   
   @FindBy(xpath="(//input[@class='tp_hr'])[2]")
   
   WebElement endtHour;
   
   @FindBy(xpath="(//input[@class='tp_min'])[1]")
   
   WebElement endMin;
   
    @FindBy(xpath="(//input[@class='tp_am_pm'])[1]")
   
   WebElement endOccasion;
    
    @FindBy(id="s2id_UserID0")
    
    WebElement instructorDropdown;
    
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
	WebElement enterTextinstructor;
    
    @FindBy(xpath="//ul[@class='select2-results']//div/span")
	
  	WebElement clickTextinstructor;
    
    @FindBy(id="SeatingCapacity0")
    
    WebElement seats;
    
    @FindBy(id="s2id_MailDepartments")
    
    WebElement department;
    
    @FindBy(xpath="//div[@id='s2id_MailDepartments']/ul/li/input")
	
	WebElement enterTextDepartment;
    
    @FindBy(xpath="//ul[@class='select2-results']//div/span")
	
	WebElement clickTextDepartment;
    
    @FindBy(id="btnsub")
    
    WebElement submit;
    
    String toastMessage;
    
    
    public EmpAddTraining()
    {
    	PageFactory.initElements(driver, this);
    }
    
    
    public String addNewTraining(String tName, String techName, String levelName, String startmonth, String startdate,String endmonth, String enddate,String sHour, String sMin, String sOcc, String eHour, String eMin, String eOcc, String Iname, String Seats, String dName)
    {
    	
    	 driver.navigate().refresh();
		   
		   TestUtils.jsClick(traningManagmentMenu, driver);
		   
		  TestUtils.jsClick(manageTraningMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  addNewTraning.click();
		  trainingName.sendKeys(tName);
		  clickTechnologyDropdown.click();
		  enterTextTecnology.sendKeys(techName);
		  clickTechnology.click();
		  leveldropdown.click();
		  enterTextlevel.sendKeys(levelName);
		  clickTextlevel.click();
		  
		  startDate.click();
		  TestUtils.selectMonth(startmonth, driver);
		  TestUtils.selectDate(startdate, driver);
		  
		   endDate.click();
		   
		   TestUtils.selectMonth(endmonth, driver);
		   TestUtils.selectDate(enddate, driver);
    	
    
		  TestUtils.enterTime(driver, startHour, sHour);
		  TestUtils.enterTime(driver, startMin,  sMin);
		  TestUtils.enterTime(driver, startOccasion, sOcc);
		  
		  TestUtils.enterTime(driver, endtHour, eHour);
		  TestUtils.enterTime(driver, endMin,  eMin);
		  TestUtils.enterTime(driver, endOccasion, eOcc);
		  
		  instructorDropdown.click();
		  enterTextinstructor.sendKeys(Iname);
		  clickTextinstructor.click();
		  
		  seats.sendKeys(Seats);
		  department.click();
		  enterTextDepartment.sendKeys(dName);
		  clickTextDepartment.click();
		  
		  submit.click();
		  
		  toastMessage=driver.findElement(By.className("toast-message")).getText().trim();
		   
		   return toastMessage;
		  
		  
    	
    }
    
    
    
   
   
   
   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
