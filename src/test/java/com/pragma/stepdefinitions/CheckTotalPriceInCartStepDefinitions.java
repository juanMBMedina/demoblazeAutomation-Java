package com.pragma.stepdefinitions;

import static org.junit.Assert.assertEquals;

import com.pragma.pages.demoblaze.CartPage;
import com.pragma.pages.demoblaze.HomePage;
import com.pragma.pages.demoblaze.ItemPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckTotalPriceInCartStepDefinitions {

	HomePage homePage;
	CartPage cartPage;
	ItemPage itemPage;

	@When("Agrego diferentes items en el carrito de compra")
	public void agregoDiferentesItemsEnElCarritoDeCompra() {
		homePage.sendPhoneToCart(cartPage, itemPage);
		homePage.sendLaptopToCart(cartPage, itemPage);
		homePage.sendMonitorToCart(cartPage, itemPage);
	}

	@Then("Valido que el precio totla mostrado es correcto")
	public void validoQueElPrecioTotlaMostradoEsCorrecto() {
		homePage.goToCart();
		cartPage.isDisplayedTable();
		Integer excpectedValue = cartPage.calculateTotalPrice();
		Integer valueInPage = cartPage.getFinalPriceInWeb();
		assertEquals("El valor esperado es diferente al valor de la web", excpectedValue, valueInPage);
	}

}
