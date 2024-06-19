package com.pragma.stepdefinitions;

import static org.junit.Assert.assertTrue;

import com.pragma.models.Item;
import com.pragma.pages.demoblaze.CartPage;
import com.pragma.pages.demoblaze.HomePage;
import com.pragma.pages.demoblaze.ItemPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveItemInCartStepDefinitions {

	HomePage homePage;
	CartPage cartPage;
	ItemPage itemPage;

	@When("Agrego varios items al carrito de compra")
	public void agregoVariosItemsAlCarritoDeCompra() {
		homePage.sendPhoneToCart(cartPage, itemPage);
		homePage.sendLaptopToCart(cartPage, itemPage);
		homePage.sendMonitorToCart(cartPage, itemPage);
	}

	@Then("Valido que el item no existe en el carrito de compra")
	public void validoQueElItemNoExisteEnElCarritoDeCompra() {
		homePage.goToCart();
		cartPage.isDisplayedTable();
		Item itemToRemove = cartPage.deleteRandomItem();
		assertTrue("El item existe en el carrito de compras !:\n" + itemToRemove, !cartPage.existItem(itemToRemove));
	}

}
