package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartIntegrationTest extends BaseTest {
    @Test()
    public static void AddRemoveitemsCart() throws InterruptedException {
        // WebDriverWait initialization
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // duration 15 seconds timeout

        // Navigate to the  product page
        WebElement searchBar = driver.findElement(By.xpath(loc.getProperty("searchBar")));
        searchBar.sendKeys("Orestes Fitness Short");
        searchBar.submit();

        // Select product options (e.g., size, color based on the assignment)
        WebElement sizeOption = driver.findElement(By.xpath(loc.getProperty("size")));
        sizeOption.click();
        WebElement colorOption = driver.findElement(By.xpath(loc.getProperty("color")));
        colorOption.click();

        // Add the product to the cart
        driver.findElement(By.xpath(loc.getProperty("addtocart"))).click();
        Thread.sleep(2500);
        // Confirm that the product is present in the cart.
        WebElement cart = driver.findElement(By.xpath(loc.getProperty("cart")));
        cart.click();
        WebElement cartItem = driver.findElement(By.xpath(loc.getProperty("cartitem")));
        Thread.sleep(1800);



        String message;

        switch (cartItem.getText().contains("Orestes Fitness Short") ? 1 : 0) {
            case 1:
                message = "The product is added to the cart successfully.";
                break;
            case 0:
                message = "Product is not added to the cart.";
                break;
            default:
                message = "Unexpected result.";
        }

        System.out.println(message);


        // Navigate to the cart page and confirm product details
        WebElement viewCartButton = driver.findElement(By.xpath(loc.getProperty("cartView")));
        viewCartButton.click();
        WebElement cartDetails = driver.findElement(By.xpath(loc.getProperty("cartdetails")));
        WebElement cartSize = driver.findElement(By.xpath(loc.getProperty("cartsize")));
        WebElement cartColor = driver.findElement(By.xpath(loc.getProperty("cartcolor")));
        WebElement itemValue = driver.findElement(By.xpath(loc.getProperty("itemvalue")));


        boolean areDetailsCorrect = cartDetails.getText().contains("Orestes Fitness Short") &&
                cartSize.getText().contains("34") &&
                cartColor.getText().contains("Blue") &&
                itemValue.getText().contains("$35.00");

        if (areDetailsCorrect) {
            System.out.println("The product information in the cart is accurate.");
        } else {
            System.out.println("The product information in the cart is ----incorrect.");
        }

    }
    }