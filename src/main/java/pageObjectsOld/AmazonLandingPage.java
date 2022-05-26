package pageObjectsOld;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLandingPage {

	public WebDriver driver;
	String productCSSValue;

	public AmazonLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="nav-link-accountList")
	private WebElement signinLink;

	@FindBy(className = "nav-action-inner")
	private WebElement signinButton;

	@FindBy(css="a[href*='mobile-phones']")
	private WebElement mobilePhoneMenu;

	public WebElement signinLink() {
		return signinLink;

	}

	public AmazonLoginPage signinButton( ) {
		signinButton.click();
		AmazonLoginPage alp = new  AmazonLoginPage(driver);
		return alp;

	}

	public WebElement mobilePhoneMenu () {
		return mobilePhoneMenu;

	}



}
