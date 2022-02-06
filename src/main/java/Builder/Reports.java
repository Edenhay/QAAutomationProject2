package Builder;

import com.aventstack.extentreports.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

\\\Creating Logs and Screenshots

public class Reports {

    public static ExtentReports extent;
    public static ExtentTest test;

    public static void beforeClass() throws Exception {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\Builder.Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("SecondQAProject", "Second QA Project - Selenium");
        test.log(Status.INFO, "@Before class");
    }

    public static String takeScreenShot(String ImagesPath) throws Exception {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Singleton.getDriverInstance();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }

    public static  void TakePicture() throws Exception {
        String timeNow = String.valueOf(System.currentTimeMillis());
        test.pass("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        takeScreenShot(timeNow);
    }

}
