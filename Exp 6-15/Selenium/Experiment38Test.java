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

public class Experiment38Test {
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

    // EXP 38: Registration form. A small local HTML form is used as the test application.
        @Test @DisplayName("38 - Registration form filling")
        void experiment38() {
            String html = testPage("Registration Form",
                    "<form onsubmit=\"document.getElementById('result').textContent='Registration submitted';return false;\">" +
                    "<input id='name' name='name'><input id='email' name='email' type='email'>" +
                    "<input id='password' name='password' type='password'>" +
                    "<button id='submit' type='submit'>Register</button></form><p id='result'></p>");
            WebDriver driver = openChrome();
            try {
                driver.get(localPage(html));
                driver.findElement(By.id("name")).sendKeys("Test Student");
                driver.findElement(By.id("email")).sendKeys("student@example.com");
                driver.findElement(By.id("password")).sendKeys("Test@123");
                driver.findElement(By.id("submit")).click();
                assertEquals("Registration submitted", driver.findElement(By.id("result")).getText());
            } finally {
                driver.quit();
            }
        }
}
