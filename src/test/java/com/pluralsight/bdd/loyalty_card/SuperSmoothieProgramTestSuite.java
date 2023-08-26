package com.pluralsight.bdd.loyalty_card;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "classpath:com/pluralsight/bdd/features/loyalty_cards",
        glue = "com.pluralsight.bdd"
)
public class SuperSmoothieProgramTestSuite {
}
