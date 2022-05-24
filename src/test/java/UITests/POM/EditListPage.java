package UITests.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditListPage extends BasePage{

    public EditListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "p:nth-child(1) > a.button.rounded")
    private WebElement addItemListBtn;

    @FindBy(id = "list_item_search")
    private WebElement addItemTextBox;

    @FindBy(xpath = "//body/div[8]/div[1]/div[2]")
    private WebElement movieChoicesScrollbar;

    @FindBy(css = "li:nth-child(1) > h4:nth-child(1)")
    private WebElement topElementList;

    @FindBy(xpath = "//span/h2[contains(text(),' Success')]")
    private WebElement confirmationPopup;

    public void editList() throws Exception {
        addItemListBtn.click();
        applyWait(webDriver,addItemTextBox,"visible",5);
    }

    public void addMovie(String movie) throws Exception {
        addItemTextBox.click();
        addItemTextBox.sendKeys(movie);
        applyWait(webDriver, movieChoicesScrollbar,"visible",5);
        addItemTextBox.sendKeys(Keys.DOWN);
        addItemTextBox.sendKeys(Keys.RETURN);
        applyWait(webDriver,movieChoicesScrollbar,"notVisible",5);
        applyWait(webDriver,confirmationPopup,"visible",5);
        confirmationPopup.click();


    }

    public String getElementListText(int num){
    	try {
        return webDriver.findElement(By.cssSelector("li:nth-child("+num+") > h4:nth-child(1)")).getText().toLowerCase();
    
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return "";
    }
    
    public void deleteMovieElement(int num) throws Exception {
        webDriver.findElement(By.cssSelector("li:nth-child("+num+") > h4:nth-child(1) > span.glyphicons_v2.circle-remove")).click();
        applyWait(webDriver,confirmationPopup,"visible",5);
    }

}