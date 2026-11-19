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

public class Experiment43Test {
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

    // EXP 43: Handle JavaScript alert, confirmation, and prompt.
        @Test @DisplayName("43 - JavaScript alert, confirm and prompt")
        void experiment43() {
            String html = testPage("JavaScript Alerts",
                    "<button id='alert' onclick='alert(\"Hello Alert\")'>Alert</button>" +
                    "<button id='confirm' onclick='confirm(\"Are you sure?\")'>Confirm</button>" +
                    "<button id='prompt' onclick='prompt(\"Enter your name\")'>Prompt</button>");
            WebDriver driver = openChrome();
            try {
                driver.get(localPage(html));
                driver.findElement(By.id("alert")).click();
                Alert alert = driver.switchTo().alert();
                assertEquals("Hello Alert", alert.getText());
                alert.accept();
    
                driver.findElement(By.id("confirm")).click();
                Alert confirm = driver.switchTo().alert();
                assertEquals("Are you sure?", confirm.getText());
                confirm.dismiss();
    
                driver.findElement(By.id("prompt")).click();
                Alert prompt = driver.switchTo().alert();
                prompt.sendKeys("Sujith");
                prompt.accept();
            } finally {
                driver.quit();
            }
        }
}
