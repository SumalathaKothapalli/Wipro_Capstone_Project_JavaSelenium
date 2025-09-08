package StepDefnitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutStep {
    WebDriver driver;
    PageClass page;

    @Given("user opens the site and adds a product to the cart")
    public void user_opens_site_and_adds_item() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        page = new PageClass(driver);
        page.search("iphone");
        page.addToCart();
    }

    @And("user click on checkout button")
    public void user_click_checkout_button() throws InterruptedException {
        page.goToCheckout();
    }

    @And("user signs in with valid credentials")
    public void user_signs_in() throws InterruptedException {
        page.login("demouser", "testingisfun99");
    }

    @When("^user enters (.*) (.*) (.*) (.*) (.*)$")
    public void user_enters_shipping_details(String firstname, String lastname, String address, String state, String postalcode) throws InterruptedException {
        page.fillShippingForm(firstname, lastname, address, state, postalcode);
    }
    @Then("checkout process completes successfully")
    public void checkout_process_completes_successfully() {
        boolean confirmationVisible = page.isConfirmationMessageDisplayed();
        Assert.assertTrue(confirmationVisible, "Checkout confirmation message not displayed");
        
        boolean receiptVisible = page.isReceiptMessageDisplayed();
        Assert.assertTrue(receiptVisible, "Receipt message not displayed");
        
        driver.quit();
    }
}
