import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Slf4j
@Getter
public class BaseTest {
    private WebDriver driver;

@BeforeMethod
public void beforeMethod(){
    log.info("------------ Start Test {} --------------");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    driver.manage().window().maximize();

}

@AfterMethod
public void AfterMethod(){
    getDriver().quit();
}

public void navigateTo(String _url){
    String url = String.format("http://%s",_url);
    log.info("Opening {} website...", url);
    getDriver().get(url);
}

}
