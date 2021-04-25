package EmpRoleTestCase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Base;
import DataProvider.FetchDataFromExcel;
import EmpRolePages.EmpViewHolidays;
import EmpRolePages.LoginPage;
import Report.ExtentReport;

public class EmpViewHolidayTestCase extends Base{
	
	
	LoginPage login;
	
	EmpViewHolidays HD;
	
	String acutalText;
	
	public EmpViewHolidayTestCase()
	{
		super();
	}
	
	@BeforeTest
	public void setupExtentReport()
	{
		ExtentReport.setExtent();
	}
	
	@AfterTest
	public void endReport()
	{
		ExtentReport.endReport();
	}
	
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browsername)
	{
		browserStart(browsername);
		login = new LoginPage();
		HD = new EmpViewHolidays();
		
		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(dataProvider="ViewHoliday",dataProviderClass=FetchDataFromExcel.class,priority=1)
	public void verfiyHolidayList(String year, String HCount, String RHCount, String HDName, String RHDName )
	{
		ExtentReport.startTest("verfiyHolidayList");
		HD.getTotalHolidayList(year, HCount, RHCount, HDName, RHDName);
	}
	
	
	

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
