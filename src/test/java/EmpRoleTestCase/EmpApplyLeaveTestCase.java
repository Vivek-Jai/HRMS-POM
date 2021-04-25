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
import EmpRolePages.EmpApplyLeave;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpApplyLeaveTestCase extends Base{
	
	LoginPage login;
	
	EmpApplyLeave applyleave;
	
	String acutalText;
	

	
	public EmpApplyLeaveTestCase()
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
		applyleave= new EmpApplyLeave();
		
		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Test(dataProvider="ApplyLeaveRequest",dataProviderClass=FetchDataFromExcel.class, priority=1)
	public  void verifyLeaveApplied(String HalfLeave,String TypeOfLeave, String StartLeaveMonth, String StartLeaveDate, String EndLeaveMonth, String EndLeaveDate ,String AssignPerson, String LeaveReason, String verifyText) throws InterruptedException 
	{
	
		ExtentReport.startTest("verifyLeaveApplied");
	acutalText =applyleave.addNewFullLeaveRequest(HalfLeave,TypeOfLeave, StartLeaveMonth, StartLeaveDate, EndLeaveMonth, EndLeaveDate,AssignPerson, LeaveReason);
	Assert.assertEquals(acutalText, verifyText);
		
		
	}
	
	@Test(dataProvider="CancelLeaveRequest",dataProviderClass=FetchDataFromExcel.class, priority=2)
	public void verifyCancelLeaveRequest(String LeaveStatus, String LeaveType, String verifyText) 
	
	{
		ExtentReport.startTest("verifyCancelLeaveRequest");
		acutalText = applyleave.cancelLeave(LeaveStatus, LeaveType);
		Assert.assertEquals(acutalText, verifyText);
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}
	
	
	
	
	
	

}
