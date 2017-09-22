package test_drcom_hub1.LiveEcommerce.git;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class testTestCase10 {
  WebDriver driver;
  BackendPage objBackendPage;
  Logger log;

  @BeforeTest
  public void openningWebsite() throws Exception {
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
  public void verifyExportOrders() throws Exception {
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

	  
	  // Export CSV
	  log.debug("Export CSV");
	  objBackendPage.selectCSV();
	  objBackendPage.clickOnExport();
	  Thread.sleep(10000);
	  
	  // Send email
	  log.debug("Send email");
	  String filePath = System.getProperty("user.home") + "/Downloads/orders.csv";
	  try {
		  Util.emailUtil(filePath);
	  } catch (MessagingException el) {
		  el.printStackTrace();
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  /*
		// 5. Read downloaded file and display the Heading and all the Order details in the console windows
		log.debug("Read downloaded file and display the Heading and all the Order details in the console windows");
	    File f = new File(filePath);

		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null){
				System.out.println(line);
				line = br.readLine();
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
  }
  
  @AfterTest
  public void closingWebsite() throws Exception {
	  Thread.sleep(3000);
	  log.debug("closing website");
	  driver.close();
  }
}
