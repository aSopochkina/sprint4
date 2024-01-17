import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import spaces.InitWebDriver;

public class Utils {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = InitWebDriver.get("chrome");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
