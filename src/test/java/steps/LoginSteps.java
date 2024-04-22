package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    private WebDriver driver;
    @Given("I am in the login page of the Para Bank Application")
    public void iAmInTheLoginPageOfTheParaBankApplication() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("tautester");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("username")).submit();
    }

    @Then("I should be taken to the Overview page")
    public void iShouldBeTakenToTheOverviewPage() throws InterruptedException {
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1")).isDisplayed();
        driver.findElement(By.linkText("Log Out"));
        driver.quit();
    }
}
