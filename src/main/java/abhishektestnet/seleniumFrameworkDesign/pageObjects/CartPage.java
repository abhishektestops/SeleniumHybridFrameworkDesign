package abhishektestnet.seleniumFrameworkDesign.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishektestnet.seleniumFrameworkDesign.baseTests.Utility;

public class CartPage extends Utility{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".fa-shopping-cart")
	WebElement cartButton;
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> productsInCart;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement checkoutButton;
	
	public void goToCart() {
		cartButton.click();
		
	}
	
	public boolean verifyProductInCart(String productName) {
		boolean checkForProduct = productsInCart.stream()
		.anyMatch(product -> product.getText().equals(productName));
		return checkForProduct; 
	}
	
	public CheckoutPage checkout() {
		checkoutButton.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

}
