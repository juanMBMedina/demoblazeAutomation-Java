package com.pragma.pages.demoblaze;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pragma.actions.Actions;
import com.pragma.utils.Utils;

import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {
	
	private final Logger LOGGER = Logger.getLogger(HomePage.class.getName());	
	protected final String PRINCIPAL_URL = "https://www.demoblaze.com/index.html#";
	private final By cartField = By.id("cartur");
	private final By phonesLabel = By.xpath("//a[text()='Phones']");
	private final By laptopsLabel = By.xpath("//a[text()='Laptops']");
	private final By monitorsLabel = By.xpath("//a[text()='Monitors']");
	private final By itemsClass = By.className("hrefch");
	private final By homeLink = By.xpath("//a[@id='nava']");
	
	private final By singUpLink = By.id("signin2");
	private final By loginLink = By.id("login2");
	
	public void navigateTo() {
		Actions.navegateToUrl(getDriver(), PRINCIPAL_URL);
	}
	
	public void selectPhonesLabel() {
		Actions.clickInObject(getDriver(), phonesLabel);
	}
	
	public void selectLaptopsLabel() {
		Actions.clickInObject(getDriver(), laptopsLabel);
	}
	
	public void selectMonitorsLabel() {
		Actions.clickInObject(getDriver(), monitorsLabel);
	}
	
	public void goToCart() {
		Actions.clickInObject(getDriver(), cartField);
	}
	
	public void goToHome() {
		Actions.clickInObject(getDriver(), homeLink);
	}
	
	public void selectItem() {
		try {
			// I don-t want to use Thread.sleep
			Thread.sleep(1000);
			List <WebElement> listItems = Actions.findElements(getDriver(), itemsClass);
	        Integer randomIndex = Utils.getRandomNumber(listItems.size());
	        Actions.clickInObject(getDriver(), listItems.get(randomIndex));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void sendPhoneToCart(CartPage cartPage, ItemPage itemPage) {
		goToHome();
		selectPhonesLabel();
		selectItem();
		itemPage.addItemToCart(cartPage);
		goToHome();
	}
	
	public void sendLaptopToCart(CartPage cartPage, ItemPage itemPage) {
		goToHome();
		selectLaptopsLabel();
		selectItem();
		itemPage.addItemToCart(cartPage);
		goToHome();
	}
	
	public void sendMonitorToCart(CartPage cartPage, ItemPage itemPage) {
		goToHome();
		selectMonitorsLabel();
		selectItem();
		itemPage.addItemToCart(cartPage);
		goToHome();
	}

}
