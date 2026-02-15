package Selleniun_start_projects.Selleniun_start_projects;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CalculatorTests {

    static WebDriver browser;

    @Before
    public void setup() {

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        browser = new FirefoxDriver(options);

        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String url = "https://testpages.eviltester.com/styled/apps/calculator.html";
        browser.get(url);
    }

    // ======================
    // חיבור
    // ======================

    @Test
    public void addTest1() { // 8 + 8 = 16
        browser.findElement(By.id("button08")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button08")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("addTest1:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("16", result);
    }

    @Test
    public void addTest2() { // 5 + (-12) = -7
        browser.findElement(By.id("button05")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button02")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("addTest2:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("-7", result);
    }

    @Test
    public void addTest4() { // 6 + 0 = 6
        browser.findElement(By.id("button06")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button00")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("addTest4:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("6", result);
    }

    // ======================
    // חיסור
    // ======================

    @Test
    public void subTest1() { // 15 - 10 = 5
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button05")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button00")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("subTest1:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("5", result);
    }

    @Test
    public void subTest2() { // (-3) - 10 = 13
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button03")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button00")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("subTest2:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("-13", result);
    }

    @Test
    public void subTest3() { // (-3) - (-8) = 5
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button03")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button08")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("subTest3:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("5", result);
    }

    @Test
    public void subTest4() { // -8 - 0 = -8
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button08")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button00")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("subTest4:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("-8", result);
    }

    // ======================
    // כפל
    // ======================

    @Test
    public void multiTest1() { // 3 x 4 = 12
        browser.findElement(By.id("button03")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button04")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("multiTest1:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("12", result);
    }

    @Test
    public void multiTest2() { // (-5) x 5 = -25
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button05")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button05")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("multiTest2:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("-25", result);
    }

    @Test
    public void multiTest3() { // (-7) x (-4) = 28
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button07")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button04")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("multiTest3:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("28", result);
    }

    @Test
    public void multiTest4() { // 4 x 0 = 0
        browser.findElement(By.id("button04")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button00")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        browser.findElement(By.id("buttonequals")).click();
        System.out.println("multiTest4:");

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value").toString();
        System.out.println(result);
        assertEquals("0", result);
    }
}
