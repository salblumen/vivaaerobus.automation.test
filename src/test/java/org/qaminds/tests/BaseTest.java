package org.qaminds.tests;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qaminds.utils.ScreenshotHelpers;
import org.qaminds.utils.reports.ReportTestListener;
import org.qaminds.utils.WebDriverConfiguration;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;

/**
 * Clase base para configurar el entorno de la prueba
 *
 * @author sblumen
 */
@Slf4j
@Getter
@Listeners(ReportTestListener.class)
public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        WebDriverConfiguration.setup(new ChromeDriver());
        WebDriverConfiguration.getDriver().manage().window().maximize();
        ScreenshotHelpers.setup();
    }

    @AfterMethod
    public void AfterMethod(ITestResult testResult) {
        WebDriverConfiguration.getDriver().quit();

    }

    /**
     * Este metodo permite navegar a la url que recibe de parametro, en caso que no se pueda navegar mandará una excepción
     *
     * @param _url path of the website without 'http://'
     */
    public void navigateTo(String _url) {
        String url = String.format("http://%s", _url);

        log.info("Opening {} website...", url);
        WebDriverConfiguration.getDriver().get(url);

        if (!WebDriverConfiguration.getDriver().getCurrentUrl().contains(_url)) {
            log.error("Browser could not navigate to the requested Page: " + url);
            throw new RuntimeException("Could not find: " + url);
        }

    }

}
