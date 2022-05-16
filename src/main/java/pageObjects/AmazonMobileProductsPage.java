 package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

public class AmazonMobileProductsPage {

	public WebDriver driver;
	public WebDriverWait wait;
	Actions action;
	String productCSSValue;


	public AmazonMobileProductsPage(WebDriver driver,String productCSSValue) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,20);
		action = new Actions(driver);
		this.productCSSValue = productCSSValue;
	}
	
	
	@FindBy(xpath="//span[text()='Samsung']")
	private WebElement selectMobileBrand;
	
	
	
	@FindBy(name = "submit.add-to-cart")
	private WebElement addToCart;
	
	@FindBy(id="attach-view-cart-button-form")
	private WebElement cart;
	
	@FindBy(xpath="//span[text()='₹10,000 - ₹20,000']")
	private WebElement priceRange;
	
	@FindBy(xpath="//span[text()='10% Off or more']")
	private WebElement discounts;
	
	public WebElement selectMobileBrand() {
		return selectMobileBrand;
		
	}
	
	public AmazonMobileProductDetailsPage product() {
		driver.findElement(By.cssSelector(productCSSValue)).click();
		 AmazonMobileProductDetailsPage mobileProducDetails = new AmazonMobileProductDetailsPage(driver);
		 return mobileProducDetails;	
	}
	
	public WebElement priceRange() {
		return priceRange;
		
	}
	
	public WebElement discounts() {
		return discounts;
		
	}
	
	

}
	