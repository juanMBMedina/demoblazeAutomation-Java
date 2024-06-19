package com.pragma.pages.demoblaze;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pragma.actions.Actions;
import com.pragma.models.Item;
import com.pragma.utils.Utils;

import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {

	private final Logger LOGGER = Logger.getLogger(CartPage.class.getName());
	private final By buttonPlaceOrder = By.className("btn-success");
	private final By itemsAdded = By.xpath("//tr[@class='success']");
	private final String itemCartXpath = "//tr[@class='success' and td[text()='%s'] and td[text()='%s']]";
	private final String labelDeleteItemCart = itemCartXpath + "//td//a[text()='Delete']";

	private List<Item> listItems = new ArrayList<Item>();

	public void add(Item item) {
		listItems.add(item);
	}

	public Boolean isNumberItemsCorrect() {
		return listItems.size() == Actions.getCantElements(getDriver(), itemsAdded);
	}

	public void isDisplayedTable() {
		Actions.waitForElement(getDriver(), itemsAdded, 5);
	}

	public Boolean existItem(Item item) {
		try {
			WebElement itemCart = getElement(String.format(itemCartXpath, item.getName(), item.getPrice()));
			return itemCart.isDisplayed() && listItems.contains(item);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "El Item " + item + " No existe en la tabla");
			return Boolean.FALSE;
		}
	}

	public Boolean deleteItem(Item item) {
		if (existItem(item)) {
			WebElement itemToRemove = getElement(String.format(labelDeleteItemCart, item.getName(), item.getPrice()));
			Actions.clickInObject(getDriver(), itemToRemove);
			listItems.remove(item);
			isDisplayedTable();
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public List<Item> getListItems() {
		return listItems;
	}

	private WebElement getElement(String strLocator) {
		By locator = By.xpath(strLocator);
		Actions.waitForElement(getDriver(), locator, 5);
		return Actions.findElement(getDriver(), locator);
	}

	public Item getRandomItem() {
		if (listItems.size() >= 1) {
			return listItems.get(Utils.getRandomNumber(listItems.size()));
		}
		throw new NullPointerException("No existen mas items en el carrito.");
	}

	public Item deleteRandomItem() {
		Item itemToRemove = getRandomItem();
		deleteItem(itemToRemove);
		return itemToRemove;
	}
}
