package pageObjectsOld;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {

	public WebDriver driver;

	public AmazonLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(id="continue")
	private WebElement continueButton;
	
	@FindBy(name="password")
	private WebElement password;
	
	
	@FindBy(id="signInSubmit")
	private WebElement signInSubmit;

	@FindBy(xpath="//*[@id='auth-email-missing-alert']/div/div")
	private WebElement emailIDMissing;

	@FindBy(xpath="//*[@id='auth-error-message-box']/div/div/ul/li/span")
	private WebElement invalidEmailAddress;
	
	
	public WebElement email () {
		return email;
		
	}
	
	public WebElement continueButton() {
		return continueButton;
				
	}
	
	public WebElement password() {
		return password;
		
	}
	
	public WebElement signInSubmit() {
		return signInSubmit;
		
	}
	
  public WebElement emailIDMissing() {
	return emailIDMissing;
	  
  }

	public WebElement invalidEmailAddress() {
		return invalidEmailAddress;

	}
	
	
	
	
	
	
	

	
	
	
}
