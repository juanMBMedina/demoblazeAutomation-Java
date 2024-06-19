package com.pragma.pages.demoblaze;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pragma.actions.Actions;
import com.pragma.constants.Constants;
import com.pragma.models.Customer;
import com.pragma.models.Item;
import com.pragma.utils.Utils;

import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {
	
	public static final String MSSG_PURCHASE_OK = "Thank you for your purchase!";
	private final Logger LOGGER = Logger.getLogger(CartPage.class.getName());
	private final By buttonPlaceOrder = By.className("btn-success");
	private final By itemsAdded = By.xpath("//tr[@class='success']");
	private final String itemCartXpath = "//tr[@class='success' and td[text()='%s'] and td[text()='%s']]";
	private final String labelDeleteItemCart = itemCartXpath + "//td//a[text()='Delete']";
	private final By ceroItemsTable = By.xpath("//tbody[count(tr)=0]");
	private final By mssgTotalPrice = By.className("col-lg-1");

	// Form in cart
	private final By editTextName = By.id("name");
	private final By editTextCountry = By.id("country");
	private final By editTextCity = By.id("city");
	private final By editTextCreditCard = By.id("card");
	private final By editTextMonth = By.id("month");
	private final By editTextYear = By.id("year");
	private final By buttonPurchase = By.xpath("//button[text()='Purchase']");
	
	// Mssge end Purchase
	private final By mssgPurchase = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//h2");
	private final By dataPurchase = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']//p");
	private final By buttonEndPurchase = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");
	
	private List<Item> listItems = new ArrayList<Item>();
	
	public String getDataPruchase() {
		return getElement(dataPurchase).getText();
	}
	
	public Integer getFinalPriceInWeb() {
		String strNumber = Utils.getDataInRegex(getElement(mssgTotalPrice).getText(), Constants.STR_REGEXP_NUMBER);
		return !strNumber.equals(Constants.NULL_VALUE) ? Integer.valueOf(strNumber) : 0;
	}

	public void goToForm() {
		Actions.clickInObject(getDriver(), buttonPlaceOrder);
	}
	
	public void sendData(Customer customer) {
		customer.setAmount(getFinalPriceInWeb());
		goToForm();
		Actions.writeEditText(getDriver(), editTextName, customer.getFullName());
		Actions.writeEditText(getDriver(), editTextCountry, customer.getCountry());
		Actions.writeEditText(getDriver(), editTextCity, customer.getCity());
		Actions.writeEditText(getDriver(), editTextCreditCard, customer.getCreditCard());
		Actions.writeEditText(getDriver(), editTextMonth, customer.getMonth());
		Actions.writeEditText(getDriver(), editTextYear, customer.getYear());
		Actions.clickInObject(getDriver(), buttonPurchase);
	}
	
	public String getMssgtoEndPurchase() {
		return getElement(mssgPurchase).getText();
	}

	public Integer calculateTotalPrice() {
		Integer totalPrice = 0;
		for (Item item : getListItems()) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

	public void add(Item item) {
		this.listItems.add(item);
	}

	public Boolean isEmpty() {
		return getElement(ceroItemsTable).isDisplayed();
	}

	public void isDisplayedTable() {
		Actions.waitForElement(getDriver(), itemsAdded, 2);
	}

	public Boolean existItem(Item item) {
		try {
			isDisplayedTable();
			WebElement itemCart = getElement(String.format(itemCartXpath, item.getName(), item.getPrice()));
			return itemCart.isDisplayed() && this.listItems.contains(item);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, "El " + item + "\nNo existe en la tabla");
			return Boolean.FALSE;
		}
	}

	public Boolean deleteItem(Item item) {
		if (existItem(item)) {
			WebElement itemToRemove = getElement(String.format(labelDeleteItemCart, item.getName(), item.getPrice()));
			Actions.clickInObject(getDriver(), itemToRemove);
			this.listItems.remove(item);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public List<Item> getListItems() {
		return this.listItems;
	}

	private WebElement getElement(String strLocator) {
		By locator = By.xpath(strLocator);
		return getElement(locator);
	}

	private WebElement getElement(By locator) {
		Actions.waitForElement(getDriver(), locator, 2);
		return Actions.findElement(getDriver(), locator);
	}

	public Item getRandomItem() {
		if (this.listItems.size() >= 1) {
			return this.listItems.get(Utils.getRandomNumber(this.listItems.size()));
		}
		throw new NullPointerException("No existen mas items en el carrito.");
	}

	public Item deleteRandomItem() {
		Item itemToRemove = getRandomItem();
		deleteItem(itemToRemove);
		return itemToRemove;
	}
}
