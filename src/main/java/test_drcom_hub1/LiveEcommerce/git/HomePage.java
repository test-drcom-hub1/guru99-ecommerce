package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage {
	// initialation of elements and objects
	WebDriver driver;
	public final String EXPECTED_TITLE = "Home page";
	public final String EXPECTED_TEXT_1 = "THIS IS DEMO SITE FOR   ";
	
	By txtActualText1 = By.xpath("//h2[contains(text(),'This is demo site for')]");
	By lnkAdvancedSearch = By.xpath("//div[@class='links']//a[@title='Advanced Search']");
	
	// contructor
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	
	// get actual text 1
	public String getActualText1() {
		return driver.findElement(txtActualText1).getText();
	}
	
	// get title
	public String getTitle() {
		return driver.getTitle();
	}
	
	// click on Advanced Search
	public void clickOnAdvancedSearch() {
		driver.findElement(lnkAdvancedSearch).click();
	}
}
