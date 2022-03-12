package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(strict = true, features="src/test/resources/Features/Wordle.feature", glue= {"StepDefinitions"},
monochrome = true

		)
public class TestRunner {

}
