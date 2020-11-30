package automation.pages;

import org.openqa.selenium.By;
import automation.Page;

public class LogInPage {
	
	private Page ui;
	public LogInPage_selectors selectors;
	
	public LogInPage(Page p) {
	        ui = p;
	        selectors = new LogInPage_selectors();
	}
	
	public void SignIn(String user, String password) {
		ui.typeText(selectors.loginInput, user);
		ui.typeText(selectors.loginPassword, password);
		clickSighIn();
	}
	
	public void clickSighIn () {
		ui.click(selectors.signInButton);
	}
}

class LogInPage_selectors {
	public final By loginInput = By.xpath("//*[@id='login-form-login']");
	public final By loginPassword = By.xpath("//*[@id='login-form-password']");
	public final By signInButton = By.xpath("//*[@id='login-form-login-button']");
}
