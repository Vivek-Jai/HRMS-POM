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
import EmpRolePages.EmpApplyTimeSheet;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpApplyTimeSheetTestCase extends Base{
	
    LoginPage login;
	
    EmpApplyTimeSheet applytimesheet;
	
	String acutalText;
	
	boolean actualFilename;
	
	
	public EmpApplyTimeSheetTestCase()
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
		applytimesheet= new EmpApplyTimeSheet();
		
		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(dataProvider="ApplyTimeSheet",dataProviderClass=FetchDataFromExcel.class, priority=1)
	public  void verifyApplyTimeSheet(String startmonth,String startdate, String projectName, String task, String ID, String Hrs ,String Min, String Desc, String assingName, String verifyText) throws InterruptedException 
	{
	
		ExtentReport.startTest("verifyApplyTimeSheet");
		
		acutalText=	applytimesheet.addNewTask(startmonth, startdate, projectName, task, ID, Hrs, Min, Desc, assingName);
		
		Assert.assertEquals(acutalText, verifyText);
		
	}
	
	@Test(dataProvider="DownloadExportfile",dataProviderClass=FetchDataFromExcel.class, priority=2)
	public  void clickDownloadFile(String startmonth,String startdate) throws InterruptedException
	{
	
		ExtentReport.startTest("clickDownloadFile");
		
		applytimesheet.downloadExportExcel(startmonth, startdate);
		
	}
	
	@Test(dataProvider="DownloadFilename",dataProviderClass=FetchDataFromExcel.class, priority=3)
	public  void verifyExportDownloadFile(String downloadPath,String fileName)
	{
	
		ExtentReport.startTest("verifyExportDownloadFile");
		
		
		
		Assert.assertTrue("The download file doesn't exixts", applytimesheet.excelExport(downloadPath, fileName));
		
	}
	
	@Test(dataProvider="SendTimeSheetReport",dataProviderClass=FetchDataFromExcel.class, priority=4)
	public  void verifySendTimeSheetReport(String startmonth,String startdate, String verifyText)
	{
	
		ExtentReport.startTest("verifySendTimeSheetReport");
		
		acutalText=applytimesheet.sendReport(startmonth, startdate);
		Assert.assertEquals(acutalText, verifyText);
		
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
