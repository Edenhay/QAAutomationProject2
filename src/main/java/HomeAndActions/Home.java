package HomeAndActions;

import Builder.Base;
import Builder.Reports;
import Builder.Singleton;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home extends Base {

    public static WebDriver driver;

    static {
        try {
            driver = Singleton.getDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String PRICESELECT = "ember2135";
    private static final String AMOUNTCHOICE = "ember2146";
    private static final String AREASELECT = "ember2152";
    private static final String SOUTHSELECT = "ember2168";
    private static final String CATEGORYSELECT = "ember2175";
    private static final String FAVORITES = "ember2199";
    private static final String FINDMESELECT = "ember2221";

    public  void HomeChoice() throws Exception {

        try {
            homeScreenSelection();
            Reports.TakePicture();
            Reports.test.log(Status.PASS, "Home Actions Screen:" + "  " + "Details entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Reports.test.log(Status.FAIL, "Home Actions Screen:" + "  " +"Some details are incorrect :( ");
            throw new Exception("Test Failed");
        }

        ClickFindMeAGift();
    }

    private static void homeScreenSelection() throws Exception {
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(PRICESELECT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(AMOUNTCHOICE))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(AREASELECT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(SOUTHSELECT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(CATEGORYSELECT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(FAVORITES))).click();
    }

    private static void ClickFindMeAGift(){
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(FINDMESELECT))).click();
    }

}
