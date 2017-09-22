package test_drcom_hub1.LiveEcommerce.git;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class testTestCase2 {
	  WebDriver driver;
	  HomePage objHomePage;
	  MenuLinks objMenuLinks;
	  MobilePage objMobiePage;
	  ProductDetail objProductDetail;
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
	  public void verifyCostOfProduct() throws Exception {
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
		  
		  // get cost of product and go to the product detail
		  String productName = "Sony Xperia";
		  log.debug("get cost of product");
		  String costOfProduct = objMobiePage.getCostOfProduct(productName);
		  log.debug("go to the product detail");
		  objMobiePage.goToProductDetail(productName);
		  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
		  // get cost of product detail
		  log.debug("get cost of product detail");
		  objProductDetail = new ProductDetail(driver);
		  String costOfProductDetail = objProductDetail.getCostOfProduct();
		  
		  // verify cost of Product page and cost of Product Detail page
		  log.debug("verify cost of Product page and cost of Product Detail page");
		  try {
			  assertEquals(costOfProduct, costOfProductDetail);
			  log.debug("PASSED");
			  System.out.println("verify cost of Product page and cost of Product Detail page: PASSED");
		  } catch (NoAlertPresentException e) {
			  log.debug("FAILED");
			  System.out.println("verify cost of Product page and cost of Product Detail page: FAILED");
		  }
	  }
	  
	  @AfterMethod
	  public void closingWebsite() throws Exception {
		  Thread.sleep(2000);
		  log.debug("closing website");
		  driver.close();
	  }
}
