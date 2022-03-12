package StepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class GettingUrlSteps {
	WebDriver driver = null;
	@Given("Chrome Browser is Open")
	public void chrome_browser_is_open() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("^Go to the Wordle URL")
	public void go_to_the_wordle_url() throws InterruptedException {
		driver.get("https://www.nytimes.com/games/wordle/index.html");
	}

	@Then("Should see an Info Pop-up")
	public void i_should_see_an_info_popup() {
		
		// Check Instruction class is appear or not // 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String str2 = "return document.querySelector(\"body > game-app\").shadowRoot.querySelector(\"#game > game-modal > game-help\").shadowRoot.querySelector(\"section > div\")";
		WebElement instructionClass = (WebElement) js.executeScript(str2);
		instructionClass.isDisplayed();
		
		
			//SECOND WAY//
			/*driver.getPageSource().contains("Each guess must be a valid five-letter word. Hit the enter button to submit.");*/
	}
	@And("Close the Instructions Pop-up")
	public void close_the_pop_up() throws InterruptedException {
		
		// Click somewhere in page // 
		driver.findElement(By.cssSelector("body")).click();
		Thread.sleep(2000);
	}	
	@Then("Should see keyboard and input rows")
	public void should_see_keyboard() {

		
		String str = "return document.querySelector('game-app').shadowRoot.querySelector(\"game-theme-manager\")";
		
		// Check Game Panel is appear or not // 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		WebElement root = (WebElement) js.executeScript(str);
		if(root.findElement(By.cssSelector("div#game")).isDisplayed()) {
			driver.close();
			
			//SECOND WAY//
			//WebElement root = driver.findElement(By.tagName("game-app"));  
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			//WebElement shadowDom1 = (WebElement) js.executeScript("return arguments[0].shadowRoot", root); 
			//WebElement gamethememanager = shadowDom1.findElement(By.tagName("game-theme-manager"));
			//WebElement dividgame = gamethememanager.findElement(By.cssSelector("div#game"));
			//WebElement divboardcontainer = dividgame.findElement(By.cssSelector("div#board-container"));
			//if(divboardcontainer.findElement(By.cssSelector("div#board")).isDisplayed()) {
			//driver.close();
		}
	}
}







