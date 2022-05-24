package UITests;



import UITests.POM.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners({AllureListener.class})
public class BaseTest extends BaseClass {
	
	public WebDriver driver;
	private MainPage mainPage;
	private LoginPage loginPage;
	private ProfilePage profilePage;
	private ListPage listPage;
	private EditListPage editListPage;

	@BeforeMethod
	public void condition() throws Exception {
		BaseClass baseClass = new BaseClass();
		baseClass.initializeDriver();
		
		driver.get("https://www.themoviedb.org");
		mainPage = new MainPage(driver);
		loginPage = new LoginPage(driver);
		profilePage = new ProfilePage(driver);
		listPage = new ListPage(driver);
		editListPage = new EditListPage(driver);

		// Given that I'm a logged-in user (login)
		mainPage.clickButton();
		loginPage.login(getUsername(), getPassword());
	}

	@AfterMethod
	public void postCondition() {
		driver.quit();
	}

	
	@Test(priority = 1, description="Create a list using information provided")
	@Description("Create a list using information provided")
	@Feature("Feature1: Create a list")
	@Story("Story: Create list")
	@Severity(SeverityLevel.CRITICAL)
	public void createList() throws Exception {
		// Create list from profile page
		profilePage.enterCreateList();
		listPage.createList(getListName(), getListDescription());
		String titleList = listPage.titleList.getText();
		// verify that the list has been created
		Assert.assertEquals(getListName(), titleList);
	}

	@Test(priority = 2)
	@Description("Add a new movie to the list")
	@Feature("Feature1: Add a movie")
	@Story("Story: Add movie")
	@Severity(SeverityLevel.NORMAL)
	public void addItemToList() throws Exception {
		profilePage.enterListItem();
		editListPage.editList();
		editListPage.addMovie(getMovie());
		Assert.assertTrue(editListPage.getElementListText(1).contains(getMovie()));

	}

	@Test(priority = 3)
	@Description("Delete a movie from the list")
	@Feature("Feature1: Delete movie")
	@Story("Story: Delete movie")
	@Severity(SeverityLevel.NORMAL)
	public void deleteMovie() throws Exception {
		int position = 1;
		profilePage.enterListItem();
		editListPage.editList();
		String beforeDeleting = editListPage.getElementListText(position);
		editListPage.deleteMovieElement(position);
		String afterDeleting = editListPage.getElementListText(position);
		Assert.assertNotEquals(beforeDeleting, afterDeleting);
	}
}