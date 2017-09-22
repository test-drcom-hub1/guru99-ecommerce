package test_drcom_hub1.LiveEcommerce.git;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class testTestCaseExtra1 {
  WebDriver driver;
  Logger log;
  BackendPage objBackendPage;
	
  @BeforeTest
  public void openingWebsite() throws Exception {
	  // set logger
	  log = Logger.getLogger("devpinoyLogger");
	  
	  // set driver for Chrome browser
	  System.setProperty(Util.CHROME_DRIVER_CORE, Util.CHROME_DRIVER_PATH);
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  log.debug("open backend site");
	  driver.get(Util.BASE_URL_ADMIN);
	  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
  }
  
  @Test
  public void verifyInvoiceCanBePrinted() throws Exception {
	  	  objBackendPage = new BackendPage(driver);
	  	  
	      // enter username, password and login
		  log.debug("enter username, password and login");
		  objBackendPage.enterUsername(Util.ADMIN_USER);
		  objBackendPage.enterPassword(Util.ADMIN_PASS);
		  objBackendPage.clickOnLogin();
		  	  
		  objBackendPage.closeIncomingPu();
		  
		  // switch main windows
		  log.debug("switch main windows");
		  for(String handle : driver.getWindowHandles()) {
			  driver.switchTo().window(handle);
		  }

		  // click on Orders menu
		  log.debug("click on Orders menu");
		  objBackendPage.clickOnSalesMenu();
		  objBackendPage.clickOnOrdersMenu();
		  
		  // choose status Canceled
		  log.debug("choose status Canceled");
		  objBackendPage.selectCanceledStatus();
		  objBackendPage.clickOnSearch();
		  Thread.sleep(5000);
		  // choose the first item
		  log.debug("choose the first item");
		  objBackendPage.selectFirstItem();
		  // print invoice
		  log.debug("print invoice");
		  objBackendPage.selectPrintInvoice();
		  objBackendPage.clickOnSubmit();
		  Thread.sleep(5000);
		  // verify error message
		  String actualErrorMessage = objBackendPage.getErrorMessage();
		  try {
			  assertEquals(actualErrorMessage, objBackendPage.EXPECTED_ERROR_MESSAGE);
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  
		  // select complete
		  log.debug("select complete");
		  objBackendPage.selectCompleteStatus();
		  objBackendPage.clickOnSearch();
		  Thread.sleep(5000);
		  // choose the first item
		  log.debug("choose the first item");
		  objBackendPage.selectFirstItem();
		  
		  // print invoice
		  log.debug("print invoice");
		  objBackendPage.selectPrintInvoice();
		  objBackendPage.clickOnSubmit();
		  Thread.sleep(15000);
		  
		  // verify file downloaded

  }
  
  @AfterTest
  public void closingWebsite() throws Exception {
	  Thread.sleep(3000);
	  log.debug("closing website");
	  driver.close();
  }
}
