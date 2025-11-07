package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeObjects {

    private WebDriver driver = null;

    public TimeObjects(WebDriver driver) {

        this.driver = driver;
    }

    public void clickSearchTab(){
        driver.findElements(By.xpath("//input[@class='oxd-input oxd-input--active']")).get(0).sendKeys("Time");
    }

    public void clickTime(){
        driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")).click();
    }

    public void clickTimeSheets(){
        driver.findElements(By.xpath("//i[@class='oxd-icon bi-chevron-down']")).get(0).click();
    }

    public void clickTabTimesheet(){
        driver.findElement(By.xpath("//a[text() = 'My Timesheets']")).click();
    }

    public void selectTimeTab(){
        driver.findElement(By.xpath("//i[@class = 'oxd-icon bi-calendar oxd-date-input-icon']")).click();
    }

    public void clickMonthDD(){
        driver.findElements(By.xpath("//p[@class = 'oxd-text oxd-text--p']")).get(0).click();
    }

    public void selectMonth(){
        driver.findElement(By.xpath("//li[contains(text(), 'May')]")).click();
    }

    public void clickAYear(){
        driver.findElements(By.xpath("//p[@class= 'oxd-text oxd-text--p']")).get(1).click();
    }

    public void selectYear(){
        driver.findElement(By.xpath("//li[contains(text(), '2024')]")).click();
    }

    public void selectDate(){
        driver.findElement(By.xpath("//div[contains(text(), '23')]")).click();
    }

//    public WebElement createTimeSheetButton(){
//        return driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary']"));
//    }

    public void createTimesheetButton(){
        driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary']")).click();

    }

    public void clickEditTimesheet(){
        //driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--ghost']")).click();
        //driver.findElement  (By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--ghost']")).click();
          driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--ghost']")).click();
    }


    public WebElement projDD(){
      return driver.findElement(By.xpath("//input[@placeholder = 'Type for hints...']"));
        }

    public void clickActivity(){
        WebElement dd = driver.findElement(By.xpath("//div[@class = 'oxd-select-text-input']"));
    }





}