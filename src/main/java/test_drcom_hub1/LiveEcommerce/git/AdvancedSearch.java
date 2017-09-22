package test_drcom_hub1.LiveEcommerce.git;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedSearch {
	WebDriver driver;
	
	By txtPriceFrom = By.xpath("//div[@class='input-range']/input[@id='price']");
	By txtPriceTo = By.xpath("//div[@class='input-range']/input[@id='price_to']");
	By btnSearch = By.xpath("//div[@class='buttons-set']/button[@title='Search']");
	By lstProductName = By.xpath("//div[@class='category-products']//div[@class='product-info']/*[@class='product-name']/a");
	By lstProductPrice = By.xpath("//div[@class='category-products']//div[@class='product-info']/*[@class='price-box']//span[contains(@id,'product-price')]");
	
	// contructor
	public AdvancedSearch (WebDriver driver) {
		this.driver = driver;
	}
	
	// enter value for pricefrom
	public void enterValuePriceFrom (String price) {
		driver.findElement(txtPriceFrom).clear();
		driver.findElement(txtPriceFrom).sendKeys(price);
	}
	
	// enter value for priceto
	public void enterCaluePriceTo (String price) {
		driver.findElement(txtPriceTo).clear();
		driver.findElement(txtPriceTo).sendKeys(price);
	}
	
	// click on Search button
	public void clickOnSearch() {
		driver.findElement(btnSearch).click();
	}
	
	// get all elements of product name
	public List<WebElement> getListOfProductName() {
		return driver.findElements(lstProductName);
	}
	
	// get all elements of product price
	public List<WebElement> getListOfProductPrice() {
		return driver.findElements(lstProductPrice);
	}
}
