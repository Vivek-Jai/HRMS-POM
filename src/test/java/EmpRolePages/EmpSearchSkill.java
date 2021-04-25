package EmpRolePages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import Utils.TestUtils;

public class EmpSearchSkill extends Base {
	
	
	@FindBy(xpath = "//span[text()='Skills']")

	WebElement skillManagementmenu;
	
    @FindBy(xpath="//span[text()='Search Skill']")
	
	WebElement searchSkilMenu;
    
    @FindBy(id="s2id_Skills")
	
	WebElement SearchskillDropdown;
    
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
	WebElement enterTextSearchskill;
    
    @FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clickSearchskillText;
    
    @FindBy(id="s2id_Experience")
	
   	WebElement searchExp;
    
    @FindBy(xpath="//div[@id='select2-drop']//input")
	
	WebElement enterTextSearchExp;
    
    @FindBy(xpath = "//ul[@class='select2-results']//div/span")
	
	WebElement clickSearchExpText;
    
    @FindBy(name = "btn_Submit")
	
	WebElement SearchButton;
    
    @FindBy(xpath="//table[@id='tbl']/tbody/tr/td[7]")
    
    List<WebElement> TotalRows;
    
   @FindBy(xpath="//table[@id='tbl']/tbody/tr/td[5]")
    
    List<WebElement> TotalRow;
    
    
    String Skills;
    
    String SkillsExp;
    
    public EmpSearchSkill()
    {
 	   PageFactory.initElements(driver, this);
    }
    
    
    public boolean searchSkills(String skillName, String skillExp)
    {
    	
    	 driver.navigate().refresh();
  	   
  	     TestUtils.jsClick(skillManagementmenu, driver);
  	   
  	     TestUtils.jsClick(searchSkilMenu, driver);
  	  
  	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	  
  	     SearchskillDropdown.click();
  	     
  	     enterTextSearchskill.sendKeys(skillName);
  	     
  	     clickSearchskillText.click();
  	     
  	     searchExp.click();
  	     
  	     enterTextSearchExp.sendKeys(skillExp);
  	     
  	     clickSearchExpText.click();
  	  
  	     SearchButton.click();
  	     
  	     boolean flag = true;
  	     
  	     for(int i=1;i<=TotalRows.size();i++)
  	     {
  	    	 
  	    	 
  	    Skills=	 driver.findElement(By.xpath("//table[@id='tbl']/tbody/tr["+i+"]/td[7]")).getText().trim();
  	    
  	    if(!Skills.equalsIgnoreCase(skillName))
  	    {
  	    	flag=false;
  	    	break;
  	    }
  	    
  	   }
		return flag;
		
    }	
		
		public boolean searchExp(String skillName,String skillExp, String in ,String around)
		{
			
			 driver.navigate().refresh();
		  	   
	  	     TestUtils.jsClick(skillManagementmenu, driver);
	  	   
	  	     TestUtils.jsClick(searchSkilMenu, driver);
	  	  
	  	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	  
	  	     SearchskillDropdown.click();
	  	     
	  	     enterTextSearchskill.sendKeys(skillName);
	  	     
	  	     clickSearchskillText.click();
	  	     
	  	     searchExp.click();
	  	     
	  	     enterTextSearchExp.sendKeys(skillExp);
	  	     
	  	     clickSearchExpText.click();
	  	  
	  	     SearchButton.click();
	  	     
	  	     
	  	   boolean flag = true;
	  	     
	  	     for(int i=1;i<=TotalRow.size();i++)
	  	     {
	  	    	 
	  	    	 
	  	    SkillsExp=	 driver.findElement(By.xpath("//table[@id='tbl']/tbody/tr["+i+"]/td[5]")).getText().trim();
	  	    
	  	    double exp=Double.parseDouble(SkillsExp);
	  	    
	  	int intial   = Integer.parseInt(in);
	  int last=	Integer.parseInt(around);
	  	  
	  	    
	  	   if(!(exp >= intial && exp <= last))
	  	   {
	  	    flag = false;
	  	    break;
	  	   }
			
			
		}
			return flag;
			
		
		}
}

	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


