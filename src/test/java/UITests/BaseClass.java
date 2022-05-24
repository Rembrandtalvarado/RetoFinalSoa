package UITests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;

import properties.SetProperties;

public class BaseClass extends SetProperties {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public WebDriver initializeDriver() {
		String browserToUse = getBrowser();
		driver = new DriverFactory().createInstance(browserToUse);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

}
