package StepDefnitions;

import io.cucumber.java.en.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

public class OffersStep {
    WebDriver driver;
    PageClass page;

    @Given("Default home page will open in browser")
    public void open_browser_home_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com"); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        page = new PageClass(driver);
    }
    @When("Click on offers and view")
    public void click_on_offers_and_view() throws InterruptedException {
        page.offers();  
    }

    @And("Sign in if prompted")
    public void sign_in_if_prompted() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean loginPrompted = driver.findElements(By.id("login-btn")).size() > 0;

        if (loginPrompted) {
            page.login("demouser", "testingisfun99");
            wait.until(ExpectedConditions.visibilityOfElementLocated(page.diaplaymessage));
        }
    }

    @Then("Display the message")
    public void display_the_message() {
        boolean isDisplayed = driver.findElements(page.diaplaymessage).size() > 0;
        AssertJUnit.assertTrue("Offer message is not displayed.", isDisplayed);
        driver.quit();
    }
}
