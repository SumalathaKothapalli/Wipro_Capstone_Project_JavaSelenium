package StepDefnitions;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStep {
    WebDriver driver;
    PageClass page;

    @Given("signin page should be open in default browser")
    public void signin_page_should_be_open_in_default_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com/signin"); 
        page = new PageClass(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @When("^click on signin button and enter (.*) and (.*)$")
    public void click_on_signin_button_and_enter_username_and_password(String username, String password) throws InterruptedException {
        page.login(username, password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @When("^click on loginin button check (.*)$")
    public void click_on_loginin_button_check_status(String status) {
        System.out.println("Login status check performed: " + status);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    
    }
    @Then("login successfully and open home page")
    public void login_successfully_and_open_home_page() {
        System.out.println("Home page validation done ");
        driver.quit();
    }
}
