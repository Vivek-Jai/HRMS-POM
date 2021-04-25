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
import EmpRolePages.EmpViewEditTimeSheet;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpViewEditTimeSheetTestCase extends Base {
	
	
	 LoginPage login;
		
	 EmpViewEditTimeSheet edittimesheet;
		
	String acutalText;
	
	
	public EmpViewEditTimeSheetTestCase()
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
		edittimesheet= new EmpViewEditTimeSheet();
		
		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Test(dataProvider="ViewEditTimeSheet",dataProviderClass=FetchDataFromExcel.class, priority=1)
	public  void verifyViewEditTimeSheet(String startmonth, String startdate, String endmonth, String enddate, String exptaskdate, String exptaskid, String verifyText)
	{
	
		ExtentReport.startTest("verifyViewEditTimeSheet");
		
		acutalText=	edittimesheet.viewTimesheet(startmonth, startdate, endmonth, enddate, exptaskdate, exptaskid);
		
		Assert.assertEquals(acutalText, verifyText);
		
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}
	
	
	

}
