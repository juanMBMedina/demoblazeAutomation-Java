package com.pragma.stepdefinitions;

import com.pragma.pages.demoblaze.CartPage;
import com.pragma.pages.demoblaze.HomePage;
import com.pragma.pages.demoblaze.ItemPage;

import io.cucumber.java.en.When;

public class AddLaptopsToCartStepDefinitions {

	HomePage homePage;
	CartPage cartPage;
	ItemPage itemPage;
	
	@When("Agrego una laptop al carrito de compra")
	public void agregoUnaLaptopAlCarritoDeCompra() {
		homePage.sendLaptopToCart(cartPage, itemPage);
	}
	
}
