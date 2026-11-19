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

public class Experiment36Test {
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

    // EXP 36: Open Chrome and verify ARMS portal title.
    // Set -Darms.url=https://arms.sse.saveetha.com/
    @Test
    @DisplayName("36 - Open ARMS portal and verify title")
    void experiment36() {
        assumeTrue(!armsUrl().isEmpty(),
                "Skipped: provide the actual ARMS portal URL using -Darms.url");
        WebDriver driver = openChrome();
        try {
            driver.get(armsUrl());
            assertFalse(driver.getTitle().trim().isEmpty(), "ARMS page title should not be empty");
            System.out.println("ARMS Page Title: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}