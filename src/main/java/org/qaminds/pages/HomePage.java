package org.qaminds.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(css = "app-flight-input > form > div > div:nth-child(1)")
    private WebElement inputOrigin;
    @FindBy(css = "app-flight-input > form > div > div:nth-child(1) input")
    private WebElement inputOrigin2;
    @FindBy(css = "div.input-section.secondary-section")
    private WebElement inputDestination;
    @FindBy(css = "div.input-section.secondary-section input")
    private WebElement inputDestination2;
    @FindBy(css = "div.promo-modal-header.bg-image.light > button")
    private WebElement initialPopUp;
    @FindBy(css = "div.col-lg-3.d-lg-none.d-block.ng-tns-c228-8 > button")
    private WebElement searchButton;

    public void closeInitialPopUp() {
        wait.until(ExpectedConditions.visibilityOf(initialPopUp));
        initialPopUp.click();
    }

    public void insertOriginName(String origin) {
        wait.until(ExpectedConditions.elementToBeClickable(inputOrigin));
        inputOrigin.click();
        inputOrigin2.sendKeys(origin);
        inputOrigin2.sendKeys(Keys.ENTER);
    }

    public void insertDestinationName(String destination) {
        wait.until(ExpectedConditions.elementToBeClickable(inputDestination));
        inputDestination.click();
        inputDestination2.sendKeys(destination);
        inputDestination2.sendKeys(Keys.ENTER);

    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }
}
