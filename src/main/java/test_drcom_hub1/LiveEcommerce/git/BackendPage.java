package test_drcom_hub1.LiveEcommerce.git;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BackendPage {
	WebDriver driver;
	
	By txtUsername = By.xpath("//input[@id='username']");
	By txtPassword = By.xpath("//input[@id='login']");
	By btnLogin = By.xpath("//input[@type='submit']");
	By btnClose_PuIncomming = By.xpath("//div[@class='message-popup-head']/a");
	By lnkSalesMenu = By.xpath("//div[@class='nav-bar']//ul[@id='nav']//span[text()='Sales']//parent::a");
	By lnkOrdersMenu = By.xpath("//div[@class='nav-bar']//ul[@id='nav']//a//span[text()='Orders']//parent::a");
	By lnkInvoicessMenu = By.xpath("//div[@class='nav-bar']//ul[@id='nav']//a//span[text()='Invoices']//parent::a");
	By drpExport = By.xpath("//select[@id='sales_order_grid_export']");
	By btnExport = By.xpath("//button[@title='Export']");
	By drpStatus = By.xpath("//select[@id='sales_order_grid_filter_status']");
	By btnSearch = By.xpath("//button[@title='Search']");
	By drpActions = By.xpath("//select[@id='sales_order_grid_massaction-select']");
	By btnSubmit = By.xpath("//button[@title='Submit']");
	By chkFirstItem = By.xpath("//table[@id='sales_order_grid_table']//tbody/tr[1]//input");
	By lnkEditFirstItemReview = By.xpath("//table[@id='reviwGrid_table']//tbody/tr[1]//td[@class=' last']/a");
	By drpStatusReview = By.xpath("//select[@id='status_id']");
	By btnSaveReview = By.xpath("//div[@class='content-header']//button[@id='save_button']");
	By txtErrorMessage = By.xpath("//div[@id='messages']//span");
	By lnkCatalog = By.xpath("//div[@class='nav-bar']//ul[@id='nav']//span[text()='Catalog']//parent::a");
	By lnkReviewAndRating = By.xpath("//div[@class='nav-bar']//ul[@id='nav']//span[text()='Reviews and Ratings']//parent::a");
	By lnkCustomerReview = By.xpath("//div[@class='nav-bar']//ul[@id='nav']//span[text()='Customer Reviews']//parent::a");
	By lnkPendingReview = By.xpath("//div[@class='nav-bar']//ul[@id='nav']//span[text()='Pending Reviews']//parent::a");
	By txtInvoiceDateSort = By.xpath("//table[@id='sales_invoice_grid_table']//th[3]/span[@class='nobr']/a");
	By lstWeInvoiceId = By.xpath("//table[@id='sales_invoice_grid_table']//tbody//child::tr/td[2]");
	
	
	public final String EXPECTED_ERROR_MESSAGE = "There are no printable documents related to selected orders.";
	
	// contructor
	public BackendPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// close incomming popup
	public void closeIncomingPu() {
		driver.findElement(btnClose_PuIncomming).click();
	}

	// enter username
	public void enterUsername (String username) {
		driver.findElement(txtUsername).clear();
		driver.findElement(txtUsername).sendKeys(username);
	}
	
	// enter password
	public void enterPassword (String password) {
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	// click on login
	public void clickOnLogin() {
		driver.findElement(btnLogin).click();
	}
	
	// click on Sales menu
	public void clickOnSalesMenu() {
		driver.findElement(lnkSalesMenu).click();
	}
	
	// click on Orders menu
	public void clickOnOrdersMenu() {
		driver.findElement(lnkOrdersMenu).click();
	}
	
	// choose CSV from dropdownlist
	public void selectCSV() {
		Select selCSV = new Select(driver.findElement(drpExport));
		selCSV.selectByVisibleText("CSV");
	}
	
	// click on Export button
	public void clickOnExport() {
		driver.findElement(btnExport).click();
	}
	
	// select status canceled
	public void selectCanceledStatus() {
		Select selCanceled = new Select(driver.findElement(drpStatus));
		selCanceled.selectByVisibleText("Canceled");
	}
	
	// select status complete
	public void selectCompleteStatus() {
		Select selComplete = new Select(driver.findElement(drpStatus));
		selComplete.selectByVisibleText("Complete");
	}
	
	// click on Search button
	public void clickOnSearch() {
		driver.findElement(btnSearch).click();
	}
	
	// select print invoice
	public void selectPrintInvoice() {
		Select selPrintInvoice = new Select(driver.findElement(drpActions));
		selPrintInvoice.selectByVisibleText("Print Invoices");
	}
	
	// click on Submit button
	public void clickOnSubmit() {
		driver.findElement(btnSubmit).click();
	}
	
	// select the first item
	public void selectFirstItem() {
		driver.findElement(chkFirstItem).click();
	}
	
	// get error message
	public String getErrorMessage () {
		return driver.findElement(txtErrorMessage).getText();
	}
	
	// click on catalog
	public void clilckOnCatalog() {
		driver.findElement(lnkCatalog).click();
	}
	
	// click on review and rating
	public void clickOnReivewAndRating() {
		driver.findElement(lnkReviewAndRating).click();
	}
	
	// click on customer review
	public void clickOnCustomerReview() {
		driver.findElement(lnkCustomerReview).click();
	}
	
	// click on pending review
	public void clickOnPendingReview() {
		driver.findElement(lnkPendingReview).click();
	}
	
	// click on edit of the first item review
	public void clickOnEditFirstItemReview() {
		driver.findElement(lnkEditFirstItemReview).click();
	}
	
	// click on button save review
	public void clickOnSaveReview() {
		driver.findElement(btnSaveReview).click();
	}
	
	// choose approved for the review
	public void sellectApproved() {
		Select selApproved = new Select(driver.findElement(drpStatusReview));
		selApproved.selectByVisibleText("Approved");
	}
	
	// click on invoices
	public void clickOnInvoicesMenu() {
		driver.findElement(lnkInvoicessMenu).click();
	}
	
	// check sort method for Invoice Date (ASC or DESC)
	public boolean checkSortInvoiceDate(String sortMethod) {
		String chkSort = driver.findElement(txtInvoiceDateSort).getAttribute("class");
		if (chkSort.contains(sortMethod)) {
			return true;
		} else {
			return false;
		}		
	}
	
	
	// get the list of element invoice id
	public List<WebElement> getWeInvoicesList() {
		return driver.findElements(lstWeInvoiceId);
	}
	
}
