package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import athirahrahmat.Utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitOrderStepDefinition extends BaseTest {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increased the wait time for better stability

	@Given("User checkout the product")
	public void user_checkout_the_product() {
		// Scroll to the checkout button
        WebElement checkoutButton = driver.findElement(By.cssSelector(".totalRow button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
        System.out.println("Scrolled to checkout button.");

        // Wait for any overlaying elements to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));

        // Wait until the checkout button is clickable and click it
        checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".totalRow button")));
        checkoutButton.click();
        System.out.println("Clicked checkout button.");
	}
	
	@When("User selects a country")
	public void user_selects_a_country() {
		 Actions action = new Actions(driver);

        // Enter the country name into the input field
        action.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "Mala").perform();

        // Wait for the dropdown to appear and then select the third item
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.cssSelector(".ta-item:nth-of-type(3)")).click();
	}
	
	@Then("Order is submitted")
	public void order_is_submitted() {
		
		 // Wait until the submit button is clickable
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));

        // Scroll the submit button into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

        // Click the submit button
        submitButton.click();

        // Verify the order confirmation message
        String orderConfirmedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary"))).getText();
        Assert.assertTrue(orderConfirmedMessage.equalsIgnoreCase("Thankyou for the order."));
	}

}
