package StepDefnitions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class PageClass {
    WebDriver driver;
    By user=By.xpath("//*[@id='username']/div/div[1]");
    By pass=By.xpath("//*[@id='password']/div/div[1]/div[1]");
    By login=By.id("login-btn");
    By search=By.xpath("//*[@id='__next']/div/div/div[1]/div/div/div[2]/div/input");
    By searchicon=By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/div/div[2]/div/button");
    By add=By.className("shelf-item__buy-btn");
    By bag=By.className("bag");
    By deletecart=By.cssSelector(".shelf-item__del");
    By checkout=By.className("buy-btn");
    By fisrtname=By.id("firstNameInput");
    By lastname=By.id("lastNameInput");
    By address=By.id("addressLine1Input");
    By state=By.id("provinceInput");
    By postalcode=By.id("postCodeInput");
    By submit=By.id("checkout-shipping-continue");
    By confirmation=By.id("confirmation-message");
    By receipt=By.id("confirmation-message");
    By orders=By.id("orders");
    By orderspage=By.xpath("//*[@id=\"__next\"]/main/div/div/span");
    By orderby=By.xpath("//*[@id=\"__next\"]/div/div/main/div[2]/div[1]/div[1]/select");
    By offers=By.id("offers");
    By diaplaymessage=By.cssSelector("#__next > main > div > div > div");
    By vendors=By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/h4");
    By apple=By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/div[1]/label/span");
    By samsung=By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/div[2]/label/span");
    By google=By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/div[3]/label/span");
    By oneplus=By.xpath("//*[@id=\"__next\"]/div/div/main/div[1]/div[4]/label/span");
    By favouritesicon=By.xpath("//*[@id='1']/div[1]/button/span[1]");
    By favourites=By.id("favourites");
    By logout=By.id("signin");

  
    public PageClass(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) throws InterruptedException {
        driver.findElement(user).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='" + username + "']")).click();
        Thread.sleep(1000);
        driver.findElement(pass).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='" + password + "']")).click();
        Thread.sleep(1000);
        driver.findElement(login).click();
        Thread.sleep(2000);
    }
    public void search(String item) throws InterruptedException {
        driver.findElement(search).click();
        Thread.sleep(1000);
        driver.findElement(search).sendKeys(item);
        Thread.sleep(1000);
        driver.findElement(searchicon).click();
        Thread.sleep(3000);
    }

    public void addToCart() throws InterruptedException {
        driver.findElement(add).click();
        Thread.sleep(1000);
        driver.findElement(bag).click();
        Thread.sleep(2000);
    }

    public void deleteFromCart() throws InterruptedException {
    	Thread.sleep(1000);
        driver.findElement(deletecart).click();
        Thread.sleep(2000);
    }
    public void goToCheckout() throws InterruptedException {
        driver.findElement(checkout).click();   
        Thread.sleep(3000);                    
    }
      public void fillShippingForm(String firstname, String lname, String addr, String stateName, String pcode) throws InterruptedException {
    	Thread.sleep(10000);
        driver.findElement(fisrtname).sendKeys(firstname);
        Thread.sleep(1000);
        driver.findElement(lastname).sendKeys(lname);
        Thread.sleep(1000);
        driver.findElement(address).sendKeys(addr);
        Thread.sleep(1000);
        driver.findElement(state).sendKeys(stateName);
        Thread.sleep(1000);
        driver.findElement(postalcode).sendKeys(pcode);
        Thread.sleep(1000);
        driver.findElement(submit).click();
        Thread.sleep(2000);
      }
      public void waitForConfirmationMessage() {
    	    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(confirmation));
    	}

    	public boolean isConfirmationMessageDisplayed() {
    	    return driver.findElements(confirmation).size() > 0;
    	}

    	public boolean isReceiptMessageDisplayed() {
    	    return driver.findElements(receipt).size() > 0;
    	}

    	public void oders() throws InterruptedException {
            driver.findElement(orders).click();   
            Thread.sleep(3000);
    	}
    	public void waitForOrdersPage() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(orderspage));
        }

        public boolean isOrdersPageDisplayed() {
            return driver.findElements(orderspage).size() > 0;
        }
        public void orderby() {
  		  driver.findElement(orderby).click();
        }
        public void offers() throws InterruptedException {
            driver.findElement(offers).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            boolean loginPage = driver.findElements(login).size() > 0;
            if (loginPage) {
                login("demouser", "testingisfun99");
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(diaplaymessage));
        }
        public void vendors() throws InterruptedException{
            driver.findElement(vendors);   
            Thread.sleep(3000);
            driver.findElement(apple).click();   
            Thread.sleep(3000);
            driver.findElement(samsung).click();   
            Thread.sleep(3000);
            driver.findElement(google).click();   
            Thread.sleep(3000);
            driver.findElement(oneplus).click();   
            Thread.sleep(3000);    
        	}
        public void favourites() throws InterruptedException {
        	Thread.sleep(3000);
            driver.findElement(favouritesicon).click();
            Thread.sleep(3000);
            driver.findElement(favourites).click();
            Thread.sleep(3000);
        }
        public void logout() throws InterruptedException{
            driver.findElement(logout).click();   
            Thread.sleep(3000);
    	}
        
        }
