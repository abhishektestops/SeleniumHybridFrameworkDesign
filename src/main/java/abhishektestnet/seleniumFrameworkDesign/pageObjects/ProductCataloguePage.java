package abhishektestnet.seleniumFrameworkDesign.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishektestnet.seleniumFrameworkDesign.Utils.Utility;

public class ProductCataloguePage extends Utility{
	WebDriver driver;
	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> productsList;
	
	@FindBy(css = ".toast-message")
	WebElement errorMessage;
	
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	public WebElement getProductByName(String name) {
		WebElement prodct = productsList.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(name)).findFirst().orElse(null);
		
		return prodct;
	}
	
	public CartPage addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		threadSleep(3000);
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public boolean verifyErrorMessage(String errorMsg) {
		boolean error = errorMessage.getText().equals(errorMsg);
		return error;
	}
	
}
