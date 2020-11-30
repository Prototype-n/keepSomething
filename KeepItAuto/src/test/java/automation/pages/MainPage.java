package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import automation.Page;
import automation.pages.enums.ConectionOptions;

public class MainPage {

	private Page ui;
	public MainPage_selectors selectors;
	
	public MainPage(Page p) {
	        ui = p;
	        selectors = new MainPage_selectors();
	}
	
	public void collapseBaner() {
		WebElement visiblePart = ui.driver.findElement(selectors.visiblePartToCollapse);
		WebElement shadow_root = ui.getShadowElement(visiblePart);
        WebElement root3 = shadow_root.findElement(selectors.collapseIcon);
        root3.click();
	}
	
	public void openAddConnectionMenu() {
		ui.click(selectors.addConnectionLink);
	}
	
	public void selectAddConnectionOption(ConectionOptions option) {
		switch (option) {
		case OFFICE_365_ADMIN:
			ui.click(selectors.office365AdminOption);
			break;
		default:
			throw new IllegalArgumentException(String.format("Option %s couldn't be clicked", option));
		}
	}
}

class MainPage_selectors {
	public final By addConnectionLink = By.id("cloud-devices-button");
	public final By collapseIcon = By.cssSelector("div.close-btn");
	public final By office365AdminOption = By.cssSelector("#o365_admin");
	public final By visiblePartToCollapse = By.xpath("//keepit-banner-container");
	
}