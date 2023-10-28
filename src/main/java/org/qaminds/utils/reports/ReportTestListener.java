package org.qaminds.utils.reports;

import lombok.extern.slf4j.Slf4j;
import org.qaminds.utils.ScreenshotHelpers;
import org.qaminds.utils.WebDriverConfiguration;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Clase que nos permite implementar la funcionalidad extendida con ITestListener
 */
@Slf4j
public class ReportTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("------------ Start Test {} --------------", result.getName());
    }


    public void onTestFailure(ITestResult result) {
        log.error("---------   Failed Test : {}  ------------", result.getName());
        ScreenshotHelpers.getScreenshot(WebDriverConfiguration.getDriver());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("---------   Successful Test : {}  ------------", result.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        log.info(" ---------- End Execution: {} ---------- ", context.getName());
    }
}

