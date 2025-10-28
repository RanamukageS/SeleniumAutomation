package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdminPageObjects {

    private WebDriver driver = null;

    public AdminPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void enterRole(){
        driver.findElement(By.xpath("//span[@class = 'oxd-text oxd-text--span oxd-main-menu-item--name']")).click();
    }

    public void clickAdmin(){
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys("Admin");
    }

    public WebElement enterSysUsername(){
        return driver.findElements(By.xpath("//input[@class = 'oxd-input oxd-input--active']")).get(0);
    }

    public void clickUserRoleDD(){
        driver.findElements(By.xpath("//div[@class = 'oxd-select-text-input']")).get(0).click();
    }

    public void selectUserRole(){
       List<WebElement> ddEle = driver.findElements(By.xpath("//div[@class = 'oxd-select-text-input']"));
       if(!ddEle.isEmpty()){
           WebElement firstElement = ddEle.get(0);
       }

       for(WebElement Opt : ddEle){
           if(Opt.getText().equals("Admin")){
               Opt.click();
               break;
           }
       }
    }

    public void clickSearch(){
         driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    //Test cases under second Tab - Job[Employment Status] in Admin

    public void clickJobDD() {
        driver.findElements(By.xpath("//i[@class ='oxd-icon bi-chevron-down']")).get(1).click();
    }

    public void clickEmpStatus(){
        driver.findElement(By.xpath("//a[text() = 'Employment Status']")).click();
    }

    public void clickCheckBoxEmpStatus(){
        WebElement checkBox = driver.findElements(By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(1);
        checkBox.click();
    }

    public void clickDeleteAction(){
        driver.findElement(By.xpath("//button[@class ='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")).click();
    }

    public void clickDelete(){
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
    }

    //Test cases under second Tab - Job[Work Shifts] in Admin
    public void clickWorkShift(){
        driver.findElement(By.xpath("//a[text() = 'Work Shifts']")).click();
    }
    public void clickAddWrokshiftButton(){
        driver.findElement(By.xpath("//i[@class = 'oxd-icon bi-plus oxd-button-icon']")).click();
    }
    public WebElement addShiftName(){
        return driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']"));
    }

    public void clickWorkingHoursFrom(){
        driver.findElements(By.xpath("//i[@class='oxd-icon bi-clock oxd-time-input--clock']")).get(0).click();
    }

    public WebElement selectHour(){
        return driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active oxd-time-hour-input-text']"));
    }

    public WebElement selectMin(){
        return driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active oxd-time-minute-input-text']"));
    }

    public void clickAmFrom(){
        driver.findElement(By.xpath("//input[@name = 'am']")).click();
    }

    public void clickWorkingHoursTo(){
        driver.findElements(By.xpath("//i[@class = 'oxd-icon bi-clock oxd-time-input--clock']")).get(1).click();
    }

    public WebElement selectWorkHourTo(){
       return driver.findElement(By.xpath("//div[@class='oxd-time-hour-input']//input[@class='oxd-input oxd-input--active oxd-time-hour-input-text']"));
    }


    public WebElement selectWorkMinutesTo(){
        return driver.findElement(By.xpath("//div[@class='oxd-time-minute-input']//input[@class='oxd-input oxd-input--active oxd-time-minute-input-text']"));
    }

    public void clickPmTo(){
         driver.findElement(By.xpath("//input[@name ='pm']")).click();
    }

    public WebElement checkDurationPerDay(){
        return driver.findElement(By.xpath("//div[@class='oxd-input-group']//p[@class = 'oxd-text oxd-text--p orangehrm-workshift-duration']"));
    }

    public void clickSaveDetails(){
        driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
    }

    //Admin - Organization Tab
    public void clickOrganizationTab(){
        driver.findElements(By.xpath("//i[@class = 'oxd-icon bi-chevron-down']")).get(2).click();
    }

    public  void clickGeneralInfor(){
        driver.findElement(By.xpath("//a[text() = 'General Information']")).click();
    }

    public void clickOnEditMode(){
        driver.findElement(By.xpath("//span[@class = 'oxd-switch-input oxd-switch-input--active --label-left']")).click();
    }

    public void PostalCode(){
        WebElement textbox = driver.findElements(By.xpath("//input[@class = 'oxd-input oxd-input--active']")).get(10);
        textbox.clear();
        driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
        textbox.sendKeys("22222");
       // driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[7]/button")).click();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    }



}
