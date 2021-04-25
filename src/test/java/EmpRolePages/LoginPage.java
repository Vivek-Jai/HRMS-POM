package EmpRolePages;



 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.Base;
import Utils.TestUtils;

public class LoginPage extends Base {
	

	
	@FindBy(name="UserName")

	WebElement enterUsername;
	
	@FindBy(name="Password")
	
	WebElement enterPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	
	WebElement clickSubmit;
	
	@FindBy(className="close")
	
	WebElement popupClose;

	
	@FindBy(xpath="//li[@class='profile-info dropdown']/a")
	
	WebElement verifyusername;
	
	
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public  void Emplogin(String Username, String Password)
	
	{
		
		enterUsername.sendKeys(Username);
		enterPassword.sendKeys(Password);
		clickSubmit.click();
		
		if(TestUtils.existsElement(popupClose))
		{
			popupClose.click();
		}
}
	

	
	
	public  String verifyUsername()
	{
		String actualUN = verifyusername.getText().trim();
		
		return actualUN;
	}
	
	
	
	
	
	
	

}
