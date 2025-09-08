package StepDefnitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class VendorsStep {
    WebDriver driver;
    PageClass page;

    @Given("bstack demo home page opens")
    public void bstack_demo_home_page_opens() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        page = new PageClass(driver);
    }

    @When("^Enter (.*) products list displayed$")
    public void enter_brand_products_list_displayed(String brand) throws InterruptedException {
        page.search(brand);
    }

    @Then("view the whole products of that brand")
    public void view_the_whole_products_of_that_brand() {
        driver.close(); 
    }
}
