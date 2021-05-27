package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface Locators4Selenide {

    String url = "https://fussmattenprofi.com";

    By cookiesAccept = By.cssSelector("button[aria-label='Akzeptiere alle']");

    //Header Elements

    By loginPage = By.xpath("//span[text()='Login & Registrieren']");


    // Body Elements

    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.name("login");
    By meinKonto = By.cssSelector("#Subheader > div > div > h1");






}
