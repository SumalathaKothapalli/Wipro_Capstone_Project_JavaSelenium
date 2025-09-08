package StepDefnitions;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep {
	WebDriver driver;
	@Given("login user and search button available")
	public void login_user_and_search_button_available() {
		 driver=new ChromeDriver();
			driver.get("https://bstackdemo.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
	}
	@When("^Enter (.*) item and then press search icon$")
	public void enter_item_and_then_press_search_icon(String item) throws InterruptedException {
	    PageClass pg = new PageClass(driver);
	    pg.search(item);
	}

	@Then("List of output relevant to input")
	public void list_of_output_relevant_to_input() {
		driver.close();
	    
	}
}