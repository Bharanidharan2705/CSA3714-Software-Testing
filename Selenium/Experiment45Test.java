package experiments;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Experiment45Test {
    private WebDriver openChrome() {
        return new ChromeDriver(); // Selenium Manager resolves the matching driver.
    }

    private String localPage(String html) {
        return "data:text/html;charset=utf-8," +
                URLEncoder.encode(html, StandardCharsets.UTF_8);
    }

    private String armsUrl() {
        return System.getProperty("arms.url", "").trim();
    }

    private String testPage(String title, String body) {
        return "<!doctype html><html><head><title>" + title +
                "</title></head><body>" + body + "</body></html>";
    }

    // EXP 45: Capture and save a screenshot locally.
        @Test @DisplayName("45 - Capture screenshot")
        void experiment45() throws Exception {
            String html = testPage("Screenshot Experiment", "<h1>Selenium Screenshot</h1><p>Experiment 45</p>");
            WebDriver driver = openChrome();
            try {
                driver.get(localPage(html));
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Path destination = Path.of(System.getProperty("user.home"), "selenium-experiment-45.png");
                Files.copy(screenshot.toPath(), destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                assertTrue(Files.exists(destination));
                System.out.println("Screenshot saved to: " + destination);
            } finally {
                driver.quit();
            }
        }
}
