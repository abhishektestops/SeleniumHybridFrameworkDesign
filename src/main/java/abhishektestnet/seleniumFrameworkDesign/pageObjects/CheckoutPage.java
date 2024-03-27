package abhishektestnet.seleniumFrameworkDesign.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishektestnet.seleniumFrameworkDesign.baseTests.Utility;

public class CheckoutPage extends Utility {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css = ".ta-item:last-of-type")
	WebElement country;
	
	@FindBy(css = ".action__submit")
	WebElement submitButton;
	
	public void selectCountryName(String countryName) {
		selectCountry.sendKeys(countryName);
		country.click();
	}
	
	public ConfirmationPage placeOrder() {
		submitButton.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}

}
