package automation.tests.ui;

import org.testng.annotations.Test;
import automation.BaseTest;
import automation.pages.enums.ConectionOptions;

public class ConnectorTest extends BaseTest{

	private String user = "automation@keepitqa.com";
	private String password = "E#*b2wGIbFHz";
	//private String url = "https://ws-test.keepit.com/signin.html";
	private String connectorName = "Test text";
	
	@Test
	public void addConnectorTest() {
		
		ui.open(baseURL);
		ui.loginPage().SignIn(user, password);
		
		ui.mainPage().collapseBaner();
		ui.mainPage().openAddConnectionMenu();
		ui.mainPage().selectAddConnectionOption(ConectionOptions.OFFICE_365_ADMIN);
		
		//Type in Dialog
		ui.createNewOffice365Connector().typeConectorName(connectorName);
		
		//Click Next
		ui.createNewOffice365Connector().clickNext();
		
		//Wait for new page
		ui.loginOffice365Page().waitForPageLoad();
	}
}
