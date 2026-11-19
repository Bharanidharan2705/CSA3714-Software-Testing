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

public class Experiment37Test {
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

    // EXP 37: Automate Google search.
        @Test @DisplayName("37 - Google search")
        void experiment37() {
            WebDriver driver = openChrome();
            try {
                driver.get("https://www.google.com");
                WebElement search = new WebDriverWait(driver, Duration.ofSeconds(15))
                        .until(d -> d.findElement(By.name("q")));
                search.sendKeys("Selenium WebDriver");
                search.submit();
                new WebDriverWait(driver, Duration.ofSeconds(15))
                        .until(d -> d.getTitle().toLowerCase().contains("selenium"));
                assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
                System.out.println("Search page title: " + driver.getTitle());
            } finally {
                driver.quit();
            }
        }
}
