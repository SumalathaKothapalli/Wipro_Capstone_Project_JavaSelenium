package StepDefnitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderByStep {

    WebDriver driver;

    @Given("Open Browser Home Page")
    public void open_browser_home_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://bstackdemo.com/");
    }

    @When("Click on by order and select")
    public void click_on_by_order_and_select() {
        PageClass pg = new PageClass(driver);
        pg.orderby();
    }

    @Then("Display List of products")
    public void display_list_of_products() {
        driver.close();
    }
}
