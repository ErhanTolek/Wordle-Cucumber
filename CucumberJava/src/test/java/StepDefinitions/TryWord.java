package StepDefinitions;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TryWord {
	WebDriver driver = null;
	@Given("Wordle Game Platform is open")
	public void open_platform() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.nytimes.com/games/wordle/index.html");
		driver.findElement(By.cssSelector("body")).click();
	}
	@And("Try the word {string}")
	public void try_word(String word) throws InterruptedException {
		driver.findElement(By.cssSelector("body")).sendKeys(word);
		Thread.sleep(2000);
	}

	@When("Click the enter")
	public void click_enter() {
		String keyboard = "return document.querySelector(\"body > game-app\").shadowRoot.querySelector(\"#game > game-keyboard\").shadowRoot.querySelector(\"#keyboard > div:nth-child(3) > button:nth-child(1)\")";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement enter = (WebElement) js.executeScript(keyboard);
		enter.click();


	}

	@Then("All the letters should be wrong status")
	public void wrong_letters() {
		String blanks = "return document.querySelector(\"body > game-app\").shadowRoot.querySelector(\"#board > game-row:nth-child(1)\").shadowRoot.querySelector(\"div\")";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement blank = (WebElement) js.executeScript(blanks);
		blank.findElement(By.cssSelector("game-tile[evaluation='absent']")).isDisplayed();
		if (blank.findElements(By.cssSelector("game-tile[evaluation='correct']")).size() != 0) {
			assert false;
			
		}else if(blank.findElements(By.cssSelector("game-tile[evaluation='present']")).size() != 0) {
			assert false;
		}
		driver.close();
		{
			
		}
			
		}
	@Then("All the letters should be correct")
	public void correct_letters() {
		String blanks = "return document.querySelector(\"body > game-app\").shadowRoot.querySelector(\"#board > game-row:nth-child(1)\").shadowRoot.querySelector(\"div\")";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement blank = (WebElement) js.executeScript(blanks);
		blank.findElement(By.cssSelector("game-tile[evaluation='correct']")).isDisplayed();
		if (blank.findElements(By.cssSelector("game-tile[evaluation='absent']")).size() != 0) {
			assert false;
			
		}else if(blank.findElements(By.cssSelector("game-tile[evaluation='present']")).size() != 0) {
			assert false;
		}
		driver.close();
	}
	


}






