import Builder.*;
import SignAndLogin.Login;
import HomeAndActions.*;
import org.testng.annotations.*;

public class Run {

    @BeforeClass
    public static void beforeAll() throws Exception {
        Singleton.getDriverInstance();
    }

    @Test
    public static void loginPage() throws Exception {
    Login loginPage = new Login();
    loginPage.login();
    }

    @Test
    public static void homeScreen() throws Exception {
        Home choice = new Home();
        choice.HomeChoice();
    }

    @Test
    public static void presentScreen() throws Exception {
        Presents present = new Presents();
        present.PresentChoice();
    }

    @Test
    public static void sendDetails() throws Exception {
        Sending sendGiftDetails = new Sending();
        sendGiftDetails.SendAGift();
    }

    @AfterClass
    public static void ProjectEnd() throws Exception {
        Reports.extent.flush();
        Singleton.getDriverInstance().quit();
    }
}
