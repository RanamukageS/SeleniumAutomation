package tests;

import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

//@Listeners({utils.ExtentTestNGListner.class, utils.TestListner.class })
public class AdminPageTests extends BaseTest {

    //@Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public void searchSysUsers() {
        adminPageObjects.clickAdmin();
        adminPageObjects.enterRole();
        adminPageObjects.clickAdmin();
        adminPageObjects.enterSysUsername().sendKeys("Admin");
        adminPageObjects.clickUserRoleDD();
        adminPageObjects.selectUserRole();
        adminPageObjects.clickSearch();

        //user check
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class = 'oxd-table-body']"));
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if(cells.size() < 6){
                continue;
            }
            String col1 = cells.get(1).getText();
            String col2 = cells.get(2).getText();
            String col3 = cells.get(3).getText();
            String col4 = cells.get(4).getText();

            Assert.assertEquals(col1, "Admin");
            Assert.assertEquals(col2, "Admin");
            Assert.assertNotEquals(col3, "Jess Doe");
            Assert.assertEquals(col4, "Enabled");
            break;
        }
    }

    @Test
    public void deleteEmpStatus(){
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        adminPageObjects.enterRole();
        adminPageObjects.clickAdmin();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        adminPageObjects.clickJobDD();
        adminPageObjects.clickEmpStatus();
        driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
        adminPageObjects.clickCheckBoxEmpStatus();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        adminPageObjects.clickDeleteAction();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        adminPageObjects.clickDelete();
    }

    @Test
    public void editWorkShifDetails(){
        adminPageObjects.enterRole();
        adminPageObjects.clickAdmin();
        adminPageObjects.clickJobDD();
        adminPageObjects.clickWorkShift();
        adminPageObjects.clickAddWrokshiftButton();
        adminPageObjects.addShiftName().sendKeys("My ShiftOne");
        adminPageObjects.clickWorkingHoursFrom();
        adminPageObjects.selectHour().sendKeys("10");
        adminPageObjects.selectMin().sendKeys("30");
        adminPageObjects.clickAmFrom();
        adminPageObjects.clickWorkingHoursTo();
        adminPageObjects.selectWorkHourTo().sendKeys("10");
        adminPageObjects.selectWorkMinutesTo().sendKeys("30");
        adminPageObjects.clickPmTo();
        String durationPerDay = adminPageObjects.checkDurationPerDay().getText();
        Assert.assertEquals(durationPerDay,"8.00");
        driver.manage().timeouts().implicitlyWait(400,TimeUnit.SECONDS);
        adminPageObjects.clickSaveDetails();
    }

    @Test
    public void editGeneralInformation(){
        adminPageObjects.enterRole();
        adminPageObjects.clickAdmin();
        adminPageObjects.clickJobDD();
        driver.manage().timeouts().implicitlyWait(400,TimeUnit.SECONDS);
        adminPageObjects.clickOrganizationTab();
        driver.manage().timeouts().implicitlyWait(400,TimeUnit.SECONDS);
        adminPageObjects.clickGeneralInfor();
        driver.manage().timeouts().implicitlyWait(400,TimeUnit.SECONDS);
        adminPageObjects.clickOnEditMode();
        driver.manage().timeouts().implicitlyWait(400,TimeUnit.SECONDS);
        adminPageObjects.PostalCode();
    }
}


