package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PIM {
    private WebDriver driver = null;

    public PIM(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPIM(){
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys("PIM");
    }

    public void PIMSelectedTab(){
        driver.findElement(By.xpath("//span[text() = 'PIM']")).click();
    }

    public void clickAddEmployee(){
        driver.findElement(By.xpath("//a[text() = 'Add Employee']")).click();
    }

    public WebElement clickUploadProPic(){
        return driver.findElement(By.xpath("//button[@class = 'oxd-icon-button oxd-icon-button--solid-main employee-image-action']"));
    }

    public WebElement addFirstName(){
        return driver.findElement(By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-firstname']"));
    }

    public WebElement addSecondName(){
        return driver.findElement(By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-middlename']"));
    }

    public WebElement addThirdName(){
        return driver.findElement(By.xpath("//input[@class = 'oxd-input oxd-input--active orangehrm-lastname']"));
    }

    public void clickSave(){
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
       // driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
    }

}
