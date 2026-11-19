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

public class Experiment44Test {
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

    // EXP 44: File upload using sendKeys() on an input type=file.
        @Test @DisplayName("44 - File upload")
        void experiment44() throws Exception {
            Path uploadFile = Files.createTempFile("selenium-upload-", ".txt");
            Files.writeString(uploadFile, "Sample file for Selenium upload test.");
            String html = testPage("File Upload",
                    "<form onsubmit=\"document.getElementById('uploaded').textContent=" +
                    "document.getElementById('file').files[0].name;return false;\">" +
                    "<input type='file' id='file'><button type='submit' id='upload'>Upload</button></form>" +
                    "<p id='uploaded'></p>");
            WebDriver driver = openChrome();
            try {
                driver.get(localPage(html));
                driver.findElement(By.id("file")).sendKeys(uploadFile.toAbsolutePath().toString());
                driver.findElement(By.id("upload")).click();
                assertEquals(uploadFile.getFileName().toString(),
                        driver.findElement(By.id("uploaded")).getText());
            } finally {
                driver.quit();
                Files.deleteIfExists(uploadFile);
            }
        }
}
