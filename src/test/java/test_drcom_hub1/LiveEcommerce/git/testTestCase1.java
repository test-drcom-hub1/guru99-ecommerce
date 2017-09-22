package test_drcom_hub1.LiveEcommerce.git;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class testTestCase1 {
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
  public void verifyItemByName() throws Exception {
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
	  
	  // click on button List view
	  log.debug("click on button List view");
	  objMobiePage.clickOnListView();
	  
	  // sort by Name
	  log.debug("sort by Name");
	  objMobiePage.clickSortByName();
	  
	  // verify item sorted by Name (take screenshot)
	  log.debug("verify item sorted by Name (take screenshot)");
	  Util.takeScreenshot(driver, "screenshot_TC1.png");
	  log.debug("take screenshot successful");
  }
  
  @AfterMethod
  public void closingWebsite() throws Exception {
	  Thread.sleep(2000);
	  log.debug("closing website");
	  driver.close();
  }
}
