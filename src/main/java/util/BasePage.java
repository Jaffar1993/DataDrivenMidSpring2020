package util;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static void WaitForElements(WebDriver driver, int timeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static int RandomNumGenerate() {
		Random rnd = new Random();
		int RandomNum = rnd.nextInt(999);
		return RandomNum;
	}

	public static void DropDown(WebElement locator, String VisibleText) {
		Select sel = new Select(locator);
		sel.selectByVisibleText(VisibleText);
	}

}
