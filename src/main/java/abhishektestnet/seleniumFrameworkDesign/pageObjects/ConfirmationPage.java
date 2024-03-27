package abhishektestnet.seleniumFrameworkDesign.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishektestnet.seleniumFrameworkDesign.baseTests.Utility;

public class ConfirmationPage extends Utility {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMsg;
	
	public boolean verifyConfirmationMessage(String msg) {
		boolean confirmMsg = confirmationMsg.getText().equals(msg);
		return confirmMsg;
	}	

}
