package UITests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener{
	
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value ="{0}", type="text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
	
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("Start method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", BaseClass.getDriver());
	}
	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("Finish method " + iTestContext.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Test failed: " + getTestMethodName(iTestResult) + " Failed");
		Object testClass = iTestResult.getInstance();
		WebDriver driver = BaseClass.getDriver();
		
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case: " + getTestMethodName(iTestResult));
			saveFailureScreenShot(driver);
		}
		saveTextLog(getTestMethodName(iTestResult) + " Failed and screenshot taken");
	}
	
}
