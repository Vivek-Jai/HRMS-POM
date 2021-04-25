package EmpRolePages;



import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import Utils.TestUtils;

public class EmpApplyTimeSheet extends Base {

	@FindBy(xpath = "//span[text()='Time Sheet Management']")

	WebElement timesheetManagmentMenu;

	@FindBy(xpath = "//span[text()='My Time Sheet']")

	WebElement timesheetsubMenu;

	@FindBy(id = "Datevalue")

	WebElement selectDate;

	@FindBy(xpath = "//button[@id='addRow']")

	WebElement addNewTask;
	
	@FindBy(xpath = "//*[@id='tblTimeSheet_filter']/label/input")

	WebElement searchTask;

	@FindBy(id = "s2id_Sitename1")

	WebElement clickProjectNamedropdown;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement entertextProjectdropdown;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextProjectdropdown;

	@FindBy(id = "s2id_TaskSource1")

	WebElement clickTaskdropdown;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextTaskdropdown;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextTaskdropdown;

	@FindBy(id = "Id1")

	WebElement enterTaskID;

	@FindBy(id = "Hour1")

	WebElement enterHour;

	@FindBy(id = "Minutes1")

	WebElement enterMinute;

	@FindBy(id = "Details11")

	WebElement enterDescp;

	@FindBy(id = "s2id_ReportingPerson1")

	WebElement clickAssigndropdown;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextAssigndropdown;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextAssigndropdown;

	@FindBy(id = "ProfileSave")

	WebElement clickSave;
	
	@FindBy(xpath="//button[@onclick='ExportExcel()']")
	
	WebElement exportExcel;
	
   @FindBy(xpath="//button[@onclick='sendreporting()']")
	
	WebElement sendReport;
   
   @FindBy(xpath="//button[text()='OK']")
   
   WebElement confirmButton;
	
	

	String toastMessage;

	public EmpApplyTimeSheet() {
		PageFactory.initElements(driver, this);
	}
	
	public String addNewTask(String startmonth, String startdate, String projectName, String task, String ID, String Hrs, String Min, String Desc, String assingName) throws InterruptedException
	{
		
		    driver.navigate().refresh();
		   
		   TestUtils.jsClick(timesheetManagmentMenu, driver);
		   
		  TestUtils.jsClick(timesheetsubMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		 selectDate.click();
		  
		  TestUtils.selectMonth(startmonth, driver);
		   TestUtils.selectDate(startdate, driver);
		   
		   Thread.sleep(3000);
		  
		
		  addNewTask.click();
		
		  clickProjectNamedropdown.click();
		   
		   entertextProjectdropdown.sendKeys(projectName);
		   
		   clickTextProjectdropdown.click();
		   
		   clickTaskdropdown.click();
		   
		   enterTextTaskdropdown.sendKeys(task);
		   
		   clickTextTaskdropdown.click();
		
		   enterTaskID.sendKeys(ID);
		   
		   enterHour.sendKeys(Hrs);
		
		   enterMinute.sendKeys(Min);
		
		   enterDescp.sendKeys(Desc);
		   
		   
		   clickAssigndropdown.click();
		   
		   enterTextAssigndropdown.sendKeys(assingName);
		   
		   clickTextAssigndropdown.click();
		   
		   clickSave.click();
		   
		   
		   toastMessage=driver.findElement(By.className("toast-message")).getText();
		   
		   return toastMessage;
		
	}
	
	
	public void downloadExportExcel(String startmonth,String startdate) throws InterruptedException
	{
		 driver.navigate().refresh();
		   
		   TestUtils.jsClick(timesheetManagmentMenu, driver);
		   
		  TestUtils.jsClick(timesheetsubMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		 selectDate.click();
		  
		  TestUtils.selectMonth(startmonth, driver);
		   TestUtils.selectDate(startdate, driver);
		   
		   exportExcel.click();
		   
		   Thread.sleep(3000);
	}
	
	
	public boolean excelExport(String downloadPath,String fileName)
	{
		
		   
		   boolean flag = false;
		    File dir = new File(System.getProperty("user.dir")+downloadPath);
		    File[] dir_contents = dir.listFiles();
		  	    
		    for (int i = 0; i < dir_contents.length; i++) {
		        if (dir_contents[i].getName().equals(fileName))
		            return flag=true;
		            }

		    return flag;
		
	}
	
	public String sendReport(String startmonth,String startdate) 
	{
		 driver.navigate().refresh();
		   
		   TestUtils.jsClick(timesheetManagmentMenu, driver);
		   
		  TestUtils.jsClick(timesheetsubMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		 selectDate.click();
		  
		  TestUtils.selectMonth(startmonth, driver);
		   TestUtils.selectDate(startdate, driver);
		   
		   sendReport.click();
		   
		   TestUtils.jsClick(confirmButton, driver);
		   
		   
 toastMessage=driver.findElement(By.className("toast-message")).getText();
		   
		   return toastMessage;
		   
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
