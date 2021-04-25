package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.Base;

public class TestUtils extends Base {

	public static long PAGE_LOAD_TIMEOUT =50;
	public static long IMPLICIT_WAIT =50;
	
	
	
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;

}
	
	public static void expilicitWaittoClick(WebDriver driver,String element, int timeout  )
	{
		WebElement	ele=new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		
	
			
		ele.click();
	}
	
	
	public static void expilicitWaittoVisible(WebDriver driver,String element,int timeout )
	{
		 new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
			
		
	}

	public static void scrollDown(String down,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript(down);
	}
	
	public static void scrollUp(String up,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript(up);
	}
	
	public static void jsClick(WebElement ele, WebDriver driver)
	{
      JavascriptExecutor js = ((JavascriptExecutor) driver);
		 
	   js.executeScript("arguments[0].click();", ele);
	}
	
	public static void enterTime(WebDriver driver,WebElement ele, String value )
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].value = '"+value+"';", ele);
	}
	
	
	
	
	
	public static void selectMonth(String Month, WebDriver driver)
	{
		driver.findElement(By.xpath("//div[@class='datepicker-days']//tr[1]/th[2]")).click();
		
		switch(Month)
		{
		
		case "Jan":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[1]")).click();
			break;
			
		case "Feb":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[2]")).click();
			break;
			
		case "Mar":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[3]")).click();
			break;
			
		case "Apr":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[4]")).click();
			break;
			
		case "May":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[5]")).click();
			break;
			
		case "June":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[6]")).click();
			break;
			
		case "July":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[7]")).click();
			break;
			
		case "Aug":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[8]")).click();
			break;
			
		case "Sep":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[9]")).click();
			break;
			
		case "Oct":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[10]")).click();
			break;
			
		case "Nov":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[11]")).click();
			break;
			
		case "Dec":

			driver.findElement(By.xpath("//div[@class='datepicker-months']//td/span[12]")).click();
			break;

		}
	}
	
	public static void selectDate(String Date, WebDriver driver)
	{
		List <WebElement> allDates=driver.findElements(By.xpath("//div[@class='datepicker-days']//tbody/tr/td"));
		
		
			for(WebElement ele : allDates)
			{
				String actualDate=ele.getText();
				
				
				if(actualDate.equalsIgnoreCase(Date))
				{
					ele.click();
					
					break;
				}
			}
		
		
	}
	
	public static void windowSwitch(WebDriver driver)
	{
		String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
                if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.close();
                
            }
        }    
                driver.switchTo().window(mainwindow);
	}


	
	public static boolean existsElement(WebElement element) {
		boolean flag= false;
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	    try {
	    	//driver.findElement(By.className(element));
	    	if(element.isDisplayed())
				flag= true;
			
	    } catch (Exception e) 
	    {
	    	System.out.println("The popup is not present");
	    	
	        
	    }
		return flag;
	    
	}
	
	public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
	
	
}
