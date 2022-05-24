package UITests.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//header/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]")
    private WebElement loginButton;

    public void clickButton() throws Exception {
        applyWait(webDriver, loginButton, "clickable",5);
        loginButton.click();
    }
}
