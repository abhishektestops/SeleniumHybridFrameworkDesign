package abhishektestnet.seleniumFrameworkDesign.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import abhishektestnet.seleniumFrameworkDesign.baseTests.BaseTest;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.LandingPage;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.ProductCataloguePage;

public class SubmitOrder extends BaseTest{
	String productName = "IPHONE 13 PRO";
	@Test
	public void SubmitOrderTest() throws IOException, InterruptedException {
		LandingPage landingPage = launchApplication();
		ProductCataloguePage productCateloguePage = landingPage.login("abhishek@email.com", "Strong@00");
		productCateloguePage.addProductToCart(productName);
		
		
	}
}
