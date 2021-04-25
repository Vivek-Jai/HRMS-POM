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
import EmpRolePages.EmpDeviceRequest;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpDeviceRequestTestCase extends Base{
	
	
	
	
	
    LoginPage login;
	
    EmpDeviceRequest DevReq;
	
	String acutalText;
	
	public EmpDeviceRequestTestCase()
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
		DevReq= new EmpDeviceRequest();
		
		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	@Test(dataProvider="NewDeviceRequest",dataProviderClass=FetchDataFromExcel.class,priority=1)
	public  void verifyDeviceRequest(String ModelName,String verifyText)
	{
	
		ExtentReport.startTest("verifyDeviceRequest");
		
		acutalText= DevReq.addDeviceRequest(ModelName);
		
		Assert.assertEquals(acutalText, verifyText);
		
	}
	
	@Test(dataProvider="CancelDeviceRequest",dataProviderClass=FetchDataFromExcel.class,priority=2)
	public  void verifyCancelDeviceRequest(String DeviceStatus,String DeviceName, String verifyText)
	{
	
		ExtentReport.startTest("verifyCancelDeviceRequest");
		
		acutalText= DevReq.cancelDeviceRequest(DeviceStatus, DeviceName);
		
		Assert.assertEquals(acutalText, verifyText);
		
	}
	
	
	@Test(dataProvider="AssignDeviceRequest",dataProviderClass=FetchDataFromExcel.class,priority=3)
	public  void verifyAssignDeviceRequest(String DeviceName,String AssignUser, String verifyText)
	{
	
		ExtentReport.startTest("verifyAssignDeviceRequest");
		
		acutalText= DevReq.assignDevice(DeviceName, AssignUser);
		
		Assert.assertEquals(acutalText, verifyText);
		
	}
	
	@Test(dataProvider="ReleaseDeviceRequest",dataProviderClass=FetchDataFromExcel.class,priority=4)
	public  void verifyReleaseDeviceRequest(String DeviceName,String verifyText)
	{
	
		ExtentReport.startTest("verifyReleaseDeviceRequest");
		
		acutalText= DevReq.releaseDevice(DeviceName);
		
		Assert.assertEquals(acutalText, verifyText);
		
	}
	
	
	
	@Test(dataProvider="SearchDeviceDashboard",dataProviderClass=FetchDataFromExcel.class,priority=5)
	public  void verifySearchDeviceDashboard(String AD_DeviceName, String AD_Count, String EAD_ModelName, String DR_DeviceName, String EDR_Count, String EDR_Date, String DREQ_DeviceName, String EDREQ_Count, String EDREQ_Date)
	{
	
		ExtentReport.startTest("verifySearchDeviceDashboard");
		
		DevReq.searchDeviceDashboard(AD_DeviceName, AD_Count, EAD_ModelName, DR_DeviceName, EDR_Count, EDR_Date, DREQ_DeviceName, EDREQ_Count, EDREQ_Date);
		
		
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}
