package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	WebDriver driver = null;


	@Given("browser is open")
	public void browser_is_open() {
		System.getProperty("webdriver.chrome.driver", "C:/Users/Kron/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}

	@Given("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("wer");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		System.out.println("ert");
	}

	@When("hits enter")
	public void hits_enter() {
		System.out.println("sdvc");

	}

	@Then("user user is navigated to search results")
	public void user_user_is_navigated_to_search_results() {
		System.out.println("sdfsdf");
	}



}
