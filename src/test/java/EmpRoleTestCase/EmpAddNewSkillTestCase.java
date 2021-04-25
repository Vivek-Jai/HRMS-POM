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
import EmpRolePages.EmpAddSkills;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpAddNewSkillTestCase extends Base {
	
	
	
	
	    LoginPage login;
		
	    EmpAddSkills addSkill;
		
		String acutalText;
		
		public EmpAddNewSkillTestCase()
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
			addSkill= new EmpAddSkills();
			
			login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
		}
	
	
	
		@Test(dataProvider="AddNewSkill",dataProviderClass=FetchDataFromExcel.class, priority=1)
		public  void verifyAddNewSkill(String TechName, String Special ,String Exp, String Month, String Date,String lastUsed,String Level,String AssignName, String primaryskill, String verifyText)
		{
		
			ExtentReport.startTest("verifyAddNewSkill");
			
			acutalText=	addSkill.addNewSkills(TechName, Special, Exp, Month, Date, lastUsed, Level, AssignName,primaryskill );
			
			Assert.assertEquals(acutalText, verifyText);
			
		}
		
		
	
	
	
	
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException{
			
			ExtentReport.tearDown(result, driver);
			driver.quit();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
