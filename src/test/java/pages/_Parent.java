package pages;

import org.openqa.selenium.JavascriptException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public class _Parent {

    WebDriver driver;
    WebDriverWait wait;

    public _Parent() {

        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public void clickFunc(WebElement element){

        scrollToElementFunc(element);
        waitUntilClickable(element);
        element.click();
    }

    public void sendKeysFunc(WebElement element){
        scrollToElementFunc(element);
        waitUntilVisible(element);
        element.clear();
        element.sendKeys();
    }

    public void waitUntilClickable(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElementFunc(WebElement element){

        // Bu kısmı hazır olarak aldım
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView():", element);

    }


}
