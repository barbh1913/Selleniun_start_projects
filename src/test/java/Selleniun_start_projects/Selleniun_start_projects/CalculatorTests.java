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
        browser.get("https://testpages.eviltester.com/styled/apps/calculator.html");
    }

    // חיבור

    @Test
    public void addTest1() { // 9 + 8 = 17 
        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button08")).click();
        browser.findElement(By.id("buttonequals")).click();

        assertEquals("17", browser.findElement(By.id("calculated-display")).getAttribute("value"));
    }

    @Test
    public void addTest2() { // 15 + 19 = 34
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button05")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonequals")).click();

        assertEquals("34", browser.findElement(By.id("calculated-display")).getAttribute("value"));
    }

    @Test
    public void addTest3() { // 0 + 6 = 6 
        browser.findElement(By.id("button00")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button06")).click();
        browser.findElement(By.id("buttonequals")).click();

        assertEquals("6", browser.findElement(By.id("calculated-display")).getAttribute("value"));
    }

    // חיסור

    @Test
    public void subTest1() { // 20 - 7 = 13 
        browser.findElement(By.id("button02")).click();
        browser.findElement(By.id("button00")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button07")).click();
        browser.findElement(By.id("buttonequals")).click();

        assertEquals("13", browser.findElement(By.id("calculated-display")).getAttribute("value"));
    }

    @Test
    public void subTest2() { // 12 - 12 = 0 
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button02")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button02")).click();
        browser.findElement(By.id("buttonequals")).click();

        assertEquals("0", browser.findElement(By.id("calculated-display")).getAttribute("value"));
    }

    @Test
    public void subTest3() { // 18 - 0 = 18 
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button08")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button00")).click();
        browser.findElement(By.id("buttonequals")).click();

        assertEquals("18", browser.findElement(By.id("calculated-display")).getAttribute("value"));
    }

    // כפל

    @Test
    public void multiTest1() { // 12 x 3 = 36
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("button02")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button03")).click();
        browser.findElement(By.id("buttonequals")).click();

        assertEquals("36", browser.findElement(By.id("calculated-display")).getAttribute("value"));
    }

    @Test
    public void multiTest2() { // 9 x 0 = 0
        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button00")).click();
        browser.findElement(By.id("buttonequals")).click();

        assertEquals("0", browser.findElement(By.id("calculated-display")).getAttribute("value"));
    }

    @Test
    public void multiTest3() { // 1 x 7 = 7 
        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button07")).click();
        browser.findElement(By.id("buttonequals")).click();

        assertEquals("7", browser.findElement(By.id("calculated-display")).getAttribute("value"));
    }
}
