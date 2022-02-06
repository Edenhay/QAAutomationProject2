package HomeAndActions;

import Builder.Reports;
import Builder.Singleton;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Sending extends Builder.Base {
    private static final String SOMEONEELSE = "ember3208"
    private static final String NAME = "ember3212";
    private static final String THISNAME = "Daniel Gotlib";
    private static final String FORWHATEVENT = "ember3273";
    private static final String THANKYOU = "ember3308";
    private static final String CLEARFIELD = "textarea-clear-all";
    private static final String BLESSING = "ember3223";
    private static final String THISBLESSING = "THANKS! ";
    private static final String UPLOADPHOTH = "ember3231";
    private static final String FILEPATH = "C:\\Users\\עדן ח\\IdeaProjects\\Project\\src\\main\\java\\PICTURE.jpg";
    private static final String PROCEDTOPAYMENT  = "ember3233";
    private static final String NOWCHECK = "ember3339";
    private static final String PICKEMAIL = "ember3348";
    private static final String SENDKEYSEMAIL = "email";
    private static final String WHATEMAIL = "Edenhayute@gmail.com";
    private static final String SENDERNAMEELEMENT = "ember2316";
    private static final String SENDERNAME = "Eden Hayute";
    private static final String ENDPROJECTCLICK = "ember2321";

    public static WebDriver driver;

    static {
        try {
            driver = Singleton.getDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SendAGift() throws Exception {
        try {
            FillDetails();
            UploadFile();
            ClickProceedButton();
            SenderDetails();
            Reports.test.log(Status.PASS , "Send Gift Screen:"+ "  "+"Details entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Reports.test.log(Status.FAIL, "Send Gift Screen:"+ "  "+"Some details are incorrect :( ");
            throw new Exception("Test Faild");
        }
    }

    private static void FillDetails(){
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(SOMEONEELSE))).click();
        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(NAME))).sendKeys(THISNAME);
        Assert.assertEquals(driver.findElement(By.id(NAME)).getAttribute("value"), THISNAME);
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(FORWHATEVENT))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(THANKYOU))).click();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.className(CLEARFIELD))).click();
        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BLESSING))).sendKeys(THISBLESSING);
    }

    private static void UploadFile() throws Exception {
        WebElement fileUpload = driver.findElement(By.id(UPLOADPHOTH));
        fileUpload.sendKeys(FILEPATH);
        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gift-step-1 > div.grid.pin-end.no-gap.top-xl > div.mx-12.top-md > div.grid.no-gap.bm-media-section > div.mx-auto.top-lr.bm-media-upload-thumbnail > div")));
        Reports.TakePicture();
    }

    private static void ClickProceedButton(){
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(PROCEDTOPAYMENT))).click();
    }

    private static void SenderDetails() throws Exception {
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(NOWCHECK))).click();NOWCHECK
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(PICKEMAIL))).click();
        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SENDKEYSEMAIL))).sendKeys(WHATEMAIL);
        Singleton.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SENDERNAMEELEMENT))).sendKeys(SENDERNAME);
        Assert.assertEquals(driver.findElement(By.id(SENDERNAMEELEMENT) ).getAttribute("value") , SENDERNAME);
        Reports.TakePicture();
        Singleton.wait.until(ExpectedConditions.elementToBeClickable(By.id(ENDPROJECTCLICK))).click();
    }
}
