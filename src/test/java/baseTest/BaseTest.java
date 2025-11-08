package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pom.AdminPageObjects;
import pom.LoginData;
import pom.PIMObjects;
import pom.TimeObjects;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginData login_data;
    protected AdminPageObjects adminPageObjects;
    protected LoginData loginData;
    protected PIMObjects pimObjects;
    protected TimeObjects timeObjects;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {
        //String browser = ConfigReader.getProperty("browser");

        String browser = ConfigReader.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                try {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();

                    if (System.getenv("CI") != null) {
                        options.addArguments("--headless=new");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--window-size=1920,1080");
                        options.addArguments("--remote-allow-origins=*");
                    }

                    // Initialize driver regardless of CI environment
                    driver = new ChromeDriver(options);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    System.out.println("✅ ChromeDriver initialized successfully");
                } catch (Exception e) {
                    System.out.println("❌ Error initializing ChromeDriver: " + e.getMessage());
                    e.printStackTrace();
                    throw e;
                }
                break;


            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions option = new FirefoxOptions();
                option.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
                driver = new FirefoxDriver(option);
                break;

            default:
                throw new IllegalArgumentException("browser is not supported" + browser);
        }

        if (System.getenv("CI") == null) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String url = ConfigReader.getProperty("url");
        driver.get(url);

        login_data = new LoginData(driver);
        adminPageObjects = new AdminPageObjects(driver);
        pimObjects = new PIMObjects(driver);
        timeObjects = new TimeObjects(driver);


        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        login_data.getUserName().sendKeys(username);
        login_data.getPassword().sendKeys(password);
        login_data.clickButton();


    }

    @AfterMethod(alwaysRun = true)
    public void browserClose() {
        if (driver != null) {
            driver.quit();
        }
    }
}
