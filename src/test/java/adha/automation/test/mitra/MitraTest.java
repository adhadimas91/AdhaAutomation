package adha.automation.test.mitra;

import adha.automation.pages.common.HeaderMenu;
import adha.automation.pages.main.GravelLandingPage;
import adha.automation.pages.result.GravelLandingResultPage;
import adha.automation.pages.result.MitraResultPage;
import adha.automation.pages.result.PlayStoreResultPage;
import adha.automation.test.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MitraTest extends BaseTest {

    private GravelLandingPage gravelLandingPage;
    private GravelLandingResultPage gravelLandingResultPage;
    private MitraResultPage mitraResultPage;
    private PlayStoreResultPage playStoreResultPage;

    @BeforeTest
    public void setupPages() {
        gravelLandingPage = new GravelLandingPage(driver);
        gravelLandingPage.goTo();
        gravelLandingResultPage = new GravelLandingResultPage(driver);
        gravelLandingResultPage.GotoMitra();
    }

    @Test
    public void DaftarSekarang() {
        mitraResultPage = new MitraResultPage(driver);
        mitraResultPage.clickDaftar();
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));

        playStoreResultPage = new PlayStoreResultPage(driver);
        String appname = playStoreResultPage.getTitleAppTukang();

        Assert.assertEquals("Gravel Dulur - Untuk Tukang",appname);
        driver.switchTo().window(browserTabs.get(0));
    }

    @Test
    public void ShowProductCarousel() {
        mitraResultPage = new MitraResultPage(driver);
        mitraResultPage.scrollToCarousel();
    }

}
