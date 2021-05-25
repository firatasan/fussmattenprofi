package pagedefs;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Locators;

import java.util.concurrent.TimeUnit;

public class loginSteps extends Locators {

    WebDriver driver;

    @Given("^navigate to fussmattenprofi$")
    public void navigate_to_fussmattenprofi(){

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Then("^open login page$")
    public void open_login_page() {


    }

    @When("enter email and password and click button")
    public void enterEmailAndPasswordAndClickButton(DataTable dataTable) {
    }

    @Then("^user should login succesfully$")
    public void user_should_login_succesfully()  {

    }



}
