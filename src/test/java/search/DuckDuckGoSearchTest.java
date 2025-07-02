package search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DuckDuckGoSearchTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testDuckDuckGoSearch() {
        driver.get("https://duckduckgo.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("OpenAI");
        searchBox.submit();

        // Wait briefly for search results to appear
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.toLowerCase().contains("openai"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}