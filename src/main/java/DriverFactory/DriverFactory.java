package DriverFactory;
import DriverFactory.manager.ChromeDriverManager;
import DriverFactory.manager.EdgeDriverManager;
import DriverFactory.manager.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
	public WebDriver createInstance(String browser) {
        WebDriver driver;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType){
            case CHROME:
                driver = new ChromeDriverManager().createDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().createDriver();
                break;
            case EDGE:
                driver = new EdgeDriverManager().createDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserType);
        }
        return driver;
    } 
}
