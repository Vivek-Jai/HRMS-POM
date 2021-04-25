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
import EmpRolePages.EmpApplyOutOffice;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpApplyOutOfficeTestCase extends Base {
	
	
	LoginPage login;
	
	EmpApplyOutOffice outoffice;
    
    String acutalText;
    
    
    
    public EmpApplyOutOfficeTestCase()
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
   		outoffice= new EmpApplyOutOffice();
   		
   		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
   	}
    
    
    @Test(dataProvider="ApplyOutOffice",dataProviderClass=FetchDataFromExcel.class, priority=1)
    public void verifyApplyOutOffice(String StartMonth, String StartDate, String EndMonth, String EndDate ,String ContactNo, String Place, String Assign, String comments,String verifyText)
    {
    	ExtentReport.startTest("verifyApplyOutOffice");
   	 acutalText=outoffice.applyOutOffice(StartMonth, StartDate, EndMonth, EndDate, ContactNo, Place, Assign, comments);
   	Assert.assertEquals(acutalText, verifyText);
    }
    
    @Test(dataProvider="CancelOutOffice",dataProviderClass=FetchDataFromExcel.class, priority=2)
    public void verifyCancelOutOfficeRequest(String RequestStatus, String RequestDate, String verifyText ) 
    {
    	ExtentReport.startTest("verifyCancelOutOfficeRequest");
   	 acutalText= outoffice.cancelOutOfficeRequest(RequestStatus, RequestDate);
   	Assert.assertEquals(acutalText, verifyText);
   	 
   	 
    }
    
    
    
    @AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
