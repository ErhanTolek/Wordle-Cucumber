package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {



	@Given("is on login page")
	public void is_on_login_page() {
		System.out.println("Insýde Step - user is on login page");
	}

	@When("user enters username and pass")
	public void user_enters_username_and_pass() {
		System.out.println("Insýde Step - user enters username and pass");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Insýde Step - clicks on login button");
	}

	@Then("user is navigated to home page")
	public void user_is_navited_to_home_page() {
		System.out.println("Insýde Step - user is navigated to home page");

	}
}