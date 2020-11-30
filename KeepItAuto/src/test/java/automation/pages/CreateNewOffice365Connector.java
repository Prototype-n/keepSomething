package automation.pages;

import org.openqa.selenium.By;
import automation.Page;

public class CreateNewOffice365Connector {

	private Page ui;
	public CreateNewOffice365Connector_selectors selectors;
	
	public CreateNewOffice365Connector(Page p) {
	        ui = p;
	        selectors = new CreateNewOffice365Connector_selectors();
	}
	
	public void typeConectorName(String name) {
		ui.typeText(selectors.nameInput, name);
	}
	
	public void clickNext() {
		ui.click(selectors.nextButton);
	}
}

	class CreateNewOffice365Connector_selectors {
		public final By nextButton = By.cssSelector("div[role='dialog'][aria-hidden='false'] .btn-success:not(.disabled-btn-success)");
		public final By nameInput = By.xpath("//input[@id='name']");
	}