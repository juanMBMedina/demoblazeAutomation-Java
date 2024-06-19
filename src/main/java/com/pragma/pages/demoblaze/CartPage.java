package com.pragma.pages.demoblaze;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pragma.actions.Actions;
import com.pragma.models.Item;

import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {

	private final Logger LOGGER = Logger.getLogger(CartPage.class.getName());
	private final By buttonPlaceOrder = By.className("btn-success");
	private final By itemsAdded = By.xpath("//tr[@class='success']");
	private final String valueItemCart = "//tr[@class='success' and td[text()='%s']]";
	private final String labelDeleteItemCart = "//tr[@class='success' and td[text()='%s']]//td//a[text()='Delete']";
	
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
			WebElement itemName = getElement(String.format(valueItemCart, item.getName()));
			return itemName.isDisplayed();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "El Item " + item + " No existe en la tabla");
			return Boolean.FALSE;
		}
	}
	
	public Boolean deleteItem(Item item) {
		try {
			WebElement itemName = getElement(String.format(labelDeleteItemCart, item.getName()));
			Actions.clickInObject(getDriver(), itemName);
			listItems.remove(item);
			return itemName.isDisplayed();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "El Item " + item + " No existe en la tabla");
			return Boolean.FALSE;
		}
	}

	public List<Item> getListItems() {
		return listItems;
	}
	
	private WebElement getElement(String strLocator) {
		By locator = By.xpath(strLocator);
		Actions.waitForElement(getDriver(), locator, 5);
		return Actions.findElement(getDriver(), locator);
	}
}
