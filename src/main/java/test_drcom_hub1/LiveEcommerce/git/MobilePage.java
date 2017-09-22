package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {
	WebDriver driver;
	public final String EXPECTED_TITLE = "Mobile";
	
	By btnList = By.xpath("//div[@class='toolbar']//a[text()='List']");
	By drpSortBy = By.xpath("//select[@title='Sort By']");
	By btnCompare = By.xpath("//button[@title='Compare']");
	WebElement eCostProduct;
	WebElement btnAddToCart;
	
	// contructor
	public MobilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// click on List button
	public void clickOnListView() {
		driver.findElement(btnList).click();
	}
	
	// choose value 'Name' from dropdownlist 'Sort by'
	public void clickSortByName() {
		Select drpSortByName = new Select(driver.findElement(drpSortBy));
		drpSortByName.selectByVisibleText("Name");
	}
	
	// get cost of product
	public String getCostOfProduct(String productName) {
		String costXPath = "//div[@class='product-info']//a[text()='" + productName + "']//parent::h2//parent::div/div[@class='price-box']";
		eCostProduct = driver.findElement(By.xpath(costXPath));
		return eCostProduct.getText();		
	}
	
	// go to product detail
	public void goToProductDetail(String productName) {
		driver.findElement(By.xpath("//div[@class='product-info']//a[text()='" + productName + "']")).click();
	}
	
	// click on Add To Cart
	public void clickAddToCart(String productName) {
		String addToCartXPath = "//div[@class='product-info']//a[text()='" + productName + "']//parent::h2//parent::div/div[@class='actions']//button[@class='button btn-cart']";
		btnAddToCart = driver.findElement(By.xpath(addToCartXPath));
		btnAddToCart.click();
	}
	
	// choosing two products to compare
	public void compareTwoProducts(String productName1, String productName2) {
		String compareProduct1XPath = "//div[@class='product-info']//a[text()='" + productName1 + "']//parent::h2//parent::div/div[@class='actions']/ul/li[2]/a";
		String compareProduct2XPath = "//div[@class='product-info']//a[text()='" + productName2 + "']//parent::h2//parent::div/div[@class='actions']/ul/li[2]/a";
		driver.findElement(By.xpath(compareProduct1XPath)).click();
		driver.findElement(By.xpath(compareProduct2XPath)).click();
		driver.findElement(btnCompare).click();
	}
	
	// click on 'Add to Wishlist'
	public void clickOnAddToWishlist(String productName) {
		String ProductWishlistXPath = "//div[@class='product-info']//a[text()='" + productName + "']//parent::h2//parent::div/div[@class='actions']/ul/li[1]/a";
		driver.findElement(By.xpath(ProductWishlistXPath)).click();
	}
}
