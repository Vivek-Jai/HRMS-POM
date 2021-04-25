package EmpRolePages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import Utils.TestUtils;

public class EmpITsupport extends Base {

	@FindBy(xpath = "//span[text()='IT Support']")

	WebElement itSupportMenu;

	@FindBy(xpath = "//span[text()='My IT Support Request']")

	WebElement myITSRMenu;

	@FindBy(xpath = "//button[@onclick='SendRequest()']")

	WebElement addNewITRequest;

	@FindBy(id = "s2id_CategoryList")

	WebElement categoryDropdown;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextCategory;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextCategory;

	@FindBy(id = "s2id_PriorityList")

	WebElement priorityDropdown;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextPriority;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextPriority;

	@FindBy(id = "s2id_ProjectList")

	WebElement projectDropdown;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextProject;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextProject;

	@FindBy(id = "s2id_FloorList")

	WebElement floorDropdown;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextFloor;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextFloor;

	@FindBy(id = "txt_contact")

	WebElement contact;

	@FindBy(id = "s2id_Assigned")

	WebElement reportPerson;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextreportPerson;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextreportPerson;

	@FindBy(id = "txt_Description")

	WebElement description;

	@FindBy(xpath = "//button[@onclick='Send()']")

	WebElement submitRequest;

	@FindBy(id = "s2id_Status")

	WebElement ticketStatus;

	@FindBy(xpath = "//div[@id='select2-drop']//input")

	WebElement enterTextticketStatus;

	@FindBy(xpath = "//ul[@class='select2-results']//div/span")

	WebElement clickTextticketStatus;

	@FindBy(xpath = "//button[@name='btn_Submit']")

	WebElement clickSearch;

	@FindBy(xpath = "//div[@id='tblUsers_filter']//input")

	WebElement searchTicket;

	@FindBy(xpath = "//table[@id='tblUsers']/tbody//td[10]")

	WebElement actionButton;

	@FindBy(xpath = "//table[@id='tblUsers']/tbody//td[10]//ul/li[1]")

	WebElement viewEditButton;

	@FindBy(xpath = "//table[@id='tblUsers']/tbody//td[10]//ul/li[2]")

	WebElement reopenTicketButton;

	@FindBy(xpath = "//table[@id='tblUsers']/tbody//td[10]//ul/li[3]")

	WebElement closeTicketButton;

	@FindBy(id = "CommentText")

	WebElement commentText;

	@FindBy(id = "txt_Reason")

	WebElement reopenComment;

	@FindBy(id = "Commend")

	WebElement closeComment;

	@FindBy(xpath = "//button[@onclick='Accept()']")

	WebElement reopenCommentSubmit;

	@FindBy(xpath = "//button[@onclick='closeITRequest()']")

	WebElement closeCommentSubmit;

	@FindBy(xpath = "//button[@onclick='AddComment()']")

	WebElement addCommentButton;

	@FindBy(xpath = "//table[@id='tblUsers']/tbody//td[10]//ul/li[2]")

	WebElement cancelButton;

	@FindBy(xpath = "//button[text()='OK']")

	WebElement confirmButton;

	String toastMessage;

	public EmpITsupport() {
		PageFactory.initElements(driver, this);
	}

	public void addNewITRequest(String categoryName, String priority, String projectName, String floor,
			String contactNo, String report, String desc, String ExpToastMessage) {
		driver.navigate().refresh();

		TestUtils.scrollDown("window.scrollBy(0,400)", driver);

		TestUtils.jsClick(itSupportMenu, driver);

		TestUtils.jsClick(myITSRMenu, driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		addNewITRequest.click();

		categoryDropdown.click();

		enterTextCategory.sendKeys(categoryName);

		clickTextCategory.click();

		priorityDropdown.click();

		enterTextPriority.sendKeys(priority);

		clickTextPriority.click();

		projectDropdown.click();

		enterTextProject.sendKeys(projectName);

		clickTextProject.click();

		floorDropdown.click();

		enterTextFloor.sendKeys(floor);

		clickTextFloor.click();

		contact.sendKeys(contactNo);

		reportPerson.click();

		enterTextreportPerson.sendKeys(report);

		clickTextreportPerson.click();

		description.sendKeys(desc);

		submitRequest.click();

		toastMessage = driver.findElement(By.className("toast-message")).getText();

		Assert.assertEquals(toastMessage, ExpToastMessage);

	}

	public void editAndcancelITRequest(String tStatus, String searchKey, String comments, String ExpCommentsMessage,
			String ExpCancelMessage) {

		driver.navigate().refresh();

		TestUtils.scrollDown("window.scrollBy(0,400)", driver);

		TestUtils.jsClick(itSupportMenu, driver);

		TestUtils.jsClick(myITSRMenu, driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ticketStatus.click();

		enterTextticketStatus.sendKeys(tStatus);

		clickTextticketStatus.click();

		searchTicket.sendKeys(searchKey);

		actionButton.click();

		viewEditButton.click();

		TestUtils.scrollDown("window.scrollBy(0,400)", driver);

		commentText.sendKeys(comments);

		addCommentButton.click();

		toastMessage = driver.findElement(By.className("toast-message")).getText();

		Assert.assertEquals(toastMessage, ExpCommentsMessage);

		TestUtils.waitForPageLoaded();

		ticketStatus.click();

		enterTextticketStatus.sendKeys(tStatus);

		clickTextticketStatus.click();

		searchTicket.sendKeys(searchKey);

		actionButton.click();

		cancelButton.click();

		TestUtils.jsClick(confirmButton, driver);

		toastMessage = driver.findElement(By.className("toast-message")).getText();

		Assert.assertEquals(toastMessage, ExpCancelMessage);

	}

	public void reOpenITRequest(String tStatus, String searchKey, String rOComment, String ExpCommentsMessage) {

		driver.navigate().refresh();

		TestUtils.scrollDown("window.scrollBy(0,400)", driver);

		TestUtils.jsClick(itSupportMenu, driver);

		TestUtils.jsClick(myITSRMenu, driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ticketStatus.click();

		enterTextticketStatus.sendKeys(tStatus);

		clickTextticketStatus.click();

		searchTicket.sendKeys(searchKey);

		actionButton.click();

		reopenTicketButton.click();

		reopenComment.sendKeys(rOComment);

		reopenCommentSubmit.click();

		toastMessage = driver.findElement(By.className("toast-message")).getText();

		Assert.assertEquals(toastMessage, ExpCommentsMessage);

	}

	public void closeITRequest(String tStatus, String searchKey, String cComment, String ExpCloseMessage) {
		driver.navigate().refresh();

		TestUtils.scrollDown("window.scrollBy(0,400)", driver);

		TestUtils.jsClick(itSupportMenu, driver);

		TestUtils.jsClick(myITSRMenu, driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ticketStatus.click();

		enterTextticketStatus.sendKeys(tStatus);

		clickTextticketStatus.click();

		searchTicket.sendKeys(searchKey);

		TestUtils.scrollDown("window.scrollBy(0,400)", driver);

		actionButton.click();

		closeTicketButton.click();

		closeComment.sendKeys(cComment);

		closeCommentSubmit.click();

		toastMessage = driver.findElement(By.className("toast-message")).getText();

		Assert.assertEquals(toastMessage, ExpCloseMessage);

	}

}
