package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Test {
    WebDriver driver;
    private final String searchInput = "//input";
    private final String searchProduct = "//a[@class=\"goods-tile__picture ng-star-inserted\"]";
    private final String searchBuyButton = "//div[@class=\"product-trade ng-star-inserted\"]//button";
    private final String searchBuyButton2 = "//div[@class=\"cart-receipt ng-star-inserted\"]//a";
    private String ProductText;

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
    @BeforeMethod
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rozetka.com.ua/");
    }
    @org.testng.annotations.Test
    public void test1()
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement searchElement = driver.findElement(By.xpath(searchInput));
        searchElement.clear();
        searchElement.sendKeys("Монитор");
        searchElement.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class=\"ng-lazyloaded\"]")));
        driver.findElement(By.xpath(searchProduct)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(searchBuyButton)));
        driver.findElement(By.xpath(searchBuyButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(searchBuyButton2)));
        driver.findElement(By.xpath(searchBuyButton2)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body")));
    }
    @AfterMethod
    public void quitBrowser()
    {
        driver.quit();
    }
}
