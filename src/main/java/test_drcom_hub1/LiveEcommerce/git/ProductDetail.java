package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetail {
	WebDriver driver;
	
	By txtCostProductDetail = By.xpath("//div[@class='price-box']");
	By txtLetUsKnow = By.xpath("//textarea[@id='review_field']");
	By txtSummaryReview = By.xpath("//input[@id='summary_field']");
	By txtNickname = By.xpath("//input[@id='nickname_field']");
	By btnSubmitReview = By.xpath("//button[@title='Submit Review']");
	By txtLastestReview = By.xpath("//div[@id='customer-reviews']/dl//dd[1]");
	
	// contructor
	public ProductDetail(WebDriver driver) {
		this.driver = driver;
	}
	
	// get cost of product
	public String getCostOfProduct() {
		return driver.findElement(txtCostProductDetail).getText();
	}
	
	// enter information for textbox let us know
	public void enterLetUsKnow(String letUsKnow) {
		driver.findElement(txtLetUsKnow).clear();
		driver.findElement(txtLetUsKnow).sendKeys(letUsKnow);
	}
	
	// enter information for textbox summary review
	public void enterSummaryReview(String summaryReview) {
		driver.findElement(txtSummaryReview).clear();
		driver.findElement(txtSummaryReview).sendKeys(summaryReview);
	}
	
	// enter information for textbox nickname
	public void enterNickname(String nickName) {
		driver.findElement(txtNickname).clear();
		driver.findElement(txtNickname).sendKeys(nickName);
	}
	
	// click on button Submit Reivew
	public void clickOnSubmitReview() {
		driver.findElement(btnSubmitReview).click();
	}
	
	// get the lastest review
	public String getLastestReview() {
		return driver.findElement(txtLastestReview).getText();
	}
}
