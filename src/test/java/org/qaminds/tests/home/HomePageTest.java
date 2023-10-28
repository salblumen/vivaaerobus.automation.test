package org.qaminds.tests.home;

import lombok.extern.slf4j.Slf4j;
import org.qaminds.pages.Pages;
import org.qaminds.tests.BaseTest;
import org.qaminds.utils.WebDriverConfiguration;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class HomePageTest extends BaseTest {

    private String baseUrl = "vivaaerobus.com"; // Esto lo puedes configurar en un archivo properties

    @Test(testName = "TC-1001 ValidateHomePageLoads", priority = 1)
    public void ValidateHomePageLoads(){
        log.info("Step 1: Navigate to vivaaerobus.com");
        navigateTo(baseUrl);

        log.info("Step 2: Validate the title of the page");
        String actualTitle = "Viva Aerobus";
        assertThat(WebDriverConfiguration.getDriver().getTitle()).as("The expected title was not found").contains(actualTitle);
    }

    @Test(testName = "TC-1002 ValidateValidInputsOriginDestinationWorks", priority = 1, enabled = false)
    public void ValidateValidInputsOriginDestinationWorks(){
        log.info("Navigate to vivaaerobus.com");
        navigateTo(baseUrl);
        String actualTitle = "Viva Aerobus";
        assertThat(WebDriverConfiguration.getDriver().getTitle()).contains(actualTitle);
        log.info(" Test 1002 ----- SUCCESSFUL -------");

    }

    @Test(testName = "Reserve a round trip", enabled = false)
    public void validateRoundTripReservationFlow(){
        log.info("Step 1: Navigate to vivaaerobus.com");
        navigateTo("vivaaerobus.com");

        log.info("Step 2: Close initial Popup");
        Pages.returnHomePage().closeInitialPopUp();

        log.info("Step 3: insert origin place");
        Pages.returnHomePage().insertOriginName("mexico");

        log.info("Step 4: insert destination place");
        Pages.returnHomePage().insertDestinationName("guadalajara");

        log.info("Step 5: Select departure date");

        log.info("Step 6: Select return date");

        log.info("Step 7: Select Fligth");

        log.info("Step 8:Select Options ");

        log.info("Step 9: Get FLight quotation");
    }
}
