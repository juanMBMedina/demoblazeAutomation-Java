package com.pragma.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.pragma.models.Customer;
import com.pragma.pages.demoblaze.CartPage;
import com.pragma.pages.demoblaze.HomePage;
import com.pragma.pages.demoblaze.ItemPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyItemsInCartStepDefinitions {

	HomePage homePage;
	CartPage cartPage;
	ItemPage itemPage;
	Customer customer;

	@When("Voy a comparar items con los datos (.+) (.+) (.+) (.+) (.+) (.+)$")
	public void voyACompararItemsConLosDatos(String fullName, String strCountry, String strCity, String creditCard,
			String month, String year) {
		customer = new Customer(fullName, strCountry, strCity, creditCard, month, year);
		homePage.sendPhoneToCart(cartPage, itemPage);
		homePage.sendLaptopToCart(cartPage, itemPage);
		homePage.sendMonitorToCart(cartPage, itemPage);
		homePage.goToCart();
		cartPage.isDisplayedTable();
		cartPage.sendData(customer);
	}

	@Then("Valido que la compra fue realizada de forma correcta")
	public void validoQueLaCompraFueRealizadaDeFormaCorrecta() {
		String dataInWeb = cartPage.getDataPruchase();
		Integer excpectedValue = cartPage.calculateTotalPrice();
		Integer valueInPage = cartPage.getFinalPriceInWeb();
		assertEquals("La compra fallo", cartPage.getMssgtoEndPurchase(), CartPage.MSSG_PURCHASE_OK);
		assertEquals("El valor esperado es diferente al valor de la web", excpectedValue, valueInPage);
		assertEquals("El valor del mensaje es diferente al valor del cliente", excpectedValue, customer.getAmount());
		assertTrue("El mensaje no tiene monto de la compra", dataInWeb.contains(customer.getAmount().toString()));
		assertTrue("El mensaje no tiene la tarjeta de credito", dataInWeb.contains(customer.getCreditCard()));
		assertTrue("El mensaje no tiene el nombre del usuario", dataInWeb.contains(customer.getFullName()));
	}

}
