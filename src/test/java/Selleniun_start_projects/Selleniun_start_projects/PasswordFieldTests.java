package Selleniun_start_projects.Selleniun_start_projects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PasswordFieldTests {

    static WebDriver browser;

    @Before
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        browser = new FirefoxDriver(options);

        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String url = "https://testpages.eviltester.com/apps/7-char-val/";
        browser.get(url);
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }

    // ---------- Helper Methods ----------

    public void enterPassword(String value) {
        WebElement inputField = browser.findElement(By.name("characters"));
        inputField.clear();
        inputField.sendKeys(value);
        browser.findElement(By.name("validate")).click();
    }

    public boolean isValid() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions
                .textToBePresentInElementValue(By.name("validation_message"), "Valid"));
    }

    public boolean isInvalid() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions
                .textToBePresentInElementValue(By.name("validation_message"), "Invalid"));
    }

    // =========================
    // EP VALID
    // =========================

    @Test
    public void ep_valid_input() {
        enterPassword("Ab3*9Zx");
        assertTrue("Expected Valid", isValid());
    }

    // =========================
    // EP INVALID
    // =========================

    @Test
    public void ep_too_short() {
        enterPassword("Ab12*");
        assertTrue("Expected Invalid", isInvalid());
    }

    @Test
    public void ep_too_long() {
        enterPassword("Ab12*9Zx");
        assertTrue("Expected Invalid", isInvalid());
    }

    @Test
    public void ep_illegal_non_english() {
        enterPassword("אב3*9Zx");
        assertTrue("Expected Invalid", isInvalid());
    }

    @Test
    public void ep_illegal_special_char() {
        enterPassword("Ab3@9Zx");
        assertTrue("Expected Invalid", isInvalid());
    }

    @Test
    public void ep_empty_input() {
        enterPassword("");
        assertTrue("Expected Invalid", isInvalid());
    }
}
