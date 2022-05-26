package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LloydsHomePage {

	public WebDriver driver;

	public LloydsHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="submenu-btn")
	private WebElement productServicesMenu;
	
	@FindBy(xpath="//span[text()='Home insurance']")
	private WebElement homeInsuranceSubMenu;
	
	@FindBy(xpath="//span[text()='Get your quote now']")
	private WebElement getQuote;




	public HomeInsurancePage getQuote( ) {
		getQuote.click();
		HomeInsurancePage hip = new  HomeInsurancePage(driver);
		return hip;

	}

	public WebElement productServicesMenu () {
		return productServicesMenu;

	}
	
	public WebElement homeInsuranceSubMenu () {
		return homeInsuranceSubMenu;

	}
	
	




}
