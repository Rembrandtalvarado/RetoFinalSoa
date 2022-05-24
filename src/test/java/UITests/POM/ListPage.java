package UITests.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage {
	public ListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "name")
	private WebElement nameTextBox;

	@FindBy(id = "description")
	private WebElement descriptionTextBox;

	@FindBy(id = "step_1_submit")
	private WebElement step1Btn;

	@FindBy(css = "span > h2 > a:nth-child(1)")
	public WebElement titleList;

	public void createList(String name, String description) throws Exception {
		nameTextBox.sendKeys(name);
		descriptionTextBox.sendKeys(description);
		step1Btn.click();
		applyWait(webDriver, titleList, "visible", 5);
	}
}
