package UITests.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.SetProperties;

import java.time.Duration;

public class BasePage extends SetProperties {
	protected WebDriver webDriver;

	public BasePage(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(webDriver, this);
	}

	public void applyWait(WebDriver driver, WebElement element, String waitType, int seconds) throws Exception {
		WebDriverWait wait;
		switch (waitType) {
		case "sleep":
			int t = (seconds * 1000);
			Thread.sleep(t);
			break;
		case "clickable":
			wait = new WebDriverWait(driver, Duration.ofSeconds((seconds)));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case "visible":
			wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			break;
		case "notVisible":
			wait = new WebDriverWait((driver), Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
	}
}
