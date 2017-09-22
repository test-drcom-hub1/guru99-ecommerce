package test_drcom_hub1.LiveEcommerce.git;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	WebDriver driver;
	
	By txtFirstName = By.xpath("//input[@id='firstname']");
	By txtMiddleName = By.xpath("//input[@id='middlename']");
	By txtLastName = By.xpath("//input[@id='lastname']");
	By txtEmail = By.xpath("//input[@id='email_address']");
	By txtPassword = By.xpath("//input[@id='password']");
	By txtConfirmPassword = By.xpath("//input[@id='confirmation']");
	By btnRegister = By.xpath("//button[@title='Register']");
	
	// contructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterFirstName(String fName) {
		driver.findElement(txtFirstName).clear();
		driver.findElement(txtFirstName).sendKeys(fName);
	}
	
	public void enterMiddleName(String mName) {
		driver.findElement(txtMiddleName).clear();
		driver.findElement(txtMiddleName).sendKeys(mName);
	}
	
	public void enterLastName(String lName) {
		driver.findElement(txtLastName).clear();
		driver.findElement(txtLastName).sendKeys(lName);
	}
	
	public void enterEmail(String emailAddress) {
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(emailAddress);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(txtConfirmPassword).clear();
		driver.findElement(txtConfirmPassword).sendKeys(password);
	}
	
	public void clickOnRegister() {
		driver.findElement(btnRegister).click();
	}
}
