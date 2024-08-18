package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import athirahrahmat.Utils.BaseTest;
import athirahrahmat.Utils.CredentialPropertiesReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidUsernameStepDefinition extends BaseTest {
	
	@Before //runs before each scenario and can be used to invoke the browser setup
    public void openBrowser() {
        if (driver == null) {
            invokeBrowser();  //initialize the browser if it's not already done
        }
    }

	@Given("User is on landing page")
    public void user_on_landing_page() {
        driver.get(url);
        
    }
	
	@When("User login to application with incorrect username")
	public void user_login_to_application_with_incorrect_username() {
		
		CredentialPropertiesReader reader = new CredentialPropertiesReader("credentials.properties");
        String wrongUsername = reader.getProperty("wrongUsername1");
        String password = reader.getProperty("password1");

        driver.findElement(By.id("userEmail")).sendKeys(wrongUsername);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.id("login")).click();
		
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

}
