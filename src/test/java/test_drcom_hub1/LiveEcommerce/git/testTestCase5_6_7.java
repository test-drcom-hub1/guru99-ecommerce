package test_drcom_hub1.LiveEcommerce.git;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class testTestCase5_6_7 {
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
	  public void verifyComparePopup() throws Exception {
		  // initialation HomePage class
		  objHomePage = new HomePage(driver);
		  objMenuLinks = new MenuLinks(driver);
		  
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
		  
		  // click on TV link
		  log.debug("click on TV link");
		  objMenuLinks = new MenuLinks(driver);
		  objMenuLinks.clickOnTV();
		  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
		  
		  // click on share wishlist of product
		  log.debug("click on share wishlist of product");
		  objMobilePage = new MobilePage(driver);
		  objMobilePage.clickOnAddToWishlist(product);
		  
		  // click on share wishlist
		  log.debug("click on share wishlist");
		  driver.findElement(By.xpath("//button[@class='button btn-share']")).click();
		  
		  // enter sharing information
		  log.debug("enter sharing information");
		  driver.findElement(By.xpath("//textarea[@id='email_address']")).sendKeys("dangquangminh.vn@gmail.com");
		  driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("testing sharing wishlist");
		  
		  // click on 'share wishlist' button
		  log.debug("click on 'share wishlist' button");
		  driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		  
		  // verify wishlist has been shared.
		  log.debug("verify wishlist has been shared.");
		  String expectedWishlistShared = "Your Wishlist has been shared.";
		  String actualWishlistShared = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
		  try {
			  assertEquals(actualWishlistShared, expectedWishlistShared);
			  log.debug("PASSED");
			  System.out.println("verify wishlist has been shared: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify wishlist has been shared: FAILED");
		  }
		  System.out.println(email);
	  }
	  
	  @Test(priority=1, dependsOnMethods={"verifyComparePopup"})
	  //@Test(priority=1)
	  public void verifyLogOut() throws Exception {
		  // verify log out and direct to Home page
		  log.debug("verify log out and direct to Home page");
		  objMenuLinks.openAccountMenu();
		  objMenuLinks.clickOnLogOut();
		  Thread.sleep(8000);
		  String actualTitle = driver.getTitle();
		  try {
			  assertEquals(actualTitle, objHomePage.EXPECTED_TITLE);
			  log.debug("PASSED");
			  System.out.println("verify log out and direct to Home page: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify log out and direct to Home page: FAILED");
		  }
	  }
	  
	  
	  @Test(priority=2, dependsOnMethods={"verifyLogOut"})
	  //@Test(priority=2)
	  public void verifyPurchaseProduct() throws Exception {
		  // click on My Account link
		  log.debug("click on My Account link");
		  objMenuLinks.openAccountMenu();
		  objMenuLinks.clickOnMyAccount();
		  
		  // enter valid email and password at Login page
		  log.debug("enter valid email and password at Login page");
		  objLoginPage = new LoginPage(driver);
		  objLoginPage.enterEmail(email);
		  objLoginPage.enterPassword(password);
		  objLoginPage.clickOnLogin();
		  Thread.sleep(2000);
		  
		  // click on link My Whishlist
		  log.debug("click on link My Whishlist");
		  objMenuLinks.clickOnMyWishlist();
		  
		  // click on Add To Cart of product
		  log.debug("click on Add To Cart of product");
		  objWishlistPage = new WishlistPage(driver);
		  objWishlistPage.clickAddToCart(product);
		  Thread.sleep(4000);
		  
		  // verify title of Cart page
		  log.debug("verify title of Cart page");
		  objCartPage = new CartPage(driver);
		  String actualCartTitle = driver.getTitle();
		  try {
			  assertEquals(actualCartTitle, objCartPage.EXPECTED_TITLE);
			  log.debug("PASSED");
			  System.out.println("verify title of Cart page: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify title of Cart page: FAILED");
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
		  // verify cost is $5
		  String actualFixedCost = objCartPage.getFixedCost();
		  String expectedFixedCost = "$5.00";
		  try {
			  assertEquals(actualFixedCost, expectedFixedCost);
			  log.debug("verify cost is $5: PASSED");
			  System.out.println("verify cost is $5: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("verify cost is $5: FAILED");
			  System.out.println("verify cost is $5: FAILED");
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
	  
	  @Test(priority=3, dependsOnMethods={"verifyPurchaseProduct"})
	  public void verifyOrderPdfFile() throws Exception {
		  objOrdersPage = new OrdersPage(driver);
		  
		  // click on my orders
		  log.debug("click on my orders");
		  objMenuLinks.openAccountMenu();
		  objMenuLinks.clickOnMyAccount();
		  objMenuLinks.clickOnMyOrders();
		  Thread.sleep(3000);
		  
		  // verify status of order is pending
		  log.debug("verify status of order is pending");
		  String actualOrderStatus = objOrdersPage.getStatus(actualOrderCode);
		  try {
			  assertEquals(actualOrderStatus, objOrdersPage.PENDING_STATUS);
			  log.debug("PASSED");
			  System.out.println("verify status of order is pending: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify status of order is pending: FAILED");
		  }
		  
		  // click on view order
		  log.debug("click on view order");
		  objOrdersPage.viewOrder(actualOrderCode);
		  Thread.sleep(3000);
		  
		  // click on print order
		  log.debug("click on print order");
		  objOrdersPage.clickOnPrintOrder();
		  Thread.sleep(2000);
		  
		  // execute AutoIT script
		  log.debug("execute AutoIT script");
		  Util.executePrintDialog("verifyOrderPdfFile_PrintDialog.exe");
		  Util.takeScreenshot(driver, "Save PDF file as dialog.png");
		  Util.executeSavePdfDialog("verifyOrderPdfFile_SavePDF.exe");
	  }
	  
	  @AfterTest
	  public void closingWebsite() throws Exception {
		  Thread.sleep(3000);
		  log.debug("closing website");
		  driver.close();
	  }
}
