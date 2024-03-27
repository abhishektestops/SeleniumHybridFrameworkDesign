package abhishektestnet.seleniumFrameworkDesign.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abhishektestnet.seleniumFrameworkDesign.baseTests.Utility;

public class ProductCataloguePage extends Utility{
	WebDriver driver;
	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3 b")
	List<WebElement> productsList;
	
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	public WebElement getProductByName(String name) {
		WebElement prod = null;
		for(int i=0; i<productsList.size(); i++) {
			if(productsList.get(i).getText().equals(name)) {
				prod =  productsList.get(i);
			}else {
				continue;
			}
		}
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
	}
	
}
