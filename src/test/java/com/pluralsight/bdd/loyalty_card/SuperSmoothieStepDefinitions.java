package com.pluralsight.bdd.loyalty_card;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperSmoothieStepDefinitions {

    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    private SuperSmoothieSchema superSmoothieSchema = new SuperSmoothieSchema();
    private MorningFreshnessMember michael;

    @Given("the following drink categories")
    public void the_following_drink_categories(List<Map<String, String>> drinkCtgry) {
        drinkCtgry.forEach(
                drinkCategory -> {
                    String drink = drinkCategory.get("Drink");
                    String category = drinkCategory.get("Category");
                    Integer points = Integer.parseInt(drinkCategory.get("Points"));

                    drinkCatalog.addDrink(drink, category);
                    superSmoothieSchema.setPointsPerCategory(category, points);
                }
        );
        superSmoothieSchema.setCatalog(drinkCatalog);
    }

    @Given("^(.*) is a Morning Freshness Member$")
    public void michael_is_a_Morning_Freshness_Member(String name) {
        michael = new MorningFreshnessMember(name, superSmoothieSchema);
    }

    @When("^(.*) purchases (\\d+) (.*) drinks?$")
    public void michael_purchases_Banana_drinks(String name, Integer quantity, String drink) {
        michael.orders(quantity, drink);
    }

    @Then("^he should earn (\\d+) points$")
    public void he_should_earn_points(Integer expectedPoints) {
        assertThat(michael.getPoints()).isEqualTo(expectedPoints);
    }

}
