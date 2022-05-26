package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeInsurancePage {

	public WebDriver driver;

	public HomeInsurancePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="accept")
	private WebElement cookiesContentPopup;
	
	
	@FindBy(xpath="//button[@title='Get a home insurance quote >']")
	private WebElement getQuote;
	
	
	public WebElement cookiesContentPopup() {
		return cookiesContentPopup;
	}
	
	public HomeInsuranceJourneyPage getQuote() {
		getQuote.click();
		HomeInsuranceJourneyPage hijp = new  HomeInsuranceJourneyPage(driver);
		return hijp;

	}

}
