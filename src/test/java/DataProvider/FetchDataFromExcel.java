package DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;

public class FetchDataFromExcel {
	
	
static String data[][] =null;


	
	@DataProvider(name="ServiceCheckboxName")
	public static String[][] serviceCheckbox() throws IOException, Exception 
	{
	data=getExcelData("Sheet1");
		return data;
	}
	
	@DataProvider(name="VerifyServiceEnabled")
	public static String[][] serviceEnable() throws IOException, Exception 
	{
	data=getExcelData("Sheet2");
		return data;
	}
	
	@DataProvider(name="RemoveService")
	public static String[][] serviceRemove() throws IOException, Exception 
	{
	data=getExcelData("Sheet3");
		return data;
	}
	
	@DataProvider(name="ApplyLeaveRequest")
	public static String[][] applyLeaveRequest() throws IOException, Exception 
	{
	data=getExcelData("Sheet4");
		return data;
	}
	
	@DataProvider(name="CancelLeaveRequest")
	public static String[][] cancelLeaveRequest() throws IOException, Exception 
	{
	data=getExcelData("Sheet5");
		return data;
	}
	
	
	@DataProvider(name="ApplyWFHRequest")
	public static String[][] applyWFHRequest() throws IOException, Exception 
	{
	data=getExcelData("Sheet6");
		return data;
	}
	
	@DataProvider(name="CancelWFHRequest")
	public static String[][] cancelWFHRequest() throws IOException, Exception 
	{
	data=getExcelData("Sheet7");
		return data;
	}
	
	@DataProvider(name="ApplyOutOffice")
	public static String[][] applyOutOffice() throws IOException, Exception 
	{
	data=getExcelData("Sheet8");
		return data;
	}
	
	@DataProvider(name="CancelOutOffice")
	public static String[][] cancelOutOffice() throws IOException, Exception 
	{
	data=getExcelData("Sheet9");
		return data;
	}
	
	@DataProvider(name="ApplyTimeSheet")
	public static String[][] applyTimeSheet() throws IOException, Exception 
	{
	data=getExcelData("TimesheetUpdate");
		return data;
	}
	@DataProvider(name="DownloadExportfile")
	public static String[][] downloadExportfile() throws IOException, Exception 
	{
	data=getExcelData("Sheet11");
		return data;
	}
	
	@DataProvider(name="DownloadFilename")
	public static String[][] downloadFilename() throws IOException, Exception 
	{
	data=getExcelData("Sheet12");
		return data;
	}
	
	@DataProvider(name="SendTimeSheetReport")
	public static String[][] sendTimeSheetReport() throws IOException, Exception 
	{
	data=getExcelData("SendTimesheet");
		return data;
	}
	
	@DataProvider(name="ViewEditTimeSheet")
	public static String[][] viewEditTimeSheet() throws IOException, Exception 
	{
	data=getExcelData("Sheet14");
		return data;
	}
	
	@DataProvider(name="AddNewTraining")
	public static String[][] addNewTraining() throws IOException, Exception 
	{
	data=getExcelData("AddNewTraining");
		return data;
	}
	
	@DataProvider(name="AddNewSkill")
	public static String[][] addNewSkill() throws IOException, Exception 
	{
	data=getExcelData("AddNewSkills");
		return data;
	}
	
	@DataProvider(name="SearchSkill")
	public static Object[][] searchSkill() throws IOException, Exception 
	{
	data=getExcelData("Sheet17");
		return data;
	}
	
	@DataProvider(name="SearchExp")
	public static Object[][] searchExp() throws IOException, Exception 
	{
	data=getExcelData("Sheet18");
		return data;
	}
	
	@DataProvider(name="ConfRoomBook")
	public static Object[][] confBook() throws IOException, Exception 
	{
	data=getExcelData("ConfBook");
		return data;
	}
	
	@DataProvider(name="BookedSlot")
	public static Object[][] bookedSlot() throws IOException, Exception 
	{
	data=getExcelData("BookedSlot");
		return data;
	}
	
	@DataProvider(name="BookedTable")
	public static Object[][] bookedTable() throws IOException, Exception 
	{
	data=getExcelData("Sheet21");
		return data;
	}
	
	@DataProvider(name="ViewHoliday")
	public static Object[][] ViewHoliday() throws IOException, Exception 
	{
	data=getExcelData("Sheet22");
		return data;
	}
	
	@DataProvider(name="NewDeviceRequest")
	public static Object[][] NewDeviceRequest() throws IOException, Exception 
	{
	data=getExcelData("Sheet23");
		return data;
	}
	
	@DataProvider(name="CancelDeviceRequest")
	public static Object[][] CancelDeviceRequest() throws IOException, Exception 
	{
	data=getExcelData("Sheet24");
		return data;
	}
	
	@DataProvider(name="AssignDeviceRequest")
	public static Object[][] AssignDeviceRequest() throws IOException, Exception 
	{
	data=getExcelData("AssignDevice");
		return data;
	}
	
	@DataProvider(name="ReleaseDeviceRequest")
	public static Object[][] ReleaseDeviceRequest() throws IOException, Exception 
	{
	data=getExcelData("ReleaseDevice");
		return data;
	}
	
	@DataProvider(name="SearchDeviceDashboard")
	public static Object[][] searchDeviceDashboard() throws IOException, Exception 
	{
	data=getExcelData("Sheet27");
		return data;
	}
	
	@DataProvider(name="AddNewITRequest")
	public static Object[][] AddNewITRequest() throws IOException, Exception 
	{
	data=getExcelData("NewITRequest");
		return data;
	}
	
	@DataProvider(name="EditAndCancelITRequest")
	public static Object[][] EditAndCancelITRequest() throws IOException, Exception 
	{
	data=getExcelData("EditAndCancel");
		return data;
	}
	
	@DataProvider(name="ReOpenITRequest")
	public static Object[][] ReOpenITRequest() throws IOException, Exception 
	{
	data=getExcelData("ReOpenITRequest");
		return data;
	}
	
	@DataProvider(name="CloseITRequest")
	public static Object[][] CloseITRequest() throws IOException, Exception 
	{
	data=getExcelData("CloseITRequest");
		return data;
	}
	
	public static String[] [] getExcelData(String sheetName) throws IOException, Exception
	{
		String Path="/ExcelData/HRMSData.xls";
FileInputStream XL = new FileInputStream(System.getProperty("user.dir")+Path);
		  
	Workbook workbook = Workbook.getWorkbook(XL);
	Sheet sheet = workbook.getSheet(sheetName);
	
	int rc = sheet.getRows();
	int col = sheet.getColumns();
	
	System.out.println(rc);
	System.out.println(col);
        
        String TestData [] [] = new String[rc-1][col];
        
        for( int i=1;i<rc;i++){
       	 for( int j=0;j<col;j++)
       	 {
       		 TestData [i-1][j]=sheet.getCell(j, i).getContents();
       	 }
        }
		return TestData;
	}

}
