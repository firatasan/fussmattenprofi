package pagedefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Driver;
import pages.LocatorsOfShop;

import java.util.concurrent.TimeUnit;

public class shopSteps {

    WebDriver driver;
    LocatorsOfShop lc=new LocatorsOfShop();


    @Given("navigate to shop")
    public void navigateToShop() {

        driver = Driver.getDriver();

       // driver.manage().window().maximize();
      //  driver.get("https://fussmattenprofi.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);



        lc.findElementAndClick("fussmatten");


    }

    @When("select random trademark from all")
    public void selectRandomTrademarkFromAll() {


        lc.findAllElementsAndClickRandomly(lc.tradeMarks);

    }

    @Then("all products should be come from same trademark")
    public void allProductsShouldBeComeFromSameTrademark() {


        lc.verifyListElementsWithName(lc.productsList);


    }

    @When("select a product from a trademark")
    public void selectAProductFromATrademark() {


        lc.findAllElementsAndClickRandomly(lc.inDenWarenkorpButtons);

    }


    @Then("product should be added succesfully")
    public void productShouldBeAddedSuccesfully() {

        Assert.assertTrue(lc.successMessage.isDisplayed());

    }

    @Given("navigate to Chart")
    public void navigateToChart() {

        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


        lc.findElementAndClick("chartIcon");
    }

    @Then("user can change quantity of item")
    public void userCanChangeQuantityOfItem() {


        String urunAdetStr= lc.anzahl.getAttribute("value");
        int urunAdet = Integer.parseInt(urunAdetStr);

        System.out.println("??lk ba??taki ??r??n say??s?? = " + urunAdet );

        //lc.findElementAndSendKeys("anzahl", "2");
        lc.anzahl.clear();
        lc.anzahl.sendKeys("2");
        lc.findElementAndClick("warenkorbAktualisieren");

        String yeniUrunAdetStr= lc.anzahl.getAttribute("value");
        int yeniUrunAdet = Integer.parseInt(yeniUrunAdetStr);

        System.out.println("Sonradan ??r??n say??s?? = " + yeniUrunAdet );

        Assert.assertTrue(urunAdet!=yeniUrunAdet);

    }

    @When("user select quantity of item prise should be correct")
    public void userSelectQuantityOfItemPriseShouldBeCorrect() {


        // Sleep koymazsak site fiyatlar?? g??ncellemekte yava?? kal??yor.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String urunAdetStr= lc.anzahl.getAttribute("value");
        int urunAdet = Integer.parseInt(urunAdetStr);

        System.out.println("??r??n Say??s?? : " + urunAdet);

        String str1top = lc.Gesamtsumme.getText().substring(0,(lc.Gesamtsumme.getText().length()-4))+ "." +
                lc.Gesamtsumme.getText().substring((lc.Gesamtsumme.getText().length()-3),(lc.Gesamtsumme.getText().length()-1));
        double toplamSite1 = Double.parseDouble(str1top);

        String str2top = lc.zwischensumme.getText().substring(0,(lc.zwischensumme.getText().length()-4))+ "." +
                lc.zwischensumme.getText().substring((lc.zwischensumme.getText().length()-3),(lc.zwischensumme.getText().length()-1));
        double toplamSite2= Double.parseDouble(str2top);


        System.out.println("Sitede G??z??ken Fiyat 1. Blogu: " + toplamSite1);
        System.out.println("Sitede G??z??ken Fiyat 2. Blogu: " + toplamSite2);

        Assert.assertTrue(toplamSite1==toplamSite2);

        String strPries = lc.preis.getText().substring(0,(lc.preis.getText().length()-4))+ "." +
                lc.preis.getText().substring((lc.preis.getText().length()-3),(lc.preis.getText().length()-1));

        double olmasiGerekenFiyat = Double.parseDouble(strPries) * urunAdet;

        System.out.println("Olmas?? gereken hesaplanm???? F??yat : " + olmasiGerekenFiyat);

        Assert.assertTrue(olmasiGerekenFiyat==toplamSite1);

    }

    @When("select a random product name from ModelFilter")
    public void selectARandomProductNameFromModelFilter() {

        lc.findElementAndClick("modell");
        String filterlanacakEleman;
        WebElement secimEleman;

        int elemanSayimiz = lc.modelFilterElements.size();
        int randomSayi = ((int) (Math.random()*(elemanSayimiz-1))+1);
        filterlanacakEleman = lc.modelFilterElements.get(randomSayi).getText();
        secimEleman = lc.modelFilterElements.get(randomSayi);
        System.out.println(filterlanacakEleman);
        secimEleman.click();

    }

    @Then("products should be came from same selected category")
    public void productsShouldBeCameFromSameSelectedCategory() {
    }
}
