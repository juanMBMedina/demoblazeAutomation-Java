package com.pragma.stepdefinitions;

import com.pragma.pages.demoblaze.CartPage;
import com.pragma.pages.demoblaze.HomePage;
import com.pragma.pages.demoblaze.ItemPage;

import io.cucumber.java.en.When;

public class AddLaptopsToCartStepDefinitions {

	HomePage homePage;
	CartPage cartPage;
	ItemPage itemPage;

	@When("Dado que quiero agregar una laptop al carrito de compra")
	public void dadoQueQuieroAgregarUnaLaptopAlCarritoDeCompra() {
		// Write code here that turns the phrase above into concrete actions
		homePage.sendLaptopToCart(cartPage, itemPage);
	}

}
