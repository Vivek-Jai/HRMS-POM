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

public class EmpViewHolidays extends Base
{
	
	@FindBy(xpath = "//span[text()='View Holidays']")

	WebElement viewHolidayMenu;
	
	@FindBy(id = "s2id_Year")

	WebElement selectYear;
	
	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterYear;
	
	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickYear;
	
	@FindBy (xpath ="//table[@id='tblProjects']/tbody/tr")
	
	List<WebElement> HDRows;
	
	@FindBy(xpath ="//table[@id='tblProjects1']/tbody/tr")
	
	List<WebElement> RHDRows;
	
	@FindBy(xpath = "//div[@id='tblProjects_filter']//input")

	WebElement HDSearch;
	
	@FindBy(xpath = "//div[@id='tblProjects1_filter']//input")

	WebElement RHDSearch;
	
	
	String getNormalHolidayName;
	String getRestrictHolidayName;
	
	
	
	  public EmpViewHolidays()
	   {
		   PageFactory.initElements(driver, this);
	   }
	
	  public void getTotalHolidayList(String year, String HCount, String RHCount, String HDName, String RHDName)
	  {
		  
		  driver.navigate().refresh();
		   
		  TestUtils.jsClick(viewHolidayMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
		  TestUtils.scrollDown("window.scrollBy(0,400)", driver);
		  
		  selectYear.click();
		  
		  enterYear.sendKeys(year);
		  
		  clickYear.click();
		  
		  int EHDCount =HDRows.size();
		  int ERHDCount = RHDRows.size();
		  
		  
		  int AHDCount = Integer.parseInt(HCount);
		  int ARHDCount = Integer.parseInt(RHCount);
		  
		  Assert.assertEquals(EHDCount, AHDCount);
		  Assert.assertEquals(ERHDCount, ARHDCount);
		  
		  TestUtils.scrollDown("window.scrollBy(0,400)", driver); 
		  
		  HDSearch.sendKeys(HDName);
		  
		 getNormalHolidayName=	driver.findElement(By.xpath("//table[@id='tblProjects']/tbody/tr[1]/td[3]")).getText().trim();
		 
		Assert.assertEquals(getNormalHolidayName, HDName);	
		
		RHDSearch.sendKeys(RHDName);
		
		getRestrictHolidayName=	driver.findElement(By.xpath("//table[@id='tblProjects1']/tbody/tr[1]/td[3]")).getText().trim();
			  
	    Assert.assertEquals(getRestrictHolidayName, RHDName);
		  
		  
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
