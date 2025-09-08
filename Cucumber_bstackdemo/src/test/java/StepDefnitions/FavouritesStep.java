package StepDefnitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FavouritesStep {
	WebDriver driver;
	PageClass page;

@Given("bstack demo home page is open and clicks favourites icon of product")
public void bstack_demo_home_page_is_open_and_clicks_favourites_icon_of_product() {
	driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://bstackdemo.com"); 
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    page = new PageClass(driver);
 
}

@When("user clicks on favouritesicon and add product to favourites")
public void user_clicks_on_favouritesicon_and_add_product_to_favourites() throws InterruptedException {
	page.logout();
}

@Then("click on favourites and view")
public void click_on_favourites_and_view() {
    System.out.println("favourites diaplayed");
    driver.close();
}




}