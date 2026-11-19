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

public class Experiment40Test {
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

    // EXP 40: Logout functionality using a local sample web application.
        @Test @DisplayName("40 - Logout")
        void experiment40() {
            String html = testPage("Logged In",
                    "<p id='status'>Logged in</p><button id='logout' " +
                    "onclick=\"document.getElementById('status').textContent='Logged out';document.title='Logged Out';\">Logout</button>");
            WebDriver driver = openChrome();
            try {
                driver.get(localPage(html));
                driver.findElement(By.id("logout")).click();
                assertEquals("Logged out", driver.getTitle());
                assertEquals("Logged out", driver.findElement(By.id("status")).getText());
            } finally {
                driver.quit();
            }
        }
}
