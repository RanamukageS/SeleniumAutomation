package tests;

import baseTest.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import java.util.List;


@Listeners({utils.ExtentTestNGListner.class, utils.TestListner.class})
public class TimeTests extends BaseTest {

    @Test(groups = {"Smoke", "Regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void resetEmployeeTimeSheet() {
        adminPageObjects.enterRole();
        timeObjects.clickSearchTab();
        timeObjects.clickTime();
        timeObjects.clickTimeSheets();
        timeObjects.clickTabTimesheet();
        timeObjects.selectTimeTab();
        timeObjects.clickMonthDD();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        timeObjects.selectMonth();
        timeObjects.clickAYear();
        timeObjects.selectYear();
        timeObjects.selectDate();
        timeObjects.clickEditTimesheet();
        timeObjects.projDD().click();
        timeObjects.projDD().sendKeys("A");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@role='listbox']//div[contains(@class,'oxd-autocomplete-option')]")));
        for (WebElement option : options) {
            String text = option.getText();
            System.out.println("Option: " + text);
            if (text.equalsIgnoreCase("ACME Ltd - ACME Ltd")) {
                option.click();
                break;
            }
        }
        timeObjects.clickReset();
    }
}











