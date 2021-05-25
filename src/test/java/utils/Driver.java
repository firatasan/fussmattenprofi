package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;


    public static WebDriver getDriver(){

        if (driver == null){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
        }

        return driver;
    }

    public static void quitDriver(){

        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
