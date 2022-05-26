package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeInsuranceJourneyPage {

	public WebDriver driver;

	public HomeInsuranceJourneyPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[text()='Buildings and Contents']")
	private WebElement buildingAndContents;
	
	@FindBy(id="RiskAddress.PostCode")
	private WebElement postCode;
	
	@FindBy(xpath="//button[text()='Find address']")
	private WebElement findAddress;
	
	public WebElement buildingAndContents() {
		return buildingAndContents;
	}
	
	public WebElement postCode() {
		return postCode;
	}
	
	public WebElement findAddress() {
		return findAddress;
	}

	
}
