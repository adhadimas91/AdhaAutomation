package adha.automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    public BaseTest() {
    }

    @BeforeTest
    public void setupDriver() {

        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
