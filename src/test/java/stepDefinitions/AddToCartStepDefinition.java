package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import athirahrahmat.Utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddToCartStepDefinition extends BaseTest {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	String productName = "ZARA COAT 3";
	

	@Given("User selects a product and clicks Add to Cart")
	public void user_selects_product_and_add_to_cart() {
	    
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
            System.out.println("Products are visible on the page.");

            // Go through a list of elements and filter the product by "ZARA COAT 3"
            List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
            WebElement prod = products.stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);

            if (prod != null) {
                prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
            } else {
                System.out.println("Product 'ZARA COAT 3' not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred: " + e.getMessage());
        }
	}
	
	@Then("Product should be added to cart")
	public void product_should_be_added_to_cart() {
		try {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))); //waiting for toaster to appear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating"))); //waiting for the loader to disappear

            //open Cart page
            driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();

            //wait for the cart page to load and the items to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection")));
            List<WebElement> carts = driver.findElements(By.cssSelector(".cartSection h3"));

            //validate that the product name is found in the cart
            boolean match = carts.stream()
                                 .map(WebElement::getText)
                                 .anyMatch(productName::equalsIgnoreCase);

            Assert.assertTrue(match, "Product " + productName + " should be in the cart.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred: " + e.getMessage());
        }
		
	}
}