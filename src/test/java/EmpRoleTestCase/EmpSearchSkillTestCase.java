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
import EmpRolePages.EmpSearchSkill;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpSearchSkillTestCase extends Base {
	
	
	
	LoginPage login;
	
	EmpSearchSkill searchSkill;
	
	boolean acutalText;
	
	public EmpSearchSkillTestCase()
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
		searchSkill= new EmpSearchSkill();
		
		login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	
	
	@Test(dataProvider="SearchSkill",dataProviderClass=FetchDataFromExcel.class,priority=1)
	public  void verifySearchSkill(String skillName,String skillExp)
	{
	
		boolean verifyText= true;
		ExtentReport.startTest("verifySearchSkill");
		
		acutalText=	searchSkill.searchSkills(skillName, skillExp);
		
		Assert.assertEquals(verifyText, acutalText);
		
	}
	
	@Test(dataProvider="SearchExp",dataProviderClass=FetchDataFromExcel.class,priority=2)
	public  void verifySearchExp(String skillName,String skillExp, String in , String around)
	{
	
		boolean verifyText= true;
		ExtentReport.startTest("verifySearchExp");
		
		acutalText=	searchSkill.searchExp(skillName, skillExp, in, around);
		
		Assert.assertEquals(verifyText, acutalText);
		
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
