package EmpRolePages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import Utils.TestUtils;

public class EmpAddSkills extends Base {
	
	@FindBy(xpath = "//span[text()='Skills']")

	WebElement skillManagementmenu;
	
    @FindBy(xpath="//span[text()='Skills Declaration']")
	
	WebElement skillDeclarationMenu;
    
    @FindBy(xpath="//button[@onclick='SendRequest()']")
	
	WebElement addSkill;
    
    @FindBy(id="s2id_TechnologySearch")
	
	WebElement clickTechnologyDropdown;
   
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
	WebElement enterTextTechnology;
    
    @FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clickTechnologyText;
    
    @FindBy(id="s2id_SpecializationSearch")
	
	WebElement clickSpecializationDropdown;
    
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
	WebElement enterTextSpecialization;
    
    @FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clickSpecializationText;
    
    @FindBy(id="experiance0")
	
	WebElement enterExperience;
    
    @FindBy(id="DateAssessed0")
	
   	WebElement dateAssessed;
    
    @FindBy(id="s2id_yearId0")
	
   	WebElement lastUsedDropdown;
    
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
	WebElement enterTextlastUsed;
   
    @FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clicklastUsedText;
    
    @FindBy(id="s2id_LevelId0")
	
   	WebElement levelDropdown;
    
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
	WebElement enterTextlevel;
    
    @FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clicklevelText;
    
    @FindBy(id="s2id_ApprovedBy0")
	
   	WebElement approveDropdown;
   
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
	WebElement enterTextapprove;
    
    @FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clickapproveText;
    
    @FindBy(id="primary0")
	
   	WebElement primarySkill;
    
    @FindBy(id="btnSchedule")
	
   	WebElement submit;
    
   String toastMessage;
    
    
    public EmpAddSkills()
    {
    	PageFactory.initElements(driver, this);
    }
    
    
    public String addNewSkills(String TechName, String Special, String Exp, String Month, String Date, String lastUsed, String Level,String AssignName, String PrimaySkill)
    {
    	
    	 driver.navigate().refresh();
		   
		   TestUtils.jsClick(skillManagementmenu, driver);
		   
		  TestUtils.jsClick(skillDeclarationMenu, driver);
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
		  addSkill.click();
		  
		  clickTechnologyDropdown.click();
		  
		  enterTextTechnology.sendKeys(TechName);
		  
		  clickTechnologyText.click();
		  
		  clickSpecializationDropdown.click();
		  
		  enterTextSpecialization.sendKeys(Special);
    	
		  clickSpecializationText.click();
		  
		  enterExperience.sendKeys(Exp);
		  
		  dateAssessed.click();
		  
		  TestUtils.selectMonth(Month, driver);
		  
		  TestUtils.selectDate(Date, driver);
		  
		  lastUsedDropdown.click();
		  
		  enterTextlastUsed.sendKeys(lastUsed);
		  
		  clicklastUsedText.click();
		  
		  levelDropdown.click();
		  
		  enterTextlevel.sendKeys(Level);
		  
		  clicklevelText.click();
		  
		  approveDropdown.click();
		  
		  enterTextapprove.sendKeys(AssignName);
    	
		  clickapproveText.click();
		  
		  
    	if(PrimaySkill.equalsIgnoreCase("YES"))
    	{
    		primarySkill.click();
    	}
    	
    	
    	submit.click();
    	
    	toastMessage=driver.findElement(By.className("toast-message")).getText();
    	
    	
    	return toastMessage;
    	
    	
     	
    }
    
    
   
   
    
    
    
    
    
    
    
    
    
    
   
   
   
   
    
    
    
    
   
   
    
    
    
    
	
	
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
