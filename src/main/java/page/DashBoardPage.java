package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashBoardPage {

	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Dashboard')]")
	WebElement DASHBOARD_PAGE_LOCATOR;
	
	public void VerifyDashBoardPage() {
		Assert.assertEquals(DASHBOARD_PAGE_LOCATOR.getText(), "Dashboard", "OOPS Wrong Page");
	}

}
