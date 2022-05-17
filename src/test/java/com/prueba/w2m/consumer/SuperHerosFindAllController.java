package com.prueba.w2m.consumer;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SuperHerosFindAllController {
    private List<?> superHeroes;
    private RequestSpecification request;
    private Response response;

    private final String uri = "http://localhost:8080/api/v1/superHeros";

    @Given("a listing request")
    public void listing_request() {
        // Write code here that turns the phrase above into concrete actions
        this.superHeroes = new ArrayList<>();
    };

    @When("there are no super heroes registered")
    public void there_are_no_super_heroes_registered() {
        // Write code here that turns the phrase above into concrete actions
        this.response = request.when().get(uri);
    };

    @Then("it should return me code {int}")
    public void it_should_return_me_code(Integer int1) {
        Assert.assertEquals(Optional.ofNullable(int1), this.response.getStatusCode());

    };

    @And("message {string}")
    public void message(String string){
        JsonPath json = this.response.jsonPath();
        Assert.assertEquals(string, json.get("message").toString());
    };
}
