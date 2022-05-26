package pratice;

import org.testng.annotations.Test;

import pageObjects.HomeInsuranceJourneyPage;
import pageObjects.HomeInsurancePage;
import pageObjects.LloydsHomePage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectsOld.ForgotPassword;
import pageObjectsOld.LandingPage;
import pageObjectsOld.LoginPage;
import pageObjectsOld.LandingPage;
import resources.base;

@Test
public class GetHomeInsuranceQuote extends base {
	public static Logger log =  LogManager.getLogger(GetHomeInsuranceQuote.class.getName());
	public WebDriver driver;
	LloydsHomePage lhp;
	HomeInsurancePage hip;
	HomeInsuranceJourneyPage hijp;

	
	@BeforeTest
	 public void initialize() throws IOException {
		driver = this.initializeDriver();
		
	}

	@Test
	public void basePageNavigation() throws IOException {
		navigateURL(driver,"urlLloyds");
		lhp = new LloydsHomePage(driver);
		mouseOver(driver, lhp.productServicesMenu());
		clickElement(lhp.homeInsuranceSubMenu());
		hip = lhp.getQuote();
		log.info("Landed to Home Insurance Page");
		
		if(isElementClickable(driver, hip.cookiesContentPopup()))
			clickElement(hip.cookiesContentPopup());
		verifyTitle(driver, "homeInsuranceTitle");
		hijp = hip.getQuote();
		verifyElementPresent(driver,hijp.buildingAndContents());
		clickElement(hijp.buildingAndContents());
		enterText(hijp.postCode(), prop.getProperty("postCode"));
	    clickElement(hijp.findAddress());

	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	
	

}
