package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
	WebDriver driver;
	public final String EXPECTED_MSGQUAITYERROR = "* The maximum quantity allowed for purchase is 500.";
	public final String EXPECTED_MSGEMPTYCART = "SHOPPING CART IS EMPTY";
	public final String EXPECTED_TITLE = "Shopping Cart";
	public final String EXPECTED_SHIPPING_METHOD = "Flat Rate";
	
	By txtMessageProductAddedToCart = By.xpath("//li[@class='success-msg']/ul/li/span");
	By txtQuatity = By.xpath("//input[@class='input-text qty']");
	By btnUpdate = By.xpath("//button[@class='button btn-update']");
	By msgQuatityError = By.xpath("//p[@class='item-msg error']");
	By lnkEmptyCart = By.xpath("//button[@id='empty_cart_button']");
	By txtEmptyCartText = By.xpath("//div[@class='page-title']/h1");
	By drpCountry = By.xpath("//ul[@class='form-list']//select[@id='country']");
	By drpState = By.xpath("//li[@class='shipping-region']//select[@id='region_id']");
	By txtZip = By.xpath("//li[@class='shipping-postcode']//input[@id='postcode']");
	By lnkEstimate = By.xpath("//div[@class='buttons-set']/button");
	By txtShipMethod = By.xpath("//dl[@class='sp-methods']/dt");
	By txtFixedCost = By.xpath("//dl[@class='sp-methods']/dd//span[@class='price']");
	By txtTotalFixedCost = By.xpath("//table[@id='shopping-cart-totals-table']//tbody//td[contains(text(),'Shipping')]//parent::tr//span[@class='price']");
	By radFixedCost = By.xpath("//dl[@class='sp-methods']//input[@id='s_method_flatrate_flatrate']");
	By btnUpdateTotal = By.xpath("//div[@class='buttons-set']/button[@value='Update Total']");
	By btnProceedToCheckoutBottom = By.xpath("//ul[@class='checkout-types bottom']/li/button");
	By txtSubTotal = By.xpath("//table[@id='shopping-cart-totals-table']//tbody//td[contains(text(),'Subtotal')]//parent::tr//span[@class='price']");
	By txtGrandTotal = By.xpath("//table[@id='shopping-cart-totals-table']//tfoot//span[@class='price']");
	
	// contructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// get message of product added into cart
	public String getMessageProductAddedToCart() {
		return driver.findElement(txtMessageProductAddedToCart).getText();
	}
	
	// set quality
	public void setQuatity(String quatity) {
		driver.findElement(txtQuatity).clear();
		driver.findElement(txtQuatity).sendKeys(quatity);
	}
	
	// get quatity
	public String getQuatity() {
		return driver.findElement(txtQuatity).getText();
	}
	
	// click on update button
	public void clickUpdate() {
		driver.findElement(btnUpdate).click();
	}
	
	// get error message '* The maximum quantity allowed for purchase is 500.'
	public String getMsgQuatityError() {
		return driver.findElement(msgQuatityError).getText();
	}
	
	// click on Empty cart button
	public void clickEmptyCart() {
		driver.findElement(lnkEmptyCart).click();
	}
	
	// get text 'Shopping Cart is Empty' after clicking Empty Cart button
	public String getMsgEmptyCart() {
		return driver.findElement(txtEmptyCartText).getText();
	}
	
	// select country
	public void selectCountry(String country) {
		Select selCountry = new Select(driver.findElement(drpCountry));
		selCountry.selectByVisibleText(country);
	}
	
	// select state
	public void selectState(String state) {
		Select selState = new Select(driver.findElement(drpState));
		selState.selectByVisibleText(state);
	}
	
	// enter zip
	public void enterZip(String zip) {
		driver.findElement(txtZip).clear();
		driver.findElement(txtZip).sendKeys(zip);
	}
	
	//click on link Estimate
	public void clickOnEstimate() {
		driver.findElement(lnkEstimate).click();
	}
	
	// get shipping method
	public String getShippingMethod() {
		return driver.findElement(txtShipMethod).getText();
	}
	
	// get shipping fixed cost
	public String getFixedCost() {
		return driver.findElement(txtFixedCost).getText();
	}
	
	// get shipping total fixed cost
	public String getTotalFixedCost() {
		return driver.findElement(txtTotalFixedCost).getText();
	}
	
	// click on update total
	public void clickOnUpdateTotal() {
		driver.findElement(btnUpdateTotal).click();
	}
	
	// click on radio fixed
	public void clickOnRadioFixed() {
		driver.findElement(radFixedCost).click();
	}
	
	// click on button proceed to checkout bottom
	public void clickOnCheckOutBottom() {
		driver.findElement(btnProceedToCheckoutBottom).click();
	}
	
	// get subtotal
	public String getSubTotal() {
		return driver.findElement(txtSubTotal).getText();
	}
	
	// get grandtotal
	public String getGrandTotal() {
		return driver.findElement(txtGrandTotal).getText();
	}
}
