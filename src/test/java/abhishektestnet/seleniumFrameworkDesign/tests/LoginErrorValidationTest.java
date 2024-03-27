package abhishektestnet.seleniumFrameworkDesign.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import abhishektestnet.seleniumFrameworkDesign.baseTests.BaseTest;
import abhishektestnet.seleniumFrameworkDesign.pageObjects.ProductCataloguePage;

public class LoginErrorValidationTest extends BaseTest{
	
	/*
	 * @Method Name: ErrorValidationTest
	 * @Description: This method runs to validate that when user
	 * @Author: Abhishek Chaturvedi
	 * */
	
	@Test(groups = "ErrorValidations")
	public void loginErrorValidation() throws IOException, InterruptedException {
		ProductCataloguePage productCateloguePage = landingPage.login("abhishek@email.com", "Strong@0");
		Assert.assertTrue(productCateloguePage.verifyErrorMessage("Incorrect email or password."));
		
		
		
	}

}
