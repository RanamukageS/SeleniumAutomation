package tests;

import baseTest.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners({utils.ExtentTestNGListner.class, utils.TestListner.class})
public class TimeTests extends BaseTest {

    @Test
    public void addEmployeeTimeSheet() {
        adminPageObjects.enterRole();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        timeObjects.clickSearchTab();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        timeObjects.clickTime();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        timeObjects.clickTimeSheets();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        timeObjects.clickTabTimesheet();
        timeObjects.selectTimeTab();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        timeObjects.clickMonthDD();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        timeObjects.selectMonth();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        timeObjects.clickAYear();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        timeObjects.selectYear();
        timeObjects.selectDate();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0, 500)");
        WebDriverWait wait = new WebDriverWait(driver, 600);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary']")));
        timeObjects.createTimesheetButton();
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--ghost']")));
        timeObjects.clickEditTimesheet();
    }

}











