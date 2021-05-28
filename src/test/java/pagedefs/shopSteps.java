package pagedefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

        Locators lc=new Locators(driver);
        lc.verifyListElementsWithName(lc.productsList);


    }

    @When("select a product from a trademark")
    public void selectAProductFromATrademark() {

        Locators lc=new Locators(driver);
        lc.findAllElementsAndClickRandomly(lc.inDenWarenkorpButtons);

    }


    @Then("product should be added succesfully")
    public void productShouldBeAddedSuccesfully() {
        Locators lc=new Locators(driver);
        Assert.assertTrue(lc.successMessage.isDisplayed());

    }

    @Given("navigate to Chart")
    public void navigateToChart() {

        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Locators lc=new Locators(driver);
        lc.findElementAndClick("chartIcon");
    }

    @Then("user can change quantity of item")
    public void userCanChangeQuantityOfItem() {
        Locators lc=new Locators(driver);

        String urunAdetStr= lc.anzahl.getAttribute("value");
        int urunAdet = Integer.parseInt(urunAdetStr);

        System.out.println("İlk baştaki ürün sayısı = " + urunAdet );

        //lc.findElementAndSendKeys("anzahl", "2");
        lc.anzahl.clear();
        lc.anzahl.sendKeys("2");
        lc.findElementAndClick("warenkorbAktualisieren");

        String yeniUrunAdetStr= lc.anzahl.getAttribute("value");
        int yeniUrunAdet = Integer.parseInt(yeniUrunAdetStr);

        System.out.println("Sonradan ürün sayısı = " + yeniUrunAdet );

        Assert.assertTrue(urunAdet!=yeniUrunAdet);

    }

    @When("user select quantity of item prise should be correct")
    public void userSelectQuantityOfItemPriseShouldBeCorrect() {
        Locators lc=new Locators(driver);

        String urunAdetStr= lc.anzahl.getAttribute("value");
        int urunAdet = Integer.parseInt(urunAdetStr);

        int toplamSite1= Integer.parseInt(lc.Gesamtsumme.getText());
        int toplamSite2= Integer.parseInt(lc.zwischensumme.getText());

        Assert.assertTrue(toplamSite1==toplamSite2);

        int olmasiGerekenFiyat = urunAdet * Integer.parseInt(lc.preis.getText());

        Assert.assertTrue(olmasiGerekenFiyat==toplamSite1);

    }
}
