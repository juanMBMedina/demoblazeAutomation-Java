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

	@When("Dado que quiero agregar un celular al carrito de compra")
	public void dado_que_quiero_agregar_un_celular_al_carrito_de_compra() {
		homePage.sendPhoneToCart(cartPage, itemPage);
	}

	@Then("Validar que el item existe en el carrito de compra")
	public void validar_que_el_item_existe_en_el_carrito_de_compra() {
		homePage.goToCart();
		cartPage.isDisplayedTable();
		for (Item item : cartPage.getListItems()) {
			assertTrue("Se esperaba el la existencia del item: " + item,
					cartPage.existItem(item));
		}
	}

}
