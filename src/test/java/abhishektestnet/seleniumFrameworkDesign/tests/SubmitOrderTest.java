package abhishektestnet.seleniumFrameworkDesign.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import abhishektestnet.seleniumFrameworkDesign.baseTests.BaseTest;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.CartPage;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.CheckoutPage;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.ConfirmationPage;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.LandingPage;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.ProductCataloguePage;

public class SubmitOrderTest extends BaseTest{
	String productName = "IPHONE 13 PRO";
	@Test
	public void SubmitOrderTest() throws IOException, InterruptedException {
		ProductCataloguePage productCateloguePage = landingPage.login("abhishek@email.com", "Strong@00");
		CartPage cartPage = productCateloguePage.addProductToCart(productName);
		cartPage.goToCart();
		Assert.assertTrue(cartPage.verifyProductInCart(productName));
		CheckoutPage checkoutPage = cartPage.checkout();
		checkoutPage.selectCountryName("india");
		ConfirmationPage confirmationPage = checkoutPage.placeOrder();
		Assert.assertTrue(confirmationPage.verifyConfirmationMessage("THANKYOU FOR THE ORDER."));
		
		
	}
}
