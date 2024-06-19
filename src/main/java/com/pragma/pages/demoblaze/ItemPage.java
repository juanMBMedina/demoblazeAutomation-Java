package com.pragma.pages.demoblaze;

import org.openqa.selenium.By;

import com.pragma.actions.Actions;
import com.pragma.models.Item;
import com.pragma.utils.Utils;
import com.pragma.constants.*;

import net.serenitybdd.core.pages.PageObject;

public class ItemPage extends PageObject {

	private final By nameLabel = By.xpath("//h2[@class='name']");
	private final By priceLabel = By.xpath("//h3[@class='price-container']");
	private final By descriptionLabel = By.xpath("//div[@id='more-information']");
	private final By buttonAddToCart = By.xpath("//a[text()='Add to cart']");

	private String name;
	private Integer price;
	private String description;
	private Item tempItem;

	private void setName() {
		this.name = Actions.getTextFrom(getDriver(), nameLabel);
	}

	private void setPrice() {
		String allText = Actions.getTextFrom(getDriver(), priceLabel);
		this.price = Integer.valueOf(Utils.getDataInRegex(allText, Constants.STR_REGEXP_NUMBER));
	}

	private void setDescription() {
		this.description = Actions.getTextFrom(getDriver(), descriptionLabel);
	}

	private String getName() {
		return name;
	}

	private Integer getPrice() {
		return price;
	}

	private String getDescription() {
		return description;
	}

	private void setItem() {
		this.tempItem = new Item(getName(), getPrice(), getDescription());
	}

	public Item getItem() {
		return tempItem;
	}

	public void addItemToCart(CartPage cartPage) {
		refreshData();
		cartPage.add(getItem());
		Actions.clickInObject(getDriver(), buttonAddToCart);
		Actions.confirmAlert(getDriver());

	}

	private void refreshData() {
		Actions.waitForElement(getDriver(), nameLabel, 5);
		Actions.waitForElement(getDriver(), priceLabel, 5);
		Actions.waitForElement(getDriver(), descriptionLabel, 5);
		Actions.waitForElement(getDriver(), buttonAddToCart, 5);
		setName();
		setPrice();
		setDescription();
		setItem();

	}

}
