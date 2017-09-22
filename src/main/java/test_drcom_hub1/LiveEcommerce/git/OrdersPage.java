package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage {
	public final String PENDING_STATUS = "Pending";
	
	WebDriver driver;
	
	By lnkPrintOrder = By.xpath("//a[text()='Print Order']");
	
	
	//contructor
	public OrdersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// get pending status of order
	public String getStatus(String orderNo) {
		String orderStatusXPath = "//tbody//td[text()='" + orderNo + "']//parent::tr//td[@class='status']";
		return driver.findElement(By.xpath(orderStatusXPath)).getText();
	}
	
	// view order
	public void viewOrder(String orderNo) {
		String viewOrderXPath = "//tbody//td[text()='" + orderNo + "']//parent::tr//td[@class='a-center view last']//a[text()='View Order']";
		driver.findElement(By.xpath(viewOrderXPath)).click();
	}
	
	// click on print order link
	public void clickOnPrintOrder() {
		driver.findElement(lnkPrintOrder).click();
	}
}
