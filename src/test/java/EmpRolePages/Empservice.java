package EmpRolePages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.Base;
import Utils.TestUtils;


public class Empservice extends Base {

	@FindBy(xpath = "//div[@class='tile-title tile-gray']/div/div[@class='icon']")

	WebElement clickAddNewService;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[1]")

	WebElement MyDevice;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[2]")

	WebElement ViewDeviceRequest;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[3]")

	WebElement ApplyOutOfOffice;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[4]")

	WebElement ApplyWorkFromHome;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[5]")

	WebElement Goals;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[6]")

	WebElement Rewards;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[7]")

	WebElement SearchSkill;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[8]")

	WebElement SkillsDeclaration;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[9]")

	WebElement MyTimeSheet;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[10]")

	WebElement ViewEditTimeSheet;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[11]")

	WebElement ManageTraining;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[12]")

	WebElement MyTraining;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[13]")

	WebElement Feedback;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[14]")

	WebElement Album;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[15]")

	WebElement ReportIncident;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[16]")

	WebElement ManageRequest;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[17]")

	WebElement SubmitOnDutyForm;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[18]")

	WebElement Projects;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[19]")

	WebElement AssignedRisk;

	@FindBy(xpath = "(//label[@class='checkbox-inline']/span)[20]")

	WebElement Services;

	@FindBy(xpath = "//div[@class='modal-footer']/button[@id='btnSubmit']")

	WebElement clickSave;
	
	@FindBy(xpath="//button[@data-bb-handler='confirm']")
	
	WebElement confirmButton;

	

	static String actualText;
	static String toastMessage;
	
	WebElement element;

	public Empservice() {

		PageFactory.initElements(driver, this);
	}

	public void addNewService(String checkboxName) {

		driver.navigate().refresh();
		clickAddNewService.click();

		switch (checkboxName) {

		case "My Devices":

			MyDevice.click();

			break;

		case "View Device Request":

			ViewDeviceRequest.click();

			break;

		case "Apply Out Of Office":

			ApplyOutOfOffice.click();

			break;

		case "Apply Work From Home":

			ApplyWorkFromHome.click();

			break;

		case "Goals":

			Goals.click();

			break;

		case "Rewards":

			Rewards.click();

			break;

		case "Search Skill":

			SearchSkill.click();

			break;

		case "Skills Declaration":

			SkillsDeclaration.click();

			break;

		case "My TimeSheet":

			MyTimeSheet.click();

			break;

		case "View Edit TimeSheet":

			ViewEditTimeSheet.click();

			break;

		case "Manage Training":

			ManageTraining.click();

			break;

		case "My Training":

			MyTraining.click();

			break;

		case "Feedback":

			Feedback.click();

			break;

		case "Album":

			Album.click();

			break;

		case "Report Incident":

			ReportIncident.click();

			break;

		case "Manage Request":

			ManageRequest.click();

			break;

		case "Submit On Duty Form":

			SubmitOnDutyForm.click();

			break;

		case "Projects":

			Projects.click();

			break;

		case "Assigned Risk":

			AssignedRisk.click();

			break;

		case "Services":

			Services.click();

			break;

		}

		clickSave.click();

	}

	public String serviceDisplay(String getServiceName, String value) {

		switch (getServiceName) {
		case "My Devices":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "View Device Request":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Apply Out Of Office":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Apply Work From Home":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Goals":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Rewards":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Search Skill":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Skills Declaration":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "My TimeSheet":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "View Edit TimeSheet":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Manage Training":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Feedback":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Album":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Report Incident":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Manage Request":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Submit On Duty Form":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Projects":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Assigned Risk":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "Services":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		case "My Training":

			actualText = driver.findElement(By.xpath("(//div[@class='title']/h3)[" + value + "]")).getText().trim();
			break;

		}

		return actualText;

	}

	public String removeService(String removeServiceName, String value) {

		driver.navigate().refresh();
		
		switch (removeServiceName) {

		case "My Devices":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();

			break;

		case "View Device Request":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Apply Out Of Office":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Apply Work From Home":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Goals":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Rewards":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Search Skill":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Skills Declaration":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "My TimeSheet":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "View Edit TimeSheet":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Manage Training":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Feedback":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Album":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Report Incident":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Manage Request":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Submit On Duty Form":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Projects":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Assigned Risk":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "Services":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		case "My Training":

			driver.findElement(By.xpath("//div[@class='panel-body']//div[" + value + "]//i[@class='entypo-cancel']"))
					.click();
			element =confirmButton;
			TestUtils.jsClick(element, driver);
			toastMessage = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
			break;

		}

		return toastMessage;

	}
}
