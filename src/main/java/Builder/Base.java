package Builder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Base {
    public static void clickElement(By locator) throws Exception {
        getWebElement(locator).click();
    }

    public static void sendKeysToElement(By locator, String text) throws Exception {
        getWebElement(locator).sendKeys(text);
    }

    private static WebElement getWebElement(By locator) throws Exception {
        return Singleton.getDriverInstance().findElement(locator);
    }



}