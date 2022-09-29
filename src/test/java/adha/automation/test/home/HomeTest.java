package adha.automation.test.home;

import adha.automation.pages.common.HeaderMenu;
import adha.automation.pages.main.GravelLandingPage;
import adha.automation.pages.result.GravelLandingResultPage;
import adha.automation.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    private GravelLandingPage gravelLandingPage;
    private GravelLandingResultPage gravelLandingResultPage;
    private HeaderMenu headerMenu;

    @BeforeTest
    public void setupPages() {
        gravelLandingPage = new GravelLandingPage(driver);
        gravelLandingPage.goTo();
    }

    @Test
    public void LinkToCategories() {
        gravelLandingResultPage = new GravelLandingResultPage(driver);
        gravelLandingResultPage.goToSolution();

        Assert.assertNotEquals(0,gravelLandingResultPage.totalSolution());
    }

    @Test
    public void ShowProductCarousel() {
        gravelLandingResultPage = new GravelLandingResultPage(driver);
        gravelLandingResultPage.goToCarousel();
        String title = gravelLandingResultPage.TitleCarousel();

        Assert.assertFalse(title.isEmpty());
    }

    @Test
    public void ChangeLang() {
        headerMenu = new HeaderMenu(driver);
        headerMenu.clickLanguage();
        headerMenu.switchLanguage();

        gravelLandingResultPage = new GravelLandingResultPage(driver);
        String s = gravelLandingResultPage.MenuEnglish();

        Assert.assertEquals("Be Our Partner",s);

    }
}