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

public class Experiment42Test {
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

    // EXP 42: Checkbox and radio button selection.
        @Test @DisplayName("42 - Checkbox and radio selection")
        void experiment42() {
            String html = testPage("Checkbox and Radio",
                    "<input type='checkbox' id='javaCheck'><label for='javaCheck'>Java</label>" +
                    "<input type='radio' id='morning' name='shift' value='morning'>" +
                    "<label for='morning'>Morning</label>" +
                    "<input type='radio' id='evening' name='shift' value='evening'>" +
                    "<label for='evening'>Evening</label>");
            WebDriver driver = openChrome();
            try {
                driver.get(localPage(html));
                WebElement checkbox = driver.findElement(By.id("javaCheck"));
                if (!checkbox.isSelected()) checkbox.click();
                WebElement radio = driver.findElement(By.id("evening"));
                radio.click();
                assertTrue(checkbox.isSelected());
                assertTrue(radio.isSelected());
            } finally {
                driver.quit();
            }
        }
}
