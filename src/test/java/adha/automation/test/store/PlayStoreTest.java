package adha.automation.test.store;

import adha.automation.pages.main.GravelLandingPage;
import adha.automation.pages.result.GravelLandingResultPage;
import adha.automation.pages.result.MitraResultPage;
import adha.automation.pages.result.PlayStoreResultPage;
import adha.automation.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayStoreTest extends BaseTest {

    private GravelLandingPage gravelLandingPage;
    private GravelLandingResultPage gravelLandingResultPage;
    private PlayStoreResultPage playStoreResultPage;

    @BeforeTest
    public void setupPages() {
        gravelLandingPage = new GravelLandingPage(driver);
        gravelLandingPage.goTo();
    }

    @Test
    public void linkToPlayStore() {
        gravelLandingResultPage = new GravelLandingResultPage(driver);
        gravelLandingResultPage.GotoPlayStore();

        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));

        playStoreResultPage = new PlayStoreResultPage(driver);
        String appname = playStoreResultPage.getTitleAppOwner();

        Assert.assertEquals("Gravel - Gampang Cari Tukang",appname);
    }
}
