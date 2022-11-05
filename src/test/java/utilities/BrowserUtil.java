package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.Locale;

public class BrowserUtil {
    public static void refreshment() {
        Driver.getDriver().navigate().refresh();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    public static String createEmail() {
        //  Faker faker = new Faker();
        //String email = faker.name().firstName().toLowerCase(Locale.ROOT) + "@mail.com";
        String email2 ="barip.test@inbox.testmail.app";
        return email2;
    }

    public static void clickByObject (By byLocator){
        Driver.getDriver().findElement(byLocator).click();
    }

    public static void sendKeyByLocator (By byLocator, String keys){
        Driver.getDriver().findElement(byLocator).sendKeys(keys);
    }


}
