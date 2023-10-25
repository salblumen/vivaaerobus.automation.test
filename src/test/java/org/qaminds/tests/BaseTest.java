package org.qaminds.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qaminds.utils.Screenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Slf4j
@Getter
public class BaseTest {
    private WebDriver driver;

@BeforeMethod
public void beforeMethod(){
    log.info("------------ Start Test {} --------------");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    driver.manage().window().maximize();

}

@AfterMethod
public void AfterMethod(){
    getDriver().quit();
}

public void navigateTo(String _url){
    String url = String.format("http://%s",_url);
    log.info("Opening {} website...", url);
    getDriver().get(url);

    if(!getDriver().getCurrentUrl().contains(_url)){
        log.error("Browser could not navigate to the requested Page: " + url, Screenshot.screenshot(getDriver()));
        throw new RuntimeException("Could not find: "+ url);
    }

}

}
