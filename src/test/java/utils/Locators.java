package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages._Parent;

import java.util.List;

public class Locators extends _Parent{

    public Locators (WebDriver driver){ PageFactory.initElements(driver, this); }

    WebElement myElement;
    String secilenEleman;

    @FindBy (css = "button[aria-label='Akzeptiere alle']") public WebElement cookiesAccept;

    //Header Elements

    //                //span[text()='Login & Registrieren']    : contains daha iyi oldugunu dusunuyorum
    @FindBy (xpath = "//span[contains(text(),'Login & Registrieren')]") public WebElement loginPage;
    @FindBy (xpath = "//span[text()='Fußmatten']") public WebElement fussmatten;
    @FindBy (xpath = "//*[@class='wc-forward']") public WebElement chartIcon;

    // Body Elements

    @FindBy (id = "username") public WebElement username;
    @FindBy (id = "password") public WebElement password;
    @FindBy (name = "login") public WebElement loginButton;
    @FindBy (css = "#Subheader > div > div > h1") public WebElement meinKonto;
    //@FindBy (className = "scale-with-grid") public List<WebElement> tradeMarks;
    @FindBy (xpath = "//*[@id='Content']//img") public List<WebElement> tradeMarks;
    // yukarıdakini değiştirip //*[@id="Content"]//img xpath yap.
    @FindBy (xpath = "//*[@id='Content']//div[@class='desc']//a") public List<WebElement> productsList;
    @FindBy (xpath = "//*[@id='Subheader']//h1") public WebElement productTitle;
    @FindBy (linkText = "In den Warenkorb") public List<WebElement> inDenWarenkorpButtons;
    @FindBy (xpath = "//*[@class='woocommerce-message alert alert_success']") public WebElement successMessage;
    @FindBy (xpath = "//td[@class='product-quantity']//input") public WebElement anzahl;
    @FindBy (xpath = "//td[@class='product-price']//bdi") public WebElement preis;
    @FindBy (xpath = "//td[@class='product-subtotal']//bdi") public WebElement Gesamtsumme;
    @FindBy (xpath = "//tr[@class='cart-subtotal']//bdi") public WebElement zwischensumme;
    @FindBy (name = "update_cart") public WebElement warenkorbAktualisieren;


    // Footer Elements


    public void findElementAndClick(String elementName){

        switch (elementName){
            case "cookiesAccept": myElement=cookiesAccept; break;
            case "loginPage": myElement=loginPage; break;
            case "loginButton": myElement=loginButton; break;
            case "fussmatten": myElement=fussmatten; break;
            case "chartIcon": myElement=chartIcon; break;
            case "warenkorbAktualisieren": myElement=warenkorbAktualisieren; break;
        }

        clickFunction(myElement);
    }

    public void findElementAndSendKeys(String elementName, String value){

        switch (elementName){
            case "username": myElement=username; break;
            case "password": myElement=password; break;
        }

        sendKeysFunction(myElement, value);
    }


    public void findElementAndVerifyText (String elementName, String text) {

        switch (elementName){
            case "meinKonto": myElement=meinKonto; break;
            case "anzahl": myElement=anzahl; break;
        }

        verifyElementsText(myElement,text);
    }

    public void findAllElementsAndClickRandomly (List<WebElement> liste){

        int listeSize = liste.size();

//        for (int i = 0; i <liste.size() ; i++) {
//           System.out.println(i +  ". eleman");
//           System.out.println(liste.get(i).getAttribute("alt"));
//        }

        // 33 liste size oldugu için 32 aldım ve ilk eleman dışındaki elemanları alması gerektiği için +1
        // eklendi 0 eleman listede olmaması gereken bir eleman

        int randomSayi = ((int) (Math.random()*listeSize));

        //System.out.println("Rastgele sayi = " + randomSayi);
        //System.out.println("rastgele gelen Eleman = " + randomSayi + ".eleman " + liste.get(randomSayi).getAttribute("alt"));

        secilenEleman = liste.get(randomSayi).getAttribute("alt");

        clickFunction(liste.get(randomSayi));

    }

    public void verifyListElementsWithName (List<WebElement> liste){

        String secim;
        secim =productTitle.getText();

    secilenEleman=null;
        String[] arrSplit = secim.split(" ");
        for (int i = 0; i < 1; i++) {
            secilenEleman=arrSplit[i];
            System.out.println(secilenEleman);
        }

        if (liste!=null) {
            for (int i = 0; i < liste.size(); i++) {
//                System.out.println(i + ". eleman");
//                System.out.println(liste.get(i).getText());

                Assert.assertTrue(liste.get(i).getText().contains(secilenEleman));
            }
        }



    }



}
