package automation.pages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.Page;

public class LoginOffice365Page {

	private Page ui;
	public LoginOffice365Page_selectors selectors;
	
	public LoginOffice365Page(Page p) {
	        ui = p;
	        selectors = new LoginOffice365Page_selectors();
	}
	
	public void waitForPageLoad() {
		ui.waitForVisible(selectors.emailInput);
	}
}

class LoginOffice365Page_selectors {
	public final By emailInput = By.xpath("//input[@type='email']");
}

