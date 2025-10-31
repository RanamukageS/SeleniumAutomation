package tests;

import baseTest.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import java.util.concurrent.TimeUnit;

@Listeners({utils.ExtentTestNGListner.class, utils.TestListner.class })
public class PIMTests extends BaseTest {

//@Test
//    public void addEmployeetoPIM(){
//        adminPageObjects.enterRole();
//        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//        pim.clickPIM();
//        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//        pim.PIMSelectedTab();
//        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//        pim.clickAddEmployee();
//        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
//        pim.clickUploadProPic().click();
//        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
//        String desktopIMGPath = System.getProperty("user.home") + "/Desktop/image.jpeg";
//        File file  = new File(desktopIMGPath);
//        if(!file.exists()){
//            throw new RuntimeException("file not found" + file.getAbsolutePath());
//        }
//        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
//        pim.clickUploadProPic().sendKeys(file.getAbsolutePath());
//
//    }

@Test(retryAnalyzer = RetryAnalyzer.class)
    public void addEmpDetails(){
        adminPageObjects.enterRole();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        pimObjects.clickPIM();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        pimObjects.PIMSelectedTab();
        pimObjects.clickAddEmployee();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        pimObjects.addFirstName().sendKeys("Malmi");
        pimObjects.addSecondName().sendKeys("Nayana");
        pimObjects.addThirdName().sendKeys("maliyadda");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        pimObjects.clickSave();


        //wait until loaded the page
//        WebDriverWait wait = new WebDriverWait(driver, 300);
//        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//h6[contains(@class, '--strong')]")
//        ));
//
//        String actualText = nameElement.getText();
//        System.out.println("Actual name retrieved: '" + actualText + "'");
//        Assert.assertEquals(actualText, "Malmi maliyadda");




    }




}
