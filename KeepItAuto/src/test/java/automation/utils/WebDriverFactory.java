package automation.utils;

import java.net.MalformedURLException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

	public static WebDriver GetDriver(String browser) throws MalformedURLException {
		switch (browser.toLowerCase()) {

		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-notifications");
			return new ChromeDriver(chromeOptions);
		case "firefox":
			FirefoxOptions ffOptions = new FirefoxOptions();
			return new FirefoxDriver(ffOptions);
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			return new EdgeDriver(edgeOptions);
		default:
			throw new InvalidArgumentException("Add valid parameters 'Browser'.");

		}
	}
}
