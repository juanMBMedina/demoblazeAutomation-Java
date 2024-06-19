package com.pragma.stepdefinitions;

import com.pragma.pages.demoblaze.CartPage;
import com.pragma.pages.demoblaze.HomePage;
import com.pragma.pages.demoblaze.ItemPage;

import io.cucumber.java.en.When;

public class AddMonitorsToCartStepDefinitions {

	HomePage homePage;
	CartPage cartPage;
	ItemPage itemPage;
	
	@When("Agrego un monitor al carrito de compra")
	public void agregoUnMonitorAlCarritoDeCompra() {
		homePage.sendMonitorToCart(cartPage, itemPage);
	}
	
}
