package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By txtEmail = By.xpath("//div[@class='input-box']/input[@id='email']");
	By txtPassword = By.xpath("//div[@class='input-box']/input[@id='pass']");
	By btnLogin = By.xpath("//div[@class='buttons-set']/button[@id='send2']");
	
	// contructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// enter email
	public void enterEmail(String email) {
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	// enter password
	public void enterPassword(String password) {
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(password);
	}
	
	// click on Login
	public void clickOnLogin() {
		driver.findElement(btnLogin).click();
	}
}
