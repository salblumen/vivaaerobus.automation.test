import lombok.extern.slf4j.Slf4j;
import org.qaminds.Pages;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;



@Slf4j
public class HomePageTest extends BaseTest{

    private String baseUrl = "vivaaerobus.com";

    @Test
    public void ValidateHomePageLoads(){
        log.info("Navigate to vivaaerobus.com");
        navigateTo(baseUrl);
        String actualTitle = "Viva Aerobus";
        assertThat(getDriver().getTitle()).contains(actualTitle);
//        Screenshot.screenshot(getDriver());
        log.info(" Test 1001 ----- SUCCESSFUL -------");

    }



    @Test(testName = "Reserve a round trip", enabled = false)
    public void validateRoundTripReservationFlow(){
        log.info("Step 1: Navigate to vivaaerobus.com");
        navigateTo("vivaaerobus.com");

        log.info("Step 2: Close initial Popup");
        Pages.returnHomePage(getDriver()).closeInitialPopUp();

        log.info("Step 3: insert origin place");
        Pages.returnHomePage(getDriver()).insertOriginName("mexico");

        log.info("Step 4: insert destination place");
        Pages.returnHomePage(getDriver()).insertDestinationName("guadalajara");

        log.info("Step 5: Select departure date");

        log.info("Step 6: Select return date");

        log.info("Step 7: Select Fligth");

        log.info("Step 8:Select Options ");

        log.info("Step 9: Get FLight quotation");



    }





}
