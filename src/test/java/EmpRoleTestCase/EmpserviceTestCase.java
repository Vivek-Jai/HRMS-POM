package EmpRoleTestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import Base.Base;
import DataProvider.FetchDataFromExcel;
import EmpRolePages.Empservice;
import EmpRolePages.LoginPage;
import Report.ExtentReport;


public class EmpserviceTestCase extends Base{
	
	
      LoginPage login;
	
	Empservice service;
	
	
	
	public EmpserviceTestCase()
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
		service= new Empservice();
		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Test(dataProvider="ServiceCheckboxName",dataProviderClass=FetchDataFromExcel.class,priority=1)
	public  void enableNewService(String checkbox) 
	{
		ExtentReport.startTest("enableNewService");
		service.addNewService(checkbox);
		
		
	}
	
	@Test(dataProvider="VerifyServiceEnabled",dataProviderClass=FetchDataFromExcel.class,priority=2)
	public void verifyserviceEnabled(String serviceName, String enableService, String value)
	{
		ExtentReport.startTest("verifyserviceEnabled");
		String actualText=service.serviceDisplay(serviceName, value);
		
		Assert.assertEquals(actualText, enableService, "ServiceName not matches");
		
	}
	
	@Test(dataProvider="RemoveService",dataProviderClass=FetchDataFromExcel.class,priority=3)
	public void verifyserviceRemoved(String serviceName, String removeService, String value) 
	{
		ExtentReport.startTest("verifyserviceRemoved");
		String actualText=service.removeService(serviceName, value);
		
		
		Assert.assertEquals(actualText, removeService);		
	}
	
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}

}
