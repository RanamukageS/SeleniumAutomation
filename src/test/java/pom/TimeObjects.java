package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimeObjects {

    private WebDriver driver = null;

    public TimeObjects(WebDriver driver) {

        this.driver = driver;
    }

    public void clickSearchTab(){
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys("Time");
    }



}
