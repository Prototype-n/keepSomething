package automation;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import automation.utils.Helper;
import automation.utils.WebDriverFactory;

public class BaseTest {

	private final static int SECONDSTOWAIT = 10;
	public WebDriver driver;
	public Page ui;
	public String baseURL = Helper.readProperty("baseUrl"); 
	
	@BeforeClass
	public void setUp() throws MalformedURLException{

		// Create a Chrome driver. All test classes use this.
		//driver = new ChromeDriver();
		driver = WebDriverFactory.GetDriver(Helper.readProperty("browser"));
		
		driver.manage().timeouts().implicitlyWait(SECONDSTOWAIT, TimeUnit.SECONDS);

		// Maximize Window
		driver.manage().window().maximize();

		// Instantiate the Page Class
		ui = new Page(driver);
	}
	
	@AfterClass
	public void tearDown()  {
		driver.quit();
	}
}
