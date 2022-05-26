package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.HomeInsuranceJourneyPage;
import pageObjects.HomeInsurancePage;
import pageObjects.LloydsHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class GetHomeInsuranceQuote extends base {
	LloydsHomePage lhp;
	HomeInsurancePage hip;
	HomeInsuranceJourneyPage hijp;
	public WebDriver driver;

	public String emailAddress;

	
	@Given("Initialize the browser for Lloyds Website")
	public void initialize_the_browser_for_lloyds_website() throws IOException {
		driver = initializeDriver();
	}
	@Given("^Navigate to (.+) Lloyds Website$")
	public void navigate_to_https_www_amazon_co_uk_lloyds_website(String url) {
		navigateURL(driver,url);

	}
	@Given("MouseOver on Products and services menu in Lloyds Home Page")
	public void mouse_over_on_products_and_services_menu_in_lloyds_home_page() {
		lhp = new LloydsHomePage(driver);
		mouseOver(driver, lhp.productServicesMenu());

	}
	
	@When("Click on Home Insurance sub-menu")
	public void click_on_home_insurance_sub_menu() {
	   clickElement(lhp.homeInsuranceSubMenu());
	}
	
	@When("Click on a Get a quote now link")
	public void click_on_a_get_a_quote_now_link() {
		
		hip = lhp.getQuote();
	}
	@Then("^User landed on Home Insurance Page with Page Title (.+)$")
	public void user_landed_on_home_insurance_page(String title) {
		
		if(isElementClickable(driver, hip.cookiesContentPopup()))
			clickElement(hip.cookiesContentPopup());
		verifyTitle(driver, title);
	}
	
	@Then("User clicks on Get a quote button")
	public void user_clicks_on_get_a_quote_button() {
		hijp = hip.getQuote();
	}
	@Then("User lands on Home Insurance Journey Page")
	public void user_lands_on_home_insurance_journey_page() {
		verifyElementPresent(driver,hijp.buildingAndContents());

	}
	@Then("User clicks on Buildings and Contents Options")
	public void user_clicks_on_buildings_and_contents_options() {
	
		clickElement(hijp.buildingAndContents());
	}
	
	@Then("^User Enter Post Code (.+)$")
	public void user_enter_post_code(String postCode) {
	  enterText(hijp.postCode(), postCode);
	
	}
	@Then("Click on Find Address")
	public void click_on_find_address() {
	    clickElement(hijp.findAddress());
	}
	
	@Then("close the browser for Lloyds Website")
	public void close_the_browser_for_lloyds_website() {
		
		closeDriver(driver);
	}



}