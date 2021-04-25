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
import EmpRolePages.EmpConferenceBooking;
import EmpRolePages.LoginPage;
import Report.ExtentReport;
import junit.framework.Assert;

public class EmpConfRoomBookTestCase extends Base {
	
	
	    LoginPage login;
		
	    EmpConferenceBooking confBook;
		
		String acutalText;
		
		public EmpConfRoomBookTestCase()
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
			confBook= new EmpConferenceBooking();
			
			login.Emplogin(prop.getProperty("username"),prop.getProperty("password"));
		}
	
	
		@Test(dataProvider="ConfRoomBook",dataProviderClass=FetchDataFromExcel.class, priority =1)
		public  void verifyConfRoomBook(String pText, String depText ,String tName, String Mon, String Date,String startHR,String startMin,String startCcc, String endHR, String endMin, String endOcc,String pName,String verifyText )
		{
		
			ExtentReport.startTest("verifyConfRoomBook");
			
			acutalText=	confBook.bookConferenceRoom(pText, depText, tName, Mon, Date, startHR, startMin, startCcc, endHR, endMin, endOcc, pName);
			
			Assert.assertEquals(acutalText, verifyText);
			
		}
	
	
		@Test(dataProvider="BookedSlot",dataProviderClass=FetchDataFromExcel.class,priority =2)
		public void verifyBookedSlot(String Mon, String Date, String verifyText)
		{
			ExtentReport.startTest("verifyBookedSlot");
			
			acutalText=	confBook.bookedSlots(Mon, Date);
			
			Assert.assertEquals(acutalText, verifyText);
			
		}
		
		@Test(dataProvider="BookedTable",dataProviderClass=FetchDataFromExcel.class,priority =3)
		public void verifyMyBookTable(String MeetName, String bookDate, String expMeetname, String expBookDate)
		{
			ExtentReport.startTest("verifyMyBookTable");
			
			confBook.myMeetingTable(MeetName, bookDate, expMeetname, expBookDate);
			
			
			
		}
	
	
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException{
			
			ExtentReport.tearDown(result, driver);
			driver.quit();
		}
	
	
	
	
	

}
