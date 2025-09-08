package StepDefnitions;

import io.cucumber.java.en.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

public class OrdersStep {
    WebDriver driver;
    PageClass page;

    @Given("user is already signed in, has added products to cart, and checked out")
    public void user_is_authenticated_and_done_checkout() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        page = new PageClass(driver);
    }

    @When("user clicks the orders button")
    public void user_clicks_the_orders_button() throws InterruptedException {
        page.oders();  
        Thread.sleep(2000);  
       
        if (driver.findElements(By.id("login-btn")).size() > 0) {
            page.login("demouser", "testingisfun99");  
        }
    }

    @Then("orders page should be displayed")
    public void orders_page_should_be_displayed() {
        page.waitForOrdersPage();
        boolean isDisplayed = page.isOrdersPageDisplayed();
        AssertJUnit.assertTrue("Orders page is not displayed.", isDisplayed);
        driver.quit();
    }
}
