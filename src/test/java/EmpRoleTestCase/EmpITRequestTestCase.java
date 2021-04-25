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
import EmpRolePages.EmpITsupport;
import EmpRolePages.LoginPage;
import Report.ExtentReport;

public class EmpITRequestTestCase extends Base {

	LoginPage login;

	EmpITsupport ITS;

	String acutalText;

	public EmpITRequestTestCase() {
		super();
	}

	@BeforeTest
	public void setupExtentReport() {
		ExtentReport.setExtent();
	}

	@AfterTest
	public void endReport() {
		ExtentReport.endReport();
	}

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browsername) {
		browserStart(browsername);
		login = new LoginPage();
		ITS = new EmpITsupport();

		login.Emplogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(dataProvider = "AddNewITRequest", dataProviderClass = FetchDataFromExcel.class, priority = 1)
	public void verifyAddnewITRequest(String categoryName, String priority, String projectName, String floor,
			String contactNo, String report, String desc, String ExpToastMessage) {

		ExtentReport.startTest("verifyAddnewITRequest");

		ITS.addNewITRequest(categoryName, priority, projectName, floor, contactNo, report, desc, ExpToastMessage);

	}

	@Test(dataProvider = "EditAndCancelITRequest", dataProviderClass = FetchDataFromExcel.class, priority = 2)
	public void verifyeditAndcancelITRequest(String tStatus, String searchKey, String comments,
			String ExpCommentsMessage, String ExpCancelMessage){

		ExtentReport.startTest("verifyeditAndcancelITRequest");

		ITS.editAndcancelITRequest(tStatus, searchKey, comments, ExpCommentsMessage, ExpCancelMessage);

	}
	
	@Test(dataProvider = "ReOpenITRequest", dataProviderClass = FetchDataFromExcel.class, priority = 3)
	public void verifyreOpenITRequest(String tStatus, String searchKey, String rOComment,
			String ExpCommentsMessage){

		ExtentReport.startTest("verifyreOpenITRequest");

		ITS.reOpenITRequest(tStatus, searchKey, rOComment, ExpCommentsMessage);

	}
	
	@Test(dataProvider = "CloseITRequest", dataProviderClass = FetchDataFromExcel.class, priority = 4)
	public void verifycloseITRequest(String tStatus, String searchKey, String rOComment,
			String ExpCommentsMessage){

		ExtentReport.startTest("verifycloseITRequest");

		ITS.closeITRequest(tStatus, searchKey, rOComment, ExpCommentsMessage);

	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		ExtentReport.tearDown(result, driver);
		driver.quit();
	}

}
