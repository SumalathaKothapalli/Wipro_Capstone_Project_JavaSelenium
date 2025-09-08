package StepDefnitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStep {
	WebDriver driver;
	PageClass page;

@Given("default logged in website opens")
public void default_logged_in_website_opens() {
	driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://bstackdemo.com"); 
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    page = new PageClass(driver);
}

@When("user clicks on logout button")
public void user_clicks_on_logout_button() throws InterruptedException {
	    page.logout();
}

@Then("user should be logged out successfully")
public void user_should_be_loggged_out_sucessfully() {
    driver.close();
}




}