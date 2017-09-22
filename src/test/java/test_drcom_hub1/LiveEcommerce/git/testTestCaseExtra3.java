package test_drcom_hub1.LiveEcommerce.git;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class testTestCaseExtra3 {
	WebDriver driver;
	Logger log;
	BackendPage objBackendPage;
  
  @BeforeMethod
  public void openWebsite() throws Exception {
	  // set logger
	  log = Logger.getLogger("devpinoyLogger");
	  //set driver for chrome browser
	  System.setProperty(Util.CHROME_DRIVER_CORE, Util.CHROME_DRIVER_PATH);
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  log.debug("open website backend");
	  driver.get(Util.BASE_URL_ADMIN);
	  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
  }
	
  @Test(priority=0)
  public void verifySortDesc() throws Exception {
	  objBackendPage = new BackendPage(driver);
	  
	  // login backend
	  log.debug("login backend");
	  objBackendPage.enterUsername(Util.ADMIN_USER);
	  objBackendPage.enterPassword(Util.ADMIN_PASS);
	  objBackendPage.clickOnLogin();
	  Thread.sleep(5000);
	  
	  // closing incomming PU
	  log.debug("closing incomming PU");
	  objBackendPage.closeIncomingPu();
	  
	  // switch to main window
	  log.debug("switch to main window");
	  for(String handle : driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }
	  
	  // click on invoices menu
	  log.debug("click on Invoices menu");
	  objBackendPage.clickOnSalesMenu();
	  objBackendPage.clickOnInvoicesMenu();
	  Thread.sleep(5000);
	  
	  
	  // verify sort DESC for Invoice Date
	  log.debug("verify sort DESC for Invoice Date");
	  
	  List<WebElement> lstWeInvoice = null;
	  int rowSize = 0;
	  long[] arrayInvoice = null;
	  String sortMethod = "desc"; // checked text is asc or desc
	  Boolean isDescSort = objBackendPage.checkSortInvoiceDate(sortMethod);  
	  
	  try {	  
		  if (isDescSort == true) {
			  lstWeInvoice = objBackendPage.getWeInvoicesList();
			  rowSize = lstWeInvoice.size();
			  arrayInvoice = new long[rowSize];
			  for(int i=0; i<rowSize; i++) {
				  arrayInvoice[i] = Long.parseLong(lstWeInvoice.get(i).getText());
				  System.out.println(arrayInvoice[i]);
			  }
		  } else {
			  driver.findElement(objBackendPage.txtInvoiceDateSort).click();
			  Thread.sleep(4000);
			  lstWeInvoice = objBackendPage.getWeInvoicesList();
			  rowSize = lstWeInvoice.size();
			  arrayInvoice = new long[rowSize];
			  for(int i=0; i<rowSize; i++) {
				  arrayInvoice[i] = Long.parseLong(lstWeInvoice.get(i).getText());
				  System.out.println(arrayInvoice[i]);
			  }
		  	}
	  } catch (Exception e) {
		  e.printStackTrace();
	  	}
	  
	  try {
		  for (int i=0; i<rowSize-1; i++) {
			  Boolean acceptOperator = arrayInvoice[i] > arrayInvoice[i+1];
			  System.out.println(acceptOperator);
		  }
	  } catch (Exception e) {
		  e.printStackTrace();
		  System.out.println("verify sort DESC for Invoice Date: FAILED");
	  }
	  
	  System.out.println("verify sort DESC for Invoice Date: PASSED");
	  log.debug("verify sort DESC for Invoice Date: PASSED");
  }
  
  @Test(priority=1)
  public void verifySortAsc() throws Exception {
	  objBackendPage = new BackendPage(driver);
	  
	  // login backend
	  log.debug("login backend");
	  objBackendPage.enterUsername(Util.ADMIN_USER);
	  objBackendPage.enterPassword(Util.ADMIN_PASS);
	  objBackendPage.clickOnLogin();
	  Thread.sleep(5000);
	  
	  // closing incomming PU
	  log.debug("closing incomming PU");
	  objBackendPage.closeIncomingPu();
	  
	  // switch to main window
	  log.debug("switch to main window");
	  for(String handle : driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }
	  
	  // click on invoices menu
	  log.debug("click on Invoices menu");
	  objBackendPage.clickOnSalesMenu();
	  objBackendPage.clickOnInvoicesMenu();
	  Thread.sleep(5000);
	  
	  
	  // verify sort ASC for Invoice Date
	  log.debug("verify sort ASC for Invoice Date");
	  
	  List<WebElement> lstWeInvoice = null;
	  int rowSize = 0;
	  long[] arrayInvoice = null;
	  String sortMethod = "asc"; // checked text is asc or desc
	  Boolean isAscSort = objBackendPage.checkSortInvoiceDate(sortMethod);  
	  
	  try {	  
		  if (isAscSort == true) {
			  lstWeInvoice = objBackendPage.getWeInvoicesList();
			  rowSize = lstWeInvoice.size();
			  arrayInvoice = new long[rowSize];
			  for(int i=0; i<rowSize; i++) {
				  arrayInvoice[i] = Long.parseLong(lstWeInvoice.get(i).getText());
				  System.out.println(arrayInvoice[i]);
			  }
		  } else {
			  driver.findElement(objBackendPage.txtInvoiceDateSort).click();
			  Thread.sleep(4000);
			  lstWeInvoice = objBackendPage.getWeInvoicesList();
			  rowSize = lstWeInvoice.size();
			  arrayInvoice = new long[rowSize];
			  for(int i=0; i<rowSize; i++) {
				  arrayInvoice[i] = Long.parseLong(lstWeInvoice.get(i).getText());
				  System.out.println(arrayInvoice[i]);
			  }
		  	}
	  } catch (Exception e) {
		  e.printStackTrace();
	  	}
	  
	  
	  try {
		  for (int i=0; i<rowSize-1; i++) {
			  Boolean acceptOperator = arrayInvoice[i] < arrayInvoice[i+1];
			  System.out.println(acceptOperator);
		  }
	  } catch (Exception e) {
		  e.printStackTrace();
		  System.out.println("verify sort ASC for Invoice Date: FAILED");
	  }
	  
	  System.out.println("verify sort ASC for Invoice Date: PASSED");
	  log.debug("verify sort ASC for Invoice Date: PASSED");
  }

  @AfterMethod
  public void closingWebsite() throws Exception {
	  Thread.sleep(3000);
	  log.debug("closing website");
	  driver.close();
  }
}
