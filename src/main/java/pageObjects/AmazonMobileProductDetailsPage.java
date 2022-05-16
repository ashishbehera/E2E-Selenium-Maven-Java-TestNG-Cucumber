package pageObjects;

import java.util.List;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMobileProductDetailsPage {

	public WebDriver driver;
	public WebDriverWait wait;
	Actions action;
	String parentWindow;


	public AmazonMobileProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,20);
		action = new Actions(driver);
	}
	
	@FindBy(name = "submit.add-to-cart")
	private WebElement addToCart;
	
	@FindBy(id="attach-view-cart-button-form")
	private WebElement cart;
	
	public WebElement addToCart() {
		return addToCart;
	}
	
	public WebElement cart() {
		return cart;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
