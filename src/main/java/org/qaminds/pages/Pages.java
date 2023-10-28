package org.qaminds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.qaminds.utils.WebDriverConfiguration;

public class Pages {

    private static <T> T PagesFactory(WebDriver driver, Class<T> clazz){return PageFactory.initElements(driver,clazz);}

    public static HomePage returnHomePage(){
        return PagesFactory(WebDriverConfiguration.getDriver(), HomePage.class);
    }

    public static SelectFlightPage returnSelectFlightPage(WebDriver driver){
        return PagesFactory(driver, SelectFlightPage.class);
    }



}
