package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	public final String EXPECTED_TITLE = "Checkout";
	public final String EXPECTED_ORDER = "Your order has been received.".toUpperCase();
	public final String PATTERN_ORDER_CODE = "[0-9]+";
	
	WebDriver driver;
	By txtAddress = By.xpath("//input[@id='billing:street1']");
	By txtCity = By.xpath("//input[@id='billing:city']");
	By txtZip = By.xpath("//input[@id='billing:postcode']");
	By txtTelephone = By.xpath("//input[@id='billing:telephone']");
	By drpState = By.xpath("//select[@id='billing:region_id']");
	By drpCountry = By.xpath("//select[@id='billing:country_id']");
	By btnBillingContinue = By.xpath("//div[@id='billing-buttons-container']/button");
	By btnShipMethodContinue = By.xpath("//div[@id='shipping-method-buttons-container']/button");
	By btnPaymentContinue = By.xpath("//div[@id='payment-buttons-container']/*[@onclick='payment.save()']");
	By chkMoneyOrder = By.xpath("//dt[@id='dt_method_checkmo']/input");
	By btnPlaceOrder = By.xpath("//div[@id='review-buttons-container']/button");
	By txtOrderConfimation = By.xpath("//div[@class='page-title']/h1");
	By txtOrderCode = By.xpath("//*[contains(text(),'Your order # is: ')]/a");
	
	
	// contructor
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// get title of Checkout page
	public void getTitle() {
		driver.getTitle();
	}
	
	// enter address
	public void enterAddress(String address) {
		driver.findElement(txtAddress).sendKeys(address);
	}
	
	// enter city
	public void enterCity(String city) {
		driver.findElement(txtCity).sendKeys(city);
	}
	
	// select state
	public void selectState(String state) {
		Select selState = new Select(driver.findElement(drpState));
		selState.selectByVisibleText(state);
	}
	
	// select country
	public void selectCountry(String country) {
		Select selCountry = new Select(driver.findElement(drpCountry));
		selCountry.selectByVisibleText(country);
	}
	
	// enter zip
	public void enterZip(String zip) {
		driver.findElement(txtZip).clear();
		driver.findElement(txtZip).sendKeys(zip);
	}
	
	// enter telephone
	public void enterTelephone(String telephone) {
		driver.findElement(txtTelephone).sendKeys(telephone);
	}
	
	// click on continue button of billing information
	public void clickOnBillingContinue() {
		driver.findElement(btnBillingContinue).click();
	}
	
	// click on continue button of shipping method
	public void clickOnShipMethodContinue() {
		driver.findElement(btnShipMethodContinue).click();
	}
	
	// click on checkbox Money order
	public void clickOnChkMoneyOrder() {
		driver.findElement(chkMoneyOrder).click();
	}
	
	// click on continue button of payment
	public void clickOnPaymentContinue() {
		driver.findElement(btnPaymentContinue).click();
	}
	
	// click on place order
	public void clickOnPlaceOrder() {
		driver.findElement(btnPlaceOrder).click();
	}
	
	// get order confimation
	public String getOrderConfimation() {
		return driver.findElement(txtOrderConfimation).getText();
	}
	
	// get order code
	public String getOrderCode() {
		return driver.findElement(txtOrderCode).getText();
	}
}
