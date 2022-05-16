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
import pageObjects.AmazonLandingPage;
import pageObjects.AmazonLoginPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

@RunWith(Cucumber.class)
public class amazonLogin extends base {
	LoginPage lp;
	public WebDriver driver;
	AmazonLandingPage amazonLandingPage;
	AmazonLoginPage alp;
	public String emailAddress;


	@Given("Initialize the browser with chrome for Amazon Website")
	public void initialize_the_browser_with_chrome() throws IOException {

		driver = initializeDriver();
	}

	@Given("Navigate to {string} Amazon Website")
	public void navigate_to_site(String url) {
		driver.get(url);
	}


    @And("^close the browser for Amazon Website$")
    public void close_the_browser() throws Throwable {
    	driver.close();
    }

	@Given("MouseOver on sign link in home page to the signin links")
	public void mouse_over_on_sign_link_in_home_page_to_the_signin_links() {
		amazonLandingPage = new AmazonLandingPage(driver);
		mouseOver(driver,amazonLandingPage.signinLink());
	}
	@When("Click on sigin links")
	public void click_on_sigin_links() {
	alp = amazonLandingPage.signinButton();
	}

	@Then("verify that user is navigated to Sign-in Page")
	public void verify_that_user_is_navigated_to_sign_in_page() {
		Assert.assertEquals(true,alp.email().isDisplayed());
	}
	
	@When("^User enters emailID (.+)$")
	public void user_enters_email_id_email(String email) {
		emailAddress=email;
		if(!email.equalsIgnoreCase("blank"))
		alp.email().sendKeys(email);
		
		
	}
	
	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		alp.continueButton().click();
	}
	
	@When("^User enters password (.+)$")
	public void user_enters_password(String password) {
		alp.password().sendKeys(password);
		
	}
	
	@When("User clicks on Sign-In button")
	public void user_clicks_on_sign_in_button() {
		alp.signInSubmit().click();
	}
	
	@Then("Sign-In screen will be still there")
	public void SignIn_screen_will_be_still_there() {
		Assert.assertTrue(alp.signInSubmit().isDisplayed());
	}
	
	@When("verify the error message {string} for {string}")
	public void verify_the_error_message_for_invalid_inputs(String message,String input) {
		
		if(input.equalsIgnoreCase("INVALID_EMAIL"))
			Assert.assertEquals(message, alp.invalidEmailAddress().getText());
		else if(input.equalsIgnoreCase("BLANK_EMAIL"))		
			Assert.assertEquals(message, alp.emailIDMissing().getText());

		
		
		
	}



}