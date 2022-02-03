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

    private static final String MONYSELECT = "selected-text";
    private static final String MONEYSELECT = "ember1059";
    private static final String AREASELECT = "ember1070";
    private static final String NORTHSELECT = "ember1093";
    private static final String WHTTOBUY = "ember1101";
    private static final String SELECTBUY = "ember1153";
    private static final String CLICKSELECT = "ember1180";

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

        ClickToPresentScreen();
    }

    private static void homeScreenSelection() throws Exception {
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.className(MONYSELECT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(MONEYSELECT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(AREASELECT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(NORTHSELECT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(WHTTOBUY))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(SELECTBUY))).click();
    }

    private static void ClickToPresentScreen(){
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(CLICKSELECT))).click();
    }

}