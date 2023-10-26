package org.qaminds.utils;

import org.openqa.selenium.WebDriver;

public class WebDriverConfiguration {

    private static WebDriver driver;

    public WebDriverConfiguration(WebDriver driver){
        WebDriverConfiguration.driver = driver;
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
