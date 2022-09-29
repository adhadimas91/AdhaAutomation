package adha.automation.test.inspirasi;

import adha.automation.pages.main.GravelLandingPage;
import adha.automation.pages.result.CareerResultPage;
import adha.automation.pages.result.GravelLandingResultPage;
import adha.automation.pages.result.InspirasiResultPage;
import adha.automation.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class InspirasiTest extends BaseTest {

    private GravelLandingPage gravelLandingPage;
    private GravelLandingResultPage gravelLandingResultPage;

    private InspirasiResultPage inspirasiResultPage;

    @BeforeTest
    public void setupPages() {
        gravelLandingPage = new GravelLandingPage(driver);
        gravelLandingPage.goTo();
        gravelLandingResultPage = new GravelLandingResultPage(driver);
        gravelLandingResultPage.GotoInspirasi();
    }

    @Test
    public void CariInspirasiDiKolomSearch() {
        String search = "Energi Positif";

        inspirasiResultPage = new InspirasiResultPage(driver);
        inspirasiResultPage.SearchInput(search);

        inspirasiResultPage = new InspirasiResultPage(driver);
        String titleInspirasi = inspirasiResultPage.getTitleInspirasi();

        Assert.assertTrue(titleInspirasi.contains(search));

    }

    @Test
    public void CariInspirasiTanpaKolomSearch() {
        String search = "Boyong Energi Positif Masuk Rumah, Ini Tips Feng Shui Mengatur Tangga";

        gravelLandingResultPage = new GravelLandingResultPage(driver);
        gravelLandingResultPage.PageRefresh();

        inspirasiResultPage = new InspirasiResultPage(driver);
        inspirasiResultPage.SearchByScroll(search);

    }
}
