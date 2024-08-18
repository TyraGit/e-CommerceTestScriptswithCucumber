package stepDefinitions;

import org.openqa.selenium.By;

import athirahrahmat.Utils.BaseTest;
import athirahrahmat.Utils.CredentialPropertiesReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;

public class InvalidPasswordStepDefinition extends BaseTest {
	
	@Before //runs before each scenario and can be used to invoke the browser setup
    public void openBrowser() {
        if (driver == null) {
            invokeBrowser();  //initialize the browser if it's not already done
        }
    }
	
	@When("User login to application with incorrect password")
	public void user_login_to_application_with_incorrect_password() {
		
		CredentialPropertiesReader reader = new CredentialPropertiesReader("credentials.properties");
        String wrongUsername = reader.getProperty("username1");
        String wrongPassword = reader.getProperty("wrongPassword");

        driver.findElement(By.id("userEmail")).sendKeys(wrongUsername);
        driver.findElement(By.id("userPassword")).sendKeys(wrongPassword);
        driver.findElement(By.id("login")).click();
	}

}
