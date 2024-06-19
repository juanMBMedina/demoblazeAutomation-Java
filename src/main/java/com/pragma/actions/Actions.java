package com.pragma.actions;

import static com.pragma.constants.Constants.NULL_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
	public static void navegateToUrl(WebDriver myBrowser, String url) {
		myBrowser.navigate().to(url);
	}

	public static void writeEditText(WebDriver myBrowser, By editText, String strEditText) {
		myBrowser.findElement(editText).click();
		myBrowser.findElement(editText).sendKeys(strEditText);
	}

	public static void clickInObject(WebDriver myBrowser, By objectToClick) {
		WebDriverWait waitElem = new WebDriverWait(myBrowser,5);
		waitElem.until(ExpectedConditions.elementToBeClickable(objectToClick));
		myBrowser.findElement(objectToClick).click();
	}
	
	public static void clickInObject(WebDriver myBrowser, WebElement objectToClick) {
		WebDriverWait waitElem = new WebDriverWait(myBrowser,5);
		waitElem.until(ExpectedConditions.elementToBeClickable(objectToClick));
		objectToClick.click();
	}
	
	public static String getTextFrom(WebDriver myBrowser, By locator) {
        return myBrowser.findElement(locator).getText();
    }

    public static WebElement findElement(WebDriver myBrowser, By locator) {
        return myBrowser.findElement(locator);
    }
    
    public static List<WebElement> findElements(WebDriver myBrowser, By locator) {
        return myBrowser.findElements(locator);
    }
	
	public static void scrollDown(WebDriver myBrowser) {
		JavascriptExecutor js = (JavascriptExecutor) myBrowser;
		float delta = 1F;
		for(float i = delta; i <= 100; i += delta) {
			js.executeScript("window.scrollTo("+(i-delta)/100.0 +"*document.body.scrollHeight, "+i/100.0+"*document.body.scrollHeight);");
		}
	}

	public static void waitForElement(WebDriver myBrowser, By objectWait, Integer seconds) {
		WebDriverWait waitElem = new WebDriverWait(myBrowser,seconds);
		waitElem.until(ExpectedConditions.visibilityOfElementLocated(objectWait));
	}
	
	public static void waitForAllElement(WebDriver driver, List<WebElement> listElements, Integer seconds) {
		WebDriverWait waitElem = new WebDriverWait(driver,seconds);
		waitElem.until(ExpectedConditions.visibilityOfAllElements(listElements));
	}

	
	public static int getCantElements(WebDriver myBrowser, String txtXpathListLang) {
		List<WebElement> listLang = myBrowser.findElements(By.xpath(txtXpathListLang));
		return listLang.size();
	}
	
	public static int getCantElements(WebDriver myBrowser, By locator) {
		List<WebElement> listLang = myBrowser.findElements(locator);
		return listLang.size();
	}
	
	public static void confirmAlert(WebDriver myBrowser) {
		WebDriverWait wait = new WebDriverWait(myBrowser, 10);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
    }

	public static Integer toInt(String txtNum, String separator) {
		return Integer.parseInt(txtNum.replaceAll(separator, ""));
	}
	
	public static void waitForPageToLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
    }
	
	public static String getDataInRegex(String strTextIn, String regExp) {
		// Return data in RegExp if have one group () !
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(strTextIn);
		if (matcher.find() && matcher.groupCount() == 1 ) {
			return matcher.group(0);
		}
		return NULL_VALUE;
	}
	
	public static Integer sumList(ArrayList<Integer> listNums) {
		int sum = 0;
		for (Integer elem : listNums ) sum += elem;
		return sum;
	}

	
}
