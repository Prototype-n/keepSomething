package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.pages.CreateNewOffice365Connector;
import automation.pages.LogInPage;
import automation.pages.LoginOffice365Page;
import automation.pages.MainPage;

public class Page {

	private int timeOut = 10;
	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public Page(WebDriver driver) {
		this.driver = driver;

		// Create wait object for all pages.
		wait = new WebDriverWait(this.driver, timeOut, 200);
	}

	
	private CreateNewOffice365Connector _createNewOffice365Connector;
	private LogInPage _loginPage;
	private LoginOffice365Page _loginOffice365Page;
	private MainPage _mainPage;
	
	//App pages
	public CreateNewOffice365Connector createNewOffice365Connector() {
		return _createNewOffice365Connector == null ? _createNewOffice365Connector = new CreateNewOffice365Connector(this) : _createNewOffice365Connector;
	}
	
	public LogInPage loginPage() {
		return _loginPage == null ? _loginPage = new LogInPage(this) : _loginPage;
	}
	
	public LoginOffice365Page loginOffice365Page() {
		return _loginOffice365Page == null ? _loginOffice365Page = new LoginOffice365Page(this) : _loginOffice365Page;
	}

	public MainPage mainPage() {
		return _mainPage == null ? _mainPage = new MainPage(this) : _mainPage;
	}

	
	// Open URL
	public void open(String url) {
		driver.get(url);
	}

	// Clicks by selector
	public void click(By selector) {
		driver.findElement(selector).click();
	}

	// Write Text to element via Selector
	public void typeText(By selector, String text) {
		driver.findElement(selector).sendKeys(text);
	}

	//Waits for element visible
	public void waitForVisible(By selector) {
		wait.until(ExpectedConditions.presenceOfElementLocated(selector));
	}

	//Works with shadow DOM elements
	public WebElement getShadowElement(WebElement el) {
		WebElement shadow_root = (WebElement) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].shadowRoot", el);
		return shadow_root;
	}
}
