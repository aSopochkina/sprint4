package spaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitWebDriver {
    private static final String PRACTICUM_SERVICE = "https://qa-scooter.praktikum-services.ru/";

    public static WebDriver get(String nameBrowser) {
        WebDriver driver;
        switch (nameBrowser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser" + nameBrowser + " not exist");
        }

        driver.manage().window().maximize();
        driver.navigate().to(PRACTICUM_SERVICE);

        return driver;
    }
}

