package org.qaminds.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qaminds.utils.ScreenshotHelpers;
import org.qaminds.utils.TestListener;
import org.qaminds.utils.WebDriverConfiguration;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;

@Slf4j
@Getter
@Listeners(TestListener.class)
public class BaseTest {
    private ScreenshotHelpers screenshotHelpers;


@BeforeMethod
public void beforeMethod(Method method){
    WebDriverManager.chromedriver().setup();
    new WebDriverConfiguration(new ChromeDriver());
    new ScreenshotHelpers();
    WebDriverConfiguration.getDriver().manage().window().maximize();
}

@AfterMethod
public void AfterMethod(ITestResult testResult){
    WebDriverConfiguration.getDriver().quit();

}

public void navigateTo(String _url){
    String url = String.format("http://%s",_url);
    log.info("Opening {} website...", url);
    WebDriverConfiguration.getDriver().get(url);

    if(!WebDriverConfiguration.getDriver().getCurrentUrl().contains(_url)){
        log.error("Browser could not navigate to the requested Page: " + url);
//        log.error("Browser could not navigate to the requested Page: " + url, screenshotHelpers.screenshot(getDriver()));
        throw new RuntimeException("Could not find: "+ url);
    }

}

}
