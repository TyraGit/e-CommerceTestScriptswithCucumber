package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import athirahrahmat.Utils.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProducts extends BaseTest {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String prodName = "ZARA";
    WebElement searchBox = driver.findElement(By.xpath("(//input[@placeholder='search'])[2]"));
	
	@When("User keys in search box and press Enter")
	public void user_keyin_search_box_press_enter() {
		// Enter the product name in the search box and press Enter
        searchBox.sendKeys(prodName);
        searchBox.sendKeys(Keys.RETURN); // Simulate pressing Enter
		
	}
	
	@Then("Verify product is showing on home page")
	public void product_should_display() {
        // Locate the search results
        List<WebElement> productResults = driver.findElements(By.cssSelector(".card-body"));
        
        // Print out the text of all search results for debugging
        /*System.out.println("Search Results:");
        for (WebElement product : productResults) {
            String productText = product.findElement(By.cssSelector("h5")).getText();
            System.out.println("Found product: " + productText);
        }*/
        
        // Validate that any product containing the search term is found
        boolean isProductFound = productResults.stream()
                .map(product -> product.findElement(By.cssSelector("h5")).getText())
                .anyMatch(name -> name.toLowerCase().contains(prodName.toLowerCase()));
        
        // Assert that the product name is found in the search results
        Assert.assertTrue(isProductFound, "Product " + prodName + " was not found in the search results.");
        
        System.out.println("Product " + prodName + " is displayed in the search results.");
		
	}
	
	@Then("Clear Search field")
	public void clear_search_field() throws InterruptedException {
		
		 // clear the product name from the search box and press Enter
        searchBox.clear();
        searchBox.sendKeys(Keys.RETURN);
        
        Thread.sleep(5000);
		
	}

}
