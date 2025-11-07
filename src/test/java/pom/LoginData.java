package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginData {
    private WebDriver driver = null;

    public LoginData(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserName() {
        return driver.findElement(By.xpath("//input[@name = 'username']"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.xpath("//input[@name = 'password']"));
    }

    public void clickButton() {
        driver.findElement(By.xpath("//button[@type ='submit']")).click();
    }

}
