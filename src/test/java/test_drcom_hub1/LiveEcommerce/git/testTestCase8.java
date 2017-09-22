package test_drcom_hub1.LiveEcommerce.git;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class testTestCase8 {
	  HomePage objHomePage;
	  RegisterPage objRegisterPage;
	  MobilePage objMobilePage;
	  LoginPage objLoginPage;
	  MenuLinks objMenuLinks;
	  WishlistPage objWishlistPage;
	  CartPage objCartPage;
	  CheckoutPage objCheckoutPage;
	  OrdersPage objOrdersPage;
	  Logger log; 
	  
	  public WebDriver driver;
	  public String email;
	  public String password = "123456";
	  public String product = "Samsung LCD";
	  public String address = "ABC";
	  public String city = "New York";
	  public String telephone = "12345678";
	  public String country = "United States";
	  public String state = "New York";
	  public String zip = "542896";
	  
	  public String actualOrderCode;
	  
	  @BeforeTest
	  public void openingWebsite() throws Exception {
		  // set logger
		  log = Logger.getLogger("devpinoyLogger");
		  System.out.println(Util.FIREFOX_DRIVER_PATH);
		  // set driver
		  System.setProperty(Util.FIREFOX_DRIVER_CORE, Util.FIREFOX_DRIVER_PATH);
		  driver = new FirefoxDriver();
		  
		  // go to homepage
		  log.debug("open and go to website");
		  driver.get(Util.BASE_URL);
		  
		  // waiting time for loading homepage
		  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
	  }
	  
	  @Test(priority=0)
	  public void verifyGrandTotalChanged() throws Exception {
		  // initialation HomePage class
		  objHomePage = new HomePage(driver);
		  objMenuLinks = new MenuLinks(driver);
		  objMobilePage = new MobilePage(driver);
		  objCartPage = new CartPage(driver);
		  
		  // verify title of homepage
		  log.debug("verify title of homepage");
		  try {
			  log.debug("PASSED");
			  assertEquals(objHomePage.getTitle(), objHomePage.EXPECTED_TITLE);
			  System.out.println("verify title of homepage: PASSED");
			  
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify title of homepage: FAILED");
		  }
		  
		  // verify text 1 on home page
		  log.debug("verify text 1 on home page");
		  try {
			  log.debug("PASSED");
			  assertEquals(objHomePage.getActualText1(), objHomePage.EXPECTED_TEXT_1);
			  System.out.println("verify text 1 on home page: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify text 1 on home page: FAILED");
		  }
		  
		  // click on Register
		  log.debug("click on Register");
		  objMenuLinks.openAccountMenu();
		  objMenuLinks.clickOnRegister();
		  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
		  
		  // enter valid information for Register page
		  log.debug("enter valid information for Register page");
		  String firstName = "MinhDRCA";
		  String middleName="";
		  Random randomNum = new Random();
		  String lastName= Integer.toString(randomNum.nextInt(10000));
		  email = firstName + lastName + "@gmail.com";
		  
		  objRegisterPage = new RegisterPage(driver);
		  objRegisterPage.enterFirstName(firstName);
		  objRegisterPage.enterLastName(lastName);
		  objRegisterPage.enterEmail(email);
		  objRegisterPage.enterPassword(password);
		  objRegisterPage.clickOnRegister();
		  
		  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
		  // verify register successful
		  log.debug("verify register successful");
		  String actualAccountName = driver.findElement(By.xpath("//p[@class='welcome-msg']")).getText();
		  String expectedAccountName = ("WELCOME, " + firstName + " " + lastName + "!").toUpperCase();
		  try {
			  assertEquals(actualAccountName, expectedAccountName);
			  log.debug("PASSED");
			  System.out.println("verify register successful: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify register successful: FAILED");
		  }
		  System.out.println("Email: " + email);
		  
		  // click on TV link
		  log.debug("click on TV link");
		  objMenuLinks.clickOnTV();
		  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
		  
		  // Add a TV product into cart
		  log.debug("Add a TV product into cart");
		  objMobilePage.clickAddToCart(product);
		  
		  // get grandtotal before update quantity
		  log.debug("get grandtotal before update quantity");
		  String beforeGrandTotal = objCartPage.getGrandTotal();
		  
		  // update quantity of product
		  log.debug("Update quantity of product");
		  objCartPage.setQuatity("5");
		  objCartPage.clickUpdate();
		  
		  // get grandtotal after update quantity
		  String afterGrandTotal = objCartPage.getGrandTotal();
		  
		  System.out.println("Before Grandtotal: " + beforeGrandTotal);
		  System.out.println("After Grandtotal: " + afterGrandTotal);
		  
		  // verify grandtotal is changed
		  try {
			  assertNotEquals(afterGrandTotal, beforeGrandTotal);
			  log.debug("Grand total is changed");
			  System.out.println("Grand total is changed");
		  } catch (NoAlertPresentException e) {
			  log.debug("Grand total is not changed");
			  //System.out.println("Grand total is not changed");
		  }  
		  
		// verify Flat Rate Shipping of $5 is generated
		  log.debug("verify Flat Rate Shipping of $5 is generated");
		  
		  objCartPage.selectCountry(country);
		  objCartPage.selectState(state);
		  objCartPage.enterZip(zip);
		  objCartPage.clickOnEstimate();
		  Thread.sleep(2000);
		  String actualShippingMethod = objCartPage.getShippingMethod();
		  //verify Flat Rate Shipping
		  try {
			  assertEquals(actualShippingMethod, objCartPage.EXPECTED_SHIPPING_METHOD);
			  log.debug("verify Flat Rate Shipping: PASSED");
			  System.out.println("verify Flat Rate Shipping: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("verify Flat Rate Shipping: FAILED");
			  System.out.println("verify Flat Rate Shipping: FAILED");
		  }
		  // verify fixed cost is generated
		  String actualFixedCost = objCartPage.getFixedCost();
		  String quantity = driver.findElement(By.xpath("//table[@id='shopping-cart-table']//input[@class='input-text qty']")).getAttribute("value");
		  int iQuantity = Integer.parseInt(quantity);
		  String expectedFixedCost = "$" + Integer.toString(iQuantity * 5) + ".00";
		  
		  try {
			  assertEquals(actualFixedCost, expectedFixedCost);
			  log.debug("verify cost is $5: PASSED");
			  System.out.println("verify cost is " + expectedFixedCost + ": PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("verify cost is $5: FAILED");
			  System.out.println("verify cost is " + expectedFixedCost + ": FAILED");
		  }
		  
		  // verify total product cost
		  log.debug("verify total product cost");
		  objCartPage.clickOnRadioFixed();
		  objCartPage.clickOnUpdateTotal();
		  Thread.sleep(2000);
		  String actualTotalFixedCost = objCartPage.getTotalFixedCost();
		  try {
			  assertEquals(actualTotalFixedCost, actualFixedCost);
			  log.debug("PASSED");
			  System.out.println("verify total product cost: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify total product cost: FAILED");
		  }
		  
		  // click on proceed to checkout bottom
		  log.debug("click on proceed to checkout bottom");
		  objCartPage.clickOnCheckOutBottom();
		  Thread.sleep(3000);
		  
		  // enter information for billing information
		  log.debug("enter information for billing information");
		  objCheckoutPage = new CheckoutPage(driver);
		  objCheckoutPage.enterAddress(address);
		  objCheckoutPage.enterCity(city);
		  objCheckoutPage.selectState(state);
		  objCheckoutPage.selectCountry(country);
		  objCheckoutPage.enterTelephone(telephone);
		  objCheckoutPage.enterZip(zip);
		  objCheckoutPage.clickOnBillingContinue();
		  Thread.sleep(2000);
		  
		  // enter information for shipping method
		  log.debug("enter information for shipping method");
		  objCheckoutPage.clickOnShipMethodContinue();
		  Thread.sleep(2000);
		  
		  // enter information for payment information
		  log.debug("enter information for payment information");		  
		  objCheckoutPage.clickOnChkMoneyOrder();
		  objCheckoutPage.clickOnPaymentContinue();
		  Thread.sleep(2000);
		  
		  // enter information for order view
		  log.debug("enter information for order view");
		  objCheckoutPage.clickOnPlaceOrder();
		  Thread.sleep(4000);
		  
		  // verify order confirmation and order code
		  log.debug("verify order confirmation and order code");
		  String actualOrderConfirmation = objCheckoutPage.getOrderConfimation();
		  actualOrderCode = objCheckoutPage.getOrderCode();
		  try {
			  assertEquals(actualOrderConfirmation, objCheckoutPage.EXPECTED_ORDER);
			  log.debug("verify order confirmation: PASSED");
			  System.out.println(actualOrderConfirmation);
			  
			  assertTrue(actualOrderCode.matches(objCheckoutPage.PATTERN_ORDER_CODE));
			  log.debug("verify order code: PASSED");
			  System.out.println("Order code: " + actualOrderCode);
			  System.out.println("verify order confirmation and order code: PASSED");
			  
		  } catch (NoAlertPresentException e) {
			  log.debug("verify order confirmation and order code: FAILED");
			  System.out.println("verify order confirmation and order code: FAILED");
		  }
	  }
	  
	  
	  @AfterTest
	  public void closingWebsite() throws Exception {
		  Thread.sleep(3000);
		  log.debug("closing website");
		  driver.close();
	  }
}
