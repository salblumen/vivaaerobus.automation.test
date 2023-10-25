package org.qaminds.utils;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class WaitHelper {
    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementByWebElement(WebElement element, Duration timeout, Duration pollingInterval) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout)
                .pollingEvery(pollingInterval)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);  // Ignorar si el elemento está desactualizado

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element.isDisplayed() && element.isEnabled() ? element : null;
            }
        });
    }

    public WebElement waitForElementByBy(By locator /* By.id("id") */, Duration timeout /* El tiempo maximo que se va a esperar el elemento*/
            , Duration pollingInterval /* Cada que tiempo se va a revisar si el elemento se encuentra disponible*/) {
        // WebDriverWait X
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeout) // El tiempo maximo que va a esperar
                .pollingEvery(pollingInterval) // Cada que tiempo va a validar el elemento
                .ignoring(NoSuchElementException.class); // ignoramos excepciones

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }
}

