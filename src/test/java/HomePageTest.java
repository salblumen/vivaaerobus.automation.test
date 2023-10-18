import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.qaminds.HomePage;
import org.qaminds.Pages;
import org.testng.annotations.Test;

@Slf4j
public class HomePageTest extends BaseTest{

    @Test(testName = "Reserve a round trip")
    public void validateRoundTripReservationFlow(){
        log.info("Step 1: Navigate to vivaaerobus.com");
        navigateTo("vivaaerobus.com");

        log.info("Step 2: Close initial Popup");
        Pages.returnHomePage(getDriver()).closeInitialPopUp();

        log.info("insert origin place");
        Pages.returnHomePage(getDriver()).insertOriginName("mexico");

        log.info("insert destination place");
        Pages.returnHomePage(getDriver()).insertDestinationName("guadalajara");




    }





}
