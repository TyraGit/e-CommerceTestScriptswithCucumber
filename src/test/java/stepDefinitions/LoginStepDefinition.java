package stepDefinitions;

import org.openqa.selenium.By;

import athirahrahmat.Utils.BaseTest;
import athirahrahmat.Utils.CredentialPropertiesReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends BaseTest {
	
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

    @When("User login to application with correct credential")
    public void user_login_application_with_correct_credential() {
    	
    	CredentialPropertiesReader reader = new CredentialPropertiesReader("credentials.properties");
        String username = reader.getProperty("username2");
        String password = reader.getProperty("password2");

        driver.findElement(By.id("userEmail")).sendKeys(username);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        
        driver.findElement(By.id("login")).click();
    }
    
    @Then("User should be on the Home page")
    public void user_should_be_on_Homepage() {
    	System.out.println(driver.getTitle());
    }

}