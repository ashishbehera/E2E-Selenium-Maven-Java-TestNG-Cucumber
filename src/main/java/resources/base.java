package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//import org.testng.Assert;

import javax.swing.*;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;

	public WebDriver initializeDriver() throws IOException {
		String path = System.getProperty("user.dir") + "//src//main//java//resources//data.properties";
		prop = new Properties();
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		//String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser");
		System.out.println("browserName" + browserName);

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver//chromedriver");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless"))
				options.addArguments("headless");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//driver//geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 20);
		return driver;

	}

	public void closeDriver(WebDriver driver) {

		driver.close();
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String time = timestamp.toString();
		String destFile = System.getProperty("user.dir") + "//Screenshots//" + testCaseName + "_" + time + ".png";
		FileUtils.copyFile(source, new File(destFile));

		return destFile;

	}

	public String getParentWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public void navigateURL(WebDriver driver, String url) {
		driver.get(prop.getProperty(url));
	}

	public void switchChildWindow(WebDriver driver, String parentWindowHandle, String productName) {

		Set<String> windowHandles = driver.getWindowHandles();
		java.util.Iterator<String> itr = windowHandles.iterator();

		while (itr.hasNext()) {
			String winhanldle = itr.next();
			if (!winhanldle.equalsIgnoreCase(parentWindowHandle)) {
				driver.switchTo().window(winhanldle);
				if (driver.getCurrentUrl().contains(prop.getProperty(productName)))
					break;

			}
		}

	}

	public void switchParentWindow(WebDriver driver, String parentWindowHandle) {
		driver.switchTo().window(parentWindowHandle);

	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public void verifyTitle(WebDriver driver, String title) {
		String actualTitle = getTitle(driver);
		String expectedTitle = prop.getProperty(title);
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong page title");

	}

	public String getProductCSS(String productText) {
		String cssText = prop.getProperty(productText);
		String productCSSValue = "a[href*='" + cssText + "']";
		return productCSSValue;

	}

	public void mouseOver(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void clickElement(WebElement element) {
		element.click();

	}

	public boolean isElementClickable(WebDriver driver, WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element.isEnabled();

	}

	public void verifyElementPresent(WebDriver driver, WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Assert.assertEquals(true, element.isDisplayed());
	}
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);

	}


}
