package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utils.TestUtils;

public class Base {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Base()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/Config/EmpLogin.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public  void browserStart(String browsername)
	{
		
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	
			 Map<String, Object> prefs = new HashMap<String, Object>();
			 
			 
	         
		        // Use File.separator as it will work on any OS
		        prefs.put("download.default_directory",
		               System.getProperty("user.dir") + File.separator + "DownloadedFile");
		        
		        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
		         
		        // Adding cpabilities to ChromeOptions
		        ChromeOptions options = new ChromeOptions();
		        options.setExperimentalOption("prefs", prefs);
			    driver = new ChromeDriver(options);
			    
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//driver.get("http://dsrcwin2016:2002/User/Login");
		driver.get("http://192.168.4.89:8536");
		
		
	}

}
