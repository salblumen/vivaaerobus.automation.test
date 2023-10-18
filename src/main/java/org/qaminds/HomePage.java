package org.qaminds;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(id="flight-search-origin")
    private WebElement inputOrigin;

    @FindBy(id="flight-search-destination")
    private WebElement inputDestination;

    @FindBy(css = "div.promo-modal-header.bg-image.light > button")
    private WebElement initialPopUp;

    @FindBy(css = "div.col-lg-3.d-lg-none.d-block.ng-tns-c228-8 > button")
    private WebElement searchButton;


    public void closeInitialPopUp(){
        wait.until(ExpectedConditions.visibilityOf(initialPopUp));
        initialPopUp.click();
    }

    public void insertOriginName(String origin){
        wait.until(ExpectedConditions.visibilityOf(inputOrigin));
        inputOrigin.click();
        inputOrigin.sendKeys(origin);
        inputOrigin.sendKeys(Keys.ENTER);
    }


    public void insertDestinationName(String destination){
        wait.until(ExpectedConditions.visibilityOf(inputDestination));
        inputDestination.click();
        inputDestination.sendKeys(destination);
        inputDestination.sendKeys(Keys.ENTER);

    }

    public void clickSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }







}
