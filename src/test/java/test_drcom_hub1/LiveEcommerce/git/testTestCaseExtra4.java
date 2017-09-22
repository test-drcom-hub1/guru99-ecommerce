package test_drcom_hub1.LiveEcommerce.git;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class testTestCaseExtra4 {
  WebDriver driver;
  Logger log;
  AdvancedSearch objAdvSearchPage;
  HomePage objHomePage;
	
  @BeforeTest
  public void openingWebsite() throws Exception {
	  // set logger
	  log = Logger.getLogger("devpinoyLogger");
	  
	  // set driver for chrome browser
	  System.setProperty(Util.CHROME_DRIVER_CORE, Util.CHROME_DRIVER_PATH);
	  driver = new ChromeDriver();  
	  
	  // opening website
	  log.debug("opening website");
	  driver.get(Util.BASE_URL);
	  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
  }
  
  @Test
  public void verifyAdvancedSearch() throws Exception {
	  objHomePage = new HomePage(driver);
	  objAdvSearchPage = new AdvancedSearch(driver);
	  
	  // click on Advanced Search link
	  log.debug("click on Advanced Search link");
	  objHomePage.clickOnAdvancedSearch();
	  Thread.sleep(3000);
	  
	  // Search value Price from 151 to 1000
	  log.debug("Search value Price from 151 to 1000");
	  objAdvSearchPage.enterValuePriceFrom("151");
	  objAdvSearchPage.enterCaluePriceTo("1000");
	  objAdvSearchPage.clickOnSearch();
	  Thread.sleep(5000);
	  
	  // verify print console all product name and price
	  log.debug("verify print console all product name and price");
	  List<WebElement> lstWeProductName = objAdvSearchPage.getListOfProductName();
	  List<WebElement> lstWeProductPrice = objAdvSearchPage.getListOfProductPrice();
	  
	  System.out.println("Search value Price from 151 to 1000:");
	  try {
		  for(WebElement we:lstWeProductName) {
			  System.out.println("Product: " + we.getText());
		  }  
	  } catch (Exception e) {
		  System.out.println("verify print console all product name and price: FAILED");
		  e.printStackTrace();
	  }
	  System.out.println("-------------------------");
	  try {
		  for(WebElement we:lstWeProductPrice) {
			  System.out.println("Price: " + we.getText());
		  }  
	  } catch (Exception e) {
		  System.out.println("verify print console all product name and price: FAILED");
		  e.printStackTrace();
	  }
	  System.out.println();
	  System.out.println("verify print console all product name and price: PASSED");
	  log.debug("verify print console all product name and price: PASSED");
  }
  
  @AfterTest
  public void closingWebsite() throws Exception {
	  // closing website
	  log.debug("closing website");
	  driver.close();
  }
}
