package adha.automation.pages.main;

import adha.automation.pages.common.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GravelLandingPage {

    private WebDriver driver;

    public GravelLandingPage(final WebDriver driver){
        this.driver = driver;
    }

    public void goTo(){
        this.driver.get("https://gravel.co.id");
    }

}
