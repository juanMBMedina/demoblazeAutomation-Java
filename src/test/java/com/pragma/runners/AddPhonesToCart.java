package com.pragma.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		glue = "com.pragma.stepdefinitions",
		features = "src/test/resources/features/add_phones_to_cart.feature",
		snippets = SnippetType.CAMELCASE,
		strict = true
		)

public class AddPhonesToCart {

}

