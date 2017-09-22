package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
	WebDriver driver;
	
	// contructor
	public WishlistPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// click on Add To Cart
	public void clickAddToCart(String productName) {
		String addToCartXPath = "//tbody/tr/td/h3/a[text()='" + productName + "']//parent::h3//parent::td//parent::tr/td/div[@class='cart-cell']/button";
		driver.findElement(By.xpath(addToCartXPath)).click();
	}
}
