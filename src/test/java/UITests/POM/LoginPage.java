package UITests.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "username")
    private WebElement usernameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "login_button")
    private WebElement loginButton;

    public void login(String username, String password){
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();

    }
}