package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pom.AdminPageObjects;
import pom.LoginData;
import pom.PIM;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginData login_data;
    protected AdminPageObjects adminPageObjects;
    protected LoginData loginData;
    protected PIM pim;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void browserSetUp(){
        String browser = ConfigReader.getProperty("browser");

        switch(browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                // driver = new ChromeDriver();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");  // Use new headless mode (Chrome 109+)
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);
                break;

            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions option = new FirefoxOptions();
                option.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
                driver = new FirefoxDriver(option);
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
        pim = new PIM(driver);


        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        login_data.getUserName().sendKeys(username);
        login_data.getPassword().sendKeys(password);
        login_data.clickButton();


    }

    @AfterTest
    public void browserClose(){
      driver.close();
    }

}
