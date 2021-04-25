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


import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class LoginTestCase  extends Base{
	
		
	LoginPage login;
	
	
	public LoginTestCase()
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
	public void startBrowser(String browsername)
	{
		browserStart(browsername);
		login = new LoginPage();
		
	}
	
	@Test
	public  void assertEMPusername()
	{
		ExtentReport.startTest("assertEMPusername");
		
		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
	
	
		
       String actualusername=login.verifyUsername();
       
       
		Assert.assertEquals("Firstname_54 LastName_54", actualusername);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}
	
	
	
	
}
