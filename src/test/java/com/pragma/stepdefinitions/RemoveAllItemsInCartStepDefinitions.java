package com.pragma.stepdefinitions;

import static org.junit.Assert.assertTrue;

import com.pragma.models.Item;
import com.pragma.pages.demoblaze.CartPage;
import com.pragma.pages.demoblaze.HomePage;
import com.pragma.pages.demoblaze.ItemPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveAllItemsInCartStepDefinitions {

	HomePage homePage;
	CartPage cartPage;
	ItemPage itemPage;

	@When("Agrego varios aleatorios items al carrito de compra")
	public void agregoVariosAleatoriosItemsAlCarritoDeCompra() {
		homePage.sendPhoneToCart(cartPage, itemPage);
		homePage.sendLaptopToCart(cartPage, itemPage);
		homePage.sendMonitorToCart(cartPage, itemPage);
	}

	@Then("Valido que el carrito de compra no tiene items")
	public void validoQueElCarritoDeCompraNoTieneItems() {
		homePage.goToCart();
		Integer numberItems = cartPage.getListItems().size();
		for (Integer i = 0; i < numberItems; i++) {
			cartPage.isDisplayedTable();
			Item itemToRemove = cartPage.deleteRandomItem();
			assertTrue("El item existe en el carrito de compras !:\n" + itemToRemove,
					!cartPage.existItem(itemToRemove));
		}
		assertTrue("Existen items en el carrito de compras.", cartPage.isEmpty());
	}

}
