package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {

    public static By bySearchInputBox = By.id("ooui-php-1");
    public static By bySearchButton = By.xpath("//button[.='Search']");
    public static By byResult = By.xpath("//span[@class='searchmatch']");

    public static By bySoleTraderRadioButton = By.id("register_account_type_sole_trader");
    public static By bySearchResultTitles = By.xpath("//table/tbody/tr//a[@title]");
    public static By bySearchResultTexts = By.xpath("//table/tbody/tr//div[@class='searchresult']");


    public static Boolean verifyTitlesContainKeyword(List<WebElement> titles, String keyword) {


        List<String> listOfSearchResultTitles = titles.stream().map(e -> e.getText()).collect(Collectors.toList());

        for (String each : listOfSearchResultTitles) {
            System.out.println(each + "| |" + keyword);
            each = each.trim().toLowerCase();
            int count = 0;
            if (!each.contains(keyword.toLowerCase())) {
                count++;
                System.err.println(each + "| |" + keyword);
                if (count > listOfSearchResultTitles.size() * 0.25) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean verifyTextsContainKeyword(List<WebElement> texts, String keyword) {


        List<String> listOfSearchResultTexts = texts.stream().map(e -> e.getText()).collect(Collectors.toList());

        for (String each : listOfSearchResultTexts) {
            System.out.println(each + "| |" + keyword);
            each = each.trim().toLowerCase();
            int count = 0;
            if (!each.contains(keyword.toLowerCase())) {
                count++;
                if (count > listOfSearchResultTexts.size() * 0.25) {
                    return false;
                }
            }
        }
        return true;

    }
}
