package abhishektestnet.seleniumFrameworkDesign.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishektestnet.seleniumFrameworkDesign.baseTests.FileReader;
import abhishektestnet.seleniumFrameworkDesign.baseTests.Utility;

public class LandingPage extends Utility{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userName;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement loginButton;
	
	public ProductCataloguePage login(String username, String password) throws IOException, InterruptedException {
		driver.get(FileReader.readPropertyFile("url"));
		userName.sendKeys(username);
		userPassword.sendKeys(password);
		loginButton.click();
		ProductCataloguePage productCateloguePage = new ProductCataloguePage(driver);
		threadSleep();
		return productCateloguePage;
	}
}
