package test_drcom_hub1.LiveEcommerce.git;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class testTestCase4 {
	  WebDriver driver;
	  HomePage objHomePage;
	  MenuLinks objMenuLinks;
	  MobilePage objMobiePage;
	  Logger log; 
		
	  @BeforeMethod
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
	  
	  @Test
	  public void verifyComparePopup() throws Exception {
		  // initialation HomePage class
		  objHomePage = new HomePage(driver);
		  objMenuLinks = new MenuLinks(driver);
		  
		  // verify title of homepage
		  log.debug("verify title of homepage");
		  try {
			  log.debug("PASSED");
			  assertEquals(driver.getTitle(), objHomePage.EXPECTED_TITLE);
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
		  
		  // click on MOBILE link
		  log.debug("click on MOBILE link");
		  objMenuLinks.clickOnMobile();
		  
		  // initialation of MobilePage class
		  objMobiePage = new MobilePage(driver);
		  
		  // verify title of Mobile page
		  log.debug("verify title of Mobile page");
		  try {
			  assertEquals(driver.getTitle(), objMobiePage.EXPECTED_TITLE);
			  log.debug("PASSED");
			  System.out.println("verify title of Mobile page: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify title of Mobile page: FAILED");
		  }
		  
		  // compare two products
		  log.debug("compare two products");
		  String product1 = "IPhone";
		  String product2 = "Sony Xperia";
		  objMobiePage.compareTwoProducts(product1, product2);
		  // switch to new popup windows
		  log.debug("switch to new windows");
		  String mainWindowhandle = driver.getWindowHandle();
		  for (String handle : driver.getWindowHandles()) {
			  driver.switchTo().window(handle);
		  }
		  
		  // verify title of compare product Popup
		  log.debug("verify title of compare product Popup");
		  String expectedCompareTitle = "COMPARE PRODUCTS";
		  String actualCompareTitle = driver.findElement(By.xpath("//h1[text()='Compare Products']")).getText();
		  try {
			  assertEquals(actualCompareTitle, expectedCompareTitle);
			  log.debug("PASSED");
			  System.out.println("verify title of compare product Popup: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify title of compare product Popup: FAILED");
		  }
		  
		  // get text product from popup
		  log.debug("get text produts from popup");
		  String product1PopupXPath = "//table[@id='product_comparison']//h2/a[text()='" + product1 + "']";
		  String product2PopupXPath = "//table[@id='product_comparison']//h2/a[text()='" + product2 + "']";
		  String actualProduct1Popup = driver.findElement(By.xpath(product1PopupXPath)).getText();
		  String actualProduct2Popup = driver.findElement(By.xpath(product2PopupXPath)).getText();
		  product1 = product1.toUpperCase();
		  product2= product2.toUpperCase();
		  
		  // verify two products of Popup
		  log.debug("verify two products of Popup");
		  try {
			  assertEquals(actualProduct1Popup, product1);
			  assertEquals(actualProduct2Popup, product2);
			  log.debug("PASSED");
			  System.out.println("verify two products of Popup: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify two products of Popup: FAILED");
		  }
		  
		  // click on 'Close Window'
		  log.debug("click on 'Close Window'");
		  driver.close();
		  
		  // switch to main window
		  log.debug("switch to main window");
		  driver.switchTo().window(mainWindowhandle);
	  }
	  
	  @AfterMethod
	  public void closingWebsite() throws Exception {
		  Thread.sleep(2000);
		  log.debug("closing website");
		  driver.close();
	  }
}
