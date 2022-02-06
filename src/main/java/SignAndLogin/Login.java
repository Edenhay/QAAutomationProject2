package SignAndLogin;

import Builder.Base;
import Builder.Reports;
import Builder.Singleton;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login extends Base {

    public static WebDriver driver;

    static {
        try {
            driver = Singleton.getDriverInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String REGISTER = "data-ember-action=\"990\";
    private static final String REGISTERBTN = "data-ember-action=\"1698\";
    private static final String FIRSTNAME = "ember1975";
    private static final String EMAIL = "ember1982";
    private static final String PASS = "valPass";
    private static final String PASSREPEAT = "ember1996";
    private static final String SIGNIN = "ember2002";
    private  static String MYNAME = "Eden";
    private static String MYEMAIL = "Edenhayute59@gmail.com";
    private static String MYPASS = "PASSWORD";
    private static String MYPASSREP = "PASSWORD";

    public void login() throws Exception {
        try {
            signInButtons();
            signInDetails();
            Reports.TakePicture();
            assertDetails();
        } catch (Exception e) {
            e.printStackTrace();
            Reports.test.log(Status.FAIL, "Some details are incorrect :( ");
            throw new Exception("Test Failed");
        }
    }

    private void signInButtons()  {
        driver.findElement(By.xpath(REGISTER)).click();
        driver.findElement(By.xpath(REGISTERBTN)).click();
    }

    private void signInDetails() throws Exception {
        sendKeysToElement(By.id(FIRSTNAME), MYNAME); ///enter name
        sendKeysToElement(By.id(EMAIL) , MYEMAIL); ///enter email
        sendKeysToElement(By.id(PASS) ,  MYPASS); ///enter pass
        sendKeysToElement(By.cssSelector(PASSREPEAT), MYPASSREP); ///enter pass again
    }

    private void assertDetails() throws Exception {
        Assert.assertEquals(driver.findElement(By.id(FIRSTNAME)).getAttribute("value"), MYNAME);   /// Assert Name
        Assert.assertEquals(driver.findElement(By.id(EMAIL)).getAttribute("value") , MYEMAIL);   /// Assert Email
        Assert.assertEquals(driver.findElement(By.id(PASS)).getAttribute("value") , MYPASS);    /// Assert Pass [doesnt work]
        Assert.assertEquals(driver.findElement(By.id(PASSREPEAT)).getAttribute("value") , MYPASSREP); /// Assert Repeat Pass [Doesnt Work]
        clickElement(By.className(SIGNIN));
        Reports.test.log(Status.PASS , "Home.Login Complete");
    }

}

