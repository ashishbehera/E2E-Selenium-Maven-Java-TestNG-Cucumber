package stepDefinitions_old;

import java.io.IOException;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.junit.Cucumber;
import org.testng.Assert;
import pageObjectsOld.AmazonLandingPage;
import pageObjectsOld.AmazonLoginPage;
import pageObjectsOld.LandingPage;
import pageObjectsOld.LoginPage;
import resources.base;

@RunWith(Cucumber.class)
public class qaClickAcademy extends base {
	LoginPage lp;
	public WebDriver driver;
	AmazonLandingPage amazonLandingPage;
	AmazonLoginPage alp;


	@Given("^Browser is open$")
	    public void browser_is_open() throws Throwable {
	        System.out.println("Browser is open");
	    }

	    @When("^navigate to link$")
	    public void navigate_to_link() throws Throwable {
	        System.out.println("navigate to link");  
	    }

	    @Then("^validate the link$")
	    public void validate_the_link() throws Throwable {
	    	System.out.println("validate the link");
	        
	    }

	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {

		driver = initializeDriver();
	}

	@Given("Navigate to {string} Site")
	public void navigate_to_site(String url) {
		driver.get(url);
	}

	@Given("Click on login link in home page to land on Secure sign in Page")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page(DataTable data ) {
		List<List<String>> obj = data.asLists();
		System.out.println(obj.get(0).get(0));
		LandingPage landPageObjects = new LandingPage(driver);
		if(landPageObjects.getPopupSize().size() > 0)
		{
			landPageObjects.getPopup().click();
		}
		lp = landPageObjects.getLogin();
	}

    @When("^User enters (.+) and Password (.+)$")
    public void user_enters_and_password(String username, String password) throws Throwable {
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
	}

    @Then("^verify that user is successful logged in (.+)$")
    public void verify_that_user_is_successful_logged_in_something(String strArg1) throws Throwable {
        System.out.println("Login Status: "+strArg1);
    }
	
    @And("^close the browser$")
    public void close_the_browser() throws Throwable {
    	driver.close();
    }

}