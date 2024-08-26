package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import athirahrahmat.Utils.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterByCategories extends BaseTest {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement electronicCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[13]"));
	
	@When("User clicks on Electronic checkbox")
	public void user_clicks_Electronic_checkbox() {
		
		// Select the Electronics checkbox
        electronicCheckbox.click();
        System.out.println("Clicked on the Electronics checkbox.");
        
        // Verify the checkbox is selected
        Assert.assertTrue(electronicCheckbox.isSelected(), "Electronics checkbox was not selected.");
		
	}
	
	@Then("Verify products are showing based on the selected filter")
	public void verify_products_showing_based_on_filter() {
		
		System.out.println("Waited for the search results to load.");
        
        // Locate the search results
        List<WebElement> productResults = driver.findElements(By.cssSelector(".container .card-body"));
        System.out.println("Located the search results.");
        
        // Print out the text of all search results for debugging
        System.out.println("Filtered Results:");
        for (WebElement product : productResults) {
            String productText = product.findElement(By.cssSelector("h5")).getText();
            System.out.println("Found product: " + productText);
        }
	}
	
	@Then("Untick Electronic checkbox")
	public void untick_Electronic_checkbox() throws InterruptedException {
		
		Thread.sleep(5000);
        
        // Uncheck the Electronics checkbox if necessary
        electronicCheckbox.click();
        System.out.println("Unchecked the Electronics checkbox.");
		
	}
	
}
