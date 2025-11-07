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
        if (driver != null) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = "screenshots/" + testName + "_" + timestamp + ".png";

            try {

                // ✅ Ensure the screenshots directory exists
                File directory = new File("screenshots");
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                FileUtils.copyFile(srcFile, new File(filePath));
                System.out.println("📸 Screenshot saved to: " + filePath);
            } catch (IOException e) {
                System.out.println("❌ Failed to save screenshot: " + e.getMessage());
            }
        } else {
            System.out.println("⚠️ Screenshot skipped: driver is null");
        }
    }
}


