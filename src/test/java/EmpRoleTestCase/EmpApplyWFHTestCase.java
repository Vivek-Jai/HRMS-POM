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
import EmpRolePages.EmpApplyWFH;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpApplyWFHTestCase extends Base {
	
     LoginPage login;
	
     EmpApplyWFH applyWFH;
     
     String acutalText;

     public EmpApplyWFHTestCase()
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
 		applyWFH= new EmpApplyWFH();
 		
 		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
 	}
     
     @Test(dataProvider="ApplyWFHRequest",dataProviderClass=FetchDataFromExcel.class, priority=1)
     public void verifyApplyWFH(String StartMonth, String StartDate, String EndMonth, String EndDate ,String ContactNo, String AssignPerson, String WFHReason, String verifyText)
     {
    	 ExtentReport.startTest("verifyApplyWFH");
    	 acutalText=applyWFH.addNewWFHRequest(StartMonth, StartDate, EndMonth, EndDate,ContactNo, AssignPerson, WFHReason);
    	 
    	Assert.assertEquals(acutalText, verifyText);
     }
     
     @Test(dataProvider="CancelWFHRequest",dataProviderClass=FetchDataFromExcel.class, priority=2)
     public void verifyCancelWFHRequest(String WFHStatus, String WFHDate, String verifyText ) 
     {
    	 ExtentReport.startTest("verifyCancelWFHRequest");
    	 acutalText= applyWFH.cancelWFHRequest(WFHStatus, WFHDate);
    	 Assert.assertEquals(acutalText, verifyText);
    	 
    	 
     }
     
     
     
     @AfterMethod
 	public void tearDown(ITestResult result) throws IOException{
 		
 		ExtentReport.tearDown(result, driver);
 		driver.quit();
 	}
     
     
     
}
