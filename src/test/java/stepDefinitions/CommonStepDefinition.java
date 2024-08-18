package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import athirahrahmat.Utils.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepDefinition extends BaseTest {

//this class is to reuse steps that are common instead of renaming them
//this class can have multiple Given, When and Then
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@Given("User is on landing page")
    public void user_on_landing_page() {
        driver.get(url);
        
    }
	
	@Then("Error message toaster should display")
	public void error_toaster_should_display() {
		
		// Add explicit wait for the error message to be displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorToaster = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-error")));
        String errorMessage = errorToaster.getText();
        System.out.println("Toaster message: " + errorMessage);
        
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userPassword")).clear();
		
	}
	
	@Then("User is on the Landing page again and browser should quit")
	public void user_logged_out_and_browser_quit(){
		
        WebElement loginPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-title")));
		
        Assert.assertTrue(loginPageElement.isDisplayed(), "User should be redirected to the landing page after logout.");
        System.out.println("Logout is successful");
        
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        System.out.println("Browser closed.");
		
	}

}
