package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import athirahrahmat.Utils.BaseTest;
import io.cucumber.java.en.Given;

public class LogoutStepDefinition extends BaseTest {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@Given("User is able to see the Sign Out button and clicks on the Sign Out button")
	public void user_able_to_click_SignOut_button() throws InterruptedException {
		
		WebElement signOutButton = driver.findElement(By.xpath("//button[normalize-space()='Sign Out']"));
		
		// Scroll the button into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", signOutButton);
        
        Thread.sleep(2000);
		
        signOutButton.click();
	}
}