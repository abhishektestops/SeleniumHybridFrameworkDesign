package abhishektestnet.seleniumFrameworkDesign.baseTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriver driver;
	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForVisibilityOfElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForVisibilityOfElementLocatedBy(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void threadSleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}
	
}
