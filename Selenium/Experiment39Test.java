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

public class Experiment39Test {
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

    // EXP 39: Login to ARMS and validate invalid-credentials error.
        // Configure URL and selectors to match your actual ARMS login page.
        // Defaults: input[name=username], input[name=password], button[type=submit], #error.
        @Test @DisplayName("39 - ARMS invalid login error")
        void experiment39() {
            assumeTrue(!armsUrl().isEmpty(),
                    "Skipped: provide the actual ARMS portal URL using -Darms.url");
            String userSelector = System.getProperty("arms.username.selector", "input[name='username']");
            String passSelector = System.getProperty("arms.password.selector", "input[name='password']");
            String submitSelector = System.getProperty("arms.submit.selector", "button[type='submit']");
            String errorSelector = System.getProperty("arms.error.selector", "#error");
            WebDriver driver = openChrome();
            try {
                driver.get(armsUrl());
                driver.findElement(By.cssSelector(userSelector)).sendKeys("invalid_user_for_test");
                driver.findElement(By.cssSelector(passSelector)).sendKeys("InvalidPassword123!");
                driver.findElement(By.cssSelector(submitSelector)).click();
                WebElement error = new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(d -> d.findElement(By.cssSelector(errorSelector)));
                assertTrue(error.isDisplayed(), "Invalid-login error should be displayed");
                assertFalse(error.getText().trim().isEmpty(), "Error message should contain text");
                System.out.println("Invalid login message: " + error.getText());
            } finally {
                driver.quit();
            }
        }
}
