package test_drcom_hub1.LiveEcommerce.git;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class testTestCaseExtra2 {
	Logger log;
	WebDriver driver;
	ProductDetail objProductDetail;
	BackendPage objBackendPage;

  @BeforeTest
  public void openingWebsite() throws Exception {
	  // set logger
	  log = Logger.getLogger("devpinoyLogger");
	  
	  // set driver for chrome browser
	  System.setProperty(Util.CHROME_DRIVER_CORE, Util.CHROME_DRIVER_PATH);
	  driver = new ChromeDriver();
	  // go to the website
	  log.debug("go to the website");
	  driver.manage().window().maximize();
	  driver.get(Util.BASE_URL);
	  Thread.sleep(3000);
	  driver.manage().timeouts().implicitlyWait(Util.myTimeOut, TimeUnit.SECONDS);
  }
	
  @Test
  public void verifyReviewMechanism() throws Exception {
	  objProductDetail = new ProductDetail(driver);
	  objBackendPage = new BackendPage(driver);
	  
	  // redirect to xperia product page
	  log.debug("redirect to xperia product page");
	  driver.navigate().to("http://live.guru99.com/index.php/review/product/list/id/1/");
	  
	  // sumit the review
	  String letUsKnow = "very good 3";
	  String summaryReview = "very good summary 3";
	  String nickName = "baby girl 3";
	  
	  log.debug("sumit the review");
	  objProductDetail.enterLetUsKnow(letUsKnow);
	  objProductDetail.enterSummaryReview(summaryReview);
	  objProductDetail.enterNickname(nickName);
	  objProductDetail.clickOnSubmitReview();
	  Thread.sleep(3000);
	  
	  // redirect and login to backend page
	  log.debug("redirect and login to backend page");
	  driver.navigate().to(Util.BASE_URL_ADMIN);
	  Thread.sleep(2000);
	  objBackendPage.enterUsername(Util.ADMIN_USER);
	  objBackendPage.enterPassword(Util.ADMIN_PASS);
	  objBackendPage.clickOnLogin();
	  Thread.sleep(5000);
	  
	  // closing incomming popup
	  log.debug("closing incomming popup");
	  objBackendPage.closeIncomingPu();
	  
	  // switch to main window
	  log.debug("switch to main window");
	  for(String handle : driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }
	  Thread.sleep(2000);
	  
	  // click on pending review link
	  log.debug("click on pending review link");
	  objBackendPage.clilckOnCatalog();
	  objBackendPage.clickOnReivewAndRating();
	  objBackendPage.clickOnCustomerReview();
	  objBackendPage.clickOnPendingReview();
	  Thread.sleep(5000);
	  
	  // click on edit link of the first item review
	  log.debug("click on edit link of the first item review");
	  objBackendPage.clickOnEditFirstItemReview();
	  Thread.sleep(2000);
	  
	  // choose approved status
	  log.debug("choose approved status");
	  objBackendPage.sellectApproved();
	  
	  // save review
	  log.debug("save review");
	  objBackendPage.clickOnSaveReview();
	  Thread.sleep(2000);
	  
	  // redirect to product page
	  log.debug("redirect to product page");
	  driver.navigate().to("http://live.guru99.com/index.php/review/product/list/id/1/");
	  Thread.sleep(5000);
	  
	  // get the lastest review
	  log.debug("get the lastest review");
	  String actualLastestReview = objProductDetail.getLastestReview();
	  
	  // verify the review is approved
	  log.debug("verify the review is approved");
	  if(actualLastestReview.contains(letUsKnow)) {
		  System.out.println("My review has been approved");
		  log.debug("PASSED");
		  System.out.println("verify the review is approved: PASSED");
	  } else {
		  System.out.println("My review don't approve");
		  log.debug("FAILED");
		  System.out.println("verify the review is approved: FAILED");
	  }
  }
  
  @AfterTest
  public void closingWebsite() throws Exception {
	  Thread.sleep(3000);
	  // closing website
	  log.debug("closing website");
	  driver.close();
  }
}
