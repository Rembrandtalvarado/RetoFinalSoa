package UITests.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//body/div[1]/main[1]/div[3]/div[1]/div[1]/ul[1]/li[3]/a[1]")
	private WebElement listTab;

	@FindBy(xpath = "//a[contains(text(),'Create List')]")
	private WebElement createListBtn;

	@FindBy(xpath = "//body/div[1]/main[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/h2[1]/a[1]")
	private WebElement firstListItem;

	public void enterCreateList() throws Exception {
		listTab.click();
		applyWait(webDriver, createListBtn, "clickable", 5);
		createListBtn.click();
	}

	public void enterListItem() throws Exception {
		listTab.click();
		applyWait(webDriver, firstListItem, "clickable", 5);
		firstListItem.click();
	}

}
