package adha.automation.test.career;

import adha.automation.pages.main.GravelLandingPage;
import adha.automation.pages.result.CareerResultPage;
import adha.automation.pages.result.GravelLandingResultPage;
import adha.automation.pages.result.MitraResultPage;
import adha.automation.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CareerTest extends BaseTest {

    private GravelLandingPage gravelLandingPage;
    private GravelLandingResultPage gravelLandingResultPage;

    private CareerResultPage careerResultPage;

    @BeforeTest
    public void setupPages() {
        gravelLandingPage = new GravelLandingPage(driver);
        gravelLandingPage.goTo();
        gravelLandingResultPage = new GravelLandingResultPage(driver);
        gravelLandingResultPage.GotoCareer();
    }

    @Test
    public void ShowListkarir() {
        careerResultPage = new CareerResultPage(driver);

        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));
        WebElement element = driver.findElement(By.cssSelector(".openings-title.site-title"));

        Assert.assertEquals("Jobs at Gravel",element.getText());

    }


}
