package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
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

    // Body Elements

    @FindBy (id = "username") public WebElement username;
    @FindBy (id = "password") public WebElement password;
    @FindBy (name = "login") public WebElement loginButton;
    @FindBy (css = "#Subheader > div > div > h1") public WebElement meinKonto;
    @FindBy (className = "scale-with-grid") public List<WebElement> tradeMarks;

    // Footer Elements


    public void findElementAndClick(String elementName){

        switch (elementName){
            case "cookiesAccept": myElement=cookiesAccept; break;
            case "loginPage": myElement=loginPage; break;
            case "loginButton": myElement=loginButton; break;
            case "fussmatten": myElement=fussmatten; break;
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
        }

        verifyElementsText(myElement,text);
    }

    public void findAllElementsAndClickRandomly (List<WebElement> liste){



        for (int i = 0; i <liste.size() ; i++) {
            System.out.println(liste.get(i).getText());
        }

        int randomSayi = ((int) (Math.random()*32)) +1;

        System.out.println("Rastgele sayi = " + randomSayi);
        System.out.println("rastgele gelen Eleman = " + randomSayi + ".eleman " + liste.get(randomSayi).getText());

        secilenEleman = liste.get(randomSayi).getText();

        clickFunction(liste.get(randomSayi));

    }



}
