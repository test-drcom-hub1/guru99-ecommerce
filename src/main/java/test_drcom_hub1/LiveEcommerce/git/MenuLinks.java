package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuLinks {
	WebDriver driver;
	
	// top menu
	By lnkMobile = By.xpath("//*[@id='nav']//a[text()='Mobile']");
	By lnkTV = By.xpath("//div[@id='header-nav']//a[text()='TV']");
	
	// account menu
	By lnkAccountMenu = By.xpath("//span[text()='Account']");
	By lnkRegister = By.xpath("//div[@class='links']//a[text()='Register']");
	By lnkMyAccount = By.xpath("//div[@class='links']//a[text()='My Account']");
	By lnkLogOut = By.xpath("//div[@class='links']//a[text()='Log Out']");
	
	// left menu
	By lnkMyWishlist = By.xpath("//div[@class='block-content']/ul/li/a[text()='My Wishlist']");
	By lnkMyOrders = By.xpath("//div[@class='block-content']//a[text()='My Orders']");
	
	// contructor
	public MenuLinks (WebDriver driver) {
		this.driver = driver;
	}
	
	// click on link My Wishlist
	public void clickOnMyWishlist() {
		driver.findElement(lnkMyWishlist).click();
	}
	
	// click on link MOBILE
	public void clickOnMobile() {
		driver.findElement(lnkMobile).click();
	}
	
	// click on link TV
	public void clickOnTV() {
		driver.findElement(lnkTV).click();
	}
	
	// click on Register link
	public void clickOnRegister() {
		driver.findElement(lnkRegister).click();
	}
	
	// click on My Account link
	public void clickOnMyAccount() {
		driver.findElement(lnkMyAccount).click();
	}
	
	// click on Log Out link
	public void clickOnLogOut() {
		driver.findElement(lnkLogOut).click();
	}
	
	// [left menu] click on My Orders link
	public void clickOnMyOrders() {
		driver.findElement(lnkMyOrders).click();
	}
	
	// open account menu
	public void openAccountMenu() {
		driver.findElement(lnkAccountMenu).click();
	}
}
