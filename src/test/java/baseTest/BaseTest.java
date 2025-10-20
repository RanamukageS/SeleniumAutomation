package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pom.AdminPageObjects;
import pom.LoginData;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginData login_data;
    protected AdminPageObjects adminPageObjects;
    protected LoginData loginData;

    @BeforeTest
    public void browserSetUp(){
        String browser = ConfigReader.getProperty("browser");

        switch(browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
                driver = new FirefoxDriver(options);
                break;

            default:
                throw new IllegalArgumentException("browser is not supported" + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String url = ConfigReader.getProperty("url");
        driver.get(url);

        login_data = new LoginData(driver);
        adminPageObjects = new AdminPageObjects(driver);

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        login_data.getUserName().sendKeys(username);
        login_data.getPassword().sendKeys(password);
        login_data.clickButton();


    }

    @AfterTest
    public void browserClose(){
       // driver.close();
    }

}
