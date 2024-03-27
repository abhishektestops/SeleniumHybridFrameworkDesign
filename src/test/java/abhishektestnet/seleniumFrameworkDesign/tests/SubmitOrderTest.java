package abhishektestnet.seleniumFrameworkDesign.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import abhishektestnet.seleniumFrameworkDesign.Utils.FileReader;
import abhishektestnet.seleniumFrameworkDesign.baseTests.BaseTest;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.CartPage;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.CheckoutPage;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.ConfirmationPage;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.LandingPage;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.ProductCataloguePage;

public class SubmitOrderTest extends BaseTest{
	
	/*
	 * @Method Name: SubmitOrderTest
	 * @Description: This method runs to validate that user is able to place an order from the website
	 * @Author: Abhishek Chaturvedi
	 * */
	
	
	@Test(enabled = true, dataProvider = "getDataForSubmitOrderTest",groups="Regression", testName = "SubmitOrderTest")
	public void SubmitOrderTest(HashMap<String,String> input) throws IOException, InterruptedException {
		ProductCataloguePage productCateloguePage = landingPage.login(input.get("username"), input.get("password"));
		CartPage cartPage = productCateloguePage.addProductToCart(input.get("product"));
		cartPage.goToCart();
		Assert.assertTrue(cartPage.verifyProductInCart(input.get("product")));
		CheckoutPage checkoutPage = cartPage.checkout();
		checkoutPage.selectCountryName("india");
		ConfirmationPage confirmationPage = checkoutPage.placeOrder();
		Assert.assertTrue(confirmationPage.verifyConfirmationMessage("THANKYOU FOR THE ORDER."));
			
	}
	
	@DataProvider
	public Object[][] getDataForSubmitOrderTest() throws StreamReadException, DatabindException, IOException {
		List<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
		data = FileReader.readJsonFileIntoMap("submitOrderData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
