package pagedefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Locators;

import java.util.concurrent.TimeUnit;

public class shopSteps {

    WebDriver driver;

    @Given("navigate to shop")
    public void navigateToShop() {

        driver = Driver.getDriver();

       // driver.manage().window().maximize();
      //  driver.get("https://fussmattenprofi.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


        Locators lc=new Locators(driver);
        lc.findElementAndClick("fussmatten");


    }

    @When("select random trademark from all")
    public void selectRandomTrademarkFromAll() {
        Locators lc=new Locators(driver);

        lc.findAllElementsAndClickRandomly(lc.tradeMarks);

    }

    @Then("all products should be come from same trademark")
    public void allProductsShouldBeComeFromSameTrademark() {
    }

    @When("select a product from a trademark")
    public void selectAProductFromATrademark() {
    }

    @Then("product should be same with selected product")
    public void productShouldBeSameWithSelectedProduct() {
    }
}
