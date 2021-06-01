package pagedefs;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import pages.LocatorsOfShop;

import java.util.concurrent.TimeUnit;

public class loginSteps {

    WebDriver driver;
    LocatorsOfShop lc=new LocatorsOfShop();


    @Given("^navigate to fussmattenprofi$")
    public void navigate_to_fussmattenprofi(){

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://fussmattenprofi.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }

    @Then("^open login page$")
    public void open_login_page() {

        //lc.cookiesAccept.click();
        //lc.loginPage.click();
        lc.findElementAndClick("cookiesAccept");
        lc.findElementAndClick("loginPage");

    }

    @When("enter email and password and click button")
    public void enterEmailAndPasswordAndClickButton(DataTable dataTable) {

        lc.findElementAndSendKeys("username", dataTable.asList().get(0));
        lc.findElementAndSendKeys("password", dataTable.asList().get(1));
        lc.findElementAndClick("loginButton");
    }

    @Then("^user should login succesfully$")
    public void user_should_login_succesfully()  {

        lc.findElementAndVerifyText("meinKonto","Mein Konto");

    }

    @After
    public void afterScenario(){
       //driver.quit();
    }


}
