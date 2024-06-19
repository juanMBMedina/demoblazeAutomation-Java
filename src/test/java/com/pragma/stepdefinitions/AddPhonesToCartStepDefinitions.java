package com.pragma.stepdefinitions;

import static org.junit.Assert.assertTrue;

import com.pragma.models.Item;
import com.pragma.pages.demoblaze.CartPage;
import com.pragma.pages.demoblaze.HomePage;
import com.pragma.pages.demoblaze.ItemPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddPhonesToCartStepDefinitions {

	HomePage homePage;
	CartPage cartPage;
	ItemPage itemPage;

	@Given("Quiero ingresar al sitio demoblaze")
	public void quiero_ingresar_al_sitio_demoblaze() {
		homePage.navigateTo();
	}

	@When("Agrego un celular al carrito de compra")
	public void agregoUnCelularAlCarritoDeCompra() {
		homePage.sendPhoneToCart(cartPage, itemPage);
	}

	@Then("Valido que el item existe en el carrito de compra")
	public void validoQueElItemExisteEnElCarritoDeCompra() {
		homePage.goToCart();
		cartPage.isDisplayedTable();
		for (Item item : cartPage.getListItems()) {
			assertTrue("Se esperaba el la existencia del item: " + item, cartPage.existItem(item));
		}
	}

}
