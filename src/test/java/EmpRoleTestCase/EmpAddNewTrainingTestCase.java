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
import EmpRolePages.EmpAddTraining;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpAddNewTrainingTestCase extends Base {
	
	
	    LoginPage login;
		
	    EmpAddTraining addTrain;
		
		String acutalText;
		
		public EmpAddNewTrainingTestCase()
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
			addTrain= new EmpAddTraining();
			
			login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
		}
	
	
		@Test(dataProvider="AddNewTraining",dataProviderClass=FetchDataFromExcel.class, priority=1)
		public  void verifyAddNewTraining(String tName, String techName , String levelName, String startmonth, String startdate,String endmonth,String enddate,String sHour, String sMin, String sOcc, String eHour, String eMin, String eOcc, String Iname, String Seats, String dName, String  verifyText  )
		{
		
			ExtentReport.startTest("verifyAddNewTraining");
			
			acutalText=	addTrain.addNewTraining(tName, techName, levelName, startmonth, startdate, endmonth, enddate, sHour, sMin, sOcc, eHour, eMin, eOcc, Iname, Seats, dName);
			
			Assert.assertEquals(acutalText, verifyText);
			
		}
	
	
	
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException{
			
			ExtentReport.tearDown(result, driver);
			driver.quit();
		}
	
	
	
	
	
	
	
	
	

}
