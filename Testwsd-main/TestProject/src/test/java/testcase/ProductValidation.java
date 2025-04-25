package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ProductValidation extends BaseTest {
    @Test()
    public static void ValidateTest() throws InterruptedException {

        // FearchBar locator call from loc.properties and insert input
        WebElement searchBar = driver.findElement(By.xpath(loc.getProperty("searchBar")));
        searchBar.sendKeys("Fusion Backpack");
        searchBar.submit();


        // Verification of product result
        WebElement results = driver.findElement(By.cssSelector(loc.getProperty("result")));


        // Assertion way to display message (relevant/irrelevant)
        String message = results.getText().contains("Fusion")
                ? "The search result is relevant."
                : "The search result is not relevant.";

        System.out.println(message);
    }
}
