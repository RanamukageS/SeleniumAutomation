package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class ScreenshotUtil {

        public static void captureScreenshot(WebDriver driver, String testName) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = "screenshots/" + testName + "_" + timestamp + ".png";

            try {
                FileUtils.copyFile(srcFile, new File(filePath));
                System.out.println("📸 Screenshot saved to: " + filePath);
            } catch (IOException e) {
                System.out.println("❌ Failed to save screenshot: " + e.getMessage());
            }
        }
    }


