package Builder;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Singleton {
    private static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver getDriverInstance() throws Exception {

        if (driver == null) {
            Reports.beforeClass();

            try {
                System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
                wait = new WebDriverWait(Singleton.getDriverInstance(), Duration.ofSeconds(10));
                Reports.test.log(Status.PASS, "Driver established successfully");
                driver.get(Constant.BUYME_URL);
                driver.manage().window().maximize();

            } catch (Exception e) {
                e.printStackTrace();
                Reports.test.log(Status.FAIL, "Failed to establish Driver" + e.getMessage());
                throw new Exception("Driver failed");
            }
        }
        return driver;
    }
}
