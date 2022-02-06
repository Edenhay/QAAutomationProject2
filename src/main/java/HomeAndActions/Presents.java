package HomeAndActions;

import Builder.Base;
import Builder.Reports;
import Builder.Singleton;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Presents extends Base {
    private static final String PAGEURL = "https://buyme.co.il/search?budget=3&category=204&modal=login&region=9";
    private static final String GOLFANDCO = "ember2947";
    private static final String GIFTCARDAMOUNT = "ember3081";
    private static final String CHOOSE = "ember3087";
    private static WebDriver driver;

    static {
        try {
            driver = Singleton.getDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PresentChoice() throws Exception {
        try {
            getUrl();
            Reports.test.log(Status.PASS, "Present Screen: Details entered successfully ");
        } catch (Exception e) {
            e.printStackTrace();
            Reports.test.log(Status.FAIL, "Present Screen: Some details are incorrect ");
            throw new Exception("Test Failed");
        }
    }

    private static void getUrl() throws Exception {
        String pageUrl = driver.getCurrentUrl();
        Assert.assertEquals(pageUrl, PAGEURL);
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(GIFTCARDAMOUNT))).click();
        Reports.TakePicture();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(GiftCard))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(CHOOSE))).click();
    }
}
